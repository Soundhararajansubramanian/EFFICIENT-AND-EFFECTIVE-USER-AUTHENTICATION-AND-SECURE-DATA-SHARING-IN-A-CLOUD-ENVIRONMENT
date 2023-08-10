package generators;

import serparams.PairingKeySerParameter;
import org.bouncycastle.crypto.KeyGenerationParameters;

/**
 * 
 */
public interface PairingKeyParameterGenerator {

    void init(KeyGenerationParameters keyGenerationParameters);

    //PairingKeySerParameter generateKey();
    
}
