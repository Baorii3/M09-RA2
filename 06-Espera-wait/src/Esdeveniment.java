import java.util.ArrayList;
import java.util.List;

public class Esdeveniment{
    
    private List<Asistent> assistents = new ArrayList<>();
    private int placesDisponibles = 10;

    public Esdeveniment(){}

    public Esdeveniment(int maximEntradas){
        this.placesDisponibles = maximEntradas;
    }

    public List<Asistent> getAssistents() {
        return assistents;
    }

    public void setAssistents(List<Asistent> assistents) {
        this.assistents = assistents;
    }

    public int getEntradas() {
        return placesDisponibles;
    }

    public void setEntradas(int entradas) {
        this.placesDisponibles = entradas;
    }


    public synchronized void ferRreserva(Asistent a) throws InterruptedException {
        while (this.placesDisponibles == 0) {
            wait();
        }
        this.placesDisponibles--;
        this.assistents.add(a);
        System.out.println(a.getName() + " ha fet una reserva. Places disponibles " + this.placesDisponibles);
    }

    public synchronized void cancelaReserva(Asistent a) {
        if (this.assistents.contains(a)) {
            this.placesDisponibles++;
            this.assistents.remove(a);
            System.out.println(a.getName() + " ha cancel·lat una reserva. Places disponibles " + this.placesDisponibles);
            notifyAll();
        } else {
            System.out.println(a.getName() + " no ha pogut cancelar una reserva inexistent. Places disponibles " + this.placesDisponibles);
        }
    }

}
