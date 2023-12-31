package serparams;

import it.unisa.dia.gas.jpbc.PairingParameters;
import org.bouncycastle.crypto.CipherParameters;

import java.io.Serializable;


public class PairingCipherSerParameter implements CipherParameters, Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private PairingParameters parameters;

	/**
	 * 
	 * @param parameters
	 */
    public PairingCipherSerParameter(PairingParameters parameters) {
        this.parameters = parameters;
    }

    /**
     * 
     * @return
     */
    public PairingParameters getParameters() {
        return parameters;
    }

    /**
     * 
     */
    @Override
    public boolean equals(Object anOjbect) {
        if (this == anOjbect) {
            return true;
        }
        if (anOjbect instanceof PairingCipherSerParameter) {
            PairingCipherSerParameter that = (PairingCipherSerParameter)anOjbect;
            //Compare Pairing Parameters
            return this.getParameters().toString().equals(that.getParameters().toString());
        }
        return false;
    }
}
