class Saldo {
    private static int pendapatan = 0; //todo getting from txt
    private static int pengeluaran = 0;

    public static void setPengeluaran(int pengeluaran){
        Saldo.pengeluaran += pengeluaran;
    }
    public static Integer getPengeluaran(){
        return Saldo.pengeluaran;
    }
    public static void setPendapatan(int pendapatan){
        Saldo.pendapatan += pendapatan;
    }
    public static int getPendapatan(){
        return pendapatan;
    }
    // public static void setLaba(int laba){
    //     Saldo.laba += laba;
    //     setpendapatan(laba);
    // }
    public static int getLaba(){
        if (Saldo.pendapatan - Saldo.pengeluaran > 0) {
            return getPendapatan() - getPengeluaran();
        }
        return 0;
    }
}
