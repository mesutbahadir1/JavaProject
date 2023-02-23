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
public class Zaman {

    private String zaman;
    private Musteri musteri;
    private Ariza ariza;
    private Randevu randevu;
    private Musteri[] musteriListesi;

    public Zaman(String zaman) {
        try {
            if(zaman.length()!=10){
               throw new HataliGirisKontrol("Lütfen geçerli bir tarih giriniz. Tarihi Gün/Ay/Yıl şeklinde doğru kodladığınıza emin olunuz."); 
            }
              this.zaman=zaman;
        } catch (Exception e) {
            this.zaman="00/00/0000";
            System.out.println(e.getMessage());
        }
        
        this.musteri = musteri;
        this.ariza = ariza;
        this.randevu = randevu;
        this.musteriListesi = new Musteri[20];

    }

    public String getZaman() {
        return zaman;
    }

    public Musteri[] getMusteriListesi() {
        return musteriListesi;
    }

    public void musteriEkle(Musteri musteri) {
        boolean ayniMusteriMi = false;
        for (int i = 0; i < musteriListesi.length; i++) {
            if (musteriListesi[i] != null && musteriListesi[i] == musteri) {
                ayniMusteriMi = true;
                break;
            }
        }

        if (ayniMusteriMi == false) {
            for (int i = 0; i < musteriListesi.length; i++) {
                if (musteriListesi[i] == null) {
                    musteriListesi[i] = musteri;
                    break;
                }
            }
        } else {
            System.out.println("Bu müşteri zaten atanmıştır.");
        }

    }
    
    //Müşteri listesinin elemanından randevu listesine ulaştıktan sonra randevu sayısı null olmadığı
    //sürece başlangıçta 0 olarak atadığımız sayacı bir bir arttırıyoruz. randevuSayi dizisine
    //sayactaki sayıları eleman olarak atayıp kıyasladıktan sonra en çok randevusu olan müşteriyi döndürüyoruz.
    public void enCokRandevuMusteriDondur() {
        int sayac = 0;
        int maks = 0;
        int indis = 0;
        int[] randevuSayi = new int[100];
        for (int i = 0; i < musteriListesi.length; i++) {
            if (musteriListesi[i] != null) {
                sayac = 0;
                for (int j = 0; j < musteriListesi[i].getRandevuListesi().length; j++) {
                    if (musteriListesi[i].getRandevuListesi()[j] != null) {
                        sayac++;
                    }
                }
                randevuSayi[i] = sayac;
            }
        }

        for (int i = 0; i < randevuSayi.length; i++) {
            maks = randevuSayi[i];
            for (int j = 0; j < randevuSayi.length; j++) {
                if (maks < randevuSayi[j]) {
                    maks = randevuSayi[j];
                    indis = j;
                }
            }
        }

        for (int i = 0; i < musteriListesi[indis].getRandevuListesi().length; i++) {
            if (musteriListesi[indis].getRandevuListesi()[i] != null) {
                musteriListesi[indis].getRandevuListesi()[i].bilgiVer();
            }
        }

    }
    
    //Kullanıcının girmiş olduğu karakterle beraber içeriği uyuşan müşterinin 
    //randevularını ekrana bastıran metod.
    public void karisikAramaListele(Zaman zaman, char c1, char c2, char c3, char c4, char c5) {
        for (int i = 0; i < musteriListesi.length; i++) {
            if (musteriListesi[i] != null) {
                for (int j = 0; j < musteriListesi[i].getAd().length(); j++) {
                    if (musteriListesi[i].getAd().charAt(0) == c1 && musteriListesi[i].getAd().charAt(musteriListesi[i].getAd().length() - 1) == c4 || musteriListesi[i].getAd().charAt(0) == c1 && musteriListesi[i].getAd().charAt(musteriListesi[i].getAd().length() - 1) == c5) {
                        if (musteriListesi[i].getAd().charAt(j) == c2 || musteriListesi[i].getAd().charAt(j) == (c2 + 32) || musteriListesi[i].getAd().charAt(j) == (c2 - 32)) {
                            musteriListesi[i].randevuListele(zaman);
                            break;
                        } else if (musteriListesi[i].getAd().charAt(j) == c3 || musteriListesi[i].getAd().charAt(j) == (c3 + 32) || musteriListesi[i].getAd().charAt(j) == (c3 - 32)) {
                            musteriListesi[i].randevuListele(zaman);
                            break;
                        }
                    }
                }
            }
        }
    }

