/**
*
* @author Erencan İNANCI - erencan_inanci@hotmail.com / b171210308@sakarya.edu.tr
* @since 10.03.2019 / 15:04:39
* <p>
* Rastgelelik kavramının sistem saatine göre oluşturulduğu ve metotların bulunduğu java programı.
* </p>
*/
package rastgelekarakter;

public class RastgeleKarakter {
    int rastgeleUretilenDeger; //üretilen degeri daha sonra atayıp kullanmak için degisken
        //rastgele değerini sistem saatinden üretiyorum. daha sonra mod alınıp kullanılacak.
    private long rastgeleUretici() {
        long randValue = System.nanoTime();
        return randValue;
    }
    
    //**YALNIZCA** karakter üretilmesini sağlayan metot.
    public char rastgeleKarakterUret() {
        char karakter;
        while(true) {
            rastgeleUretilenDeger = (int) ((rastgeleUretici())%123); //sistem saati değerinin 123 e bölümünden kalanını yukarıda tanımladığım degiskene atıyorum. **
            /*  bu kısım yalnızca harf üretilmesini sağlıyan koşul bloğu, kullanılmadığı takdirde #,+,6,]... şeklinde çeşitli karakterler de üretebiliyor.         *
            **  bunun sebebi ascii table da 65-90 arası A-Z ve 97-122 arası a-z harflerinden oluşuyor olması.                                                      */
            if((rastgeleUretilenDeger>=65 && rastgeleUretilenDeger<=90) || (rastgeleUretilenDeger>=97 && rastgeleUretilenDeger<=122))
                break;
        }
        karakter=(char) rastgeleUretilenDeger; //uretilen rastgeledeger char a donusturulup karakter degiskenine atıyorum.
        return karakter;
    }
    
    
    //girilen 2 karakter arasındaki karakterlerden rastgele harf üreten metot.
    public char verilenIkiKarakter(int karakter1, int karakter2) {
        while(true){
            rastgeleUretilenDeger = rastgeleKarakterUret();
            if((rastgeleUretilenDeger >= karakter1) && (rastgeleUretilenDeger <= karakter2))
                break;
        }
        return (char) rastgeleUretilenDeger; 
    }
    
    //girilen sayı kadar rastgele karakter oluşturan metot.
    public String nTaneRandom(int sayi) throws InterruptedException{
        String s = "";
        for (int i = 1; i <= sayi; i++) {
            rastgeleUretilenDeger = rastgeleKarakterUret();
            s += (char) rastgeleUretilenDeger;
            Thread.sleep(0L);
        }
        return s;
    }
    
    //2 veya 3 kelimeli random cümle oluşturucu metot.
    public String cumleOlustur(int boslukAdedi) throws InterruptedException{
        int karakterUzunluk;
        while(true) {
            karakterUzunluk = (int) ((rastgeleUretici())%97);
            if((karakterUzunluk>=15 && karakterUzunluk<=97))
                break;
        }
        
        String cumle = "";
        for (int i = 0; i < karakterUzunluk; i++) {
            cumle += rastgeleKarakterUret(); //15 ile 97 arasında rastgele sayıda karakterli cümle generate edilip string degiskene atildi.
            try {
                Thread.sleep(0L);
            } catch (InterruptedException ex) {
            }
        }
        char cumleDonustur[] = null;
        cumleDonustur = cumle.toCharArray(); //char dizisine attım
        int boslukYerleri[] = new int[boslukAdedi]; //boşlukların geleceği indisleri dizide tuttum.
        
        for (int i = 0; i < boslukAdedi; i++) {
            boslukYerleri[i] = (int) (System.nanoTime()%karakterUzunluk);
        }
        
        while(boslukAdedi != 0){
            for (int j = 0; j < cumle.length(); j++) {
                if (boslukAdedi != 0) {
                    cumleDonustur[boslukYerleri[j]] = ' ';
                    boslukAdedi--;
                }
            }
        }
        String cumleYeni = String.valueOf(cumleDonustur);
        return cumleYeni;
    }
    
    public char verilenKarakterlerden(int karakter1, int karakter2, int karakter3, int karakter4, int karakter5){
        while(true){
            rastgeleUretilenDeger = rastgeleKarakterUret();
            if((rastgeleUretilenDeger == karakter1) || (rastgeleUretilenDeger == karakter2) || (rastgeleUretilenDeger == karakter3) || (rastgeleUretilenDeger == karakter4) || (rastgeleUretilenDeger == karakter5))
                break;
        }
        return (char) rastgeleUretilenDeger; 
    }
    
    public void ekranaYazdirTekSefer() throws InterruptedException{
        //rastgele tek karakter yazdıran metot.
        StringBuilder rastgeleKarakterYaz = new StringBuilder();
        char randomChar1 = rastgeleKarakterUret();
        rastgeleKarakterYaz.append(randomChar1);
        System.out.println("Rastgele karakter: "+rastgeleKarakterYaz.toString());
        
        //verilen karakterler arasından rastgele karakter üretme.
        StringBuilder rastgeleBelirtilenKrkArasiYaz = new StringBuilder();
        char paramx1 = 'g';
        char paramx2 = 'x';
        char paramx3 = 'u';
        char paramx4 = 'z';
        char paramx5 = 'a';
        char randomVerilen = verilenKarakterlerden(paramx1,paramx2,paramx3,paramx4,paramx5);
        rastgeleBelirtilenKrkArasiYaz.append(randomVerilen);
        System.out.println("Verilen karakter arasından rastgele("+paramx1+", "+paramx2+", "+paramx3+", "+paramx4+", "+paramx5+"): "+rastgeleBelirtilenKrkArasiYaz.toString());
        
        //verilen 2 karakter arasından rastgele tek karakter yazdıran metot.
        StringBuilder rastgeleVerilenKrkArasiYaz = new StringBuilder();
        char param1 = 'a';
        char param2 = 'k';
        char randomCharBoundary = verilenIkiKarakter(param1,param2);
        rastgeleVerilenKrkArasiYaz.append(randomCharBoundary);
        System.out.println("Verilen iki karakter("+(param1+", "+param2)+"): "+rastgeleVerilenKrkArasiYaz.toString());
        
        //n adet rastgele karakter yazdıran metot.
        StringBuilder rastgeleNAdet = new StringBuilder();
        int charSay = 3;
        String nTaneKarakter = nTaneRandom(charSay);
        rastgeleNAdet.append(nTaneKarakter);
        System.out.println("Rastgele "+charSay+" adet: "+rastgeleNAdet.toString());
        
        //cümle yazdıran metot. rastgele sayıda kelimeli (min2-max5)
        String rastgeleCumle = cumleOlustur(5);
        System.out.print("Rastgele Cumle : "+rastgeleCumle);
        System.out.print("\n");
    }
    
    public void multipleEkranaYazdir() throws InterruptedException{
        for (int i = 0; i < 100; i++) {
            ekranaYazdirTekSefer();
            System.out.println("************");
        }
    }
}