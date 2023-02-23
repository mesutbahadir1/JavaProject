/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servis_ariza_project;

/**
* @file servis_ariza_project.java
* @description Bir servisteki arıza ve randevu süreçlerini tekniker ve müşterilerin durumuna göre belirler.
* @assignment 2.proje
* @date 21/01/2022
* @author Muhammed Mesut Bahadır - muhammed.bahadir@stu.fsm.edu.tr
*/
public class Tekniker extends Kisi {

    private Ariza[] arizaListesi;
    private double teknikerKazanc;

    public Tekniker(String ad, String soyad) {
        super(ad, soyad);
        this.arizaListesi = new Ariza[20];   
        this.teknikerKazanc = teknikerKazanc;
   
    }

    public double getTeknikerKazanc() {
        return teknikerKazanc;
    }

    public Ariza[] getArizaListesi() {
        return arizaListesi;
    }
    
     //Teknikere atanacak arızayı önceden atanma durumuna göre kontrol
    //edip arıza listesine ekleyen metod.
    public void arizaEkle(Ariza ariza) {
        boolean ayniArizaMi = false;
        for (int i = 0; i < arizaListesi.length; i++) {
            if (arizaListesi[i] != null && arizaListesi[i] == ariza) {
                ayniArizaMi = true;
                break;
            }
        }

        if (ayniArizaMi == false) {
            for (int i = 0; i < this.arizaListesi.length; i++) {
                if (this.arizaListesi[i] == null) {
                    this.arizaListesi[i] = ariza;
                    break;
                }
            }
            teknikerKazanc += ariza.getAriza_ucret();
        } else {
            System.out.println("Bu arıza zaten atanmış.");
        }
    }
    
    //Arıza listesindeki elemanları null değilse bastıran metod.
    public void arizaListele() {
        for (int i = 0; i < this.arizaListesi.length; i++) {
            if (this.arizaListesi[i] != null) {
                arizaListesi[i].bilgiVer();
            }
        }
    }
    
    //Arıza listesindeki elemanları null değilse arızanın sahibi 
    //müşteriyi bastırır.
    public void musteriListele() {
        for (int i = 0; i < arizaListesi.length; i++) {
            if (arizaListesi[i] != null) {
                System.out.println(arizaListesi[i].getMusteri());
            }
        }

    }

}
