import kafic.Gost;
import kafic.Kafic;
import kafic.Konobar;
import kafic.Sto;

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
                        + "|7| - Resetuj kasu  |0| - Izlaz");
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
                    case 6:
                    // naplati racun stola
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
                System.out.println("Unesite koliko novca imate kod sebe:");
                System.out.println("===============================================");
                int novac = sc.nextInt();
                kafic.getGosti().add(new Gost(ime,prezime,godine,novac));
                gost = kafic.pronadjiGosta(ime,prezime);
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
                case 0:

                    uslov = false;
                    break;

            }
        }

    }


    public void  sediZaStolom(int brojStola, Gost gost){

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




