package genparams;

import serparams.PairingKeySerParameter;
import org.bouncycastle.crypto.KeyGenerationParameters;

//
public class PairingKeyDelegationParameter extends KeyGenerationParameters {
    private PairingKeySerParameter publicKeyParameter;
    private PairingKeySerParameter secretKeyParameter;
    
    /**
     * 
     * @param publicKeyParameter
     * @param secretKeyParameter
     */
    public PairingKeyDelegationParameter(PairingKeySerParameter publicKeyParameter, PairingKeySerParameter secretKeyParameter) {
        super(null, PairingParametersGenerationParameter.STENGTH);
        this.publicKeyParameter = publicKeyParameter;
        this.secretKeyParameter = secretKeyParameter;
    }

    /**
     * 
     * @return
     */
    public PairingKeySerParameter getPublicKeyParameter() {
        return this.publicKeyParameter;
    }

    /**
     * 
     * @return
     */
    public PairingKeySerParameter getSecretKeyParameter() {
        return this.secretKeyParameter;
    }
}