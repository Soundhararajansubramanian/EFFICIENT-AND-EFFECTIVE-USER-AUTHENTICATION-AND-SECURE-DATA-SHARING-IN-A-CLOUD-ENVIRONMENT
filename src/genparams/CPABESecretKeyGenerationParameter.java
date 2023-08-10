package genparams;


import serparams.PairingKeySerParameter;
import utils.PairingUtils;


/**
 * CP-ABE
 */
public class CPABESecretKeyGenerationParameter extends PairingKeyGenerationParameter {
    private String[] attributes;//

    /**
     *
     * @param publicKeyParameter
     * @param masterSecretKeyParameter
     * @param attributes
     */
    public CPABESecretKeyGenerationParameter(
            PairingKeySerParameter publicKeyParameter, PairingKeySerParameter masterSecretKeyParameter, String[] attributes) {
        super(publicKeyParameter, masterSecretKeyParameter);
        this.attributes = PairingUtils.removeDuplicates(attributes);
    }
    /**
     * 
     * @return
     */
    public String[] getAttributes() { return this.attributes; }
}