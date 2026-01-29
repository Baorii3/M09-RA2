import java.util.Random;

public class Asistent extends Thread {
    private Esdeveniment esdeveniment;
    private Random random = new Random();

    public Asistent(String name, Esdeveniment e) {
        super(name);
        this.esdeveniment = e;
    }

    @Override
    public void run(){
        while(true) {
            if (random.nextDouble() < 0.3) {
                try {
                    esdeveniment.ferRreserva(this);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            } else {
                esdeveniment.cancelaReserva(this);
            }
            try {
                Thread.sleep(random.nextInt(1000));
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
