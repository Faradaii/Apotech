import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Scanner;
import java.io.BufferedWriter;
import java.io.FileWriter;

public class Apotek extends Saldo{

Scanner scan = new Scanner(System.in);


public ArrayList<Obat> obats = new ArrayList<Obat>();
public ArrayList<Membership> memberships = new ArrayList<Membership>();
public ArrayList<PenjualanObat> penjualanObats = new ArrayList<PenjualanObat>();
public ArrayList<RestockObat> restockObats = new ArrayList<RestockObat>();
public ArrayList<Struk> strukPenjualanObats = new ArrayList<Struk>();
//section kasir 
public void pembelianObat(){
  showInformasiObat();
  PenjualanObat laporan = new PenjualanObat();
  Struk strukPenjualanObat = new Struk(); //ini khusus struk untuk dicetak

  System.out.printf("%nSilahkan pilih id obat yang ingin di beli : ");
  int idObat = scan.nextInt();
  laporan.setIdObat(idObat);
  scan.nextLine(); // solusi sementara agar pengisian nama terbaca
  Obat obat = getObatById(idObat);
  while (obat == null) {
    System.out.print("obat tidak ada! ingin kembali? (y/n) : ");
    String answer = scan.nextLine();
    if (answer.equalsIgnoreCase("y")){
      return;
    }
    System.out.print("Silahkan ulangi masukan id obat!\n");
    System.out.print("id obat : ");
    idObat = scan.nextInt();
    scan.nextLine();
    obat = getObatById(idObat);
  }

  while(obat.getStockObat() <= 0){
    System.out.printf("Stock obat habis, mohon pilih obat yang lain!");
    System.out.printf("%nSilahkan pilih id obat yang ingin di beli : ");
    idObat = scan.nextInt();
    laporan.setIdObat(idObat);
    obat = getObatById(idObat);
  }
  laporan.setNamaObat(obat.getNamaObat());

  System.out.printf("Silahkan masukan jenis pembayaran : ");
  laporan.setJenisPembayaran(scan.nextLine());
  System.out.printf("Silahkan masukan total item : ");
  laporan.setTotalItem(scan.nextInt());
  obat.setStockObat(obat.getStockObat()-laporan.getTotalItem()); // pengurangan stok obat
  scan.nextLine(); // solusi sementara agar pengisian nama terbaca

  System.out.printf("Apakah anda memiliki memberships ? (y/n) : ");
  String answer = scan.nextLine();

  laporan.setPembeli("anonymous");
  if(answer.equalsIgnoreCase("y")){
    System.out.printf("Silahkan masukan id member : ");
    int idMember = scan.nextInt();
    scan.nextLine();
    Membership member = getMemberById(idMember);
    laporan.setPembeli(member.getNama());
    laporan.setTotalHarga(laporan.getTotalItem()*(obat.getHargaMember()));
  } else {
    laporan.setTotalHarga(laporan.getTotalItem()*obat.getHarga());
  }
  Saldo.setPendapatan(laporan.getTotalHarga());

  strukPenjualanObat.setKeseluruhan(laporan.getId(), laporan.getPembeli(), laporan.getJenisPembayaran(), String.valueOf(laporan.getDate()));
  strukPenjualanObat.tambahPembelian(laporan.getNamaObat(), laporan.getTotalItem(), obat.getHarga(), laporan.getTotalHarga()/laporan.getTotalItem());

  this.penjualanObats.add(laporan);
  this.strukPenjualanObats.add(strukPenjualanObat);

  System.out.printf("ada tambahan lagi? y/n: ");
  while (scan.nextLine().equals("y")) {
    pembelianObat(true, laporan.getJenisPembayaran(), laporan.getPembeli(), strukPenjualanObat.getId());
  }

  System.out.println(strukPenjualanObat.getTotalHargaKeseluruhan());
  System.out.printf("Silahkan masukan total bayar pelanggan : ");
  strukPenjualanObat.setBayar(scan.nextInt());
  scan.nextLine(); //untuk clear scanner

  System.out.printf("Apakah struknya ingin dicetak? y/n : ");
  if (scan.nextLine().equals("y")) {
    strukPenjualanObat.cetak();    
  }

}
public void pembelianObat(Boolean buyAgain, String jenisPembayaran, String pembeli, String strukId){
  showInformasiObat();
  PenjualanObat laporan = new PenjualanObat(strukId);
  Struk strukPenjualanObat = getStrukById(strukId); //ini khusus struk untuk dicetak
  System.out.printf("%nSilahkan pilih id obat yang ingin di beli : ");
  int idObat = scan.nextInt();
  laporan.setIdObat(idObat);
  scan.nextLine(); // solusi sementara agar pengisian nama terbaca
  Obat obat = getObatById(idObat);
   while (obat == null) {
    System.out.print("obat tidak ada! ingin kembali? (y/n) : ");
    String answer = scan.nextLine();
    if (answer.equalsIgnoreCase("y")){
      return;
    }
    System.out.print("Silahkan ulangi masukan id obat!\n");
    System.out.print("id obat : ");
    idObat = scan.nextInt();
    scan.nextLine();
    obat = getObatById(idObat);
    }
  while(obat.getStockObat() <= 0){
    System.out.printf("Stock obat habis, mohon pilih obat yang lain!");
    System.out.printf("%nSilahkan pilih id obat yang ingin di beli : ");
    idObat = scan.nextInt();
    laporan.setIdObat(idObat);
    obat = getObatById(idObat);
  }
  laporan.setNamaObat(obat.getNamaObat());

  laporan.setJenisPembayaran(jenisPembayaran);
  System.out.printf("Silahkan masukan total item : ");
  laporan.setTotalItem(scan.nextInt());
  obat.setStockObat(obat.getStockObat()-laporan.getTotalItem()); // pengurangan stok obat
  scan.nextLine(); // solusi sementara agar pengisian nama terbaca

  laporan.setPembeli(pembeli);
  if(!laporan.getPembeli().equals("anonymous")){
    laporan.setTotalHarga(laporan.getTotalItem()*(obat.getHargaMember()));
  } else {
    laporan.setTotalHarga(laporan.getTotalItem()*obat.getHarga());
  }
  
  Saldo.setPendapatan(laporan.getTotalHarga());
  strukPenjualanObat.tambahPembelian(laporan.getNamaObat(), laporan.getTotalItem(), obat.getHarga(), laporan.getTotalHarga()/laporan.getTotalItem());
  this.penjualanObats.add(laporan);
  this.strukPenjualanObats.add(strukPenjualanObat);


  System.out.printf("ada tambahan lagi? y/n: ");
}
public void pembuatanMemberBaru(){
  System.out.printf("%nSilahkan masukan data ! ");
  System.out.printf("%nnama : ");
  String nama = scan.nextLine();
  System.out.printf("alamat : ");
  String alamat = scan.nextLine();
  System.out.printf("jenisKelamin : ");
  String jenisKelamin = scan.nextLine();
  System.out.printf("nomorTelpon : ");
  String nomorTelpon = scan.nextLine();
  System.out.printf("umur : ");
  String umur = scan.nextLine();

  Membership member = new Membership();
  member.setNama(nama);
  member.setAlamat(alamat);
  member.setJenisKelamin(jenisKelamin);
  member.setNomorTelpon(nomorTelpon);
  member.setUmur(umur);

  this.memberships.add(member);
}


//section manajemen obat
public void updateInformasiObat(){
  showInformasiObat();
  System.out.printf("%nSilahkan pilih id obat yang ingin di edit : ");
  int id = scan.nextInt();
  scan.nextLine(); // solusi sementara agar pengisian nama terbaca
  Obat obat = getObatById(id);
   while (obat == null) {
    System.out.print("obat tidak ada! ingin kembali? (y/n) : ");
    String answer = scan.nextLine();
    if (answer.equalsIgnoreCase("y")){
      return;
    }
    System.out.print("Silahkan ulangi masukan id obat!\n");
    System.out.print("id obat : ");
    id = scan.nextInt();
    scan.nextLine();
    obat = getObatById(id);
  }
  System.out.printf("%nsilahkan masukan data obat terbaru : ");
  System.out.printf("%nnama : ");
  obat.setNamaObat(scan.nextLine());
  System.out.printf("kode : ");
  obat.setKodeObat(scan.nextLine());
  System.out.printf("stok : ");
  obat.setStockObat(scan.nextInt());
  scan.nextLine(); // solusi sementara agar pengisian nama
  System.out.printf("productby : ");
  obat.setProductby(scan.nextLine());
  System.out.printf("expiredYear : ");
  obat.setExpiredYear(scan.nextInt());
  System.out.printf("Harga : ");
  obat.setHarga(scan.nextInt());
  System.out.printf("%nUpdate telah berhasil !%n");

  
}
public void pemesananObat(){
  RestockObat restockObat = new RestockObat();
  System.out.printf("%nsilahkan masukan data laporan : ");
  System.out.printf("%nnama obat : ");
  String namaObat = scan.nextLine();
  System.out.printf("kode obat : ");
  String kodeObat = scan.nextLine();
  System.out.printf("stok : ");
  int stockObat = scan.nextInt();
  scan.nextLine(); // solusi sementara agar pengisian nama
  System.out.printf("Supplier : ");
  String supplier = scan.nextLine();
  System.out.printf("Apakah produksi dilakukan oleh supplier ? y/n :");
  if (scan.nextLine().equals("y")) {
      restockObat.setSupplier(supplier, true);
  }
  System.out.printf("Harga : ");
  int harga = scan.nextInt();
  restockObat.setNamaObat(namaObat);
  restockObat.setHarga(harga);
  restockObat.setKodeObat(kodeObat);
  restockObat.setStockObat(stockObat);
  restockObat.setTotalHarga(restockObat.getHarga()*restockObat.getStockObat());

  Saldo.setPengeluaran(restockObat.getTotalHarga());
  this.obats.add(restockObat.obat);
  this.restockObats.add(restockObat);
  
}
public void showSaldo(){
  System.out.printf("Saldo saat ini %n");
  System.out.print("Pengeluaran : ");
  System.out.println(Saldo.getPengeluaran());
  System.out.print("Pendapatan : ");
  System.out.println(Saldo.getPendapatan());
  System.out.print("Laba : ");
  System.out.println(Saldo.getLaba());
}

//section Laporan
public void showLaporanPenjualan(){
  System.out.println("Laporan Penjualan");
  System.out.printf("%-20s|\t %-20s|\t %-20s|\t %-20s|\t %-20s|\t %-20s|\t %-20s|\t %-20s|\t", "id Laporan", "Kode Obat", "Tanggal Penjualan", "Nama Obat", "Jenis Pembayaran", "Total Item", "Total Harga", "Nama Pembeli");
  for (PenjualanObat penjualanObat : this.penjualanObats) {
      System.out.printf("%n%-20s|\t %-20s|\t %-20s|\t %-20s|\t %-20s|\t %-20d|\t %-20d|\t %-20s|\t", penjualanObat.getId(), penjualanObat.getIdObat(), penjualanObat.getDate(), penjualanObat.getNamaObat(),penjualanObat.getJenisPembayaran(),penjualanObat.getTotalItem(),penjualanObat.getTotalHarga(), penjualanObat.getPembeli());
    }
}
public void showLaporanPemesanan(){
  System.out.println("Laporan Pemesanan");
  System.out.printf("%-20s|\t %-20s|\t %-20s|\t %-20s|\t %-20s|\t %-20s|\t  %-20s|\t %-20s|\t", "id Laporan", "Kode Obat", "Tanggal Restock", "Nama Obat", "Supllier", "stock","Harga", "Total Harga");
  for (RestockObat restockObat : this.restockObats) {
      System.out.printf("%n%-20s|\t %-20s|\t %-20s|\t %-20s|\t %-20s|\t %-20d|\t %-20d|\t %-20d|\t", restockObat.getId(), restockObat.getKodeObat(), restockObat.getDate(), restockObat.getNamaObat(),restockObat.getSupplier(),restockObat.getStockObat(), restockObat.getHarga(),restockObat.getTotalHarga());
    }
}  

// Section informasi obat dan memberships
public void showInformasiObat(){
    System.out.printf("Total jenis obat yang dijual : %d%n", Obat.jumlahObatKeseluruhan);
    System.out.printf("%-4s| %-20s|\t %-20s|\t %-20s|\t %-20s|\t %-20s|\t %-20s|\t %-20s|\t", "id", "Nama Obat", "Kode Obat", "Stok", "Produksi Oleh", "Tahun Expired", "Harga Obat", "Harga Member");
    for (Obat obat : this.obats) {
        System.out.printf("%n%-4d| %-20s|\t %-20s|\t %-20d|\t %-20s|\t %-20d|\t %-20d|\t %-20d|\t", obat.getId(), obat.getNamaObat(), obat.getKodeObat(),obat.getStockObat(),obat.getProductby(),obat.getExpiredYear(), obat.getHarga(), obat.getHargaMember());
      }
}
public void showInformasiMemberships(){
    System.out.printf("Total Member yang terdaftar : %d%n", Membership.jumlahMembershipsKeseluruhan);
    System.out.printf("%-4s| %-20s|\t %-20s|\t %-20s|\t %-20s|\t %-20s|\t", "id", "Nama", "Alamat", "Jenis Kelamin", "Nomor Telepon", "Umur");
    for (Membership member : this.memberships) {
        System.out.printf("%n%-4d| %-20s|\t %-20s|\t %-20s|\t %-20s|\t %-20s|\t", member.getId(), member.getNama(), member.getAlamat(),member.getJenisKelamin(),member.getNomorTelpon(),member.getUmur());
      }
}

private Obat getObatById(int id) {
  for (Obat obat : this.obats) {
    if (obat.getId() == id) {
      return obat;
    }
  }
  return null;
}
private Membership getMemberById(int id) {
  for (Membership member : this.memberships) {
    if (member.getId() == id) {
      return member;
    }
  }
  return null;
}
private Struk getStrukById(String id) {
  for (Struk struk : this.strukPenjualanObats) {
    if (struk.getId().equals(id)) {
      return struk;
    }
  }
  return null;
}

//load data
public void loadData(String x) throws IOException{
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
            this.obats.add(obat);
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
            this.memberships.add(member);
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
                this.restockObats.add(invoice);
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
                this.penjualanObats.add(invoice);
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

//save data
public void saveData(String x) throws IOException {
    //penggunaan ini jika database tidak kosong
    FileWriter getFileWriter = new FileWriter("database/"+x+".txt");
    BufferedWriter tulis = new BufferedWriter(getFileWriter);

    if (x.equals("obat")) {
        for (Obat obat : this.obats) {
            tulis.write(obat.getId() + "," + obat.getNamaObat() + "," + obat.getKodeObat() + "," + obat.getStockObat() + "," + obat.getProductby() + "," + obat.getExpiredYear() + "," + obat.getHarga()+",");
            tulis.newLine();
        }
    } else if (x.equals("member")){
        for (Membership member : this.memberships) {
            tulis.write(member.getId() + "," + member.getNama() + "," + member.getAlamat() + "," + member.getJenisKelamin() + "," + member.getNomorTelpon() + "," + member.getUmur() +",");
            tulis.newLine();
        }
    } else if (x.equals("restockobat")){
        for (RestockObat invoice : this.restockObats){
            tulis.write(invoice.getId() + "," + invoice.getKodeObat() + "," + invoice.getDate() + "," + invoice.getNamaObat() + "," + invoice.getSupplier() + "," + invoice.getStockObat() + "," +  invoice.getHarga() + "," + invoice.getTotalHarga() + ",");
            tulis.newLine();
        }
    } else if (x.equals("penjualanobat")) {
        for(PenjualanObat invoice : this.penjualanObats){
            tulis.write(invoice.getId() + "," + invoice.getIdObat() + "," + invoice.getDate() + "," + invoice.getNamaObat() + "," + invoice.getJenisPembayaran() + "," + invoice.getTotalItem() + "," + invoice.getTotalHarga() + "," + invoice.getPembeli() + ","  );
            tulis.newLine();
        }
    
    } else if (x.equals("saldo")){
        tulis.write(Saldo.getPengeluaran() + "," + Saldo.getPendapatan() + ",");
        tulis.newLine();
    }
    tulis.close();
}

}