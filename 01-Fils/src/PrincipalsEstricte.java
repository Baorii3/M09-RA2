public class PrincipalsEstricte {
    public static void main(String[] args) {
        Fil filPepe = new Fil("Pepe", true);
        Fil filJuan = new Fil("Juan", true);

        Thread threadPepe = new Thread(filPepe);
        Thread threadJuan = new Thread(filJuan);

        threadPepe.start();
        threadJuan.start();
        
        System.out.println("Acaba el main");
    }
}
