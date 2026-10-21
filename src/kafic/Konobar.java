package kafic;

import java.util.ArrayList;
import java.util.List;

public class Konobar {

    private String ime;
    private List<Sto> stolovi;
    private Kafic kafic;

    public Konobar(String ime, Kafic kafic) {
        this.ime = ime;
        this.stolovi = new ArrayList<>();
        this.kafic = kafic;
    }

    public String getIme() {
        return ime;
    }

    // Setter za ime konobara je uklonjen

    public List<Sto> getStolovi() {
        return stolovi;
    }

    // Setter za stolove je uklonjen

    public Kafic getKafic() {
        return kafic;
    }

    @Override
    public String toString() {
        return "Ime ovog konobara je: "+getIme()+" a njegovi stolovi su: "+
                stolovi.toString();
    }
}
