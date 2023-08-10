package serparams;

import it.unisa.dia.gas.jpbc.PairingParameters;


public class PairingKeySerParameter extends PairingCipherSerParameter {
    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private boolean privateKey;

	
    public PairingKeySerParameter(boolean privateKey, PairingParameters pairingParameters) {
        super(pairingParameters);
        this.privateKey = privateKey;
    }

    /**
     * 
     * @return
     */
    public boolean isPrivate()
    {
        return privateKey;
    }

    /**
     * 
     */
    @Override
    public boolean equals(Object anOjbect) {
        if (this == anOjbect) {
            return true;
        }
        if (anOjbect instanceof PairingKeySerParameter) {
            PairingKeySerParameter that = (PairingKeySerParameter)anOjbect;
            //Compare Pairing Parameters
            return (this.privateKey == that.privateKey);
        }
        return false;
    }
}
