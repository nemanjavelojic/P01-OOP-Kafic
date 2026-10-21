import kafic.Kafic;
import kafic.Konobar;

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
                    case 0:
                    uslov = false;
                    break;
                }




            }
        }

    }


    public static void main(String[] args) {

        Main main = new Main();

    }


}

