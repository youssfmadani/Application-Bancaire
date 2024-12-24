import java.util.Date;

public class Operation {
    private String type;
    private double montant;
    private Date date;
    private Compte compteAssocie;

    public Operation(String type, double montant, Date date, Compte compteAssocie) {
        this.type = type;
        this.montant = montant;
        this.date = date;
        this.compteAssocie = compteAssocie;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public double getMontant() {
        return montant;
    }

    public void setMontant(double montant) {
        this.montant = montant;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public Compte getCompteAssocie() {
        return compteAssocie;
    }

    public void setCompteAssocie(Compte compteAssocie) {
        this.compteAssocie = compteAssocie;
    }

    @Override
    public String toString() {
        return "Operation : " +
                "type='" + type + '\'' +
                ", montant=" + montant +
                ", date=" + date +
                ", compteAssocie=" + compteAssocie.getNumero();
    }
}
