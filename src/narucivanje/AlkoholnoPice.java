package narucivanje;

import narucivanje.enumi.VrstaAlkohola;

public class AlkoholnoPice extends Pice {

    private VrstaAlkohola vrstaAlkohola;

    public AlkoholnoPice(String ime, double kolicina, int cena, VrstaAlkohola vrstaAlkohola) {
        super(ime, kolicina, cena);
        this.vrstaAlkohola = vrstaAlkohola;
    }

    @Override
    public boolean piceZaOdrasle() {
        return true;
    }

    public VrstaAlkohola getVrstaAlkohola() {
        return vrstaAlkohola;
    }

}
