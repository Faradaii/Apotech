import java.util.ArrayList;
import java.util.Scanner;

public class Apotek extends Saldo{

Scanner scan = new Scanner(System.in);


public ArrayList<Obat> obats = new ArrayList<Obat>();
public ArrayList<Membership> memberships = new ArrayList<Membership>();
public ArrayList<PenjualanObat> penjualanObats = new ArrayList<PenjualanObat>();
public ArrayList<RestockObat> restockObats = new ArrayList<RestockObat>();

//section kasir 
public void pembelianObat(){
  showInformasiObat();
  PenjualanObat laporan = new PenjualanObat();
  System.out.printf("%nSilahkan pilih id obat yang ingin di beli : ");
  int idObat = scan.nextInt();
  laporan.setIdObat(idObat);
  scan.nextLine(); // solusi sementara agar pengisian nama terbaca
  Obat obat = getObatById(idObat);
  laporan.setNamaObat(obat.getNamaObat());

  System.out.printf("Silahkan masukan jenis pembayaran : ");
  laporan.setJenisPembayaran(scan.nextLine());
  System.out.printf("Silahkan masukan total item : ");
  laporan.setTotalItem(scan.nextInt());
  obat.setStockObat(obat.getStockObat()-laporan.getTotalItem()); // pengurangan stok obat
  scan.nextLine(); // solusi sementara agar pengisian nama terbaca

  laporan.setTotalHarga(laporan.getTotalItem()*obat.getHarga());
  Saldo.setLaba(laporan.getTotalHarga() - (laporan.getTotalHarga()*10/12));


  System.out.printf("Apakah anda memiliki memberships ? (y/n) : ");
  String answer = scan.nextLine();

  laporan.setPembeli("anonymous");
  if(answer.equalsIgnoreCase("y")){
    System.out.printf("Silahkan masukan id member : ");
    int idMember = scan.nextInt();
    Membership member = getMemberById(idMember);
    laporan.setPembeli(member.getNama());
    laporan.setTotalHarga(laporan.getTotalItem()*(obat.getHarga()*10/12));
    Saldo.setLaba(laporan.getTotalHarga());


  } 

  this.penjualanObats.add(laporan);

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
  System.out.println(obat.getNamaObat());
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
  System.out.printf("Harga : ");
  int harga = scan.nextInt();
  restockObat.setNamaObat(namaObat);
  restockObat.setHarga(harga);
  restockObat.setKodeObat(kodeObat);
  restockObat.setStockObat(stockObat);
  restockObat.setSupplier(supplier);
  restockObat.setTotalHarga(restockObat.getHarga()*restockObat.getStockObat());

  Saldo.setKasBersih(-1*restockObat.getTotalHarga());
  this.obats.add(restockObat.obat);
  this.restockObats.add(restockObat);
  
}
public void showSaldo(){
  System.out.printf("Saldo saat ini %n");
  System.out.println("Kas bersih : ");
  System.out.println(Saldo.getKasBersih());
  System.out.println("Laba : ");
  System.out.println(Saldo.getLaba());
}

//section Laporan
public void showLaporanPenjualan(){
  System.out.println("Laporan Penjualan");
  System.out.printf("%-20s|\t %-20s|\t %-20s|\t %-20s|\t %-20s|\t %-20s|\t %-20s|\t", "id Laporan", "Kode Obat", "Tanggal Penjualan", "Nama Obat", "Jenis Pembayaran", "Total Item", "Total Harga");
  for (PenjualanObat penjualanObat : this.penjualanObats) {
      System.out.printf("%n%-20s|\t %-20s|\t %-20s|\t %-20s|\t %-20s|\t %-20d|\t %-20d|\t", penjualanObat.getId(), penjualanObat.getIdObat(), penjualanObat.getDate(), penjualanObat.getNamaObat(),penjualanObat.getJenisPembayaran(),penjualanObat.getTotalItem(),penjualanObat.getTotalHarga());
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
    System.out.printf("Total jenis obat yang dijual :%d%n", Obat.jumlahObatKeseluruhan);
    System.out.printf("%-4s| %-20s|\t %-20s|\t %-20s|\t %-20s|\t %-20s|\t %-20s|\t", "id", "Nama Obat", "Kode Obat", "Stok", "Produksi Oleh", "Tahun Expired", "Harga Obat");
    for (Obat obat : this.obats) {
        System.out.printf("%n%-4d| %-20s|\t %-20s|\t %-20d|\t %-20s|\t %-20d|\t %-20d|\t", obat.getId(), obat.getNamaObat(), obat.getKodeObat(),obat.getStockObat(),obat.getProductby(),obat.getExpiredYear(), obat.getHarga());
      }
}

public void showInformasiMemberships(){
    System.out.printf("Total Member yang terdaftar :%d%n", Membership.jumlahMembershipsKeseluruhan);
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


}