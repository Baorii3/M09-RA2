public class Taula {
    private Forquilla[] forquilles;
    private Filosof[] comensals;

    public Taula(int numComensals) {
        this.comensals = new Filosof[numComensals];
        this.forquilles = new Forquilla[numComensals];

        for (int i = 0; i < numComensals; i++) {
            this.forquilles[i] = new Forquilla(i);
        }

        for (int i = 0; i < numComensals; i++) {
            this.comensals[i] = new Filosof("Filosof"+i,i, this.forquilles[i], this.forquilles[(i+1)%numComensals]);
        }
    }

    public void showTaula() {
        for (int i = 0; i < this.comensals.length; i++) {
            System.out.println("Comensal:" + this.comensals[i]);
        }
    }

    public void cridarTaula() {
        for (int i = 0; i < this.comensals.length; i++) {
            this.comensals[i].start();
        }

        for (Filosof filosof : this.comensals) {
            try {
                filosof.join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public static void main(String[] args) {
        Taula taula = new Taula(5);
        taula.showTaula();
        taula.cridarTaula();
    }
}
 
