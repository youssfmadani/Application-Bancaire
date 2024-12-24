public abstract class Compte {
    private String numero;
    protected double solde;
    private Client proprietaire;

    public Compte(String numero, double solde, Client proprietaire) {
        this.numero = numero;
        this.solde = solde;
        this.proprietaire = proprietaire;
    }

    public String getNumero() { return numero; }
    public double getSolde() { return solde; }
    public Client getProprietaire() { return proprietaire; }

    public abstract void retirer(double montant);
    public void deposer(double montant) {
        this.solde += montant;
    }

    @Override
    public String toString() {
        return "Compte : " +
                "numero='" + numero + '\'' +
                ", solde=" + solde +
                ", proprietaire=" + proprietaire;
    }
}
