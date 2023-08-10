package generators;

import serparams.PairingCipherSerParameter;
import org.bouncycastle.crypto.CipherParameters;

import algorithm.Lagrange;

/**
 * 
 */
public interface PairingEncryptionGenerator {

    /**
     * 
     * @param params the parameters the public key pair is to be initialised with.
     */
    void init(CipherParameters params);

    /**
     * 
     * @return a PairingCipherSerParameter representing the ciphertext.
     */
    PairingCipherSerParameter generateCiphertext();
    
}
