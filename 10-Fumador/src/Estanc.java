import java.util.ArrayList;
import java.util.List;

public class Estanc extends Thread {

    private List<Tabac> tabac;
    private List<Paper> paper;
    private List<Llumi> llumi;
    private boolean obert;

    public Estanc() {
        tabac = new ArrayList<>();
        paper = new ArrayList<>();
        llumi = new ArrayList<>();
        obert = true;
    }

    private void nouSubministrament() {
        double num = Math.random();
        if (num < 0.33) {
            addTabac();
        } else if (num < 0.66) {
            addPaper();
        } else {
            addLlumi();
        }
    }

    private synchronized void addTabac() {
        System.out.println("Afegint tabac");
        tabac.add(new Tabac());
        notifyAll();
    }

    private synchronized void addPaper() {
        System.out.println("Afegint paper");
        paper.add(new Paper());
        notifyAll();
    }

    private synchronized void addLlumi() {
        System.out.println("Afegint llumi");
        llumi.add(new Llumi());
        notifyAll();
    }

    public Tabac venTabac() {
        synchronized (this) {
            while (tabac.isEmpty()) {
                try {
                    wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            return tabac.remove(0);
        }
    }

    public Paper venPaper() {
        synchronized (this) {
            while (paper.isEmpty()) {
                try {
                    wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            return paper.remove(0);
        }
    }

    public Llumi venLlumi() {
        synchronized (this) {
            while (llumi.isEmpty()) {
                try {
                    wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            return llumi.remove(0);
        }
    }

    public void tancarEstanc() {
        obert = false;
    }

    @Override
    public void run() {
        System.out.println("Estanc obert");
        while (obert) {
            nouSubministrament();
            try {
                Thread.sleep((long) (Math.random() * 1000 + 500));
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        System.out.println("Estanc tancat");
    }
}