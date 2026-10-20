package kafic;

import java.util.ArrayList;
import java.util.List;

public class Sto {

    private List<Gost> gosti;
    private int racun;
    private int brojStola;
    private static int brojacStolova;

    public Sto() {
        this.gosti = new ArrayList<>();
        this.racun = 0;
        Sto.brojacStolova++;
        this.brojStola = brojacStolova;
    }


    public List<Gost> getGosti() {
        return gosti;
    }

    public void setGosti(List<Gost> gosti) {
        this.gosti = gosti;
    }

    public int getRacun() {
        return racun;
    }

    public void setRacun(int racun) {
        this.racun = racun;
    }

    // samo getter, radi sigurnosti
    public int getBrojStola() {
        return brojStola;
    }

}
