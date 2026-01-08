public class Motor extends Thread {

    private int pObjectiu = 0;
    private int pActual = 0;
    private boolean activo = true;
    private boolean cambio = false;

    public Motor(String name) {
        setName(name);
    }

    public void setPotencia(int pObjectiu) {
        this.pObjectiu = pObjectiu;
        if (pObjectiu == 0) {
            activo = false;
        }
        cambio = true;
    }

    @Override
    public void run() {
        while (activo || pActual > 0) {
            if (!cambio) {
                try {
                    Thread.sleep(500);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                continue;
            }
            if (pActual < pObjectiu) {
                pActual++;
                System.out.printf("Motor %s: incre. Objectiu: %d Actual: %d%n", getName(), pObjectiu, pActual);
            } else if (pActual > pObjectiu) {
                pActual--;
                System.out.printf("Motor %s: decre. Objectiu: %d Actual: %d%n", getName(), pObjectiu, pActual);
            } else {
                cambio = false;
                System.out.printf("Motor %s: ferRes. Objectiu: %d Actual: %d%n", getName(), pObjectiu, pActual);
            }
            

            try {
                Thread.sleep((long) (Math.random() +1) * 1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    
}
