import java.util.Random;

public class Soci extends Thread{
    private Compte compte;
    private float aportacio;
    private int esperaMax;
    private int maxAnys;
    private Random random = new Random();
    
    public Soci() {
        this.compte = Compte.getInstance();
        this.aportacio = 10f;
        this.esperaMax = 100;
        this.maxAnys = 10;
    }

    public Compte getCompte() {
        return compte;
    }

    @Override
    public void run() {
        for (int a = 0; a < random.nextInt(maxAnys); a++) {
            for (int i = 0; i < 12; i++) {
                if (i % 2 == 0) {
                    compte.ingressar(aportacio);
                } else {
                    compte.treure(aportacio);
                }
                try {
                    Thread.sleep(random.nextInt(esperaMax));
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
