package kafic;

public class Gost {

    private String ime;
    private String prezime;
    private int godine;
    private int novac;
    private Sto sto;

    public Gost(String ime, String prezime, int godine, int novac) {
        this.ime = ime;
        this.prezime = prezime;
        this.godine = godine;
        this.novac = novac;
    }

    // Setter za ime uklonjen

    public String getIme() {
        return ime;
    }

    // Setter za prezime je uklonjen

    public String getPrezime() {
        return prezime;
    }

    // Setter za godine uklonjen

    public int getGodine() {
        return godine;
    }

    public int getNovac() {
        return novac;
    }

    //Setter za novac je uklonjen

    public Sto getSto() {
        return sto;
    }

    public void setSto(Sto sto) {
        this.sto = sto;
    }

    @Override
    public String toString() {
        return "Ime: " + ime + " Prezime: " + prezime;
    }

}
