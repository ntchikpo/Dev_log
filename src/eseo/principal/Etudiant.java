public class Etudiant {

    private String numeroApprenant;
    private String nom;
    private String prenom;
    private Cursus cursus;

    public Etudiant() {}

    public Etudiant(String numeroApprenant, String nom, String prenom, Cursus cursus) {
        this.numeroApprenant = numeroApprenant;
        this.nom = nom;
        this.prenom = prenom;
        this.cursus = cursus;
    }

    public String getNumeroApprenant() {
        return numeroApprenant;
    }
    public void setNumeroApprenant(String numeroApprenant) {
        this.numeroApprenant = numeroApprenant;
    }

    public String getNom() {
        return nom;
    }
    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getPrenom() {
        return prenom;
    }
    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    public Cursus getCursus() {
        return cursus;
    }
    public void setCursus(Cursus cursus) {
        this.cursus = cursus;
    }

    @Override
    public String toString() {
        return "Etudiant{" +
                "numeroApprenant='" + numeroApprenant + '\'' +
                ", nom='" + nom + '\'' +
                ", prenom='" + prenom + '\'' +
                ", cursus=" + cursus +
                '}';
    }
}