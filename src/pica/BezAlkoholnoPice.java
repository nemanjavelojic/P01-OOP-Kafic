package pica;

public class BezAlkoholnoPice extends Pice {

    private VrstaNeAlkohola vrstaNeAlkohola;

    public BezAlkoholnoPice(String ime, double kolicina, int cena, VrstaNeAlkohola vrstaNeAlkohola) {
        super(ime, kolicina, cena);
        this.vrstaNeAlkohola = vrstaNeAlkohola;
    }

    public VrstaNeAlkohola getVrstaNeAlkohola() {
        return vrstaNeAlkohola;
    }

}
