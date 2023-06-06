import java.time.LocalDate;
public class PenjualanObat extends Laporan {

    public static int idLaporan;

    public PenjualanObat(){
        idLaporan++;
        this.setId();
        this.setDate();
    }

    private String id;
    private int idObat;
    private LocalDate date;
    private String pembeli;
    private String namaObat;
    private String jenisPembayaran;
    private int totalItem;
    private int totalHarga;

    public String getId() {
        return id;
    }
    public void setId() {
        this.id = "A0"+ idLaporan;
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
        this.date = generateDate();
    }
    

    public LocalDate generateDate(){
        LocalDate today = LocalDate.now();
        return today;
    }
}
