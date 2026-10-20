package pica;

public class AlkoholnoPice extends Pice {

    private VrstaAlkohola vrstaAlkohola;

    public AlkoholnoPice(String ime, double kolicina, int cena, VrstaAlkohola vrstaAlkohola) {
        super(ime, kolicina, cena);
        this.vrstaAlkohola = vrstaAlkohola;
    }

    public VrstaAlkohola getVrstaAlkohola() {
        return vrstaAlkohola;
    }

}
