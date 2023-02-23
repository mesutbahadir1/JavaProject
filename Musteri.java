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
public class Musteri extends Kisi {

    private int id;
    private Randevu[] randevuListesi;

    public Musteri(int id, String ad, String soyad) {
        super(ad, soyad);
        
        try {
            if(id<=0){
               throw new HataliGirisKontrol("Lütfen geçerli bir id tanımlayınız."); 
            }
             this.id = id;
        } catch (Exception e) {
            this.id = 0;
            System.out.println(e.getMessage());
        }
        
        randevuListesi = new Randevu[20];    
    }

    public int getId() {
        return id;
    }

    public Randevu[] getRandevuListesi() {
        return randevuListesi;
    }
  
    public String getAd(){
        return super.getAd();
    }

    @Override
    public String getSoyad() {
        return super.getSoyad();
    }
    

    //Müşteriyi atanacak randevuyu önceden atanma durumuna göre kontrol
    //edip randevu listesine ekleyen metod.
    public void randevuEkle(Randevu randevu) {
        boolean ayniRandevuMu = false;
        for (int i = 0; i < randevuListesi.length; i++) {
            if (randevuListesi[i] != null && randevuListesi[i] == randevu) {
                ayniRandevuMu = true;
                break;
            }
        }

        if (ayniRandevuMu == false) {
            for (int i = 0; i < randevuListesi.length; i++) {
                if (randevuListesi[i] == null) {
                    randevuListesi[i] = randevu;
                    break;
                }
            }
        } else {
            System.out.println("Bu randevu zaten alınmıştır.");
        }
    }
    
    
    //String bir ifade içerisinde verilen zaman'ı önce '/'a göre bölüp daha sonra
    //parseInt ile bir diziye çevirdim. Dizideki elemenların dizilişi ise şöyle olacak
    //arrDuzenlenmis[2]=Yıl
    //arrDuzenlenmis[1]=Ay
    //arrDuzenlenmis[0]=Gün  
    public int[] zamanDizile(String zaman) {

        String metin = zaman;
        String[] arrStr = new String[3];

        String kelime = "";
        int sayac = 0;
        for (int i = 0; i < metin.length(); i++) {
            if (metin.charAt(i) != '/') {
                kelime += metin.charAt(i);
            } else {
                arrStr[sayac] = kelime;
                kelime = "";
                sayac++;
            }
        }
        arrStr[sayac] = kelime;

        int[] arrDuzenlenmis = new int[arrStr.length];

        for (int i = 0; i < arrStr.length; i++) {
            arrDuzenlenmis[i] = Integer.parseInt(arrStr[i]);
        }

        return arrDuzenlenmis;
    }
    
    
    //Randevu listesindeki randevuları zaman sınıfından aldığı güncel zamana göre 
    //çözümlenip çözümlenmediğini tespit edip ona göre listeleyen metod.
    public void randevuListele(Zaman zaman) {
        int[] guncelZaman = zamanDizile(zaman.getZaman());
        Randevu[] cozumlenmisRandevu= new Randevu[20];
        Randevu[] cozumlenmemisRandevu= new Randevu[20];
        for (int i = 0; i < randevuListesi.length; i++) {
            if (randevuListesi[i] != null) {
                if (zamanDizile(randevuListesi[i].getRandevu_tarih())[2] > guncelZaman[2]) {
                    cozumlenmemisRandevu[i] = randevuListesi[i];
                } else if (zamanDizile(randevuListesi[i].getRandevu_tarih())[2] == guncelZaman[2] && zamanDizile(randevuListesi[i].getRandevu_tarih())[1] > guncelZaman[1]) {
                    cozumlenmemisRandevu[i] = randevuListesi[i];
                } else if (zamanDizile(randevuListesi[i].getRandevu_tarih())[2] == guncelZaman[2] && zamanDizile(randevuListesi[i].getRandevu_tarih())[1] < guncelZaman[1]) {
                    cozumlenmisRandevu[i] = randevuListesi[i];
                } else if (zamanDizile(randevuListesi[i].getRandevu_tarih())[2] == guncelZaman[2] && zamanDizile(randevuListesi[i].getRandevu_tarih())[1] == guncelZaman[1] && zamanDizile(randevuListesi[i].getRandevu_tarih())[0] > guncelZaman[0]) {
                    cozumlenmemisRandevu[i] = randevuListesi[i];
                } else if (zamanDizile(randevuListesi[i].getRandevu_tarih())[2] == guncelZaman[2] && zamanDizile(randevuListesi[i].getRandevu_tarih())[1] == guncelZaman[1] && zamanDizile(randevuListesi[i].getRandevu_tarih())[0] < guncelZaman[0]) {
                    cozumlenmisRandevu[i] = randevuListesi[i];
                } else if (zamanDizile(randevuListesi[i].getRandevu_tarih())[2] < guncelZaman[2]) {
                    cozumlenmisRandevu[i] = randevuListesi[i];
                }
            }
        }

        System.out.println("Güncel tarih : " + zaman.getZaman());
        System.out.println("Geçmişteki randevular : ");
        for (int i = 0; i < cozumlenmisRandevu.length; i++) {
            if (cozumlenmisRandevu[i] != null) {
                cozumlenmisRandevu[i].bilgiVer();
            }
        }

        System.out.println();

        System.out.println("Gelecekteki randevular : ");
        for (int i = 0; i < cozumlenmemisRandevu.length; i++) {
            if (cozumlenmemisRandevu[i] != null) {
                cozumlenmemisRandevu[i].bilgiVer();
            }
        }

    }
    
