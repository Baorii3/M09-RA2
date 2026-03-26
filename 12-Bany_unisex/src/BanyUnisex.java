import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Semaphore;
import java.util.concurrent.locks.ReentrantLock;

public class BanyUnisex {
    enum BanyEstat { BANY_BUIT, BANY_AMB_DONES, BANY_AMB_HOMES }
    private BanyEstat estatActual;
    private int ocupants;
    private static final int CAPACITAT_MAX = 3;

    private Semaphore capacitat;
    private ReentrantLock lockEstat;

    public BanyUnisex() {
        this.estatActual = BanyEstat.BANY_BUIT;
        this.ocupants = 0;
        this.capacitat = new Semaphore(CAPACITAT_MAX, true);
        this.lockEstat = new ReentrantLock();
    }

    public void entraHome() {
        while (true) {
            try {
                capacitat.acquire();
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
                return;
            }

            lockEstat.lock();
            try {
                if (estatActual == BanyEstat.BANY_BUIT || estatActual == BanyEstat.BANY_AMB_HOMES) {
                    if (ocupants == 0) {
                        estatActual = BanyEstat.BANY_AMB_HOMES;
                    }
                    ocupants++;
                    System.out.println("Home entra al bany. Ocupants: " + ocupants);
                    return;
                }
            } finally {
                lockEstat.unlock();
            }

            capacitat.release();
        }
    }
    public void entraDona() {
        while (true) {
            try {
                capacitat.acquire();
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
                return;
            }
            
            lockEstat.lock();
            try {
                if (estatActual == BanyEstat.BANY_BUIT || estatActual == BanyEstat.BANY_AMB_DONES) {
                    if (ocupants == 0) {
                        estatActual = BanyEstat.BANY_AMB_DONES;
                    }
                    ocupants++;
                    System.out.println("Dona entra en el bany. Ocupants: " + ocupants);
                    return;
                }
            } finally {
                lockEstat.unlock();
            }

            capacitat.release();
        }
    }

    public void surtHome() {
        try {
            lockEstat.lock();
            ocupants--;
            System.out.println("Home surt del bany. Ocupants: " + ocupants);
            if (ocupants == 0) {
                estatActual = BanyEstat.BANY_BUIT;
                System.out.println("El bany està buit");
            }
            capacitat.release();
        } catch (Exception e) {
            Thread.currentThread().interrupt();
        } finally {
            lockEstat.unlock();
        }
    }
    
    public void surtDona() {
        try {
            lockEstat.lock();
            ocupants--;
            System.out.println("Dona surt del bany. Ocupants: " + ocupants);
            if (ocupants == 0) {
                estatActual = BanyEstat.BANY_BUIT;
                System.out.println("El bany està buit");
            }
            capacitat.release();
        } catch (Exception e) {
            Thread.currentThread().interrupt();
        } finally {
            lockEstat.unlock();
        }
    }


    public static void main(String[] args) {
        BanyUnisex bany = new BanyUnisex();
        List<Home> homes = new ArrayList<>();
        List<Dona> dones = new ArrayList<>();

        for (int i = 0; i < 5; i++) {
            homes.add(new Home("Home " + i, bany));
            homes.get(i).start();
            dones.add(new Dona("Dona " + i, bany));
            dones.get(i).start();
        }
        
        for (int i = 0; i < homes.size(); i++) {
            try {
                homes.get(i).join();
                dones.get(i).join();
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        }



    }
}
