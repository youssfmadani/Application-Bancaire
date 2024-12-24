public class Client {
    private String id;
    private String nom;
    private String prenom;
    private String email;
    private String adresse;
    private String telephone;

    // Constructeur, getters, setters
    public Client(String id, String nom, String prenom, String email, String adresse, String telephone) {
        this.id = id;
        this.nom = nom;
        this.prenom = prenom;
        this.email = email;
        this.adresse = adresse;
        this.telephone = telephone;
    }

    public Client() {

    }

    // Getters
    public String getId() {
        return id; }
    public String getNom() {
        return nom; }
    public String getPrenom() {
        return prenom; }
    public String getEmail() {
        return email; }
    public String getAdresse() {
        return adresse; }
    public String getTelephone() {
        return telephone; }

    @Override
    public String toString() {
        return "Client \n" +
                "id='" + id + '\'' +
                ", nom='" + nom + '\'' +
                ", prenom='" + prenom + '\'' +
                ", email='" + email + '\'' +
                ", adresse='" + adresse + '\'' +
                ", telephone='" + telephone + '\'';
    }
}
