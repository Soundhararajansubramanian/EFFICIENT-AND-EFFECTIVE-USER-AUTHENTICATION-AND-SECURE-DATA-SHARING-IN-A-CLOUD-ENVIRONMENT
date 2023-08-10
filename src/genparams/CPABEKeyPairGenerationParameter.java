package genparams;

import generators.AsymmetricKeySerPairGenerator;
import it.unisa.dia.gas.jpbc.PairingParameters;
import org.bouncycastle.crypto.KeyGenerationParameters;

/**
 
 * 
 */
public class CPABEKeyPairGenerationParameter extends PairingKeyPairGenerationParameter {
    private int maxAttributesNum;
    private AsymmetricKeySerPairGenerator chameleonHashKeyPairGenerator;
    private KeyGenerationParameters chameleonHashKeyGenerationParameter;

    /**
     *
     * @param pairingParameters
     */
    public CPABEKeyPairGenerationParameter(PairingParameters pairingParameters) {
        super(pairingParameters);
        this.maxAttributesNum = -1;
    }
    
   /**
    * 
    * @param pairingParameters
    * @param maxAttributesNum
    */
    public CPABEKeyPairGenerationParameter(PairingParameters pairingParameters, int maxAttributesNum) {
        super(pairingParameters);
        this.maxAttributesNum = maxAttributesNum;
    }

    /**
     * 
     * @param pairingParameters
     * @param chameleonHashKeyPairGenerator
     * @param chameleonHashKeyGenerationParameter
     */
    public CPABEKeyPairGenerationParameter(
            PairingParameters pairingParameters,
            AsymmetricKeySerPairGenerator chameleonHashKeyPairGenerator,
            KeyGenerationParameters chameleonHashKeyGenerationParameter) {
        super(pairingParameters);
        this.maxAttributesNum = -1;
        this.chameleonHashKeyPairGenerator = chameleonHashKeyPairGenerator;
        this.chameleonHashKeyGenerationParameter = chameleonHashKeyGenerationParameter;
    }

    /**
     * 
     * @return
     */
    public int getMaxAttributesNum() {
        return this.maxAttributesNum;
    }

    /**
     * 
     * @param maxAttributesNum
     * @return
     */
    public int setMaxAttributesNum(int maxAttributesNum) {
         this.maxAttributesNum=maxAttributesNum;
         return 0;
    }
    
    /**
     * 
     * @return
     */
    public AsymmetricKeySerPairGenerator getChameleonHashKeyPairGenerator() {
        return this.chameleonHashKeyPairGenerator;
    }

    /**
     * 
     * @return
     */
    public KeyGenerationParameters getChameleonHashKeyGenerationParameter() {
        return this.chameleonHashKeyGenerationParameter;
    }
}