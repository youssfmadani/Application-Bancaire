public class CompteCourant extends Compte {
    private double fraisBancaires;

    public CompteCourant(String numero, double solde, Client proprietaire, double fraisBancaires) {
        super(numero, solde, proprietaire);
        this.fraisBancaires = fraisBancaires;
    }

    public double getFraisBancaires() {
        return fraisBancaires;
    }
    public void setFraisBancaires(double fraisBancaires) {
        this.fraisBancaires = fraisBancaires;
    }

    @Override
    public boolean retirer(double montant) {
        if (solde - montant >= fraisBancaires) {
            solde -= montant;
        } else {
            System.out.println("Fonds insuffisants pour effectuer ce retrait.");
        }
        return false;
    }
}
