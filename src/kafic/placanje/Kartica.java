package kafic.placanje;

import kafic.Gost;

public class Kartica implements NacinPlacanja {

    private int novac;
    private Gost gost;

    public Kartica(int novac) {
        this.novac = novac;
    }

    @Override
    public void plati() {

        int placanje = this.novac - gost.getVrednostRacuna();

        this.novac = placanje;

        gost.getSto().getRacun().ocistiRacun();
        gost.getSto().setVremePorudzbine(null);
    }

    public int getNovac() {
        return novac;
    }

    public Gost getGost() {
        return gost;
    }

    public void setGost(Gost gost) {
        this.gost = gost;
    }
}
