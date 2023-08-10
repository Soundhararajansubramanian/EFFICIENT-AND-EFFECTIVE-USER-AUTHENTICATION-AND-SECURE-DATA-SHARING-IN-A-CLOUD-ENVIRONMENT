package acess;


import it.unisa.dia.gas.jpbc.Element;
import it.unisa.dia.gas.jpbc.Pairing;

import java.util.Map;


public interface AccessControlEngine {
    String getEngineName();

    boolean isSupportThresholdGate();

    AccessControlParameter generateAccessControl(int[][] accessPolicy, String[] rhos);

    Map<String, Element> secretSharing(Pairing pairing, Element secret, AccessControlParameter accessControlParameter);

    Map<String, Element> reconstructOmegas(Pairing pairing, String[] attributes, AccessControlParameter accessControlParameter) throws UnsatisfiedAccessControlException;
    

}