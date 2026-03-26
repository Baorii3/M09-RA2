public class Home extends Thread {
    private String nom;
    private BanyUnisex lavabo;

    public Home(String nom, BanyUnisex lavabo) {
        this.nom = nom;
        this.lavabo = lavabo;
    }

    @Override
    public void run() {
        while (true) {
            System.out.println(nom + " vol entrar al bany");
            entraHome();
            utilitzaLavabo();
            surtHome();
            System.out.println(nom + " ha acabat d'usar el bany");
        }
    }

    public void entraHome() {
        lavabo.entraHome();
    }

    public void utilitzaLavabo() {
        try {
            sleep( (long) Math.random() * 1000 + 1000);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }

    public void surtHome() {
        lavabo.surtHome();
    }


}