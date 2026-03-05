import java.util.concurrent.locks.ReentrantLock;

public class Forquilla {
    private int num;
    private int propietari;
    private boolean enUs;
    private final ReentrantLock bloqueig = new ReentrantLock(true);
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

    public boolean intentarAgarrar(int numFilosof) {
        boolean agafar = false;
        bloqueig.lock();
        try {
            if (!enUs) {
                enUs = true;
                propietari = numFilosof;
                agafar = true;
            }
        } finally {
            bloqueig.unlock();
        }        
        return agafar;
    }
    
    public void deixar() {
        bloqueig.lock();
        try {
            enUs = false;
            propietari = LLIURE;
        } finally {
            bloqueig.unlock();
        }
    }
}
