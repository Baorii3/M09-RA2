import java.util.Random;

public class Treballador extends Thread {

    private final float sou_anual_brut;
    private final int edat_inici_treball;
    private final int edat_fi_treball;
    private int edat_actual;
    private float cobrat;

    private Random rnd = new Random();
    
    public Treballador (String nom) {
        super(nom);
        this.sou_anual_brut = 25000;
        this.edat_inici_treball = 20;
        this.edat_fi_treball = 65;
        this.edat_actual = 0;
        this.cobrat = 0;    
    }

    public float getCobrat() {
        return cobrat;
    }

    public int getEdat() {
        return edat_actual;
    }

    public void cobra() {
        cobrat += sou_anual_brut / 12;
    }

    public void pagaImpostos() {
        float impostos = sou_anual_brut / 12 * 0.24f;
        cobrat -= impostos;
    }

    public void run() {
        for (edat_actual = edat_inici_treball; edat_actual < edat_fi_treball; edat_actual++) {
            for (int mes = 1; mes <= 12; mes++) {
                cobra();
                try {
                    Thread.sleep(rnd.nextInt(10));
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                pagaImpostos();
            }
        }
    }

}