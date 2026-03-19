public class Barber extends Thread {

    public Barber(String nom) {
        super(nom);
    }

    @Override
    public void run() {
        while (true) {
            Barberia barberia = Barberia.barberia;
            Client clientSeguent;
            synchronized (barberia.condBarber) {
                clientSeguent = barberia.seguentClient();
                while (clientSeguent == null) {
                    System.out.println("Ningú en espera");
                    System.out.println("Barber " + this.getName() + " dormint");
                    try {
                        barberia.condBarber.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    clientSeguent = barberia.seguentClient();

                }
                System.out.println("Li toca al client " + clientSeguent.getNom());
                clientSeguent.tallarseElcabell(null);  
            }
            try {
                sleep(900 + (long)(Math.random() * 100));
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}