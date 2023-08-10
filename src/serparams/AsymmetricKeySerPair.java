package serparams;
import org.bouncycastle.crypto.CipherParameters;

public class AsymmetricKeySerPair {
	 private AsymmetricKeySerParameter publicParam;
	    private AsymmetricKeySerParameter privateParam;

	    /**
	     * 
	     * @param publicParam a public key parameters object.
	     * @param privateParam the corresponding private key parameters.
	     */
	    public AsymmetricKeySerPair(AsymmetricKeySerParameter publicParam, AsymmetricKeySerParameter privateParam)
	    {
	        this.publicParam = publicParam;
	        this.privateParam = privateParam;
	    }

	    /**
	     * （out of date）
	     * @param publicParam a public key parameters object.
	     * @param privateParam the corresponding private key parameters.
	     * @deprecated use AsymmetricKeyParameter
	     */
	    public AsymmetricKeySerPair(CipherParameters publicParam, CipherParameters privateParam)
	    {
	        this.publicParam = (AsymmetricKeySerParameter)publicParam;
	        this.privateParam = (AsymmetricKeySerParameter)privateParam;
	    }

	    /**
	     * 
	     * @return the public key parameters.
	     */
	    public AsymmetricKeySerParameter getPublic()
	    {
	        return publicParam;
	    }

	    /**
	     * 
	     * @return the private key parameters.
	     */
	    public AsymmetricKeySerParameter getPrivate()
	    {
	        return privateParam;
	    }
}
