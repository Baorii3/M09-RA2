public class Compte {

    public int saldo;    
    public static Compte instancia = new Compte();
    
    private Compte() {
    }

    public static Compte getInstance() {
        if (instancia == null) {
            return instancia = new Compte();
        } 
        return instancia;
    }

    public int getSaldo() {
        return saldo;
    }
    public void setSaldo(int saldo) {
        this.saldo = saldo;
    }

    public synchronized void ingressar(float quantitat) {
        saldo += quantitat;
    }

    public synchronized void treure(float quantitat) {
        saldo -= quantitat;
    }
}
