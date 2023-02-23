/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servis_ariza_project;

/**
 * @file servis_ariza_project.java
 * @description Bir servisteki arıza ve randevu süreçlerini tekniker ve
 * müşterilerin durumuna göre belirler.
 * @assignment 2.proje
 * @date 21/01/2022
 * @author Muhammed Mesut Bahadır - muhammed.bahadir@stu.fsm.edu.tr
 */
public class Kisi {

    private String ad;
    private String soyad;
    private Kisi[] kisiList;

    public Kisi(String ad, String soyad) {

        try {
            if (ad.length() < 2) {
                throw new HataliGirisKontrol("Böyle bir ad tanımlanamaz.");
            }
            this.ad = ad;
        } catch (Exception e) {
            this.ad = "KullaniciDefault";
            System.out.println(e.getMessage());
        }

        try {
            if (soyad.length() < 2) {
                throw new HataliGirisKontrol("Böyle bir soyad tanımlanamaz.");
            }
            this.soyad = soyad;
        } catch (Exception e) {
            this.soyad = "KullaniciSoyadDefault";
            System.out.println(e.getMessage());
        }
        
        this.kisiList=new Kisi[30];

    }

    @Override
    public String toString() {
        return this.ad + " " + this.soyad;
    }

    public String getAd() {
        return ad;
    }

    public String getSoyad() {
        return soyad;
    }

}
