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
public class Randevu {

    private int id;
    private Ariza ariza;
    private Tekniker tekniker;
    private Musteri musteri;
    private Arac arac;
    private double randevu_ucret;
    private String randevu_tarih;

    public Randevu(int id, Ariza ariza, Tekniker tekniker, Musteri musteri, Arac arac, double randevu_ucret, String randevu_tarih) {

        try {
            if (id <= 0) {
                throw new HataliGirisKontrol("Lütfen geçerli bir id tanımlayınız.");
            }
            this.id = id;
        } catch (Exception e) {
            this.id = 0;
            System.out.println(e.getMessage());
        }

        this.ariza = ariza;
        this.tekniker = tekniker;
        this.musteri = musteri;
        this.arac = arac;

        try {
            if (randevu_ucret <= 0) {
                throw new HataliGirisKontrol("Lütfen geçerli bir randevu ücreti tanımlayınız.");
            }
            this.randevu_ucret = randevu_ucret;
        } catch (Exception e) {
            this.randevu_ucret = 0;
            System.out.println(e.getMessage());
        }

        try {
            if (randevu_tarih.length() != 10) {
                throw new HataliGirisKontrol("Lütfen geçerli bir randevu tarihi giriniz. Tarihi Gün/Ay/Yıl şeklinde doğru kodladığınıza emin olunuz.");
            }
            this.randevu_tarih = randevu_tarih;
        } catch (Exception e) {
            this.randevu_tarih = "00/00/0000";
            System.out.println(e.getMessage());
        }

    }

    public double getRandevu_ucret() {
        return randevu_ucret;
    }

    public String getRandevu_tarih() {
        return randevu_tarih;
    }

    public Musteri getMusteri() {
        return musteri;
    }

    public void setRandevu_tarih(String randevu_tarih) {
        this.randevu_tarih = randevu_tarih;
    }

    public void bilgiVer() {
        System.out.println("Randevu id: " + this.id);
        System.out.println("Arıza bilgi: " + this.ariza.getAriza_bilgi());
        System.out.println("Müşteri bilgi: " + this.musteri);
        System.out.println("Tekniker bilgi : " + this.tekniker);
        System.out.println("Araç bilgi : " + this.arac);
        System.out.println("Randevu tarih : " + this.randevu_tarih);
        System.out.println();
    }

}
