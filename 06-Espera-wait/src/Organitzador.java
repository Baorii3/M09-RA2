public class Organitzador {
    
    public static void main(String[] args) {
        Esdeveniment esdeveniment = new Esdeveniment(5);
        for (int i = 1; i <= 10; i++) {
            Asistent a = new Asistent("Asistent-" + i, esdeveniment);
            a.start();
        }
    }

}
