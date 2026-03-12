public class Fumador extends Thread {
    private Estanc estanc;
    private Long id;
    private Tabac tabac;
    private Llumi llumi;
    private Paper paper;
    private int numFumades;


    public Fumador(Estanc estanc, Long id) {
        this.estanc = estanc;
        this.id = id;
        this.numFumades = 0;
    }

    public void fuma() {
        if (tabac != null && paper != null && llumi != null) {
            System.out.println("Fumador " + id + " fumant");
            numFumades++;
            System.out.println("Fumador " + id + " ha fumat " + numFumades + " vegades");
            tabac = null;
            paper = null;
            llumi = null;
        }
    }

    public void comprar() {
        comprarTabac();
        comprarPaper();
        comprarLlumi();
    }

    public void comprarTabac() {
        if (tabac == null) {
            System.out.println("Fumador " + id + " comprant tabac");
            tabac = estanc.venTabac();
        }
    }

    public void comprarPaper() {
        if (paper == null) {
            System.out.println("Fumador " + id + " comprant paper");
            paper = estanc.venPaper();
        }
    }

    public void comprarLlumi() {
        if (llumi == null) {
            System.out.println("Fumador " + id + " comprant llumi");
            llumi = estanc.venLlumi();
        }
    }

    @Override
    public void run() {
        while (numFumades < 3) {
            comprar();
            fuma();
        }
    }
}
