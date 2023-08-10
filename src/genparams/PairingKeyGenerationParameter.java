package genparams;

import serparams.PairingKeySerParameter;
import org.bouncycastle.crypto.KeyGenerationParameters;

/**
 * 
 */
public class PairingKeyGenerationParameter extends KeyGenerationParameters {
    private PairingKeySerParameter masterSecretKeyParameter;//
    private PairingKeySerParameter publicKeyParameter;//

    /**
     * 
     * @param publicKeyParameter
     * @param masterSecretKeyParameter
     */
    public PairingKeyGenerationParameter(PairingKeySerParameter publicKeyParameter, PairingKeySerParameter masterSecretKeyParameter) {
        super(null, PairingParametersGenerationParameter.STENGTH);

        this.masterSecretKeyParameter = masterSecretKeyParameter;
        this.publicKeyParameter = publicKeyParameter;
    }
    
   /**
    * 
    * @return
    */
    public PairingKeySerParameter getMasterSecretKeyParameter() {
        return this.masterSecretKeyParameter;
    }
  /**
   * 
   * @return
   */
    public PairingKeySerParameter getPublicKeyParameter() {
        return this.publicKeyParameter;
    }
}
