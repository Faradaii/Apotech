import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class Main{


static Scanner scan = new Scanner(System.in);
static Apotek apotek = new Apotek();

public static void main(String[] args) throws Exception{
    loadData("obat");
    loadData("member");
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

    saveData("obat");
    saveData("member");

    
}

public static void loadData(String x) throws IOException{
    FileReader getFileReader = new FileReader("database/"+x+".txt");
    BufferedReader baca = new BufferedReader(getFileReader);
    
    Scanner scanFile = new Scanner(baca);
    if (x.equals("obat")) {
        while (scanFile.hasNext()){
            scanFile.useDelimiter(",");
            Obat obat = new Obat();
            scanFile.next().trim();
            obat.setNamaObat(scanFile.next().trim());
            obat.setKodeObat(scanFile.next().trim());
            obat.setStockObat(Integer.valueOf(scanFile.next().trim()));
            obat.setProductby(scanFile.next().trim());
            scanFile.next().trim();
            obat.setHarga(Integer.valueOf(scanFile.next().trim()));
            apotek.obats.add(obat);
            if (scanFile.nextLine().trim().isEmpty()) {
                break;
            }
        }
    } else if (x.equals("member")) {
        while (scanFile.hasNext()){
            scanFile.useDelimiter(",");
            Membership member = new Membership();
            scanFile.next().trim();
            member.setNama(scanFile.next().trim());
            member.setAlamat(scanFile.next().trim());
            member.setJenisKelamin(scanFile.next().trim());
            member.setNomorTelpon(scanFile.next().trim());
            member.setUmur(scanFile.next().trim());
            apotek.memberships.add(member);
            if (scanFile.nextLine().trim().isEmpty()) {
                break;
            }
        }
    }
    scanFile.close();

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
        case 3: 
        while (choose < 1 || choose > 3){
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
    System.out.printf("pilih menu? %n");
    int selected = chooseMenu(2);
    switch(selected){
        case 1 -> apotek.pembelianObat();
        case 2 -> apotek.pembuatanMemberBaru();
    }
    
}

public static void manajemenObat() {
    System.out.printf("%nSilahkan pilih menu berikut : %n");
    System.out.printf("\t1. Edit Informasi Obat %n");
    System.out.printf("\t2. Restock Obat %n");
    System.out.printf("pilih menu? %n");
    int selected = chooseMenu(2);
    switch(selected){
        case 1 -> apotek.updateInformasiObat();
        case 2 -> apotek.pemesananObat();
    }
}

public static void laporan() {
    System.out.printf("%nSilahkan pilih menu berikut : %n");
    System.out.printf("\t1. Lihat Informasi Penjualan Obat %n");
    System.out.printf("\t2. Lihat Informasi Pemesanan Obat %n");
    System.out.printf("pilih menu? %n");
    int selected = chooseMenu(3);
    switch(selected){
        case 1 -> apotek.showLaporanPenjualan();
        case 2 -> apotek.showLaporanPemesanan();
        case 3 -> apotek.showSaldo();
    }
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
    try {
        saveData("obat");
        saveData("member");
    } catch (IOException e) {
        e.printStackTrace();
    }
    System.exit(0);
}

public static void saveData(String x) throws IOException {
    //penggunaan ini jika database tidak kosong
    FileWriter getFileWriter = new FileWriter("database/"+x+".txt");
    BufferedWriter tulis = new BufferedWriter(getFileWriter);

    if (x.equals("obat")) {
        for (Obat obat : apotek.obats) {
            tulis.write(obat.getId() + "," + obat.getNamaObat() + "," + obat.getKodeObat() + "," + obat.getStockObat() + "," + obat.getProductby() + "," + obat.getExpiredYear() + "," + obat.getHarga()+",");
            tulis.newLine();
        }
    } else if (x.equals("member")){
        for (Membership member : apotek.memberships) {
            tulis.write(member.getId() + "," + member.getNama() + "," + member.getAlamat() + "," + member.getJenisKelamin() + "," + member.getNomorTelpon() + "," + member.getUmur() +",");
            tulis.newLine();
        }
    }
    tulis.close();
}


}