package chameleonhash;

import org.bouncycastle.crypto.CipherParameters;
import org.bouncycastle.crypto.CryptoException;
import org.bouncycastle.crypto.DataLengthException;


public interface ChameleonHasher {
    /**
     *
     * @param forCollisionFind true if for finding a hash collision, false otherwise
     * @param param necessary parameters.
     */
    void init(boolean forCollisionFind, CipherParameters param);

    /**
     * 
     */
    void update(byte b);

    /**
     *  
     */
    void update(byte[] in, int off, int len);

    /**
     * 
     */
    byte[][] computeHash() throws CryptoException, DataLengthException;

    /**
     * 
     */
    byte[][] computeHash(byte[] cHashResult, byte[] auxiliaryParameters) throws CryptoException, DataLengthException;

    byte[][] findCollision(byte[] cHashResult, byte[] auxiliaryParameters);

    /**
     * 
     */
    void reset();
}