import kafic.Gost;
import kafic.Kafic;
import kafic.Konobar;
import kafic.Sto;
import kafic.placanje.Kartica;
import kafic.placanje.Kes;
import kafic.placanje.Novcanik;

import java.util.List;
import java.util.Scanner;

public class Main {



    Kafic kafic = new Kafic("Vela");
    Scanner sc = new Scanner(System.in);
    String sifraSef = "sifra123"; // Sifra za Sefa

    private Main() {

        boolean uslov = true;
        while(uslov){
            System.out.println("===============================================");
            System.out.println("! Dobrodosli u Kafic ~Vela~ !");
            System.out.println("Izaberite opciju:\r\n"
                    + "|1| - Sef \r\n"
                    + "|2| - Konobar\r\n"
                    + "|3| - Gost\r\n"
                    + "|0| - Izlaz");
            System.out.println("===============================================");

        int izbor = sc.nextInt();

        switch (izbor) {

            case 1: programSef();
            break;
            case 2: programKonobar();
            break;
            case 3: programGost();
            break;
            case 0:
            uslov = false;
            break;
        }
        }
    }


    private void programSef() {


        System.out.println("Unesite sifru kako biste pristupili programu Sefa:");
        String sifra = sc.next();
        if(sifraSef.equals(sifra)){
            boolean uslov = true;
            while(uslov) {
                System.out.println("===============================================");
                System.out.println("Meni\r\n"
                        + "|1| - Dodaj stolove  |2| - Ukloni stolove\r\n"
                        + "|3| - Dodaj konobara  |4| - Ukloni konobara\r\n"
                        + "|5| - Prikazi konobare  |6| - Prikazi stolove\r\n"
                        + "|7| - Resetuj kasu  |8| - Prikazi kasu\r\n"
                        + "|0| - Izlaz");
                System.out.println("===============================================");

                int izbor = sc.nextInt();
                switch (izbor){
                    case 1:
                    System.out.println("Koliko zelite stolova da dodate, taj broj unesite:");
                    kafic.dodajStolove(sc.nextInt());
                    break;
                    case 2:
                    System.out.println("Unesite broj stola koji zelite da obrisete:");
                    kafic.ukloniSto(sc.nextInt());
                    break;
                    case 3:
                    System.out.println("Kreiramo konobara, unesite njegovo ime:");
                    kafic.dodajKonobara(sc.next());
                    break;
                    case 4:
                    System.out.println("Unesite ime konobara kojeg zelite ukloniti:");
                    kafic.ukloniteKonobara(sc.next());
                    break;
                    case 5:
                    System.out.println("Prikazivanje svih konobara u kaficu");
                    kafic.prikaziKonobare();
                    break;
                    case 6:
                    System.out.println("Prikazivanje svih stolova u kaficu");
                    kafic.prikaziStolove();
                    break;
                    case 7:
                    System.out.println("Resetovanje kase..");
                    kafic.resetujKasu();
                    break;
                    case 8:
                    kafic.prikaziKasu();
                    break;
                    case 0:
                    uslov = false;
                    break;
                }




            }
        }

    }

    private void programKonobar() {

        System.out.println("Unesite vase ime da biste pristupili vasem meniju:");
        String name = sc.next();
        for(Konobar k : kafic.getKonobari()){
            if(name.equalsIgnoreCase(k.getIme())){
                boolean uslov = true;
                while (uslov) {
                    System.out.println("===============================================");
                    System.out.println("Meni\r\n"
                            + "|1| - Pogledaj stolove  |2| - Predaj meni\r\n"
                            + "|3| - Moji stolovi  |4| - Napusti sto\r\n"
                            + "|5| - Pogledaj vreme  |6| - Naplati racun stola \r\n"
                            + "|7| - Konobar casti!  |0| - Izlaz");
                    System.out.println("===============================================");


                switch (sc.nextInt()){
                    case 1:
                    k.prikaziStolove();
                    break;
                    case 2:
                    System.out.println("Unesite tacan broj stola gde predajete meni, i taj sto postaje vas:");
                    int brojStola = sc.nextInt();
                    k.predajMeni(brojStola);
                    System.out.println("- Uspesno ste odabrali vas sto i to je broj: "+brojStola);
                    break;
                    case 3:
                    k.prikaziMojeStolove();
                    break;
                    case 4:
                        System.out.println("Pre nego sto napustite vas sto, proverite da li je placen racun.");
                        System.out.println("Ukoliko je racun placen, vise niste za ovim stolom.");
                        System.out.println("================================================================");
                        System.out.println("Unesite broj stola koji zelite da proverite racun i napustite ga.");
                        int brojStolaZaRacun;
                        brojStolaZaRacun = sc.nextInt();
                        if (k.placenRacun(brojStolaZaRacun)) {
                            k.napustiSto(brojStolaZaRacun);
                        }
                        break;
                    case 5:
                        k.proveriVreme();
                    break;
                    case 6:
                    System.out.println("Kako zelite da naplatite gostu kes(1) ili kartica(2)");
                    int iznosRacunaStola = k.gostZaPlacanje().getVrednostRacuna();
                    kafic.dodajKasi(iznosRacunaStola);
                    int izbor = sc.nextInt();
                    if(izbor == 1){
                        k.gostZaPlacanje().getNovcanik().getKes().plati();
                        System.out.println("Uspesno ste naplatili racun stola.");
                    }else if(izbor==2){
                        k.gostZaPlacanje().getNovcanik().getKartica().plati();
                        System.out.println("Uspesno ste naplatili racun stola.");
                    }else{
                        System.out.println("Niste uneli pravu opciju (1) ili (2)");
                        break;
                    }
                    break;
                    case 7:
                    System.out.println("Unesite broj stola koji zelite da castite u ime Kafica:");
                    k.castiSto(sc.nextInt());
                    break;
                    case 0:
                    uslov = false;
                    break;
                }

                }

            }
        }



    }

