public class Dona extends Thread {
    private String nom;
    private BanyUnisex lavabo;

    public Dona(String nom, BanyUnisex lavabo) {
        this.nom = nom;
        this.lavabo = lavabo;
    }

    @Override
    public void run() {
        while (true) {
            System.out.println(nom + " vol entrar al bany");
            entraDona();
            utilitzaLavabo();
            surtDona();
            System.out.println(nom + " ha acabat d'usar el bany");
        }
    }

    public void entraDona() {
        lavabo.entraDona();
    }

    public void utilitzaLavabo() {
        try {
            sleep( (long) Math.random() * 1000 + 1000);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }

    public void surtDona() {
        lavabo.surtDona();
    }


}