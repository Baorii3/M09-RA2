public class Filosof extends Thread {
    private int numComersal;
    private Forquilla forquillaDreta;
    private Forquilla forquillaEsquerra;
    public int gana;
    public long iniciGana;
    public long fiGana;

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
        calcularGana();
        System.out.println(this.getName() + " menja amb gana: " + this.gana);
        try {
            Thread.sleep((long)((Math.random() * 1000) * 2));
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        this.deixarForquilles();
        iniciGana = System.currentTimeMillis();
        return true;
    }

    public void pensar() {
        System.out.println(this.getName() + " pensant");
        try {
            Thread.sleep((long)((Math.random() * 1000) + 1000));
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void run() {
        iniciGana = System.currentTimeMillis();
        while (true) {
            if (menjar()) {
                pensar();
            }
        
        }
    }

    public boolean agafarForquilles() {
        forquillaEsquerra.intentarAgarrar(this.numComersal);
            if (this.forquillaDreta.intentarAgarrar(this.numComersal)) {
            } else {
                deixarForquilles();
                try {
                    Thread.sleep((long)((Math.random() * 500) + 500));
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                return false;
            }
            System.out.println(this.getName()+" té forquilles esq(" + this.forquillaEsquerra.getNum() + ") i dreta(" + this.forquillaDreta.getNum() + ")");
        return true;
    }

    public void agafarForquillaDreta() {
        if (!forquillaDreta.intentarAgarrar(this.numComersal)) {
            deixarForquilles();
            return;
        }       
    }

    public void agafarForquillaEsquerra() {
        if (!forquillaEsquerra.intentarAgarrar(this.numComersal)) {
            return;
        }
    }

    public void deixarForquilles() {
        if (this.forquillaDreta.getPropietari() == this.numComersal) {
            this.forquillaDreta.deixar();
        }
        if (this.forquillaEsquerra.getPropietari() == this.numComersal) {
            this.forquillaEsquerra.deixar();
        }
        System.out.println(this.getName()+" deixa les forquilles");
    }

    @Override
    public String toString() {
        return this.getName() + " esq"+this.forquillaEsquerra.getNum() + " dreta"+this.forquillaDreta.getNum();
    }

    public void calcularGana() {
        fiGana = System.currentTimeMillis();
        this.gana = (int) (fiGana - iniciGana) / 1000;
    }
}
