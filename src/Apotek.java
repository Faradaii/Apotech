import java.util.ArrayList;

public class Apotek{


public ArrayList<Obat> obats = new ArrayList<Obat>();
public ArrayList<Membership> memberships = new ArrayList<Membership>();
public ArrayList<PenjualanObat> penjualanObats = new ArrayList<PenjualanObat>();
public ArrayList<RestockObat> restockObats = new ArrayList<RestockObat>();

// Section informasi obat dan memberships
public void showInformasiObat(){
    System.out.printf("Total jenis obat yang dijual :%d%n", Obat.jumlahObatKeseluruhan);
    System.out.printf("%-4s| %-20s|\t %-20s|\t %-20s|\t %-20s|\t %-20s|\t", "id", "Nama Obat", "Kode Obat", "Untuk Penyakit", "Produksi Oleh", "Tahun Expired");
    for (Obat obat : this.obats) {
        System.out.printf("%n%-4d| %-20s|\t %-20s|\t %-20s|\t %-20s|\t %-20d|\t", obat.getId(), obat.getNamaObat(), obat.getKodeObat(),obat.getUntukPenyakit(),obat.getProductby(),obat.getExpiredYear());
      }
}

public void showInformasiMemberships(){
    System.out.printf("Total Member yang terdaftar :%d%n", Membership.jumlahMembershipsKeseluruhan);
    System.out.printf("%-4s| %-20s|\t %-20s|\t %-20s|\t %-20s|\t %-20s|\t", "id", "Nama", "Alamat", "Jenis Kelamin", "Nomor Telepon", "Umur");
    for (Membership member : this.memberships) {
        System.out.printf("%n%-4d| %-20s|\t %-20s|\t %-20s|\t %-20s|\t %-20d|\t", member.getId(), member.getNama(), member.getAlamat(),member.getJenisKelamin(),member.getNomorTelpon(),member.getUmur());
      }
}



}