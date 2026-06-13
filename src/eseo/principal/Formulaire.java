import java.time.LocalDate;
import java.util.ArrayList;

public class Formulaire {

    private static int compteur = 0;

    private int id;
    private LocalDate dateCreation;
    private LocalDate dateModification;
    private Epreuve epreuve;
    private ArrayList<Etudiant> etudiants;
    private ArrayList<Fraude> fraudes;

    public Formulaire() {
        this.id = ++compteur;
        this.dateCreation = LocalDate.now();
        this.dateModification = LocalDate.now();
        this.etudiants = new ArrayList<>();
        this.fraudes = new ArrayList<>();
    }

    public Formulaire(Epreuve epreuve) {
        this.id = ++compteur;
        this.dateCreation = LocalDate.now();
        this.dateModification = LocalDate.now();
        this.epreuve = epreuve;
        this.etudiants = new ArrayList<>();
        this.fraudes = new ArrayList<>();
    }

    public void ajouterEtudiant(Etudiant etudiant) {
        etudiants.add(etudiant);
        majDateModification();
    }

    public void ajouterFraude(Fraude fraude) {
        fraudes.add(fraude);
        majDateModification();
    }

    private void majDateModification() {
        this.dateModification = LocalDate.now();
    }

    public int getId() {
        return id;
    }

    public LocalDate getDateCreation() {
        return dateCreation;
    }

    public LocalDate getDateModification() {
        return dateModification;
    }

    public Epreuve getEpreuve() {
        return epreuve;
    }
    public void setEpreuve(Epreuve epreuve) {
        this.epreuve = epreuve;
    }

    public ArrayList<Etudiant> getEtudiants() {
        return etudiants;
    }

    public ArrayList<Fraude> getFraudes() {
        return fraudes;
    }

    @Override
    public String toString() {
        return "Formulaire{" +
                "id=" + id +
                ", dateCreation=" + dateCreation +
                ", dateModification=" + dateModification +
                ", epreuve=" + epreuve +
                ", etudiants=" + etudiants +
                ", fraudes=" + fraudes +
                '}';
    }
}