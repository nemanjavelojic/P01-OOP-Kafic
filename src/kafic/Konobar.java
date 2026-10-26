package kafic;

import pica.Pice;

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

    public void prikaziStolove() {

        for(Sto s : kafic.kopijaStolova()){

            System.out.println("=====Prikaz stola=====");
            System.out.println("Gosti ovog stola su:");
            for(Gost g : s.getGosti()){

                System.out.println("Ime gosta: "+g.getIme());
                System.out.println("Prezime gosta: "+g.getPrezime());
                System.out.println("Godine gosta: "+g.getGodine());
                System.out.println("Novac gosta: "+g.getNovac());

            };
            System.out.println("Broj ovog stola je:"+" "+s.getBrojStola());
            System.out.println("Racun stola je:"+" "+s.getRacun());

        }

    }

    public void prikaziMojeStolove() {

        for(Sto s : stolovi) {

            System.out.println(s.toString());

        }

    }

    // metoda koja sluzi da kada gost sedne za stolom, konobar preda meni pica i gost moze to da pogleda i poruci pice
    public void predajMeni(int n){

            Sto sto = kafic.getStoPoBroju(n);
            stolovi.add(sto);
            sto.setKonobar(this);

    }

    public void pregledMenijaBezAlkPica(){

        for(Pice p : kafic.getMeniPiceBezAlkoholna()){

            System.out.println("Naziv pica: "+p.getIme());
            System.out.println("Kolicina u l: "+p.getKolicina());
            System.out.println("Cena pica: "+p.getCena());
            System.out.println("================================");

        }

    }

    public void pregledMenijaAlkPica(){

        for(Pice p : kafic.getMeniPiceAlkoholna()){

            System.out.println("Naziv pica: "+p.getIme());
            System.out.println("Kolicina u l: "+p.getKolicina());
            System.out.println("Cena pica: "+p.getCena());
            System.out.println("================================");

        }


    }

    public void napustiSto(int n){

        Sto sto = kafic.getStoPoBroju(n);
        stolovi.remove(sto);
        sto.setKonobar(null);

    }


    public boolean placenRacun(int n) {

        Sto sto = kafic.getStoPoBroju(n);

        if(sto.getRacun()<=0){
            System.out.println("Racun za ovaj sto"+" "+sto.getBrojStola()+" "+"je placen.");
            return true;
        }else{
            System.out.println("Racun za ovaj sto"+" "+sto.getBrojStola()+" "+"nije placen.");
            return false;
        }


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
