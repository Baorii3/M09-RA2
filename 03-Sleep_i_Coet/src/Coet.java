import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Coet {
    private Motor motor;
    private Motor motor2;
    private Motor motor3;
    private Motor motor4;

    public Coet() {
        motor = new Motor("0");
        motor2 = new Motor("1");
        motor3 = new Motor("2");
        motor4 = new Motor("3");
    }

    public void passaApotencia(int potencia) {
        if (potencia < 0 || potencia >= 10) {
            System.out.println("Potencia no valida");
            return;
        }
        motor.setPotencia(potencia);
        motor2.setPotencia(potencia);
        motor3.setPotencia(potencia);
        motor4.setPotencia(potencia);

    }

    public void arranca() {
        motor.start();
        motor2.start();
        motor3.start();
        motor4.start();
    }   

    public static void main(String[] args) throws IOException {
        Coet coet = new Coet();
        coet.arranca();
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        while (coet.motor.isAlive() || coet.motor2.isAlive() || coet.motor3.isAlive() || coet.motor4.isAlive()) {
           if (reader.ready()) {
                int potencia = Integer.parseInt(reader.readLine());
                coet.passaApotencia(potencia);
            }
            
        }
    }
    
}