    private void programGost() {

        Gost gost = null;
        while(gost == null) {
            System.out.println("===============================================");
            System.out.println("Novi gost?\r\n"
            + "|1| Da\r\n"
            + "|2| Ne"
            );

            int izbor = sc.nextInt();
            switch (izbor) {

                case 1:
                System.out.println("Dobrodosli u kafic ~Vela~");
                System.out.println("Unesite potrebne podatke prilikom registracije:");
                System.out.println("===============================================");
                System.out.println("Unesite vase ime:");
                System.out.println("===============================================");
                String ime = sc.next();
                System.out.println("Unesite vase prezime:");
                System.out.println("===============================================");
                String prezime = sc.next();
                System.out.println("Unesite koliko imate godina:");
                System.out.println("===============================================");
                int godine = sc.nextInt();
                System.out.println("|=| Vas novcanik |=|");
                System.out.println("Unesite koliko novca imate kod sebe:");
                System.out.println("===============================================");
                int kesIznos = sc.nextInt();
                Kes kes = new Kes(kesIznos);
                System.out.println("Unesite koliko novca imate na kartici:");
                System.out.println("===============================================");
                int karticaIznos = sc.nextInt();
                Kartica kartica = new Kartica(karticaIznos);
                Novcanik novcanik = new Novcanik(kes, kartica);
                kafic.getGosti().add(new Gost(ime, prezime, godine, novcanik));


                gost = kafic.pronadjiGosta(ime,prezime);
                kes.setGost(gost);
                kartica.setGost(gost);

                break;
                case 2:
                System.out.println("===============================================");
                System.out.println("Unesite vase ime kako bi vas pronasli u sistemu:");
                String imeGosta = sc.next();
                System.out.println("Unesite vase prezime kako bi vas pronasli u sistemu:");
                String prezimeGosta = sc.next();
                gost = kafic.pronadjiGosta(imeGosta,prezimeGosta);
                break;

            }

        }

        System.out.println("===============================================");
        System.out.println("Dobrodosli! " +gost.getIme());
        System.out.println("===============================================");

        boolean uslov = true;
        while (uslov) {

            System.out.println("===============================================");
            System.out.println("Meni\r\n"
                    + "|1| - Odaberi sto  |2| - Pogledaj meni bezalkoholnih pica \r\n"
                    + "|3| - Pogledaj meni alkoholnih pica  |4| - Naruci pice\r\n"
                    + "|5| - Pogledaj racun  |6| - Pogledaj novcanik\r\n"
                    + "|7| - Plati racun  |0| - Izlaz");
            System.out.println("===============================================");

            int izbor = sc.nextInt();
            switch (izbor) {

                case 1:
                    kafic.prikaziStoloveGostu();
                    System.out.println("Unesite broja za kolim zelite da sedite:");
                    int brojStola = sc.nextInt();
                    sediZaStolom(brojStola,gost);
                    System.out.println("Konobar ce uskoro doci i doneti meni.");
                    break;
                case 2:
                    gost.getSto().getKonobar().pregledMenijaBezAlkPica();
                    break;
                case 3:
                    gost.getSto().getKonobar().pregledMenijaAlkPica();
                    break;
                case 4:
                    System.out.println("Narucujem bezalkoholno pice (1), Narucujem alkoholno pice (2)");
                    int izborOT = sc.nextInt();
                    System.out.println("Napisi broj po redu koje pice zelis poruciti.");
                    int n = sc.nextInt();
                    gost.naruciPice(izborOT,n);
                    break;
                case 5:
                    System.out.println("Vrednost racuna za vasim stolom je: "+gost.getVrednostRacuna());
                    break;
                case 6:
                    System.out.println("Proverava kes(1) ili kartica(2)");
                    int opcija = sc.nextInt();
                    if(opcija == 1){
                        System.out.println("U novcaniku imate: "+gost.getNovcanik().getKes().getNovac()+" rsd.");
                    }else if(opcija == 2){
                        System.out.println("Na kartici imate: "+gost.getNovcanik().getKartica().getNovac()+" rsd.");
                    }else{
                        System.out.println("Greska! Niste uneli (1) ili (2) opciju.");
                        break;
                    }
                    break;
                case 7:
                    System.out.println("Placanje racuna u toku..");
                    System.out.println("Ukoliko zelite da platite kesom odaberite (1), a ukoliko zelite karticom (2)");
                    int opcijaPlacanja = sc.nextInt();
                    if(opcijaPlacanja == 1){
                        gost.getNovcanik().getKes().plati();
                        System.out.println("Uspesno ste platili racun.");
                    }else if(opcijaPlacanja == 2){
                        gost.getNovcanik().getKartica().plati();
                        System.out.println("Uspesno ste platili racun.");
                    }else{
                        System.out.println("Niste uneli pravi izbor (1) ili (2)");
                        break;
                    }
                    break;
                case 0:
                    uslov = false;
                    break;

            }
        }

    }


    public void sediZaStolom(int brojStola, Gost gost){

        for(Sto s : kafic.getStolovi()){

            if(s.getBrojStola() == brojStola){
                gost.setSto(s);
                s.getGosti().add(gost);
                System.out.println(s.toString());
            }

        }

    }


    public static void main(String[] args) {

        Main main = new Main();

    }

}




