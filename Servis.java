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
public class Servis {

    private int id;
    private String name;
    private Tekniker tekniker;
    private Tekniker[] teknikerList;

    public Servis(int id, String name) {

        try {
            if (id <= 0) {
                throw new HataliGirisKontrol("Lütfen geçerli bir id tanımlayınız.");
            }
            this.id = id;
        } catch (Exception e) {
            this.id = 0;
            System.out.println(e.getMessage());
        }

        this.name = name;
        try {
            if (name.length() < 2) {
                throw new HataliGirisKontrol("Böyle bir servis ismi tanımlanamaz.");
            }
            this.name = name;
        } catch (Exception e) {
            this.name = "ServisİsimDefault";
            System.out.println(e.getMessage());
        }

        this.tekniker = tekniker;
        teknikerList = new Tekniker[10];
    }

    //Atanacak teknikeri önceden atanma durumuna göre kontrol
    //edip tekniker listesine ekleyen metod.
    public void teknikerEkle(Tekniker tekniker) {
        boolean ayniTeknikerMi = false;
        for (int i = 0; i < teknikerList.length; i++) {
            if (teknikerList[i] != null && teknikerList[i] == tekniker) {
                ayniTeknikerMi = true;
                break;
            }
        }

        if (ayniTeknikerMi == false) {
            for (int i = 0; i < this.teknikerList.length; i++) {
                if (this.teknikerList[i] == null) {
                    this.teknikerList[i] = tekniker;
                    break;
                }
            }
        } else {
            System.out.println("Bu tekniker zaten atanmış.");
        }
    }
    
