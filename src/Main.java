import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
// import java.time.format.DateTimeFormatter;
import java.util.Scanner;

public class Main{


static Scanner scan = new Scanner(System.in);
static Apotek apotek = new Apotek();

public static void main(String[] args) throws Exception{
    loadData("obat");
    loadData("member");
    loadData("penjualanobat");
    loadData("restockobat");
    loadData("saldo");

    Boolean sukses = login();
    while (!sukses){
        sukses = login();
    }

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
    saveData("penjualanobat");
    saveData("restockobat");
    saveData("saldo");
}

private static void loadData(String x) throws IOException{
    FileReader getFileReader = new FileReader("database/"+x+".txt");
    BufferedReader baca = new BufferedReader(getFileReader);
    
    Scanner scanFile = new Scanner(baca);
    scanFile.useDelimiter(",");
    if (x.equals("obat")) {
        while (scanFile.hasNext()){
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
            // scanFile.useDelimiter(",");
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
    } else if (x.equals("restockobat")){
            while (scanFile.hasNext()){
                // scanFile.useDelimiter(",");
                RestockObat invoice = new RestockObat();
                invoice.setId(scanFile.next().trim());
                invoice.setKodeObat(scanFile.next().trim());
                invoice.setDate(LocalDate.parse(scanFile.next().trim()));
                invoice.setNamaObat(scanFile.next().trim());
                invoice.setSupplier(scanFile.next().trim());
                invoice.setStockObat(Integer.valueOf(scanFile.next().trim()));
                invoice.setHarga(Integer.valueOf(scanFile.next().trim()));
                invoice.setTotalHarga(Integer.valueOf(scanFile.next().trim()));
                apotek.restockObats.add(invoice);
                if(scanFile.nextLine().trim().isEmpty()){
                    break;
                }

            }  
    } else if (x.equals("penjualanobat")) {
            while(scanFile.hasNext()){
                // scanFile.useDelimiter(",");
                PenjualanObat invoice = new PenjualanObat();
                invoice.setId(scanFile.next().trim());
                invoice.setIdObat(Integer.valueOf(scanFile.next().trim()));
                invoice.setDate(LocalDate.parse(scanFile.next().trim()));
                invoice.setNamaObat(scanFile.next().trim());
                invoice.setJenisPembayaran(scanFile.next().trim());
                invoice.setTotalItem(Integer.valueOf(scanFile.next().trim()));
                invoice.setTotalHarga(Integer.valueOf(scanFile.next().trim()));
                invoice.setPembeli((scanFile.next().trim()));
                apotek.penjualanObats.add(invoice);
                if(scanFile.nextLine().trim().isEmpty()){
                    break;
                }
            }
        
    } else if(x.equals("saldo")){
        while(scanFile.hasNext()){
            Saldo.setPengeluaran(Integer.valueOf(scanFile.next().trim()));
            Saldo.setPendapatan(Integer.valueOf(scanFile.next().trim()));
            if(scanFile.nextLine().trim().isEmpty()){
                break;
            }
        }
    }
    scanFile.close();

}

public static void showMenu(){
    System.out.printf("%nSelamat %s! %nSilahkan pilih menu berikut : %n", greeting());
    System.out.printf("\t1. Kasir %n");
    System.out.printf("\t2. Manajemen Obat %n");
    System.out.printf("\t3. Laporan Penjualan, Pemesanan Obat dan Saldo %n");
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
    System.out.printf("\t3. Lihat Informasi Saldo %n");
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
        saveData("penjualanobat");
        saveData("restockobat");
        saveData("saldo");
    } catch (IOException e) {
        e.printStackTrace();
    }
    System.exit(0);
}

private static void saveData(String x) throws IOException {
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
    } else if (x.equals("restockobat")){
        for (RestockObat invoice : apotek.restockObats){
            tulis.write(invoice.getId() + "," + invoice.getKodeObat() + "," + invoice.getDate() + "," + invoice.getNamaObat() + "," + invoice.getSupplier() + "," + invoice.getStockObat() + "," +  invoice.getHarga() + "," + invoice.getTotalHarga() + ",");
            tulis.newLine();
        }
    } else if (x.equals("penjualanobat")) {
        for(PenjualanObat invoice : apotek.penjualanObats){
            tulis.write(invoice.getId() + "," + invoice.getIdObat() + "," + invoice.getDate() + "," + invoice.getNamaObat() + "," + invoice.getJenisPembayaran() + "," + invoice.getTotalItem() + "," + invoice.getTotalHarga() + "," + invoice.getPembeli() + ","  );
            tulis.newLine();
        }
    
    } else if (x.equals("saldo")){
        tulis.write(Saldo.getPengeluaran() + "," + Saldo.getPendapatan() + ",");
        tulis.newLine();
    }
    tulis.close();
}

private static String greeting(){
    
    LocalDateTime date = LocalDateTime.now();
    // DateTimeFormatter hour = DateTimeFormatter.ofPattern("HH");
    int h = Integer.parseInt(date.format(DateTimeFormatter.ofPattern("HH")));
    if (h >= 19) {
        return "Malam";
    } else if (h >= 16){
        return "Sore";
    } else if (h >= 12){
        return "Siang";
    } else {
        return "Pagi";
    }
}

private static Boolean login() throws IOException{
    System.out.printf("Silahkan masukan username : ");
    String username = scan.nextLine();
    System.out.printf("Silahkan masukan password : ");
    String password = scan.nextLine();
    FileReader getFileReader = new FileReader("admin/admin.txt");
    BufferedReader baca = new BufferedReader(getFileReader);
    Scanner scanFile = new Scanner(baca);
    scanFile.useDelimiter(",");
    while (scanFile.hasNext()) {
        if (username.equals(scanFile.next().trim()) && password.equals(scanFile.next().trim())) {
            scanFile.close();
            return true;
        } 
        if(scanFile.nextLine().trim().isEmpty()){
            break;
        }
    }
    System.out.println("Username or Password wrong! Try again");
    scanFile.close();
    return false;

}


}