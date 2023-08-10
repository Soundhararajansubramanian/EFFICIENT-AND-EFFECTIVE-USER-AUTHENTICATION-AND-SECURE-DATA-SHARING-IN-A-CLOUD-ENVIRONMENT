package generators;

import serparams.PairingKeyEncapsulationSerPair;
import org.bouncycastle.crypto.CipherParameters;

/**
 * 
 * interface that a pairing KEM encryption pair generator should conform to.
 */

public interface PairingEncapsulationPairGenerator {

    /**
     * 
     * @param params the parameters the public key pair is to be initialised with.
     */
    void init(CipherParameters params);

    /**
     * 
     * @return an PairingKeyEncapsulationSerPair containing the generated session key and the ciphertext.
     */
   PairingKeyEncapsulationSerPair generateEncryptionPair();
   
}
