package generators;

import it.unisa.dia.gas.jpbc.Element;
import org.bouncycastle.crypto.CipherParameters;
import org.bouncycastle.crypto.InvalidCipherTextException;

/**
 * 
 * interface that a pairing-based decryption generator should conform to.
 */
public interface PairingDecryptionGenerator {
    /**
     * 
     * @param params the parameters the decryption is to be initialised with.
     */
    void init(CipherParameters params);

    /**
    
     * @return the message recovered from the ciphertext.
     */
    Element recoverMessage() throws InvalidCipherTextException;
}
