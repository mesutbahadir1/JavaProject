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
public class Arac {

    private String ad;
    private int model;

    public Arac(String ad, int model) {
        try {
            if(ad.length()<2){
               throw new HataliGirisKontrol("Böyle bir araba ismi tanımlanamaz."); 
            }
              this.ad=ad;
        } catch (Exception e) {
            this.ad="AracİsimDefault";
            System.out.println(e.getMessage());
        }
              
        try {
            if(model<1900 || model>2022){
               throw new HataliGirisKontrol("Böyle bir araba modeli tanımlanamaz."); 
            }
              this.model=model;
        } catch (Exception e) {
            this.model=0;
            System.out.println(e.getMessage());
        }

    }

    public String getAd() {
        return ad;
    }

    public int getModel() {
        return model;
    }

    @Override
    public String toString() {
        return ad + " ," + model;
    }

}
