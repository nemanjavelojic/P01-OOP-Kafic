package kafic;

import pica.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Kafic {

    private String naziv;
    private List<Sto> stolovi;
    private List<Konobar> konobari;
    private List<Gost> gosti;
    private List<Pice> meniPiceBezAlkoholna;
    private List<Pice> meniPiceAlkoholna;
    private int kasa;

    public Kafic(String naziv) {
        this.naziv = naziv;
        this.stolovi = new ArrayList<>();
        this.konobari = new ArrayList<>();
        this.gosti = new ArrayList<>();
        this.meniPiceBezAlkoholna = svaPicaBezAlkoholna();
        this.meniPiceAlkoholna = svaPicaAlkoholna();
        this.kasa = 0;
    }

    public List<Sto> kopijaStolova() {

        List<Sto> kopijaSvihStolova = new ArrayList<>();

        kopijaSvihStolova = stolovi;

        return kopijaSvihStolova;

    }


    public void resetujKasu() {

        if(this.kasa > 0) {
            setKasa(0);
        }

    }


    public void dodajStolove(int n){

        for(int i = 0; i < n; i++){
            Sto sto = new Sto();
            stolovi.add(sto);
        }

    }

    public void prikaziStolove() {

        for(Sto s : stolovi){
            System.out.println(s.toString());
        }

    }

    public void ukloniSto(int n) {

        for(Sto s : stolovi) {
            if(s.getBrojStola() == n){
                stolovi.remove(s);
                break;
            }
        }

    }

    public void prikaziKonobare() {

        for(Konobar k : konobari)  {
            System.out.println(k.toString());
        }

    }

    // Konobaru prosledjujem kafic(this), da bi kasnije imao pristup meniju pica za goste
    public void dodajKonobara(String imeKonobara) {

        Konobar konobar = new Konobar(imeKonobara, this);
        konobari.add(konobar);

    }

    public void ukloniteKonobara(String ime) {

        for(Konobar k : konobari) {
            if(k.getIme().equalsIgnoreCase(ime)){
                konobari.remove(k);
                break;
            }
        }

    }



    private List<Pice> svaPicaBezAlkoholna() {

        List<Pice> bezAlkoholna = new ArrayList<>();

        Pice pice = new BezAlkoholnoPice("Rosa", 0.33, 150, VrstaNeAlkohola.VODA);
        Pice pice2 = new BezAlkoholnoPice("Orangina", 0.33, 350, VrstaNeAlkohola.GAZIRANI_SOK);
        Pice pice3 = new BezAlkoholnoPice("Orange", 0.2, 200, VrstaNeAlkohola.NEGAZIRANI_SOK);
        Pice pice4 = new BezAlkoholnoPice("Guarana", 0.2, 250, VrstaNeAlkohola.ENERGETSKO_PICE);
        Pice pice5 = new BezAlkoholnoPice("Kratki Espresso", 0.03, 220, VrstaNeAlkohola.KAFA);
        Pice pice6 = new BezAlkoholnoPice("Brusnica", 0.25, 220, VrstaNeAlkohola.CAJ);
        Pice pice7 = new BezAlkoholnoPice("Bela topla cokolada", 0.3, 380, VrstaNeAlkohola.TOPLA_COKOLADA);

        bezAlkoholna.add(pice);
        bezAlkoholna.add(pice2);
        bezAlkoholna.add(pice3);
        bezAlkoholna.add(pice4);
        bezAlkoholna.add(pice5);
        bezAlkoholna.add(pice6);
        bezAlkoholna.add(pice7);

        return bezAlkoholna;

    }

    private List<Pice> svaPicaAlkoholna() {

        List<Pice> alkoholna = new ArrayList<>();

        Pice pice = new AlkoholnoPice("Jelen",0.5,350, VrstaAlkohola.PIVO);
        Pice pice2 = new AlkoholnoPice("Heineken",0.33,400,VrstaAlkohola.PIVO);
        Pice pice3 = new AlkoholnoPice("Vranac",0.2,400,VrstaAlkohola.VINO);
        Pice pice4 = new AlkoholnoPice("Tamjanika",0.2,500,VrstaAlkohola.VINO);
        Pice pice5 = new AlkoholnoPice("Somersby",0.33,400,VrstaAlkohola.CIDER);
        Pice pice6 = new AlkoholnoPice("Sljivovica",0.03,300,VrstaAlkohola.RAKIJA);
        Pice pice7 = new AlkoholnoPice("Jack Daniels", 0.03, 450, VrstaAlkohola.VISKI);
        Pice pice8 = new AlkoholnoPice("Smirnoff",0.03,350,VrstaAlkohola.VODKA);
        Pice pice9 = new AlkoholnoPice("Gordon's",0.03,380,VrstaAlkohola.DZIN);

        alkoholna.add(pice);
        alkoholna.add(pice2);
        alkoholna.add(pice3);
        alkoholna.add(pice4);
        alkoholna.add(pice5);
        alkoholna.add(pice6);
        alkoholna.add(pice7);
        alkoholna.add(pice8);
        alkoholna.add(pice9);

        return alkoholna;

    }

    public Sto getStoPoBroju(int n) {

        for (Sto s : this.stolovi) {

            if (s.getBrojStola() == n) {
                return s;
            }

        }
            return null;
    }


    public String getNaziv() {
        return naziv;
    }

    // Setter za naziv uklonjen

    public List<Sto> getStolovi() {
        return stolovi;
    }

    // Setter za stolove uklonjen

    public List<Konobar> getKonobari() {
        return konobari;
    }

    // Setter za konobare uklonjen

    public int getKasa() {
        return kasa;
    }

    public void setKasa(int kasa) {
        if(kasa < 500000 && kasa >= 0){
            this.kasa = kasa;
        }
    }

    public List<Pice> getMeniPiceBezAlkoholna() {
        return meniPiceBezAlkoholna;
    }

    public List<Pice> getMeniPiceAlkoholna() {
        return meniPiceAlkoholna;
    }

    public List<Gost> getGosti() {
        return gosti;
    }

    // setter za goste uklonjen

    public Gost pronadjiGosta(String ime, String prezime) {

        for (Gost g : gosti) {
            if (g.getIme().equalsIgnoreCase(ime) && g.getPrezime().equalsIgnoreCase(prezime)) {
                return g;
            }
        }
        return null;
    }



    public void prikaziStoloveGostu(){

        System.out.println("Slobodni stolovi su:");
        for(Sto s : stolovi) {

            if(s.getGosti().isEmpty()){
                System.out.println("Broj stola je: "+s.getBrojStola());
            }

        }

    }

}

