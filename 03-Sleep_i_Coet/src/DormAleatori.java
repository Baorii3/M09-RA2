
public class DormAleatori extends Thread {
    
    public long time;
    public long tempsDormir;

    public DormAleatori(String name) {
        setName(name);
        time = System.currentTimeMillis();
    }

    @Override
    public void run() {
        for (int i = 0; i<10; i++) {
            tempsDormir = (long) (Math.random() * 1000);
            System.out.printf("%s(%d) a dormir %dms total %dms%n", getName(), i, tempsDormir, System.currentTimeMillis()-time);
            try {
                sleep(tempsDormir);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            
        }
    }
    
    public static void main(String[] args) {
        DormAleatori t1 = new DormAleatori("a");
        DormAleatori t2 = new DormAleatori("b");

        t1.start();
        t2.start();

        System.out.println("--Fi de main----------");
    }
}
