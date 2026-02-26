public class Forquilla {
    private int num;
    private int propietari;
    private boolean enUs;
    private final int LLIURE = -1;

    public Forquilla(int num) {
        this.num = num;
        this.enUs = false;
        this.propietari = LLIURE;
    }

    public int getNum() {
        return num;
    }

    public void setNum(int num) {
        this.num = num;
    }

    public boolean isEnUs() {
        return enUs;
    }

    public void setEnUs(boolean enUs) {
        this.enUs = enUs;
    }

    public int getPropietari() {
        return propietari;
    }

    public void setPropietari(int propietari) {
        this.propietari = propietari;
    }

    public synchronized void intentarAgarrar(int numFilosof) {
        while (enUs) {
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            } 
        }
        enUs = true;
        propietari = numFilosof;
    }
    public synchronized void deixar() {
        enUs = false;
        propietari = LLIURE;
        notifyAll();
    }
}
