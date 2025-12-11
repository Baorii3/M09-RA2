public class PrincipalsIguals {
    public static void main(String[] args) {
        Fil filPepe = new Fil("Pepe");
        Fil filJuan = new Fil("Juan");

        Thread threadPepe = new Thread(filPepe);
        threadPepe.setPriority(Thread.MIN_PRIORITY);
        Thread threadJuan = new Thread(filJuan);
        threadJuan.setPriority(Thread.MIN_PRIORITY);

        threadPepe.start();
        threadJuan.start();
        
        System.out.println("Acaba el main");
    }
}