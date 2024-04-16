import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("--HOSGELDINIZ--");

        ArrayList<String> users = new ArrayList<>();
        ArrayList<String> passwords = new ArrayList<>();
        ArrayList<Integer> balances = new ArrayList<>();
        String adminUserName = "admin";
        String adminPassoword ="aDmiN123";
        while (true) {
            System.out.println("Giris yapmak icin 1 tusuna basiniz.");
            System.out.println("Hesap oluşturmak için 2 tuşuna basiniz.");
            System.out.println("Cikis yapmak için 3 tuşuna basiniz.");
            System.out.println("Sistemdeki kayitli kullanicalari gormek icin 4 tusuna basiniz.");
            String ilkGiris = scanner.next();
            scanner.nextLine();
            String islemler = "Islem tipi seciniz: \n" +
                    "1- Para Cekme \n" +
                    "2- Para Yatirma \n" +
                    "3- Cikis yapma";

            switch (ilkGiris) {
                case "1": {
                    System.out.println("Kullanici adinizi giriniz:");
                    String nick = scanner.nextLine();
                    System.out.println("Şifrenizi giriniz:");
                    String password = scanner.nextLine();

                    boolean girisYapildi = false;
                    for (int k = 0; k < users.size(); k++) {
                        if (nick.equals(users.get(k)) && password.equals(passwords.get(k))) {
                            System.out.println("Giris yapildi.");
                            girisYapildi = true;
                            int bakiye = balances.get(k);


                            System.out.println(islemler);
                            int tip = scanner.nextInt();
                            switch (tip) {
                                case 1: {
                                    System.out.println("Bakiyeniz:"+bakiye);
                                    System.out.println("Para cekme tutari giriniz:");
                                    int tutar = scanner.nextInt();
                                    if (bakiye >= tutar) {
                                        System.out.println("Paraniz veriliyor..");
                                        bakiye = bakiye - tutar;
                                        balances.set(k, bakiye);
                                        System.out.println("Kalan bakiye: " + bakiye);
                                        System.out.println();

                                    } else {
                                        System.out.println("Yetersiz bakiye!");
                                        System.out.println();
                                    }
                                    break;
                                }
                                case 2: {
                                    System.out.println("Yatirilicak tutar:");
                                    int yatir = scanner.nextInt();
                                    System.out.println("Para yatiriliyor..");
                                    bakiye = yatir + bakiye;
                                    balances.set(k, bakiye);
                                    System.out.println("Hesap bakiyesi:" + bakiye);
                                    System.out.println();
                                    break;
                                }
                                case 3: {
                                    System.out.println("Cikis yapiliyor...");

                                    break;
                                }

                                default:
                                    System.out.println("Gecersiz islem");
                                    System.out.println();
                                    break;
                            }

                        }
                    }
                    if (!girisYapildi) {
                        System.out.println("Kullanici adi veya sifre hatali.");
                        System.out.println("Cikis yapiliyor..");
                        System.out.println();

                    }
                    break;
                }
                case "2": {
                    System.out.println("Yeni kullanici adi olusturunuz:");
                    String nickNew = scanner.nextLine();
                    System.out.println("Yeni sifre olusturunuz:");
                    String passwordNew = scanner.nextLine();
                    if (users.contains(nickNew)){
                        System.out.println("Bu Kullanici adi daha önceden alinmis!");
                    } else if (passwordNew.length()<4) {
                        System.out.println("Sifre en az 4 haneli olmalidir!");

                    } else{
                        System.out.println("!---Yeni kullanici olusturuldu---!");
                        System.out.println();
                        users.add(nickNew);
                        passwords.add(passwordNew);
                        balances.add(10000);
                        break;
                    }
                }
                case "3": {
                    System.out.println("Cikis yapiliyor..");
                    System.out.println();
                    break;
                }
                case "4":{
                    System.out.println("Hosgeldin Admin!");
                    System.out.println("Sistem bilgilerini görmek için kullanici adi ve sifre giriniz:");
                    System.out.print("Admin Adi:");
                    String adminKullanici = scanner.next();
                    System.out.print("Admin sifre:");
                    String adminSifre = scanner.next();
                    if (adminKullanici.equals(adminUserName)&&adminSifre.equals(adminPassoword)){
                        System.out.println("Giris Yapildi!");
                        for (int i=0;i<users.size();i++){
                            System.out.print((i+1)+". User Nickname: "+users.get(i)+" User Password: "+passwords.get(i)+" User Balance "+balances.get(i));
                            System.out.println();
                        }
                        break;

                    }else{
                        System.out.println("Admin password veya kullanici adi hatali!");
                        System.out.println("Cikis yapiliyor..");
                        System.out.println();
                        break;
                    }
                }
                default:
                    System.out.println("Geçersiz işlem!");
                    break;
            }
        }
    }
}
