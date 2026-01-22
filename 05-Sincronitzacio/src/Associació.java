public class Associació {

    private int numSocis = 1000;
    private Soci[] socis;

    public Associació() {
        socis = new Soci[numSocis];
        for (int i = 0; i < numSocis; i++) {
            socis[i] = new Soci();
        }
    }

    public static void main(String[] args) {
        Associació associacio = new Associació();
        associacio.iniciaCompteTempsSocis();
        associacio.esperaPeriodeSocis();
        associacio.mostraBalanComptes();
    }

    public void iniciaCompteTempsSocis() {
        for (int i = 0; i < numSocis; i++) {
            socis[i].start();
        }
    }

    public void esperaPeriodeSocis() {
        for (int i = 0; i < numSocis; i++) {
            try {
                socis[i].join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public void mostraBalanComptes() {
        System.out.println("Saldo final " + Compte.getInstance().getSaldo());
    }
}