package acess;

import acess.AccessControlParameter;
import acess.AccessTreeNode;
import acess.LSSSPolicyEngine;
import acess.LSSSPolicyParameter;

import acess.BinaryTreeNode;

import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.Map;


public class LSSSEngine extends LSSSPolicyEngine {
    public static final String SCHEME_NAME = "linear secret-sharing scheme";

    private static LSSSEngine instance = new LSSSEngine();

    private LSSSEngine() {

    }

    public static LSSSEngine getInstance() {
        return instance;
    }

    public String getEngineName() {
        return SCHEME_NAME;
    }

    public boolean isSupportThresholdGate() {
        return false;
    }

    public AccessControlParameter generateAccessControl(int[][] accessPolicy, String[] rhos) {
        
        AccessTreeNode rootAccessTreeNode = AccessTreeNode.GenerateAccessTree(accessPolicy, rhos);
        
        BinaryTreeNode rootBinaryTreeNode = BinaryTreeNode.ReconstructBinaryTreeNode(accessPolicy, rhos);

        
        Map<String, LinkedList<LinkedList<Integer>>> map = new LinkedHashMap<String, LinkedList<LinkedList<Integer>>>();
        int maxLen = 0;
        int rows = 0;
       
        int c = 1;
        LinkedList<Integer> vector = new LinkedList<Integer>();
        
        vector.add(1);
        rootBinaryTreeNode.setVector(vector);

        LinkedList<BinaryTreeNode> queue = new LinkedList<BinaryTreeNode>();
        queue.add(rootBinaryTreeNode);

        while (!queue.isEmpty()) {
            BinaryTreeNode p = queue.removeFirst();
            if (p.getType() == BinaryTreeNode.NodeType.AND) {
               
                int size = p.getVector().size();
                LinkedList<Integer> pv = new LinkedList<Integer>();
               
                if (size < c) {
                    pv.addAll(p.getVector());
                    for (int i = 0; i < c - size; i++) {
                        pv.add(0);
                    }
                } else {
                    pv.addAll(p.getVector());
                }
                
                BinaryTreeNode right = p.getRight();
                LinkedList<Integer> lv = new LinkedList<Integer>();
                lv.addAll(pv);
                lv.addLast(1);
                right.setVector(lv);
                queue.add(right);

                
                BinaryTreeNode left = p.getLeft();
                LinkedList<Integer> rv = new LinkedList<Integer>();
                for (int i = 0; i < c; i++) {
                    rv.add(0);
                }
                rv.addLast(-1);
                left.setVector(rv);
                queue.add(left);
                
                c += 1;
            } else if (p.getType() == BinaryTreeNode.NodeType.OR) {
                
                BinaryTreeNode left = p.getLeft();
                LinkedList<Integer> lv = new LinkedList<Integer>();
                
                lv.addAll(p.getVector());
                left.setVector(lv);
                queue.add(left);

                BinaryTreeNode right = p.getRight();
                LinkedList<Integer> rv = new LinkedList<Integer>();
                
                rv.addAll(p.getVector());
                right.setVector(rv);
                queue.add(right);
            } else {
                
                rows += 1;
                int size = p.getVector().size();
                maxLen = size > maxLen ? size : maxLen;
                if (map.containsKey(p.getValue())) {
                    map.get(p.getValue()).add(p.getVector());
                } else {
                    LinkedList<LinkedList<Integer>> list = new LinkedList<LinkedList<Integer>>();
                    list.add(p.getVector());
                    map.put(p.getValue(), list);
                }
            }
        }

        for (Map.Entry<String, LinkedList<LinkedList<Integer>>> entry : map
                .entrySet()) {
            LinkedList<LinkedList<Integer>> v = entry.getValue();
            for (LinkedList<Integer> aV : v) {
                int size = aV.size();
                if (size < maxLen) {
                    for (int j = 0; j < maxLen - size; j++) {
                        aV.add(0);
                    }
                }
            }
        }

       
        int[][] lsssMatrix = new int[rows][];
        String[] rhosParameter = new String[rhos.length];
        int i = 0;
        for (Map.Entry<String, LinkedList<LinkedList<Integer>>> entry : map.entrySet()) {
            LinkedList<LinkedList<Integer>> v = entry.getValue();
            for (LinkedList<Integer> aV : v) {
                rhosParameter[i] = entry.getKey();
                lsssMatrix[i] = new int[maxLen];
                for (int k = 0; k < maxLen; k++) {
                    lsssMatrix[i][k] = aV.get(k);
                }
                i += 1;
            }
        }
        return new LSSSPolicyParameter(rootAccessTreeNode, accessPolicy, lsssMatrix, rhosParameter);
    }
}