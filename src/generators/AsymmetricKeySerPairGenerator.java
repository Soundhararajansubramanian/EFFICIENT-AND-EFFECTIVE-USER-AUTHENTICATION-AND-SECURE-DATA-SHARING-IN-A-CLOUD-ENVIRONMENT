package generators;

import serparams.AsymmetricKeySerPair;
import org.bouncycastle.crypto.KeyGenerationParameters;

/**
 * 
 * Asymmetric key pair generator.
 */
public interface AsymmetricKeySerPairGenerator {
    /**
     * 
     * @param param the parameters the key pair is to be initialised with.
     */
    void init(KeyGenerationParameters param);

    /**
     * 
     * @return an AsymmetricCipherKeyPair containing the generated keys.
     */
    AsymmetricKeySerPair generateKeyPair();
}
