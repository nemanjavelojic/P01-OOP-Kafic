package kafic;

import narucivanje.Pice;
import narucivanje.Racun;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class Sto {

    private List<Gost> gosti;
    private Racun racun;
    private int brojStola;
    private static int brojacStolova;
    private Konobar konobar;
    private LocalDateTime vremePorudzbine;

    public Sto() {
        this.gosti = new ArrayList<>();
        this.racun = new Racun();
        Sto.brojacStolova++;
        this.brojStola = brojacStolova;
    }

    public void dodajNaRacun(Pice p) {

        getRacun().getListaPica().add(p);
        getRacun().dodajNovac(p.getCena());

    }

    public List<Gost> getGosti() {
        return gosti;
    }

    public Racun getRacun() {
        return racun;
    }

    public void setRacun(Racun racun) {
        this.racun = racun;
    }

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


    public LocalDateTime getVremePorudzbine() {
        return vremePorudzbine;
    }

    public void setVremePorudzbine(LocalDateTime vremePorudzbine) {
        this.vremePorudzbine = vremePorudzbine;
    }

    @Override
    public String toString() {
        return "Broj stola: " + brojStola + " " + "racun je: "+getRacun().getNovac();
    }


}
