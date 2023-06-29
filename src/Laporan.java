import java.time.LocalDate;

abstract class Laporan{

    protected static int idLaporan;
    protected String id;
    protected int idObat;
    protected LocalDate date;
    protected String namaObat;
    protected int totalItem;
    protected int totalHarga;

    public LocalDate generateDate(){
        LocalDate today = LocalDate.now();
        return today;
    }

    public int showJumlah(){
        return idLaporan;
    }
}