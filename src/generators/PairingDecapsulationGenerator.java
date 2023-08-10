package generators;

import org.bouncycastle.crypto.CipherParameters;
import org.bouncycastle.crypto.InvalidCipherTextException;

/**
 * 
 * interface that a pairing KEM decryption generator should conform to.
 */
public interface PairingDecapsulationGenerator {
    /**
     *
     * @param params the parameters the decapsulation is to be initialised with.
     */
    void init(CipherParameters params);

    /**
     * 
     * @return the session key recovered from the ciphertext.
     */
    byte[] recoverKey() throws InvalidCipherTextException;
}