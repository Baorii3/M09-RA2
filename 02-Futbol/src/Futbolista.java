public class Futbolista extends Thread{
    private static final int NUM_JUGADORS = 11;
    private static final int NUM_TIRADES = 20;
    private static final float PROBABILITAT = 0.5f;

    private String nom;
    private int ngols;
    private int ntirades;

    public Futbolista() {
        this(null);
    }
    
    public Futbolista(String nom) {
        this.nom = nom;
        this.ngols = 0;
        this.ntirades = 0;
    }

    public int getNgols() {
        return ngols;
    }

    public int getNtirades() {
        return ntirades;
    }

    public String getNom() {
        return nom;
    }

    @Override
    public void run() {
        for (int i = 0; i < NUM_TIRADES; i++) {
            float prob = (float) Math.random();
            if (prob < PROBABILITAT) {
                ngols++;
            }
            ntirades++;
        }

    }

    public static void main(String[] args) throws InterruptedException {
        String[] noms = {"Pique", "Vinicius", "Torres", "Ramos", "Ronaldo", "Lewan", "Belli", "Arnau", "Aspas", "Messi", "Mbapé", "No deberia salir"};
        Futbolista[] futbolistes = new Futbolista[NUM_JUGADORS];

        System.out.println("Inici dels xuts---------");
        for (int i = 0; i < NUM_JUGADORS; i++) {
            futbolistes[i] = new Futbolista(noms[i]);
            futbolistes[i].start();
        }
        System.out.println("Fi dels xuts------------");
        

        for (Futbolista fb : futbolistes) {
            fb.join();
        }
        System.out.println("---Estadistiques----");
        for (Futbolista fb : futbolistes) {
            System.out.printf("%-9s -> %d gols%n", fb.getNom(), fb.getNgols());
        } 
    }
}
