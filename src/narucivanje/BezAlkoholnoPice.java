package narucivanje;

import narucivanje.enumi.VrstaNeAlkohola;

public class BezAlkoholnoPice extends Pice {

    private VrstaNeAlkohola vrstaNeAlkohola;

    public BezAlkoholnoPice(String ime, double kolicina, int cena, VrstaNeAlkohola vrstaNeAlkohola) {
        super(ime, kolicina, cena);
        this.vrstaNeAlkohola = vrstaNeAlkohola;
    }

    @Override
    public boolean piceZaOdrasle() {
        return false;
    }

    public VrstaNeAlkohola getVrstaNeAlkohola() {
        return vrstaNeAlkohola;
    }

}
