public class Administracio {
    private int num_poblacio;
    private Treballador[] poblacio_activa;

    public Administracio() {
        this.num_poblacio = 50;
        this.poblacio_activa = new Treballador[num_poblacio];
        for (int i = 0; i < num_poblacio; i++) {
            poblacio_activa[i] = new Treballador("Ciutada" + (i + 1));
        }
    }

    public static void main(String[] args) {
        Administracio admin = new Administracio();
        for (int i = 0; i < admin.num_poblacio; i++) {
            admin.poblacio_activa[i].start();
        }
        for (int i = 0; i < admin.num_poblacio; i++) {
            try {
                admin.poblacio_activa[i].join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        
        for (int i = 0; i < admin.num_poblacio; i++) {
            int edat = 0;
            float total_cobrat = 0;
            total_cobrat = admin.poblacio_activa[i].getCobrat();
            edat = admin.poblacio_activa[i].getEdat();
            System.out.printf("%s -> edat: %d / total: %.2f%n", admin.poblacio_activa[i].getName(), edat, total_cobrat);
        }
    }
}
