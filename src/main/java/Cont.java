public class Cont {

    private String titular;
    private String iban;
    private double balanta;
    private double dobanda;

    public Cont(String titular, String iban, double balanta, double dobanda) {
        this.titular = titular;
        this.iban = iban;
        this.balanta = balanta;
        this.dobanda = dobanda;
    }
    public double withdraw(double suma){
        return balanta -= suma;
    }

    public double deposit(double suma){
        return balanta += suma;
    }

    public double adaugaDobanda(){
        return balanta *= (1 + dobanda);
    }

    @Override
    public String toString(){
        return titular + " are in contul bancar " + iban + " " + balanta + " lei.";
    }
}
