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
public class Test {

    public static void main(String[] args) {

        Servis s1 = new Servis(123, "Bahadır Servis");

        Musteri m1 = new Musteri(01 ,"Mesut", "Bahadır");
        Musteri m2 = new Musteri(02 ,"Ali", "Ateş");
        Musteri m3= new Musteri(03, "Cengiz", "Kurtoğlu");
        Musteri m4= new Musteri(04,"Merve", "Durmaz");       

        Arac a1 = new Arac("Fiat Fiorino", 2013);
        Arac a2 = new Arac("Ford Mondeo", 2018);
        Arac a3= new Arac("Ford Mustang", 2022);
        Arac a4= new Arac("Audi A8",2022);       

        Tekniker t1 = new Tekniker("Halil", "Sevimli");
        Tekniker t2 = new Tekniker("Ahmet", "Arakan");
        Tekniker t3=new Tekniker("Berkan", "Özyurt");

        Ariza ariza1 = new Ariza(a1, m1, t1, "Motor arızalı.", 5687.8, 5,"06/05/2022");
        Ariza ariza2 = new Ariza(a1, m1, t1, "Kaput değişmeli.", 3200.0, 8,"08/12/2024");
        Ariza ariza3 = new Ariza(a2, m2, t2, "Cantlar değişmeli.", 848.6, 16,"09/05/2021");
        Ariza ariza4= new Ariza(a3, m3, t2, "Civatalar değişmeli", 267.0, 2,"09/05/2021");
        Ariza ariza5=new Ariza(a4, m4, t3, "Camlı tavan değişmeli", 6798.5, 24,"24/07/2023");

        Randevu r1 = new Randevu(001, ariza1, t1, m1, a1,5687.8,"06/05/2022");
        Randevu r2 = new Randevu(002, ariza2, t1, m1, a1,3200.0,"08/12/2024");
        Randevu r3= new Randevu(003, ariza3, t2, m2, a2,848.6,"09/05/2021");
        Randevu r4=new Randevu(004, ariza4, t2, m3, a3,267.0,"09/05/2021");
        Randevu r5= new Randevu(005, ariza5, t3, m4, a4,6798.5,"24/07/2023");
        
        
        //Buradaki zaman class'ı aşağıdaki metotlarda tarih kullanılması gerekli olduğu durunmlarda
        //işlemin yapıldığı tarihi belirtmek amacıyla yazılmıştır.
        Zaman z1=new Zaman("19/05/2022");
        Zaman z2=new Zaman("05/05/2022");
        Zaman z3=new Zaman("19/07/2023");
        Zaman z4=new Zaman("19/06/2022");
        Zaman z5=new Zaman("05/05/2021");
        Zaman z6= new Zaman("10/05/2022");
        Zaman z7= new Zaman("05/05/2021");
        Zaman z8= new Zaman("07/05/2022");
        Zaman z9=new Zaman("08/05/2021");
        
        
                    
        
        //1.madde   
        /*
        t1.arizaEkle(ariza1);
        t1.arizaEkle(ariza2);        
        t1.arizaListele();
        
        System.out.println("----------");
        t2.arizaEkle(ariza3);
        t2.arizaEkle(ariza4);      
        t2.arizaListele();
        
        System.out.println("--------");
        t3.arizaEkle(ariza5);
        t3.arizaListele();
        */
        
        
        //2.madde
        /*
        s1.teknikerEkle(t1);
        s1.teknikerEkle(t2);
        s1.teknikerEkle(t3);
        
        t1.arizaEkle(ariza1);
        t1.arizaEkle(ariza2);
        t2.arizaEkle(ariza3);
        t2.arizaEkle(ariza4);
        t3.arizaEkle(ariza5);
        s1.karisikArizaListele();
         */
        
        
         //3.madde
        /*
        z1.musteriEkle(m1);
        z1.musteriEkle(m2);
        
        m1.randevuEkle(r1);
        m1.randevuEkle(r2);
        m2.randevuEkle(r3);
        
        System.out.println("En çok randevuya sahip müşterinin randevu listesi:");
        z1.enCokRandevuMusteriDondur();
        */
        
        
        //4.madde
        /*
        m1.randevuEkle(r1);
        m1.randevuEkle(r2);
        m1.randevuListele(z1);
        
        System.out.println();
        System.out.println("-----------------");
        
        m2.randevuEkle(r3);
        m2.randevuListele(z1);
        
        System.out.println();
        System.out.println("-----------------");
        
        m4.randevuEkle(r5);
        m4.randevuListele(z1);
        */
        
        
        //5.madde
        /*
        m3.randevuEkle(r4);
        m1.randevuEkle(r2);
        m2.randevuEkle(r3);
        System.out.println("Randevu tarihiniz : "+r2.getRandevu_tarih());
        m1.randevuDegistir(z4, r2,"21/06/2022");
        System.out.println("Yeni randevu tarihiniz : "+r2.getRandevu_tarih());
        
        System.out.println("------------------");
        
        m3.randevuDegistir(z4, r4, "22/06/2022");
        
        System.out.println("------------------");
        
        m2.randevuDegistir(z9, r3, "16/10/2021");
        */
        
        
        //6.madde
        /*
        z1.musteriEkle(m1);
        z1.musteriEkle(m2);
        z1.musteriEkle(m3);
        z1.musteriEkle(m4);
        
        m1.randevuEkle(r1);
        m1.randevuEkle(r2);
        m2.randevuEkle(r3);
        m3.randevuEkle(r4);
        m4.randevuEkle(r5);
        
        z1.karisikAramaListele(z1, 'M', 'r', 's', 't', 'e');
        */
        
        
        
        //7.madde 1.örnek
        /*
        z6.musteriEkle(m1);
        z6.musteriEkle(m2);
        m1.randevuEkle(r1);
        m2.randevuEkle(r3);
               
        System.out.println("Silme öncesi müşteri listesi : ");
        for (int i = 0; i < z6.getMusteriListesi().length; i++) {
            if(z6.getMusteriListesi()[i]!=null){
                System.out.println(z6.getMusteriListesi()[i].getAd()+" "+z6.getMusteriListesi()[i].getSoyad());
            }
        }
        
       System.out.println("------------------------------");
       z6.musteriSil(m1, z6);
       System.out.println("------------------------------");
       System.out.println("Silme sonrası müşteri listesi : "); 
        
       for (int i = 0; i < z6.getMusteriListesi().length; i++) {
            if(z6.getMusteriListesi()[i]!=null){
                System.out.println(z6.getMusteriListesi()[i].getAd()+" "+z6.getMusteriListesi()[i].getSoyad());
            }
        }
        */
                
        
        //7.madde 2.örnek
        /*
        z5.musteriEkle(m1);
        z5.musteriEkle(m2);
        z5.musteriEkle(m3);
        
        m1.randevuEkle(r1);
        m2.randevuEkle(r3);
        m3.randevuEkle(r4);
        
        System.out.println("Silme öncesi müşteri listesi : ");
        for (int i = 0; i < z5.getMusteriListesi().length; i++) {
            if(z5.getMusteriListesi()[i]!=null){
                System.out.println(z5.getMusteriListesi()[i].getAd()+" "+z5.getMusteriListesi()[i].getSoyad());
            }
        }
        
        System.out.println("------------------------------");   
        z5.musteriSil(m2, z5);
        System.out.println("------------------------------");
        System.out.println("Silme sonrası müşteri listesi : "); 
        
        for (int i = 0; i < z5.getMusteriListesi().length; i++) {
            if(z5.getMusteriListesi()[i]!=null){
                System.out.println(z5.getMusteriListesi()[i].getAd()+" "+z5.getMusteriListesi()[i].getSoyad());
            }
        }
        */
        
        
        //8.soru 1.örnek
        /*
        s1.teknikerEkle(t1);
        s1.teknikerEkle(t2);
        s1.teknikerEkle(t3);
        t1.arizaEkle(ariza1);
        t2.arizaEkle(ariza3);
        
        s1.teknikerSil(t1, z7);
        
        System.out.println();
        t2.arizaListele();
        System.out.println("-----------------");
        t3.arizaListele();
        */
        
        //8.soru 2.örnek(Aktif arızası olmayan tekniker.)
        /*
        s1.teknikerEkle(t1);
        s1.teknikerEkle(t2);
        s1.teknikerEkle(t3);
        t1.arizaEkle(ariza1);
        s1.teknikerSil(t1, z8);
        */
        
        //8.soru 3.örnek(Aktif arızası mevcut, fakat sistemde başka tekniker olmadığında gerçekleşecek ihtimal.)
        /*
        s1.teknikerEkle(t3);
        t3.arizaEkle(ariza5);
        s1.teknikerSil(t3,z3);
        */
        
        
        
        //9.madde
        /*
        s1.teknikerEkle(t1);
        s1.teknikerEkle(t2);
        s1.teknikerEkle(t3);
        
        t1.arizaEkle(ariza1);
        t1.arizaEkle(ariza2);
        t2.arizaEkle(ariza3);
        t2.arizaEkle(ariza4);
        t3.arizaEkle(ariza5);
        
        s1.teknikerEnCokHasilatListele();
        */
       
        
        //10.madde
        /*
        z1.musteriEkle(m1);
        z1.musteriEkle(m2);
        z1.musteriEkle(m3);
        z1.musteriEkle(m4);
        
        m1.randevuEkle(r1);
        m1.randevuEkle(r2);
        m2.randevuEkle(r3);
        m3.randevuEkle(r4);
        m4.randevuEkle(r5);
        
        z1.musteriEnCokOdemeListele();
        */
        
        
        //11.madde
        /*
        s1.teknikerEkle(t1);
        s1.teknikerEkle(t2);
        s1.teknikerEkle(t3);
      
        t1.arizaEkle(ariza1);
        t1.arizaEkle(ariza2);
        t2.arizaEkle(ariza3);
        t2.arizaEkle(ariza4);
        t3.arizaEkle(ariza5);
        
        s1.ortalamaKazancVeTamirSuresi();
        */
        
        
        //12 ve 13.maddeler
        /*
        z1.musteriEkle(m1);
        z1.musteriEkle(m2);
        z1.musteriEkle(m3);
        z1.musteriEkle(m4);
        
        m1.randevuEkle(r1);
        m1.randevuEkle(r2);
        m2.randevuEkle(r3);
        m3.randevuEkle(r4);
        m4.randevuEkle(r5);
        
        z1.cozumlenmisVeCozumlenmemisListele(z2, z3);
        */
        
        
        //Exception örneği
        /*
        m1.randevuEkle(r1);
        m1.randevuEkle(r2);
        
        for(Randevu randevu: m1.getRandevuListesi()){
            try {
                if(randevu==null){
                   throw new NullControl("İlgili indeksteki eleman null.");
                }
                randevu.bilgiVer();
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
            
        }
        */
    }
}