    //Tekniker listesinin her bir elemanındaki arızayı listeleyerek
    //servisteki bütün arızaları karışık olarak listeler.
    public void karisikArizaListele() {
        for (int i = 0; i < teknikerList.length; i++) {
            if (teknikerList[i] != null) {
                teknikerList[i].arizaListele();
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
    
    
    //Tekniker listesinin elemanından arıza listesine ulaştıktan sonra buradaki arızanın
    //ücret bilgilerine ulaşıp her bir tekniker için toplayıp diziye eleman olarak atıyoruz.
    //Bu dizideki elemanlardan en çok hasılat yapanı indisiyle beraber bulup teknikere ait
    //arızaları listesini yazdırıyoruz.    
    public void teknikerEnCokHasilatListele() {
        double toplam = 0;
        double maks = 0;
        int indis = 0;
        double[] hasilatToplam = new double[100];
        for (int i = 0; i < teknikerList.length; i++) {
            if (teknikerList[i] != null) {
                toplam = 0;
                for (int j = 0; j < teknikerList[i].getArizaListesi().length; j++) {
                    if (teknikerList[i].getArizaListesi()[j] != null) {
                        toplam += teknikerList[i].getArizaListesi()[j].getAriza_ucret();
                    }
                }
                hasilatToplam[i] = toplam;
            }
        }

        for (int i = 0; i < hasilatToplam.length; i++) {
            maks = hasilatToplam[i];
            for (int j = 0; j < hasilatToplam.length; j++) {
                if (maks < hasilatToplam[j]) {
                    maks = hasilatToplam[j];
                    indis = j;
                }
            }
        }

        System.out.println("Maksimum kazanç sağlayan tekniker : " + teknikerList[indis].toString());
        System.out.println("--------------------------------------");
        System.out.println("Teknikerin bakmış olduğu arızalar : ");
        System.out.println();
        for (int i = 0; i < teknikerList[indis].getArizaListesi().length; i++) {
            if (teknikerList[indis].getArizaListesi()[i] != null) {
                teknikerList[indis].getArizaListesi()[i].bilgiVer();
            }
        }

    }
    
    //Servisteki tüm teknikerlerin çalışma saatleri ve kazançlarının teknikerList
    //sayesinde toplamıyla tekniker sayısına bölününce ortalama kazanç ve tamir süresini 
    //bulan metod.
    public void ortalamaKazancVeTamirSuresi() {
        double ortalamaKazanc = 0;
        double toplamKazanc = 0;
        double ortalamaTamirSure = 0;
        double toplamTamirSure = 0;
        int sayac = 0;
        for (int i = 0; i < teknikerList.length; i++) {
            if (teknikerList[i] != null) {
                for (int j = 0; j < teknikerList[i].getArizaListesi().length; j++) {
                    if (teknikerList[i].getArizaListesi()[j] != null) {
                        toplamKazanc += teknikerList[i].getArizaListesi()[j].getAriza_ucret();
                        toplamTamirSure += teknikerList[i].getArizaListesi()[j].getAriza_sure();
                        sayac++;
                    }
                }
            }
        }

        ortalamaKazanc = toplamKazanc / sayac;
        ortalamaTamirSure = toplamTamirSure / sayac;

        System.out.println("Elde elien ortalama kazanç : " + ortalamaKazanc);
        System.out.println("Servisteki ortalama tamir süresi : " + ortalamaTamirSure + " gündür.");
    }
    
    
    
    //Teknikerin verilen zaman göre aktif arızasının olup olmadığı tespitini yapıp ona göre
    //teknikerin silen metod. Teknikere ait aktif bir arıza bulunmuyorsa varsa eski arızalarını eskiArızalar
    //listesine atar. Eğer aktif arıza bulunuyorsa serviste başka bir tekniker varsa ona aktarılır ve arızalar 
    //eskiArızalara aktarılır. Eğer tekniker yoksa silme işlemi gerçekleştirilmez.
    public void teknikerSil(Tekniker tekniker, Zaman zaman) {
        int[] guncelZaman = zamanDizile(zaman.getZaman());
        int sayac = 0;
        int rastgeleSayi = 0;
        Ariza[] eskiArizalar = new Ariza[20];
        for (int i = 0; i < teknikerList.length; i++) {
            if (teknikerList[i] == tekniker) {

                for (int j = 0; j < teknikerList[i].getArizaListesi().length; j++) {
                    if (teknikerList[i].getArizaListesi()[j] != null) {
                        if (zamanDizile(teknikerList[i].getArizaListesi()[j].getArizaRandevuTarih())[2] > guncelZaman[2]) {
                            for (int k = 0; k < teknikerList.length; k++) {
                                if (teknikerList[k] != tekniker && teknikerList[k] != null) {
                                    sayac++;
                                }
                            }

                            if (sayac > 0) {
                                rastgeleSayi = (int) (Math.random() * sayac) + 1;

                                for (int k = 0; k < teknikerList[i].getArizaListesi().length; k++) {
                                    if (teknikerList[i].getArizaListesi()[k] != null) {
                                        teknikerList[rastgeleSayi].arizaEkle(teknikerList[i].getArizaListesi()[k]);
                                        eskiArizalar[k] = teknikerList[i].getArizaListesi()[k];
                                    }
                                }
                                teknikerList[i] = null;

                                System.out.println("Eski arızalar listesi: ");
                                for (int k = 0; k < eskiArizalar.length; k++) {
                                    if (eskiArizalar[k] != null) {
                                        eskiArizalar[k].bilgiVer();
                                    }
                                }

                                System.out.println("Silinen teknikerin bilgileri boşta olan diğer teknikere atandı. Tekniker silme işlemi başarılı.");
                                break;

                            } else {
                                System.out.println("Randevu aktarılacak başka bir tekniker olmadığından silme işlemi yapılamadı.");
                            }

                        } else if (zamanDizile(teknikerList[i].getArizaListesi()[j].getArizaRandevuTarih())[2] == guncelZaman[2] && zamanDizile(teknikerList[i].getArizaListesi()[j].getArizaRandevuTarih())[1] > guncelZaman[1]) {
                            for (int k = 0; k < teknikerList.length; k++) {
                                if (teknikerList[k] != tekniker && teknikerList[k] != null) {
                                    sayac++;
                                }
                            }

                            if (sayac > 0) {
                                rastgeleSayi = (int) (Math.random() * sayac) + 1;

                                for (int k = 0; k < teknikerList[i].getArizaListesi().length; k++) {
                                    if (teknikerList[i].getArizaListesi()[k] != null) {
                                        teknikerList[rastgeleSayi].arizaEkle(teknikerList[i].getArizaListesi()[k]);
                                        eskiArizalar[k] = teknikerList[i].getArizaListesi()[k];
                                    }
                                }
                                teknikerList[i] = null;

                                System.out.println("Eski arızalar listesi: ");
                                for (int k = 0; k < eskiArizalar.length; k++) {
                                    if (eskiArizalar[k] != null) {
                                        eskiArizalar[k].bilgiVer();
                                    }
                                }

                                System.out.println("Silinen teknikerin bilgileri boşta olan diğer teknikere atandı. Tekniker silme işlemi başarılı.");
                                break;

                            } else {
                                System.out.println("Randevu aktarılacak başka bir tekniker olmadığından silme işlemi yapılamadı.");
                            }

                        } else if (zamanDizile(teknikerList[i].getArizaListesi()[j].getArizaRandevuTarih())[2] == guncelZaman[2] && zamanDizile(teknikerList[i].getArizaListesi()[j].getArizaRandevuTarih())[1] == guncelZaman[1] && zamanDizile(teknikerList[i].getArizaListesi()[j].getArizaRandevuTarih())[0] > guncelZaman[0]) {
                            for (int k = 0; k < teknikerList.length; k++) {
                                if (teknikerList[k] != tekniker && teknikerList[k] != null) {
                                    sayac++;
                                }
                            }

                            if (sayac > 0) {
                                rastgeleSayi = (int) (Math.random() * sayac) + 1;

                                for (int k = 0; k < teknikerList[i].getArizaListesi().length; k++) {
                                    if (teknikerList[i].getArizaListesi()[k] != null) {
                                        teknikerList[rastgeleSayi].arizaEkle(teknikerList[i].getArizaListesi()[k]);
                                        eskiArizalar[k] = teknikerList[i].getArizaListesi()[k];
                                    }
                                }
                                teknikerList[i] = null;

                                System.out.println("Eski arızalar listesi: ");
                                for (int k = 0; k < eskiArizalar.length; k++) {
                                    if (eskiArizalar[k] != null) {
                                        eskiArizalar[k].bilgiVer();
                                    }
                                }

                                System.out.println("Silinen teknikerin bilgileri boşta olan diğer teknikere atandı. Tekniker silme işlemi başarılı.");
                                break;

                            } else {
                                System.out.println("Randevu aktarılacak başka bir tekniker olmadığından silme işlemi yapılamadı.");
                            }
                        } else {
                            for (int k = 0; k < teknikerList[i].getArizaListesi().length; k++) {
                                if (teknikerList[i].getArizaListesi()[k] != null) {
                                    eskiArizalar[k] = teknikerList[i].getArizaListesi()[k];
                                }
                            }

                            teknikerList[i] = null;
                            System.out.println("Silme işlemi başarıyla gerçekleştirildi.");
                            System.out.println();
                            System.out.println("Eski arızalar listesi: ");
                            for (int k = 0; k < eskiArizalar.length; k++) {
                                if (eskiArizalar[k] != null) {
                                    eskiArizalar[k].bilgiVer();
                                }
                            }
                            break;
                        }
                    }
                }
            }
        }

    }

}
