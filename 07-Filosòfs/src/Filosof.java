public class Filosof extends Thread {
    private Forquilla forquillaDreta;
    private Forquilla ForquillaEsquerra;
    public int gana;

    public Filosof(String nom, Forquilla forquillaDreta, Forquilla forquillaEsquerra) {
        super(nom);
        this.forquillaDreta = forquillaDreta;
        this.ForquillaEsquerra = forquillaEsquerra;
    }

    public boolean menjar() {
        if (!this.ForquillaEsquerra.isEnUs()) {
            this.ForquillaEsquerra.setEnUs(true);
            System.out.println("Filosof:"+this.getName() + " agafa la forquilla esquerra " + this.ForquillaEsquerra.getNum());
            if (!this.forquillaDreta.isEnUs()) {
                this.forquillaDreta.setEnUs(true);
                System.out.println("Filosof:"+this.getName() + " agafa la forquilla dreta " + this.forquillaDreta.getNum());
                System.out.println("Filosof: "+this.getName() + " menja");
                this.gana = 0;
                try {
                    Thread.sleep((long)((Math.random() * 1000) * 2));
                } catch (InterruptedException e) {
                     e.printStackTrace();
                }
                this.forquillaDreta.setEnUs(false);
                this.ForquillaEsquerra.setEnUs(false);
                return true;
            }
            this.ForquillaEsquerra.setEnUs(false);
            System.out.println("Filosof: "+this.getName() + " deixa l'esquerra(" + this.ForquillaEsquerra.getNum() + ") i espera (dreta ocupada)");
        }
        this.gana++;
        System.out.println("Filosof: "+this.getName() + " gana=" + this.gana);
        return false;
        
    }

    public void pensar() {
        System.out.println("Filosof: "+this.getName() + " pensant");
        try {
            Thread.sleep((long)((Math.random() * 1000) + 1000));
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void run() {
        while (true) {
            if (menjar()) {
                pensar();
            } else {
                try {
                    Thread.sleep((long)((Math.random() * 1000) / 2));
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    @Override
    public String toString() {
        return this.getName() + " esq"+this.ForquillaEsquerra.getNum() + " dreta"+this.forquillaDreta.getNum();
    }

}
