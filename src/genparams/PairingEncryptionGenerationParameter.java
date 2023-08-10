package genparams;

import serparams.PairingKeySerParameter;
import it.unisa.dia.gas.jpbc.Element;

//
public abstract class PairingEncryptionGenerationParameter extends PairingEncapsulationGenerationParameter {
    private Element message;//

    /**
     * 
     * @param publicKeyParameter
     * @param message
     */
    public PairingEncryptionGenerationParameter(PairingKeySerParameter publicKeyParameter, Element message) {
        super(publicKeyParameter);
        if (message != null) {
            //parameter for encryption.
            this.message = message.getImmutable();
        }
    }

    /**
     * 
     * @return
     */
    public Element getMessage() {
        if (message == null) {
            return null;
        }
        return this.message.duplicate();
    }
}