    //Değiştirilmek istenen randevunun zaman sınıfındaki güncel tarihe göre değiştirildiği metod.
    //Randevu tarihinden 1 gün önce değiştirme yapılmayacağı için kullanıcıya uyarı mesajı gelir.
    //Randevu tarihine bir günden fazla var ise kullanıcının istediği tarih ile değiştirilir.
    public void randevuDegistir(Zaman zaman, Randevu randevu,String tarih) {
        int[] guncelZaman = zamanDizile(zaman.getZaman());
        for (int i = 0; i < randevuListesi.length; i++) {
            if (randevuListesi[i] != null && randevuListesi[i] == randevu) {
                if (zamanDizile(randevu.getRandevu_tarih())[2] == guncelZaman[2] && zamanDizile(randevu.getRandevu_tarih())[1] == guncelZaman[1] && (zamanDizile(randevu.getRandevu_tarih())[0] - guncelZaman[0]) <= 1) {
                    System.out.println("Randevu süreniz 1 günden az kaldığı için randevuyu iptal edilemez.");
                }else if(zamanDizile(randevu.getRandevu_tarih())[2]<guncelZaman[2]){
                    System.out.println("Bu randevunun tarihi geçtiği için silme veya değiştirme işlemleri uygulanamaz.");
                }else if(zamanDizile(randevu.getRandevu_tarih())[2] == guncelZaman[2] && zamanDizile(randevu.getRandevu_tarih())[1] <guncelZaman[1]){
                    System.out.println("Bu randevunun tarihi geçtiği için silme veya değiştirme işlemleri uygulanamaz.");
                }else if(zamanDizile(randevu.getRandevu_tarih())[2] == guncelZaman[2] && zamanDizile(randevu.getRandevu_tarih())[1] == guncelZaman[1] && zamanDizile(randevu.getRandevu_tarih())[0] < guncelZaman[0]){
                     System.out.println("Bu randevunun tarihi geçtiği için silme veya değiştirme işlemleri uygulanamaz.");
                }else if(zamanDizile(randevu.getRandevu_tarih())[2] > guncelZaman[2]){
                   System.out.println("Bu randevunun tarihi istediğiniz tarih ile değiştirildi.");
                    randevuListesi[i].setRandevu_tarih(tarih);
                }else if(zamanDizile(randevu.getRandevu_tarih())[2] == guncelZaman[2] && zamanDizile(randevu.getRandevu_tarih())[1] >guncelZaman[1]){
                    System.out.println("Bu randevunun tarihi istediğiniz tarih ile değiştirildi.");
                    randevuListesi[i].setRandevu_tarih(tarih);
                }else if(zamanDizile(randevu.getRandevu_tarih())[2] == guncelZaman[2] && zamanDizile(randevu.getRandevu_tarih())[1] == guncelZaman[1] && (zamanDizile(randevu.getRandevu_tarih())[0] - guncelZaman[0]) > 1){
                    System.out.println("Bu randevunun tarihi istediğiniz tarih ile değiştirildi.");
                    randevuListesi[i].setRandevu_tarih(tarih);
                }
            }
        }

    }
      
}
