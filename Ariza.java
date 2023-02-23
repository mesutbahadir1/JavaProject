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
public class Ariza {

    private Arac arac;
    private Musteri musteri;
    private Tekniker tekniker;
    private String ariza_bilgi;
    private double ariza_ucret;
    private int ariza_sure;
    private String arizaRandevuTarih;

    public Ariza(Arac arac, Musteri musteri, Tekniker tekniker, String ariza_bilgi, double ariza_ucret, int ariza_sure, String arizaRandevuTarih) {
        this.arac = arac;
        this.musteri = musteri;
        this.tekniker = tekniker;
   
        

        try {
            if(ariza_ucret<=0){
               throw new HataliGirisKontrol("Lütfen geçerli bir arıza ücreti tanımlayınız."); 
            }
              this.ariza_ucret = ariza_ucret;
        } catch (Exception e) {
            this.ariza_ucret = 0;
            System.out.println(e.getMessage());
        }
        try {
            if(ariza_bilgi=="" || ariza_bilgi==" " || ariza_bilgi=="  "){
               throw new HataliGirisKontrol("Lütfen arıza bilgisini doğru giriniz."); 
            }
              this.ariza_bilgi = ariza_bilgi;
        } catch (Exception e) {
            this.ariza_bilgi="ArizaBilgiDefault";
            System.out.println(e.getMessage());
        }       
        
        try {
            if(ariza_sure<=0){
               throw new HataliGirisKontrol("Lütfen geçerli bir arıza süresi tanımlayınız."); 
            }
              this.ariza_sure = ariza_sure;
        } catch (Exception e) {
            this.ariza_sure = 0;
            System.out.println(e.getMessage());
        }
        
       
        try {
            if(arizaRandevuTarih.length()!=10){
               throw new HataliGirisKontrol("Lütfen geçerli bir arıza tarihi giriniz. Tarihi Gün/Ay/Yıl şeklinde doğru kodladığınıza emin olunuz."); 
            }
              this.arizaRandevuTarih=arizaRandevuTarih;
        } catch (Exception e) {
            this.arizaRandevuTarih="00/00/0000";
            System.out.println(e.getMessage());
        }

    }

    public Arac getArac() {
        return arac;
    }

    public Musteri getMusteri() {
        return musteri;
    }

    public Tekniker getTekniker() {
        return tekniker;
    }

    public String getAriza_bilgi() {
        return ariza_bilgi;
    }

    public double getAriza_ucret() {
        return ariza_ucret;
    }

    public int getAriza_sure() {
        return ariza_sure;
    }

    public String getArizaRandevuTarih() {
        return arizaRandevuTarih;
    }
    

    public void bilgiVer() {
        System.out.println("Randevu id: " + this.arac);
        System.out.println("Müşteri bilgi: " + this.musteri);
        System.out.println("Tekniker bilgi: " + this.tekniker);
        System.out.println("Arıza bilgi: " + this.ariza_bilgi);
        System.out.println("Arzza ücret: " + this.ariza_ucret);
        System.out.println("Arıza süre : " + this.ariza_sure);
        System.out.println();
    }

}
