package pica;

public abstract class Pice {

    private String ime;
    private double kolicina;
    private int cena;

    public Pice(String ime, double kolicina, int cena) {
        this.ime = ime;
        this.kolicina = kolicina;
        this.cena = cena;
    }

    public String getIme() {
        return ime;
    }

    public double getKolicina() {
        return kolicina;
    }

    public int getCena() {
        return cena;
    }

    @Override
    public String toString() {
        return getIme() + " " + "od:" + " " + getKolicina() + "l" + " " + "po ceni:" + " " +getCena() + " " + "din";
    }

}
