package kafic;

import kafic.placanje.Novcanik;
import narucivanje.Pice;

import java.time.LocalDateTime;
import java.util.List;

public class Gost {

    private String ime;
    private String prezime;
    private int godine;
    private Novcanik novcanik;
    private Sto sto;

    public Gost(String ime, String prezime, int godine, Novcanik novcanik) {
        this.ime = ime;
        this.prezime = prezime;
        this.godine = godine;
        this.novcanik = novcanik;
        this.sto = sto;
    }

    public String getIme() {
        return ime;
    }

    public String getPrezime() {
        return prezime;
    }

    public int getGodine() {
        return godine;
    }

    public Sto getSto() {
        return sto;
    }

    public void setSto(Sto sto) {
        this.sto = sto;
    }

    public Novcanik getNovcanik() {
        return novcanik;
    }

    public void naruciPice(int izborOT, int n) {

        List<Pice> bezAlkoholnaPica;
        List<Pice> alkoholnaPica;

        bezAlkoholnaPica = getSto().getKonobar().getKafic().getMeniPiceBezAlkoholna();
        alkoholnaPica = getSto().getKonobar().getKafic().getMeniPiceAlkoholna();

        Pice pice = null;

        if (izborOT == 1) {
            pice = bezAlkoholnaPica.get(n - 1);
        } else if (izborOT == 2) {
            pice = alkoholnaPica.get(n - 1);
        } else {
            System.out.println("Niste uneli pravi broj (1) ili (2)");
        }

        if(pice != null){

            if(pice.piceZaOdrasle() && getGodine()<18){
                System.out.println("Ne mozete naruciti alkoholno pice nemate dovoljno godina(18+)");
            }else{
                if(getNovcanik().getKes().getNovac() >= pice.getCena()+getVrednostRacuna()
                        || getNovcanik().getKartica().getNovac() >= pice.getCena()+getVrednostRacuna()){
                    if(getSto().getRacun().getListaPica().isEmpty()){
                        getSto().setVremePorudzbine(LocalDateTime.now());
                    }
                    getSto().dodajNaRacun(pice);
                }else{
                    System.out.println("Nemate dovoljno novca da narucite pice.");
                }

            }

        }

    }

    public int getVrednostRacuna() {

        Sto s = getSto();

        int vrednostRacuna;

        vrednostRacuna = s.getRacun().getNovac();

        return vrednostRacuna;

    }


    @Override
    public String toString() {
        return "Ime: " + ime + " Prezime: " + prezime;
    }

}
