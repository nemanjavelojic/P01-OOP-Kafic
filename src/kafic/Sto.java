package kafic;

import java.util.ArrayList;
import java.util.List;

public class Sto {

    private List<Gost> gosti;
    private int racun;
    private int brojStola;
    private static int brojacStolova;
    private Konobar konobar;

    public Sto() {
        this.gosti = new ArrayList<>();
        this.racun = 0;
        Sto.brojacStolova++;
        this.brojStola = brojacStolova;
    }


    public List<Gost> getGosti() {
        return gosti;
    }

    // Setter za listu gostiju je obrisan radi sigurnosti

    public int getRacun() {
        return racun;
    }

    // Setter za racun stola je uklonjen

    // samo getter, radi sigurnosti, setter uklonjen
    public int getBrojStola() {
        return brojStola;
    }

    public Konobar getKonobar() {
        return konobar;
    }

    public void setKonobar(Konobar konobar) {
        this.konobar = konobar;
    }

    //staticki brojac nema ni getter ni setter



    @Override
    public String toString() {
        return "Broj stola: " + brojStola + " " + "racun je: "+racun;
    }


}
