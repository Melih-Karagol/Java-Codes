import java.util.HashMap;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        System.out.println("Para miktarini giriniz:");
        double para = scanner.nextDouble();
        System.out.println("Doviz degerini giriniz:");
        double doviz = scanner.nextDouble();
        ParaBozdur(para,doviz);
    }
    public static void ParaBozdur(double a,double b){
        HashMap<String,Integer> banknot = new HashMap<>();
        double sonuc = a*b;
        int ikiYuzluk =0;
        int yuzluk =0;
        int ellilik =0;
        int yirmilik=0;
        int onluk =0;
        int beslik = 0;
        int birlik=0;
        System.out.println((int)sonuc+" TL icin banknot sayisi:");
        while (sonuc>0){
            if (sonuc%200==0){
                ikiYuzluk++;
                sonuc = sonuc-200;

            } else if (sonuc%100==0) {
                yuzluk++;
                sonuc=sonuc-100;

            } else if (sonuc%50==0) {
                ellilik++;
                sonuc = sonuc-50;

            } else if (sonuc%20==0) {
                yirmilik++;
                sonuc = sonuc-20;
            } else if (sonuc%10==0) {
                onluk++;
                sonuc = sonuc-10;

            } else if (sonuc%5==0) {
                beslik++;
                sonuc = sonuc-5;

            } else if (sonuc%1==0) {
                birlik++;
                sonuc =sonuc-1;

            }
        }
        banknot.put("200 banknot sayisi: ",ikiYuzluk);
        banknot.put("100 banknot sayisi:",yuzluk);
        banknot.put("50 banknot sayisi: ",ellilik);
        banknot.put("20 banknot sayisi: ",yirmilik);
        banknot.put("10 banknot sayisi: ",onluk);
        banknot.put("5 banknot sayisi: ",beslik);
        banknot.put("1 banknot sayisi: ",birlik);

        for (String i :banknot.keySet()){
            if (banknot.get(i)>0) {
                System.out.println(i + banknot.get(i));
            }
        }
    }
}
