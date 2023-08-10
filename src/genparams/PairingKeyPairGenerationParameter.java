package genparams;

import it.unisa.dia.gas.jpbc.PairingParameters;
import org.bouncycastle.crypto.KeyGenerationParameters;

/**
 * 
 */
public class PairingKeyPairGenerationParameter extends KeyGenerationParameters {
    private PairingParameters pairingParameters;//

    /**
     * 
     * @param pairingParameters
     */
    public PairingKeyPairGenerationParameter(PairingParameters pairingParameters) {
        super(null, PairingParametersGenerationParameter.STENGTH);
        this.pairingParameters = pairingParameters;
    }

    /**
     * 
     * @return
     */
    public PairingParameters getPairingParameters() { return this.pairingParameters; }
}