package kafic.placanje;

import kafic.Gost;

public class Novcanik {

    private Kes kes; // placanje u kesu
    private Kartica kartica; // placanje sa karticom

    public Novcanik(Kes kes, Kartica kartica) {
        this.kes = kes;
        this.kartica = kartica;
    }

    public Kes getKes() {
        return kes;
    }

    public Kartica getKartica() {
        return kartica;
    }

}
