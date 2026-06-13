import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Scanner;

public class Systeme {

    private ArrayList<Formulaire> formulaires;
    private ArrayList<Epreuve> epreuves;
    private HashMap<Etudiant, List<Etudiant>> graphe;

    public Systeme() {
        this.formulaires = new ArrayList<>();
        this.epreuves = new ArrayList<>();
        this.graphe = new HashMap<>();
    }

    //FORMULAIRE

    public void ajouterFormulaire(Formulaire formulaire) {
        formulaires.add(formulaire);
        mettreAJourGraphe(formulaire);
    }

    public void supprimerFormulaire(int id) {
        Formulaire f = rechercherFormulaireParId(id);
        if (f != null) {
            formulaires.remove(f);
            System.out.println("Formulaire supprimé.");
        } else {
            System.out.println("Identifiant inconnu.");
        }
    }

    public Formulaire rechercherFormulaireParId(int id) {
        for (Formulaire f : formulaires) {
            if (f.getId() == id) {
                return f;
            }
        }
        return null;
    }

    public ArrayList<Formulaire> formulairesParEtudiant(Etudiant etudiant) {
        ArrayList<Formulaire> resultat = new ArrayList<>();
        for (Formulaire f : formulaires) {
            if (f.getEtudiants().contains(etudiant)) {
                resultat.add(f);
            }
        }
        return resultat;
    }

    public ArrayList<Formulaire> formulairesParEpreuve(Epreuve epreuve) {
        ArrayList<Formulaire> resultat = new ArrayList<>();
        for (Formulaire f : formulaires) {
            if (f.getEpreuve().equals(epreuve)) {
                resultat.add(f);
            }
        }
        return resultat;
    }

    public void afficherListeFormulaires() {
        if (formulaires.isEmpty()) {
            System.out.println("Aucun formulaire enregistré.");
        } else {
            for (Formulaire f : formulaires) {
                System.out.println(f);
            }
        }
    }

    //EPREUVE

    public void ajouterEpreuve(Epreuve epreuve) {
        epreuves.add(epreuve);
    }

    public void afficherListeEpreuves() {
        if (epreuves.isEmpty()) {
            System.out.println("Aucune épreuve enregistrée.");
        } else {
            for (int i = 0; i < epreuves.size(); i++) {
                System.out.println(i + 1 + ". " + epreuves.get(i));
            }
        }
    }

    public Epreuve getEpreuve(int index) {

        return epreuves.get(index);
    }

    //ETUDIANT

    public Etudiant rechercherEtudiantParNumero(String numeroApprenant) {
        for (Formulaire f : formulaires) {
            for (Etudiant e : f.getEtudiants()) {
                if (e.getNumeroApprenant().equals(numeroApprenant)) {
                    return e;
                }
            }
        }
        return null;
    }

    public ArrayList<Etudiant> rechercherEtudiantParNom(String nom) {
        ArrayList<Etudiant> resultat = new ArrayList<>();
        for (Formulaire f : formulaires) {
            for (Etudiant e : f.getEtudiants()) {
                if (e.getNom().equalsIgnoreCase(nom) && !resultat.contains(e)) {
                    resultat.add(e);
                }
            }
        }
        return resultat;
    }

    public ArrayList<Etudiant> rechercherEtudiantParPrenom(String prenom) {
        ArrayList<Etudiant> resultat = new ArrayList<>();
        for (Formulaire f : formulaires) {
            for (Etudiant e : f.getEtudiants()) {
                if (e.getPrenom().equalsIgnoreCase(prenom) && !resultat.contains(e)) {
                    resultat.add(e);
                }
            }
        }
        return resultat;
    }

    // STATISTIQUES

    public int nbreTotalFormulaire() {

        return formulaires.size();
    }

    public int nbreTotalEtudiant() {
        ArrayList<Etudiant> etudiants = new ArrayList<>();
        for (Formulaire f : formulaires) {
            for (Etudiant e : f.getEtudiants()) {
                if (!etudiants.contains(e)) {
                    etudiants.add(e);
                }
            }
        }
        return etudiants.size();
    }

    public int nbreTotalFraude() {
        int total = 0;
        for (Formulaire f : formulaires) {
            total += f.getFraudes().size();
        }
        return total;
    }

    public double moyNbreFraudeFormulaire() {
        if (formulaires.isEmpty()) {
            return 0;
        }
        return (double) nbreTotalFraude() / formulaires.size();
    }

    public double ecartType() {
        if (formulaires.isEmpty()) return 0;
        double moyenne = moyNbreFraudeFormulaire();
        double somme = 0;
        for (Formulaire f : formulaires) {
            double diff = f.getFraudes().size() - moyenne;
            somme += diff * diff;
        }
        return Math.sqrt(somme / formulaires.size());
    }

    public void afficherStatistiques() {
        System.out.println("Statistiques");
        System.out.println("Nombre total de formulaires : " + nbreTotalFormulaire());
        System.out.println("Nombre d'étudiants distincts : " + nbreTotalEtudiant());
        System.out.println("Nombre total de fraudes : " + nbreTotalFraude());
        System.out.println("Moyenne fraudes par formulaire : " + moyNbreFraudeFormulaire());
        System.out.println("Ecart-type : " + ecartType());
    }

    //GRAPHE

    private void mettreAJourGraphe(Formulaire formulaire) {
        ArrayList<Etudiant> etudiants = formulaire.getEtudiants();
        for (Etudiant e : etudiants) {
            if (!graphe.containsKey(e)) {
                graphe.put(e, new ArrayList<>());
            }
        }
        for (int i = 0; i < etudiants.size(); i++) {
            for (int j = i + 1; j < etudiants.size(); j++) {
                Etudiant e1 = etudiants.get(i);
                Etudiant e2 = etudiants.get(j);
                if (!graphe.get(e1).contains(e2)) {
                    graphe.get(e1).add(e2);
                }
                if (!graphe.get(e2).contains(e1)) {
                    graphe.get(e2).add(e1);
                }
            }
        }
    }

    public void afficherGraphe() {
        System.out.println("Graphe de plagiat");
        if (graphe.isEmpty()) {
            System.out.println("Aucune relation de plagiat détectée.");
        } else {
            for (Etudiant e : graphe.keySet()) {
                System.out.print(e.getNom() + " " + e.getPrenom() + " --> ");
                List<Etudiant> voisins = graphe.get(e);
                if (voisins.isEmpty()) {
                    System.out.print("aucun lien");
                } else {
                    for (Etudiant v : voisins) {
                        System.out.print(v.getNom() + " " + v.getPrenom() + " ");
                    }
                }
                System.out.println();
            }
        }
    }

    public ArrayList<Formulaire> getFormulaires() {
        return formulaires;
    }
    public ArrayList<Epreuve> getEpreuves() {
        return epreuves;
    }
    public HashMap<Etudiant, List<Etudiant>> getGraphe() {
        return graphe;
    }
}