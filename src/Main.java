import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        /*
        Kepler kanununa göre eksentri ve r değerini bulan program
         */
        // kullanıcıdan gerekli parametreleri alıyorum
        System.out.println("Elipsin büyük yarıçapını giriniz: ");
        double a =0;
        a=sc(a);
        System.out.println("Elipsin küçük yarıçapını giriniz: ");
        double b =0;
        b=sc(b);
        //Kural gereği a değeri b den büyük olmalıdır
        if(a>b)
        {

            System.out.println("Elipsin açı değerini giriniz: ");
            double q =0;
            q=sc(q);
            //Kepler classımı çağırıyorum
            Kepler kepler = new Kepler(a,b,q);
            kepler.yazdir();
        }
        else {
            System.out.println("Yanlış değer girdiniz");

        }

    }
    static double sc(double x)
    {
        // KUllanıcıdan değerlerimi scanner kullanarak metod içinde alıyorum
        Scanner scan = new Scanner(System.in);
        while (true) {
            x = scan.nextDouble();

            if (x > 0) {
                break; // Doğru değer girildiğinde döngü sonlanır
            }

            System.out.println("Hatalı giriş yaptınız. Lütfen pozitif bir sayı girin.");
        }

        return x;
    }
}
class Kepler{
    //Kepler classımı oluşturdum içerisine parametrelerimi yazdım
    double a;
    double b;
    double q;
    Kepler(double a,double b, double q){
        this.a = a;
        this.b=b;
        this.q=q;

    }
    public double eksentri(){
        // e değerimi hesaplıyorum

        double deger = (1-b/a)*(1+b/a);
        double e = Math.sqrt(Math.abs(deger));
        return  e;
    }
    public double polar()
    {
        //r değerimi hesaplıyorum
        double e = eksentri();
        double d0 =Math.pow(e,2);
        double d1 = a*(1-d0);
        double radyan = Math.toRadians(q);
        double d2 = e*Math.cos(radyan);
        double r= d1 /(1+d2);

        return r;
    }
    public void yazdir(){
        //maine yazmaya hazır hale getirdim
        double e= eksentri();
        double r = polar();
        System.out.println("Elipsin büyük yarıçapı : "+a);
        System.out.println("Elipsin küçük yarıçapı : "+b);
        System.out.println("Açı değeri : "+ q);
        System.out.println("Eksentri değeri : "+e);
        System.out.println("r değeri : "+r);

    }
}