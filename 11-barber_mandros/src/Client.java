public class Client {
    private String nom;

    public Client(int id) {
        this.nom = "Client " + id;
    }


    public void tallarseElcabell(Barber barber) {
        System.out.println("Tallant cabell a " + this.nom);
    }

    public String getNom() {
        return this.nom;
    }

}
