import java.time.LocalDate;

abstract class Laporan{

    public static int idLaporan;
    public String id;
    public int idObat;
    public LocalDate date;
    public String namaObat;
    public int totalItem;
    public int totalHarga;
    
    public LocalDate generateDate(){
        LocalDate today = LocalDate.now();
        return today;
    }
}