package narucivanje;

import java.util.ArrayList;
import java.util.List;

public class Racun {

    public int novac;
    public List<Pice> listaPica;

    public Racun() {
        this.novac = 0;
        this.listaPica = new ArrayList<>();
    }

    public void ocistiRacun(){

        this.novac = 0;
        listaPica.clear();

    }

    public int getNovac() {
        return novac;
    }
    public void dodajNovac(int novac) {
        this.novac += novac;
    }

    public List<Pice> getListaPica() {
        return listaPica;
    }

}
