package serparams;

import org.bouncycastle.crypto.CipherParameters;


public class AsymmetricKeySerParameter implements CipherParameters, java.io.Serializable {
    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private boolean privateKey;

	/**
	 * 
	 * @param privateKey
	 */
    public AsymmetricKeySerParameter(boolean privateKey) {
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
        if (anOjbect instanceof AsymmetricKeySerParameter) {
            AsymmetricKeySerParameter that = (AsymmetricKeySerParameter)anOjbect;
            //Compare Pairing Parameters
            return (this.privateKey == that.privateKey);
        }
        return false;
    }
}
