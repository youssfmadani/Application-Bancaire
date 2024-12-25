import java.util.*;

public class ApplicationBancaire {

    private static List<Client> clients = new ArrayList<>();
    private static List<Compte> comptes = new ArrayList<>();

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int choix = 0;

        do {
            afficherMenuPrincipal();
            try {
                choix = Integer.parseInt(scanner.nextLine());
                switch (choix) {
                    case 1:
                        gererClients(scanner);
                        break;
                    case 2:
                        gererComptes(scanner);
                        break;
                    case 3:
                        effectuerOperations(scanner); // Add later
                        break;
                    case 4:
                        afficherComptes();
                        break;
                    case 5:
                        System.out.println("Merci d'utiliser l'application bancaire. À bientôt !");
                        break;
                    default:
                        System.out.println("Option invalide. Veuillez réessayer.");
                }
            } catch (NumberFormatException e) {
                System.out.println("Veuillez entrer un nombre valide.");
            }
        } while (choix != 5);

        scanner.close();
    }

    public static void afficherMenuPrincipal() {
        System.out.println("==========================================");
        System.out.println("      BIENVENUE DANS L'APPLICATION BANCAIRE");
        System.out.println("==========================================");
        System.out.println("1. Gérer les Clients");
        System.out.println("2. Gérer les Comptes Bancaires");
        System.out.println("3. Effectuer des Opérations Bancaires");
        System.out.println("4. Afficher tous les comptes bancaires");
        System.out.println("5. Quitter l'Application");
        System.out.print("Veuillez sélectionner une option (1-5) : ");
    }

    public static void gererClients(Scanner scanner) {
        System.out.println("==========================================");
        System.out.println("         GESTION DES CLIENTS");
        System.out.println("==========================================");
        System.out.println("1. Ajouter un nouveau client");
        System.out.println("2. Afficher la liste des clients");
        System.out.println("3. Retour au menu principal");
        System.out.print("Veuillez sélectionner une option (1-3) : ");

        try {
            int choix = Integer.parseInt(scanner.nextLine());
            switch (choix) {
                case 1:
                    ajouterClient(scanner);
                    break;
                case 2:
                    afficherClients();
                    break;
                case 3:
                    break;
                default:
                    System.out.println("Option invalide.");
            }
        } catch (NumberFormatException e) {
            System.out.println("Veuillez entrer un nombre valide.");
        }
    }

    private static void ajouterClient(Scanner scanner) {
        int id = Integer.parseInt(lireEntreeValidee(scanner, "ID (4-10 chiffres) : ", "^\\d{4,10}$"));
        String nom = lireEntreeValidee(scanner, "Nom (au moins 2 lettres) : ", "^[a-zA-Z]{2,}$");
        String prenom = lireEntreeValidee(scanner, "Prénom (au moins 2 lettres) : ", "^[a-zA-Z]{2,}$");
        String email = lireEntreeValidee(scanner, "Email (format valide, ex : exemple@mail.com) : ", "^[\\w]+@[\\w]+\\.[a-zA-Z]{2,6}$");
        System.out.print("Adresse : ");
        String adresse = scanner.nextLine();
        String telephone = lireEntreeValidee(scanner, "Téléphone (10 chiffres) : ", "^\\d{10}$");

        clients.add(new Client(id, nom, prenom, email, adresse, telephone));
        System.out.println("Client ajouté avec succès !");
    }

    private static String lireEntreeValidee(Scanner scanner, String message, String regex) {
        String input;
        while (true) {
            System.out.print(message);
            input = scanner.nextLine();
            if (input.matches(regex)) {
                break;
            } else {
                System.out.println("Entrée invalide. Veuillez réessayer.");
            }
        }
        return input;
    }

    private static void afficherClients() {
        if (clients.isEmpty()) {
            System.out.println("Aucun client enregistré.");
        } else {
            for (Client client : clients) {
                System.out.println(client.toString());
            }
        }
    }

    private static Client RecherchebyId() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("ID du client : ");
        int id = scanner.nextInt();
        for (Client client : clients) {
            if (id == client.getId()) {
                return client;
            }
        }
        return null;
    }

    public static void gererComptes(Scanner scanner) {
        System.out.println("==========================================");
        System.out.println("         GESTION DES COMPTES BANCAIRES");
        System.out.println("==========================================");
        System.out.println("1. Créer un compte bancaire");
        System.out.println("2. Afficher les informations d'un compte");
        System.out.println("3. Afficher tous les comptes associés à un client");
        System.out.println("4. Retour au menu principal");
        System.out.print("Veuillez sélectionner une option (1-4) : ");

        try {
            int choix = Integer.parseInt(scanner.nextLine());
            switch (choix) {
                case 1:
                    creerCompte(scanner);
                    break;
                case 2:
                    afficherComptes();
                    break;
                case 3:
                    afficherComptesClient(scanner);
                    break;
                case 4:
                    break;
                default:
                    System.out.println("Option invalide.");
            }
        } catch (NumberFormatException e) {
            System.out.println("Veuillez entrer un nombre valide.");
        }
    }

    private static void creerCompte(Scanner scanner) {
        if (clients.isEmpty()) {
            System.out.println("Veuillez ajouter un client avant de créer un compte.");
            return;
        }

        Client client = RecherchebyId();
        if (client == null) {
            System.out.println("Client introuvable.");
            return;
        }

        System.out.print("Numero de compte : ");
        String numero = scanner.nextLine();

        System.out.print("Type de compte (1: Courant, 2: Epargne) : ");
        int type = Integer.parseInt(scanner.nextLine());

        System.out.print("Solde initial : ");
        double solde = Double.parseDouble(scanner.nextLine());

        if (type == 1) {
            comptes.add(new CompteCourant(numero, solde, client, 50));
        } else if (type == 2) {
            comptes.add(new CompteEpargne(numero, solde, client, 0.02));
        } else {
            System.out.println("Type de compte invalide.");
        }

        System.out.println("Compte créé avec succès !");
    }

    private static void afficherComptes() {
        if (comptes.isEmpty()) {
            System.out.println("Aucun compte enregistré.");
        } else {
            for (Compte compte : comptes) {
                System.out.println(compte.toString());
            }
        }
    }

    private static void afficherComptesClient(Scanner scanner) {
        Client client = RecherchebyId();
        if (client != null) {
            for (Compte compte : comptes) {
                if (compte.getProprietaire().equals(client)) {
                    System.out.println(compte.toString());
                }
            }
        } else {
            System.out.println("Client introuvable.");
        }
    }
    public static void effectuerOperations(Scanner scanner) {
        System.out.println("==========================================");
        System.out.println("         OPÉRATIONS BANCAIRES");
        System.out.println("==========================================");
        System.out.println("1. Effectuer un dépôt");
        System.out.println("2. Effectuer un retrait");
        System.out.println("3. Effectuer un virement");
        System.out.println("4. Retour au menu principal");
        System.out.print("Veuillez sélectionner une option (1-4) : ");

        try {
            int choix = Integer.parseInt(scanner.nextLine());
            switch (choix) {
                case 1:
                    effectuerDepot(scanner);
                    break;
                case 2:
                    effectuerRetrait(scanner);
                    break;
                case 3:
                    effectuerVirement(scanner);
                    break;
                case 4:
                    break;
                default:
                    System.out.println("Option invalide.");
            }
        } catch (NumberFormatException e) {
            System.out.println("Veuillez entrer un nombre valide.");
        }
    }

    private static void effectuerDepot(Scanner scanner) {
        Compte compte = rechercherCompte(scanner);
        if (compte == null) {
            System.out.println("Compte introuvable.");
            return;
        }
        double montant = Double.parseDouble(lireEntreeValidee(scanner, "Montant du dépôt : ", "^[0-9]+(\\.[0-9]{1,2})?$"));
        compte.deposer(montant);
        System.out.println("Dépôt effectué avec succès !");
    }

    private static void effectuerRetrait(Scanner scanner) {
        Compte compte = rechercherCompte(scanner);
        if (compte == null) {
            System.out.println("Compte introuvable.");
            return;
        }
        double montant = Double.parseDouble(lireEntreeValidee(scanner, "Montant du retrait : ", "^[0-9]+(\\.[0-9]{1,2})?$"));
        if (compte.retirer(montant)) {
            System.out.println("Retrait effectué avec succès !");
        } else {
            System.out.println("Fonds insuffisants.");
        }
    }

    private static void effectuerVirement(Scanner scanner) {
        System.out.println("Compte source :");
        Compte compteSource = rechercherCompte(scanner);
        if (compteSource == null) {
            System.out.println("Compte source introuvable.");
            return;
        }
        System.out.println("Compte cible :");
        Compte compteCible = rechercherCompte(scanner);
        if (compteCible == null) {
            System.out.println("Compte cible introuvable.");
            return;
        }
        double montant = Double.parseDouble(lireEntreeValidee(scanner, "Montant du virement : ", "^[0-9]+(\\.[0-9]{1,2})?$"));
        if (compteSource.retirer(montant)) {
            compteCible.deposer(montant);
            System.out.println("Virement effectué avec succès !");
        } else {
            System.out.println("Fonds insuffisants.");
        }
    }

    private static Compte rechercherCompte(Scanner scanner) {
        String numero = lireEntreeValidee(scanner, "Numéro de compte : ", "^[a-zA-Z0-9]+$");
        for(Compte compte : comptes) {
            if (compte.getNumero().equals(numero)) {
                return compte;
            }
        }
        return null;
    }

}