    //Müşteri listesinin elemanından randevu listesine ulaştıktan sonra buradaki randevunun
    //ücret bilgilerine ulaşıp her bir müşteri için toplayıp diziye eleman olarak atıyoruz.
    //Bu dizideki elemanlardan en çok ödeme yapanı indisiyle beraber bulup müşteriye ait
    //randevuların listesini yazdırıyoruz.
    public void musteriEnCokOdemeListele() {
        double toplam = 0;
        double maks = 0;
        int indis = 0;
        double[] odemeToplam = new double[100];
        for (int i = 0; i < musteriListesi.length; i++) {
            if (musteriListesi[i] != null) {
                toplam = 0;
                for (int j = 0; j < musteriListesi[i].getRandevuListesi().length; j++) {
                    if (musteriListesi[i].getRandevuListesi()[j] != null) {
                        toplam += musteriListesi[i].getRandevuListesi()[j].getRandevu_ucret();
                    }
                }
                odemeToplam[i] = toplam;
            }
        }

        for (int i = 0; i < odemeToplam.length; i++) {
            maks = odemeToplam[i];
            for (int j = 0; j < odemeToplam.length; j++) {
                if (maks < odemeToplam[j]) {
                    maks = odemeToplam[j];
                    indis = j;
                }
            }
        }

        System.out.println("En çok ödeme yapan müşteri : " + musteriListesi[indis].toString());
        System.out.println("--------------------------------------");
        System.out.println("Müşterinin almış olduğu randevular : ");
        System.out.println();
        for (int i = 0; i < musteriListesi[indis].getRandevuListesi().length; i++) {
            if (musteriListesi[indis].getRandevuListesi()[i] != null) {
                musteriListesi[indis].getRandevuListesi()[i].bilgiVer();
            }
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
    
    //Zaman sınıfı ile beraber verilen iki zaman ile müşteri listesindeki her bir elemanın 
    //o tarihler arasındaki çözümlenmiş ve çözümlenmemiş elemanlarını ayrı ayrı olarak ekrana bastırır.
    public void cozumlenmisVeCozumlenmemisListele(Zaman z1, Zaman z2) {
        int[] zaman1 = zamanDizile(z1.getZaman());
        int[] zaman2 = zamanDizile(z2.getZaman());
        Randevu[] cozumlenmisRandevu = new Randevu[20];
        Randevu[] cozumlenmemisRandevu = new Randevu[20];

        for (int i = 0; i < musteriListesi.length; i++) {
            if (musteriListesi[i] != null) {

                for (int j = 0; j < musteriListesi[i].getRandevuListesi().length; j++) {

                    if (musteriListesi[i].getRandevuListesi()[j] != null) {
                        if (zaman1[2] == zamanDizile(musteriListesi[i].getRandevuListesi()[j].getRandevu_tarih())[2] && zamanDizile(musteriListesi[i].getRandevuListesi()[j].getRandevu_tarih())[2] == zaman2[2]) {
                            if (zaman1[1] < zamanDizile(musteriListesi[i].getRandevuListesi()[j].getRandevu_tarih())[1] && zamanDizile(musteriListesi[i].getRandevuListesi()[j].getRandevu_tarih())[1] < zaman2[1]) {
                                cozumlenmisRandevu[i] = musteriListesi[i].getRandevuListesi()[j];
                            } else if ((zaman1[1] == zamanDizile(musteriListesi[i].getRandevuListesi()[j].getRandevu_tarih())[1] && zamanDizile(musteriListesi[i].getRandevuListesi()[j].getRandevu_tarih())[1] < zaman2[1]) && (zaman1[0] < zamanDizile(musteriListesi[i].getRandevuListesi()[j].getRandevu_tarih())[0])) {
                                cozumlenmisRandevu[i] = musteriListesi[i].getRandevuListesi()[j];
                            } else if ((zaman1[1] < zamanDizile(musteriListesi[i].getRandevuListesi()[j].getRandevu_tarih())[1] && zamanDizile(musteriListesi[i].getRandevuListesi()[j].getRandevu_tarih())[1] == zaman2[1]) && (zaman2[0] > zamanDizile(musteriListesi[i].getRandevuListesi()[j].getRandevu_tarih())[0])) {
                                cozumlenmisRandevu[i] = musteriListesi[i].getRandevuListesi()[j];
                            } else if ((zaman1[1] == zamanDizile(musteriListesi[i].getRandevuListesi()[j].getRandevu_tarih())[1] && zamanDizile(musteriListesi[i].getRandevuListesi()[j].getRandevu_tarih())[1] == zaman2[1]) && (zaman1[0] < zamanDizile(musteriListesi[i].getRandevuListesi()[j].getRandevu_tarih())[0] && zamanDizile(musteriListesi[i].getRandevuListesi()[j].getRandevu_tarih())[0] < zaman2[0])) {
                                cozumlenmisRandevu[i] = musteriListesi[i].getRandevuListesi()[j];
                            }
                        } else if (zaman1[2] == zamanDizile(musteriListesi[i].getRandevuListesi()[j].getRandevu_tarih())[2] && zamanDizile(musteriListesi[i].getRandevuListesi()[j].getRandevu_tarih())[2] < zaman2[2]) {
                            if (zaman1[1] < zamanDizile(musteriListesi[i].getRandevuListesi()[j].getRandevu_tarih())[1]) {
                                cozumlenmisRandevu[i] = musteriListesi[i].getRandevuListesi()[j];
                            } else if (zaman1[1] == zamanDizile(musteriListesi[i].getRandevuListesi()[j].getRandevu_tarih())[1] && zaman1[0] < zamanDizile(musteriListesi[i].getRandevuListesi()[j].getRandevu_tarih())[0]) {
                                cozumlenmisRandevu[i] = musteriListesi[i].getRandevuListesi()[j];
                            }
                        } else if (zaman1[2] < zamanDizile(musteriListesi[i].getRandevuListesi()[j].getRandevu_tarih())[2] && zamanDizile(musteriListesi[i].getRandevuListesi()[j].getRandevu_tarih())[2] == zaman2[2]) {
                            if (zamanDizile(musteriListesi[i].getRandevuListesi()[j].getRandevu_tarih())[1] < zaman2[1]) {
                                cozumlenmisRandevu[i] = musteriListesi[i].getRandevuListesi()[j];
                            } else if (zamanDizile(musteriListesi[i].getRandevuListesi()[j].getRandevu_tarih())[1] == zaman2[1] && zamanDizile(musteriListesi[i].getRandevuListesi()[j].getRandevu_tarih())[0] < zaman2[0]) {
                                cozumlenmisRandevu[i] = musteriListesi[i].getRandevuListesi()[j];
                            } else {
                                cozumlenmemisRandevu[i] = musteriListesi[i].getRandevuListesi()[j];
                            }
                        } else if (zaman1[2] < zamanDizile(musteriListesi[i].getRandevuListesi()[j].getRandevu_tarih())[2] && zamanDizile(musteriListesi[i].getRandevuListesi()[j].getRandevu_tarih())[2] < zaman2[2]) {
                            cozumlenmisRandevu[i] = musteriListesi[i].getRandevuListesi()[j];
                        } else if (zaman1[2] < zamanDizile(musteriListesi[i].getRandevuListesi()[j].getRandevu_tarih())[2] && zamanDizile(musteriListesi[i].getRandevuListesi()[j].getRandevu_tarih())[2] > zaman2[2]) {
                            cozumlenmemisRandevu[i] = musteriListesi[i].getRandevuListesi()[j];
                        }
                    }

                }

            }
        }

        System.out.println("Çözümlenmiş randevular : ");
        for (int i = 0; i < cozumlenmisRandevu.length; i++) {
            if (cozumlenmisRandevu[i] != null) {
                cozumlenmisRandevu[i].bilgiVer();
            }
        }

        System.out.println();

        System.out.println("Çözümlenmemiş randevular : ");
        for (int i = 0; i < cozumlenmemisRandevu.length; i++) {
            if (cozumlenmemisRandevu[i] != null) {
                cozumlenmemisRandevu[i].bilgiVer();
            }
        }

    }
    
    //Müşteriye ait herhangi bir aktif arızaının olup olmadığını kontrol edip
    //aktif arıza yoksa silip, varsa silinme işlemi yapılmaz.
    public void musteriSil(Musteri musteri, Zaman zaman) {
        int[] guncelZaman = zamanDizile(zaman.getZaman());

        for (int i = 0; i < musteriListesi.length; i++) {
            if (musteriListesi[i] == musteri) {

                for (int j = 0; j < musteriListesi[i].getRandevuListesi().length; j++) {
                    if (musteriListesi[i].getRandevuListesi()[j] != null) {
                        if (zamanDizile(musteriListesi[i].getRandevuListesi()[j].getRandevu_tarih())[2] > guncelZaman[2]) {
                            System.out.println("Müşteriye ait aktif randevu bulunduğundan silinme işlemi yapılamaz.");
                        } else if (zamanDizile(musteriListesi[i].getRandevuListesi()[j].getRandevu_tarih())[2] == guncelZaman[2] && zamanDizile(musteriListesi[i].getRandevuListesi()[j].getRandevu_tarih())[1] > guncelZaman[1]) {
                            System.out.println("Müşteriye ait aktif randevu bulunduğundan silinme işlemi yapılamaz.");
                        } else if (zamanDizile(musteriListesi[i].getRandevuListesi()[j].getRandevu_tarih())[2] == guncelZaman[2] && zamanDizile(musteriListesi[i].getRandevuListesi()[j].getRandevu_tarih())[1] == guncelZaman[1] && zamanDizile(musteriListesi[i].getRandevuListesi()[j].getRandevu_tarih())[0] > guncelZaman[0]) {
                            System.out.println("Müşteriye ait aktif randevu bulunduğundan silinme işlemi yapılamaz.");
                        } else {
                            System.out.println("Müşteriye ait herhangi bir aktif randevu bulunamadı. Müşteri silme işlemi başarılı.");
                            musteriListesi[i] = null;
                            break;
                        }

                    }
                }

            }
        }
    }
}
