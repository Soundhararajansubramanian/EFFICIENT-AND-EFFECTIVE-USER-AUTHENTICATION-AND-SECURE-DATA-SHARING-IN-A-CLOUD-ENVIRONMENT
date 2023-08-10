package genparams;

import acess.AccessControlEngine;
import genparams.PairingDecryptionGenerationParameter;
import serparams.PairingCipherSerParameter;
import serparams.PairingKeySerParameter;
import chameleonhash.ChameleonHasher;

/**
 * CP-ABE 
 */
public class CPABEDecryptionGenerationParameter extends PairingDecryptionGenerationParameter {
    private int[][] accessPolicy;
    private String[] rhos;
    private AccessControlEngine accessControlEngine;
    private ChameleonHasher chameleonHasher;

    public CPABEDecryptionGenerationParameter(
            AccessControlEngine accessControlEngine, PairingKeySerParameter publicKeyParameter, PairingKeySerParameter secretKeyParameter,
            int[][] accessPolicy, String[] rhos, PairingCipherSerParameter ciphertextParameter) {
        super(publicKeyParameter, secretKeyParameter, ciphertextParameter);
        this.accessControlEngine = accessControlEngine;
        this.accessPolicy = accessPolicy;
        this.rhos = rhos;
    }

    public void setChameleonHasher(ChameleonHasher chameleonHasher) {
        this.chameleonHasher = chameleonHasher;
    }

    public int[][] getAccessPolicy() { return this.accessPolicy; }

    public String[] getRhos() { return this.rhos; }

    public AccessControlEngine getAccessControlEngine() { return this.accessControlEngine; }

    public ChameleonHasher getChameleonHasher() { return this.chameleonHasher; }
}