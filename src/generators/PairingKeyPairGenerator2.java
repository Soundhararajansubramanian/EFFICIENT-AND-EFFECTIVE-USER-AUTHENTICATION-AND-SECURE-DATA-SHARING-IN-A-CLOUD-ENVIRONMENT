package generators;

import serparams.PairingKeySerPair;
import org.bouncycastle.crypto.KeyGenerationParameters;

/**
 * 
 */
public interface PairingKeyPairGenerator2 {
    /**
     * 
     * @param param the parameters the key pair is to be initialised with.
     */
    void init(KeyGenerationParameters param);

    /**
     * 
     * @return an AsymmetricCipherKeyPair containing the generated keys.
     */
    PairingKeySerPair generateKeyPair();
    //PairingKeySerPair generateKeyPair(String[] rhos);
}