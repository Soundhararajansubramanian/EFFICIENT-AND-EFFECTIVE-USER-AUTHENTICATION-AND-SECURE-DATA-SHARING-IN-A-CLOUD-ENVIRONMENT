package genparams;

import serparams.PairingCipherSerParameter;
import serparams.PairingKeySerParameter;
import org.bouncycastle.crypto.CipherParameters;

/**
 * 
 * Pairing decryption generation parameter
 */
public abstract class PairingDecryptionGenerationParameter implements CipherParameters {
    private PairingKeySerParameter publicKeyParameter;
    private PairingKeySerParameter secretKeyParameter;
    private PairingCipherSerParameter ciphertextParameter;

    /**
     * 
     * @param publicKeyParameter
     * @param secretKeyParameter
     * @param ciphertextParameter
     */
    public PairingDecryptionGenerationParameter(
            PairingKeySerParameter publicKeyParameter, PairingKeySerParameter secretKeyParameter,
            PairingCipherSerParameter ciphertextParameter) {
        this.publicKeyParameter = publicKeyParameter;
        this.secretKeyParameter = secretKeyParameter;
        this.ciphertextParameter = ciphertextParameter;
    }
    
    public PairingKeySerParameter getPublicKeyParameter() { return this.publicKeyParameter; }

    
    public PairingKeySerParameter getSecretKeyParameter() { return this.secretKeyParameter; }
    //
    public PairingCipherSerParameter getCiphertextParameter() { return this.ciphertextParameter; }
}