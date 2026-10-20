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

    public void setIme(String ime) {
        this.ime = ime;
    }

    public List<Sto> getStolovi() {
        return stolovi;
    }

    public void setStolovi(List<Sto> stolovi) {
        this.stolovi = stolovi;
    }

    public Kafic getKafic() {
        return kafic;
    }



}
