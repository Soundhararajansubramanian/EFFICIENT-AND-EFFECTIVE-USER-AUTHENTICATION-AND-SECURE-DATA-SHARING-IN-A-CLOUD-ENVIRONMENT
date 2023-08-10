package abe;

import java.util.HashMap;
import java.util.Map;

import org.bouncycastle.crypto.InvalidCipherTextException;

import acess.ParserUtils;
import acess.PolicySyntaxException;
import it.unisa.dia.gas.jpbc.Element;
import it.unisa.dia.gas.jpbc.Pairing;
import it.unisa.dia.gas.jpbc.PairingParameters;
import it.unisa.dia.gas.plaf.jpbc.pairing.PairingFactory;
import it.unisa.dia.gas.plaf.jpbc.pairing.a.TypeACurveGenerator;
import serparams.PairingCipherSerParameter;
import serparams.PairingKeySerPair;
import serparams.PairingKeySerParameter;
import utils.PairingUtils;
import utils.PairingUtils.PairingGroupType;

public class ABE {
	public  void testABE(String fn,String sub,String year,String dep,String filecon) {
	 CPABEwatersEngine abe=new CPABEwatersEngine();
	 
	 //Set pairing type
	 int rBits = 160; //Group order
	 int qBits = 512; // The order of zq.
	 TypeACurveGenerator pg = new TypeACurveGenerator(rBits, qBits); //Specify the type of elliptic curve typeA
	 PairingParameters typeAParams = pg.generate();
	
	 String []deparray=dep.split(",");
         System.out.print(deparray[0]+" "+deparray[1]);
	 
	 System.out.println("Encryption mechanism："+abe.getEngineName());
	 System.out.print("\n");
	 
	 
	 //Attribute domain
	// String[] attributeUniverse= {"Hegong University","Xuancheng Campus","Emerald Lake Campus","IT Academy","School of Mechanical Engineering","School of Vehicle Engineering"};
	 String[] attributeUniverse= {sub,year,deparray[0],deparray[1]};
	 
	 //Maximum number of attributes
	 int maxNumAttributes=4;
	 
	 /*print*/
	 System.out.print("Attribute domain：");
	 
	 for(String str:attributeUniverse) {
		 System.out.print(str+" ");
	 }
	 System.out.print("\n");
	 /*print*/
	 
	 
	 //SetUp algorithm
	 PairingKeySerPair KeyPair=abe.setup(typeAParams, maxNumAttributes,attributeUniverse);
	
	 //Access strategy
	// String AccessPolicy="(Hegong University AND ( IT Academy AND (Emerald Lake Campus OR Xuancheng Campus)))";
	//{sub,year,deparray[0],deparray[1]};
        String AccessPolicy="("+sub+" AND ("+ year+" AND ("+ deparray[0]+" OR "+deparray[1]+")))";
     //    String AccessPolicy="( A AND ( B OR (C) ))";
         
	 int[][] accesspolicy = null;
	 
	 //Generate strategy matrix
	 try {
		 accesspolicy=ParserUtils.GenerateAccessPolicy(AccessPolicy);
	} catch (PolicySyntaxException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	 //Ciphertext attributes
	 String[] rhos=new String[accesspolicy.length];
	 try {
		rhos=ParserUtils.GenerateRhos(AccessPolicy);
	} catch (PolicySyntaxException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}

	 /*print*/
	 System.out.println("Access control strategy："+AccessPolicy);
	 System.out.println("Access control matrix structure：");
     for(int i=0;i<accesspolicy.length;i++) {
		 for(int j=0;j<accesspolicy[i].length;j++)
		 {
			 System.out.print(accesspolicy[i][j]+"\t");
		 }
		 System.out.print("\n");
	 }
     System.out.print("\n");
     /*print*/
	 
     //Plaintext
	 String message= filecon;//"Ciphertext-policy attribute-based encryption: An expressive, efficient, and provably secure realization";
	 Element elementMessage=PairingUtils.MapStringToGroup(PairingFactory.getPairing(typeAParams), message, PairingGroupType.GT).getImmutable();
	 Map<Element,String> PT=new HashMap<Element,String >();
	 PT.put(elementMessage,message);
	 System.out.println("PlainText："+message);
	 System.out.print("\n");
	 //Encryption algorithm
	 CiphertextSerParameter Cipher=abe.encryption(KeyPair.getPublic(), accesspolicy, rhos, elementMessage);
     System.out.println("Ciphertext："+Cipher.getC().toString());
	System.out.print("\n");
	 
	 //Private key attributes
	// String[] attributes= {"Hegong University","IT Academy","Xuancheng Campus"};
//         String[] attributes= {"A","D","B"};
//	 System.out.print("User attributes：");
//	 for(int k=0;k<attributes.length;k++) {
//		  System.out.print(attributes[k]+" ");
//	 }
//	 
//	 //Key Generation algorithm
//	 PairingKeySerParameter SecretKey=abe.keyGen(KeyPair.getPublic(), KeyPair.getPrivate(), attributes);
//         System.out.println("\nSecretkey:-"+SecretKey.hashCode());
//         
//	 Element recoverElementMessage =PairingFactory.getPairing(typeAParams).getGT().newOneElement().getImmutable();
//	           
//         System.out.println("\nElement"+recoverElementMessage.toString());
//	 //Encryption algorithm
//	 try {
//		 recoverElementMessage=abe.decryption(KeyPair.getPublic(), SecretKey, accesspolicy,rhos, Cipher).getImmutable();
//	} catch (InvalidCipherTextException e) {
//		// TODO Auto-generated catch block
//		e.printStackTrace();
//	}
//	System.out.println("Element"+recoverElementMessage.toString());
//	 System.out.print("\n");
//	 System.out.println("Decrypt："+PT.get(recoverElementMessage.toString()));
//	 if(elementMessage.isEqual(recoverElementMessage) ) {
//		 System.out.println("Decrypt："+PT.get(elementMessage));
//		}
	
	
 }
 
	
 
}
