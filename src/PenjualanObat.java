import java.time.LocalDate;
public class PenjualanObat extends Laporan {

    private static int jumlahLaporan = 0;
    private String pembeli;
    private String jenisPembayaran;

    public PenjualanObat(){
        idLaporan++;
        jumlahLaporan++;
        this.setId();
        this.setDate();
    }
    public PenjualanObat(String id){
        this.setId(id);
        this.setDate();
    }

    public int showJumlah(){
        return jumlahLaporan;
    }
    public int showJumlahKeseluruhan(){
        return super.showJumlah();
    }

    public String getId() {
        return id;
    }
    public void setId() {
        this.id = "A0"+ idLaporan;
    }
    public void setId(String id){
        this.id = id;
    }
    public int getIdObat() {
        return idObat;
    } 
    public void setIdObat(int idObat){
        this.idObat = idObat;
    }
    public String getPembeli(){
        return pembeli;
    }
    public void setPembeli(String pembeli){
        this.pembeli = pembeli;
    }
    public String getNamaObat(){
        return namaObat;
    }
    public void setNamaObat(String namaObat){
        this.namaObat = namaObat;
    }
    public String getJenisPembayaran(){
        return jenisPembayaran;
    }
    public void setJenisPembayaran(String jenisPembayaran){
        this.jenisPembayaran = jenisPembayaran;
    }
    public int getTotalItem(){
        return totalItem;
    }
    public void setTotalItem(int totalItem){
        this.totalItem = totalItem;
    }
    public int getTotalHarga(){
        return totalHarga;
    }
    public void setTotalHarga(int totalHarga){
        this.totalHarga = totalHarga;
    }
    public LocalDate getDate(){
        return this.date;
    }
    public void setDate(){
        this.date = super.generateDate();
    }
    public void setDate(LocalDate date){
        this.date = date;
    }
    

    
}
