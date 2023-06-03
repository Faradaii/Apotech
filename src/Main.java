import java.util.Scanner;

public class Main{


static Scanner scan = new Scanner(System.in);
static Apotek apotek = new Apotek();

public static void main(String[] args) {
    init();
    String isContinue = "y";

    while (isContinue.equals("y")) {
        showMenu();
        int selectedMenu = chooseMenu(5);

        switch (selectedMenu) {
            case 1 -> kasir();
            case 2 -> manajemenObat();
            case 3 -> laporan();
            case 4 -> informasiObatDanMember();
            case 5 -> exit();
        }
        
        System.out.printf("%ncontinue ? : ");
        isContinue = scan.next();
        
        //handling salah input
        while (!(isContinue.equalsIgnoreCase("y") || isContinue.equalsIgnoreCase("n"))) {
            System.out.println("wrong input");
            isContinue = scan.next();
        }
    }

    
}

public static void init(){
    Obat obat1 = new Obat();
    obat1.setId(3);
    obat1.setNamaObat("paramex");

    apotek.obats.add(obat1);
}

public static void showMenu(){
    System.out.printf("%nSelamat {jam}! %nSilahkan pilih menu berikut : %n");
    System.out.printf("\t1. Kasir %n");
    System.out.printf("\t2. Manajemen Obat %n");
    System.out.printf("\t3. Laporan Penjualan dan Pemesanan Obat %n");
    System.out.printf("\t4. Informasi Obat dan Member %n");
    System.out.printf("\t5. Exit %n");
}

public static Integer chooseMenu(int hint){
    System.out.printf("%nMasukan input : ");
    int choose = scan.nextInt();
    switch(hint){
        case 5 : 
        while (choose < 1 || choose > 5){
            System.out.printf("Input salah, Silahkan coba lagi! %n");
            System.out.printf("Masukan input : ");
            choose = scan.nextInt();
        }   return choose;
        case 2 : 
        while (choose < 1 || choose > 2){
            System.out.printf("Input salah, Silahkan coba lagi! %n");
            System.out.printf("Masukan input : ");
            choose = scan.nextInt();
        }   return choose;
    }
    return choose; //tidak dieksekusi
}


public static void kasir() {
    System.out.printf("%nSilahkan pilih menu berikut : %n");
    System.out.printf("\t1. Pembelian Obat %n");
    System.out.printf("\t2. Pembuatan Member Baru %n");
}

public static void manajemenObat() {
}

public static void laporan() {
}

public static void informasiObatDanMember() {
    System.out.printf("%nSilahkan pilih menu berikut : %n");
    System.out.printf("\t1. Informasi Obat %n");
    System.out.printf("\t2. Informasi Memberships %n");
    int selected = chooseMenu(2);
    switch(selected){
        case 1 -> apotek.showInformasiObat();
        case 2 -> apotek.showInformasiMemberships();
    }
}

public static void exit() {
}

}