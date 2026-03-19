import java.util.Queue;
import java.util.LinkedList;

public class Barberia extends Thread {
    private Queue<Client> salaEspera;
    private int maxSillas;
    public Object condBarber;
    public static Barberia barberia;

    public Barberia(int maxSillas) {
        this.maxSillas = maxSillas;
        this.salaEspera = new LinkedList<>();
        this.condBarber = new Object();
    }

    public Client seguentClient() {
        return this.salaEspera.poll();
    }

    public void entrarClient(Client client) {
        synchronized (this.condBarber) {
            if (salaEspera.size() < maxSillas) {
                System.out.println("El client " + client.getNom() + " en espera.");
                this.salaEspera.add(client);
                this.condBarber.notifyAll();
            } else {
                System.out.println("No queden cadires, client " + client.getNom() + " se'n va.");
            }
        }
    }


    @Override
    public void run() {
        for (int i = 0; i < 10; i++) {
            entrarClient(new Client(i));
            try {
                sleep(500);
            } catch (InterruptedException e) {
                e.printStackTrace();

            }
        }

        try {
            sleep(10000);
        } catch (InterruptedException e) {
            e.printStackTrace();

        }

        for (int i = 0; i < 10; i++) {
            entrarClient(new Client(i));
            try {
                sleep(500);
            } catch (InterruptedException e) {
                e.printStackTrace();

            }
        }
    }

    public static void main(String[] args) {
        Barberia barberia = new Barberia(3);
        Barberia.barberia = barberia;
        Barber barber1 = new Barber("ian");
        barber1.start();
        barberia.start();
        try {
            barber1.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        try {
         barberia.join();   
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
