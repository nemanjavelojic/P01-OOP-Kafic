package kafic;

import narucivanje.Pice;

import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

public class Konobar {

    private String ime;
    private List<Sto> stolovi;
    private Kafic kafic;
    private Gost gost;

    public Konobar(String ime, Kafic kafic) {
        this.ime = ime;
        this.stolovi = new ArrayList<>();
        this.kafic = kafic;
    }

    public String getIme() {
        return ime;
    }

    public List<Sto> getStolovi() {
        return stolovi;
    }


    public Gost gostZaPlacanje() {

        for(Sto s : getStolovi()){

            for(Gost g : s.getGosti()){

                return g;

            }

        }

        return null;

    }

    public void prikaziStolove() {

        for(Sto s : kafic.kopijaStolova()){

            System.out.println("=====Prikaz stola=====");
            System.out.println("Gosti ovog stola su:");
            for(Gost g : s.getGosti()){

                System.out.println("Ime gosta: "+g.getIme());
                System.out.println("Prezime gosta: "+g.getPrezime());
                System.out.println("Godine gosta: "+g.getGodine());
                System.out.println("Novac gosta: "+g.getNovcanik().getKes());
                System.out.println("Novac gosta na kartici: "+g.getNovcanik().getKartica());

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

    public void proveriVreme() {


        if(stolovi.isEmpty()){
            System.out.println("Jos nemate odabrani sto, izaberite neki od slobodnih.");
        }else{

            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd.MM.yyyy HH:mm");

            for(Sto s : stolovi) {

                System.out.println("Broj stola je: "+s.getBrojStola());
                if(s.getVremePorudzbine() == null){
                    System.out.println("Za ovim stolom jos nema ni jedne porudzbine.");
                }else{
                    System.out.println("Vreme porudzbine je: "+s.getVremePorudzbine().format(formatter));
                }

            }

        }

    }

    public void castiSto(int brojStola) {

        boolean stoNadjen = false;

        for(Sto s : stolovi) {

            if(brojStola == s.getBrojStola()){
                stoNadjen = true;

                if(s.getRacun().getNovac()<=0){
                    System.out.println("Racun za stolom broj: "+s.getBrojStola()+" je 0 rsd, trenutno nije moguce castiti.");
                }else{
                    s.getRacun().ocistiRacun();
                    s.setVremePorudzbine(null);
                    System.out.println("Uspesno si castio za stolom broj: "+s.getBrojStola());
                }

            }

        }

        if(!stoNadjen){

            System.out.println("Ovaj sto nije pronadjen kao Vas sto, ne mozete castiti u ime Kafica.");

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

        if(sto.getRacun().getNovac()<=0){
            System.out.println("Racun za ovaj sto"+" "+sto.getBrojStola()+" "+"je placen.");
            return true;
        }else{
            System.out.println("Racun za ovaj sto"+" "+sto.getBrojStola()+" "+"nije placen.");
            return false;
        }


    }

    public Kafic getKafic() {
        return kafic;
    }

    public Gost getGost() {
        return gost;
    }

    @Override
    public String toString() {
        return "Ime ovog konobara je: "+getIme()+" a njegovi stolovi su: "+
                stolovi.toString();
    }
}
