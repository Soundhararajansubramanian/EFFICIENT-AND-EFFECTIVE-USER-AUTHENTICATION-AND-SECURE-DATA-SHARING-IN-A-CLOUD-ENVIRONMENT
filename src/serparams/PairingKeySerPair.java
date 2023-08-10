package serparams;

import org.bouncycastle.crypto.CipherParameters;


public class PairingKeySerPair {
    
	private PairingKeySerParameter publicParam;
    private PairingKeySerParameter privateParam;

    /**
     * @param publicParam a public key parameters object.
     * @param privateParam the corresponding private key parameters.
    */
    public PairingKeySerPair(PairingKeySerParameter publicParam, PairingKeySerParameter privateParam)
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
    public PairingKeySerPair(CipherParameters publicParam, CipherParameters privateParam)
        {
            this.publicParam = (PairingKeySerParameter)publicParam;
            this.privateParam = (PairingKeySerParameter)privateParam;
        }

    /**
     * 
     * @return
     */
    public PairingKeySerParameter getPublic()
    {
        return publicParam;
    }

    /**
     * 
     * @return the private key parameters.
     */
    public PairingKeySerParameter getPrivate()
    {
        return privateParam;
    }
}