package abe;

import acess.AccessControlEngine;
import acess.AccessControlParameter;

import generators.PairingEncapsulationPairGenerator;
import generators.PairingEncryptionGenerator;
import serparams.PairingCipherSerParameter;
import serparams.PairingKeyEncapsulationSerPair;

import genparams.CPABEEncryptionGenerationParameter;

import it.unisa.dia.gas.jpbc.Element;
import it.unisa.dia.gas.jpbc.Pairing;
import it.unisa.dia.gas.plaf.jpbc.pairing.PairingFactory;
import org.bouncycastle.crypto.CipherParameters;

import java.util.HashMap;
import java.util.Map;


public class EncryptionGenerator implements PairingEncryptionGenerator, PairingEncapsulationPairGenerator {
	 private CPABEEncryptionGenerationParameter parameter;

	    private PublicKeySerParameter publicKeyParameter;
	    private Element sessionKey;
	    private Element Cprime;//C'
	    private Map<String, Element> C1s;//C1i
	    private Map<String, Element> D1s;//D1i

	    public void init(CipherParameters parameter) {
	        this.parameter = (CPABEEncryptionGenerationParameter) parameter;
	        this.publicKeyParameter = (PublicKeySerParameter) this.parameter.getPublicKeyParameter();
	    }

	    private void computeEncapsulation() {
	        int[][] accessPolicy = this.parameter.getAccessPolicy();
	        String[] rhos = this.parameter.getRhos();
	        AccessControlEngine accessControlEngine = this.parameter.getAccessControlEngine();
	        AccessControlParameter accessControlParameter = accessControlEngine.generateAccessControl(accessPolicy, rhos);
	        
	        Pairing pairing = PairingFactory.getPairing(publicKeyParameter.getParameters());
	        Element s = pairing.getZr().newRandomElement().getImmutable();
	        this.sessionKey = publicKeyParameter.getEggAlpha().powZn(s).getImmutable();
	        this.Cprime = publicKeyParameter.getG().powZn(s).getImmutable();
	        Map<String, Element> lambdas = accessControlEngine.secretSharing(pairing, s, accessControlParameter);
	        
	     
	        this.C1s = new HashMap<String, Element>();
	        this.D1s = new HashMap<String, Element>();
	       
	        for (String rho : lambdas.keySet()) {
	        	Element r=pairing.getZr().newRandomElement().getImmutable();
	            C1s.put(rho, publicKeyParameter.getGA().powZn(lambdas.get(rho)).mul(publicKeyParameter.getHAt(rho).powZn(r.negate())).getImmutable());
	            D1s.put(rho, publicKeyParameter.getG().powZn(r).getImmutable());
	          
	        }
	    }
        
	   
	    public CiphertextSerParameter generateCiphertext() {
	        computeEncapsulation();
	        Element C = this.sessionKey.mul(this.parameter.getMessage()).getImmutable();
	        return new CiphertextSerParameter(publicKeyParameter.getParameters(), C, Cprime, C1s, D1s);
	    }

	    public PairingKeyEncapsulationSerPair generateEncryptionPair() {
	        computeEncapsulation();
	        return new PairingKeyEncapsulationSerPair(
	                this.sessionKey.toBytes(),
	                new HeaderSerParameter(publicKeyParameter.getParameters(), Cprime, C1s, D1s)
	        );
	    }
}