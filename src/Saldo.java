class Saldo{
    private static int pendapatan = 0; 
    private static int pengeluaran = 0;

    public static void tambahPengeluaran(int pengeluaran){
        Saldo.pengeluaran += pengeluaran;
    }
    public static Integer getPengeluaran(){
        return Saldo.pengeluaran;
    }
    public static void tambahPendapatan(int pendapatan){
        Saldo.pendapatan += pendapatan;
    }
    public static int getPendapatan(){
        return pendapatan;
    }
    public static int getLaba(){
        if (Saldo.pendapatan - Saldo.pengeluaran > 0) {
            return getPendapatan() - getPengeluaran();
        }
        return 0;
    }
}
