public class Filosof extends Thread {
    private int numComersal;
    private Forquilla forquillaDreta;
    private Forquilla forquillaEsquerra;
    public int gana;

    public Filosof(String nom, int numComersal, Forquilla forquillaDreta, Forquilla forquillaEsquerra) {
        super(nom);
        this.numComersal = numComersal;
        this.forquillaDreta = forquillaDreta;
        this.forquillaEsquerra = forquillaEsquerra;
        this.gana = 0;
    }

    public boolean menjar() {
        if (!this.agafarForquilles()) {
            return false;
        }
        System.out.println("Filosof: "+this.getName() + " menja");
        this.gana = 0;
        try {
            Thread.sleep((long)((Math.random() * 1000) * 2));
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        this.deixarForquilles();
        return true;
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
            }
        
        }
    }

    public boolean agafarForquilles() {
        forquillaEsquerra.intentarAgarrar(this.numComersal);
        System.out.println("Filosof "+this.getName()+" agafa esquerra "+forquillaEsquerra.getNum());
    
        synchronized(forquillaDreta) {
            if (!this.forquillaDreta.isEnUs()) {
                forquillaDreta.setEnUs(true);
                forquillaDreta.setPropietari(this.numComersal);
                System.out.println("Filosof "+this.getName()+" agafa dreta "+forquillaDreta.getNum());
            } else {
                System.out.println("Filosof "+this.getName()+" no pot agafar dreta "+forquillaDreta.getNum());
                aumentarGana();
                deixarForquilles();
                try {
                    Thread.sleep((long)((Math.random() * 500) + 500));
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                return false;
            }
        }
        return true;
    }

    public void agafarForquillaDreta() {
        if (this.forquillaDreta.isEnUs()) {
            aumentarGana();
            deixarForquilles();
            return;
        }
        forquillaDreta.intentarAgarrar(this.numComersal);
        System.out.println("Filosof "+this.getName()+" agafa forquilla dreta");
    }

    public void agafarForquillaEsquerra() {
        if (this.forquillaEsquerra.isEnUs()) {
            aumentarGana();
            return;
        }
        forquillaEsquerra.intentarAgarrar(this.numComersal);
        System.out.println("Filosof "+this.getName()+" agafa forquilla esquerra");
    }

    public void deixarForquilles() {
        if (this.forquillaDreta.getPropietari() == this.numComersal) {
            this.forquillaDreta.deixar();
        }
        if (this.forquillaEsquerra.getPropietari() == this.numComersal) {
            this.forquillaEsquerra.deixar();
        }
    }

    public void aumentarGana() {
        this.gana++;
        System.out.println("Filosof "+this.getName()+" gana="+this.gana);
    }

    @Override
    public String toString() {
        return this.getName() + " esq"+this.forquillaEsquerra.getNum() + " dreta"+this.forquillaDreta.getNum();
    }

}
