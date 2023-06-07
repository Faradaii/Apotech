class Saldo {
    private static int kasBersih = 0; //todo getting from txt
    private static int laba = 0;
    public static void setKasBersih(int kasBersih){
        Saldo.kasBersih += kasBersih;
    }
    public static int getKasBersih(){
        return kasBersih;
    }
    public static void setLaba(int laba){
        Saldo.laba += laba;
        setKasBersih(laba);
    }
    public static int getLaba(){
        return laba;
    }
}
