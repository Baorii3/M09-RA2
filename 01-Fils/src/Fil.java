public class Fil implements Runnable  {
    String text = "";
    Boolean estricto = false;

    public Fil(String text) {
        this(text, false);
    }
    public Fil(String text, Boolean estricto) {
        this.text = text;
        this.estricto = estricto;
    }

    @Override
    public void run() {
        for (int i = 1; i < 10; i++) {
            System.out.println(text + ": " + i);
            if (estricto) {
                try {
                    Thread.sleep(100);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            } else {
                for (int a = 0; a<1000; a++);
            }
        }
        System.out.println("Acaba el fil " + text);
    }
}
