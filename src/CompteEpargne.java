public class CompteEpargne extends Compte {
    private double tauxInteret;

    public CompteEpargne(String numero, double solde, Client proprietaire, double tauxInteret) {
        super(numero, solde, proprietaire);
        this.tauxInteret = tauxInteret;
    }

    public double getTauxInteret() {
        return tauxInteret;
    }
    public void setTauxInteret(double tauxInteret) {
        this.tauxInteret = tauxInteret;
    }

    @Override
    public void retirer(double montant) {
        if (solde - montant >= 0) {
            solde -= montant;
        } else {
            System.out.println("Fonds insuffisants pour effectuer ce retrait.");
        }
    }
}
