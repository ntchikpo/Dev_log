import eseo.fraude.Fraude;
import eseo.fraude.FraudeCalculatrice;
import eseo.fraude.FraudeIAG;
import eseo.fraude.FraudePapier;
import eseo.fraude.enumeration.Cursus;
import eseo.fraude.enumeration.Modalite;
import eseo.principal.Epreuve;
import eseo.principal.Etudiant;
import eseo.principal.Formulaire;
import eseo.principal.Systeme;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.lang.reflect.Field;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
/**
 * Tests unitaires de la classe Systeme.
 */
class SystemeTest {
    /**
     * Remet le compteur statique à zéro avant chaque test.
     * @throws Exception si le champ n'est pas accessible
     */
    @BeforeEach
    void resetCompteur() throws Exception {
        Field f = Formulaire.class.getDeclaredField("compteur");
        f.setAccessible(true);
        f.setInt(null, 0);
    }

    /**
     * Teste le constructeur vide.
     */
    @Test
    void testConstructeurVide() {
        // Act
        Systeme systeme = new Systeme();

        // Assert
        assertNotNull(systeme.getFormulaires());
        assertNotNull(systeme.getEpreuves());
        assertNotNull(systeme.getGraphe());
        assertTrue(systeme.getFormulaires().isEmpty());
        assertTrue(systeme.getEpreuves().isEmpty());
        assertTrue(systeme.getGraphe().isEmpty());
    }
    /**
     * Teste l'ajout d'une épreuve.
     */
    @Test
    void testAjouterEpreuve() {
        // Arrange
        Systeme systeme = new Systeme();
        Epreuve epreuve = new Epreuve("MATH101", LocalDate.of(2026, 5, 10), LocalTime.of(9, 0), 2.0f, Modalite.EXAMEN_ECRIT);

        // Act
        systeme.ajouterEpreuve(epreuve);

        // Assert
        assertEquals(1, systeme.getEpreuves().size());
        assertEquals(epreuve, systeme.getEpreuves().get(0));
    }
    /**
     * Teste getEpreuve par index.
     */
    @Test
    void testGetEpreuve() {
        // Arrange
        Systeme systeme = new Systeme();
        Epreuve epreuve1 = new Epreuve("MATH101", LocalDate.now(), LocalTime.of(9, 0), 2.0f, Modalite.EXAMEN_ECRIT);
        Epreuve epreuve2 = new Epreuve("INFO202", LocalDate.now(), LocalTime.of(14, 0), 1.5f, Modalite.QCM);

        systeme.ajouterEpreuve(epreuve1);
        systeme.ajouterEpreuve(epreuve2);

        // Act
        Epreuve resultat = systeme.getEpreuve(1);

        // Assert
        assertEquals(epreuve2, resultat);
    }
    /**
     * Teste l'ajout d'un formulaire.
     */
    @Test
    void testAjouterFormulaire() {
        // Arrange
        Systeme systeme = new Systeme();
        Formulaire formulaire = new Formulaire();

        // Act
        systeme.ajouterFormulaire(formulaire);

        // Assert
        assertEquals(1, systeme.getFormulaires().size());
        assertEquals(formulaire, systeme.getFormulaires().get(0));
    }
    /**
     * Teste la recherche d'un formulaire par id.
     */
    @Test
    void testRechercherFormulaireParId() {
        // Arrange
        Systeme systeme = new Systeme();
        Formulaire formulaire = new Formulaire();

        systeme.ajouterFormulaire(formulaire);

        // Act
        Formulaire resultat = systeme.rechercherFormulaireParId(formulaire.getId());

        // Assert
        assertEquals(formulaire, resultat);
    }
    /**
     * Teste la recherche d'un formulaire avec un id inconnu.
     */
    @Test
    void testRechercherFormulaireParIdInconnu() {
        // Arrange
        Systeme systeme = new Systeme();

        // Act
        Formulaire resultat = systeme.rechercherFormulaireParId(999);

        // Assert
        assertNull(resultat);
    }
    /**
     * Teste la suppression d'un formulaire.
     */
    @Test
    void testSupprimerFormulaire() {
        // Arrange
        Systeme systeme = new Systeme();
        Formulaire formulaire = new Formulaire();

        systeme.ajouterFormulaire(formulaire);

        // Act
        systeme.supprimerFormulaire(formulaire.getId());

        // Assert
        assertTrue(systeme.getFormulaires().isEmpty());
    }
    /**
     * Teste la suppression avec un id inconnu.
     */
    @Test
    void testSupprimerFormulaireIdInconnuNeSupprimeRien() {
        // Arrange
        Systeme systeme = new Systeme();
        Formulaire formulaire = new Formulaire();

        systeme.ajouterFormulaire(formulaire);

        // Act
        systeme.supprimerFormulaire(999);

        // Assert
        assertEquals(1, systeme.getFormulaires().size());
        assertEquals(formulaire, systeme.getFormulaires().get(0));
    }
    /**
     * Teste la recherche de formulaires par étudiant.
     */
    @Test
    void testFormulairesParEtudiant() {
        // Arrange
        Systeme systeme = new Systeme();
        Etudiant etudiant = new Etudiant("001", "Dupont", "Alice", Cursus.E1);

        Formulaire formulaire1 = new Formulaire();
        formulaire1.ajouterEtudiant(etudiant);

        Formulaire formulaire2 = new Formulaire();
        formulaire2.ajouterEtudiant(etudiant);

        systeme.ajouterFormulaire(formulaire1);
        systeme.ajouterFormulaire(formulaire2);

        // Act
        ArrayList<Formulaire> resultat = systeme.formulairesParEtudiant(etudiant);

        // Assert
        assertEquals(2, resultat.size());
        assertTrue(resultat.contains(formulaire1));
        assertTrue(resultat.contains(formulaire2));
    }
    /**
     * Teste la recherche de formulaires par épreuve.
     */
    @Test
    void testFormulairesParEpreuve() {
        // Arrange
        Systeme systeme = new Systeme();
        Epreuve epreuve = new Epreuve("MATH101", LocalDate.now(), LocalTime.of(9, 0), 2.0f, Modalite.EXAMEN_ECRIT);

        Formulaire formulaire1 = new Formulaire(epreuve);
        Formulaire formulaire2 = new Formulaire(epreuve);

        systeme.ajouterFormulaire(formulaire1);
        systeme.ajouterFormulaire(formulaire2);

        // Act
        ArrayList<Formulaire> resultat = systeme.formulairesParEpreuve(epreuve);

        // Assert
        assertEquals(2, resultat.size());
        assertTrue(resultat.contains(formulaire1));
        assertTrue(resultat.contains(formulaire2));
    }
    /**
     * Teste la recherche d'un étudiant par numéro apprenant.
     */
    @Test
    void testRechercherEtudiantParNumero() {
        // Arrange
        Systeme systeme = new Systeme();
        Etudiant etudiant = new Etudiant("001", "Dupont", "Alice", Cursus.E1);

        Formulaire formulaire = new Formulaire();
        formulaire.ajouterEtudiant(etudiant);
        systeme.ajouterFormulaire(formulaire);

        // Act
        Etudiant resultat = systeme.rechercherEtudiantParNumero("001");

        // Assert
        assertEquals(etudiant, resultat);
    }
    /**
     * Teste la recherche d'un étudiant avec un numéro inconnu.
     */
    @Test
    void testRechercherEtudiantParNumeroInconnu() {
        // Arrange
        Systeme systeme = new Systeme();

        // Act
        Etudiant resultat = systeme.rechercherEtudiantParNumero("999");

        // Assert
        assertNull(resultat);
    }
    /**
     * Teste la recherche d'étudiants par nom.
     */
    @Test
    void testRechercherEtudiantParNom() {
        // Arrange
        Systeme systeme = new Systeme();
        Etudiant etudiant = new Etudiant("001", "Dupont", "Alice", Cursus.E1);

        Formulaire formulaire = new Formulaire();
        formulaire.ajouterEtudiant(etudiant);
        systeme.ajouterFormulaire(formulaire);

        // Act
        ArrayList<Etudiant> resultat = systeme.rechercherEtudiantParNom("dupont");

        // Assert
        assertEquals(1, resultat.size());
        assertEquals(etudiant, resultat.get(0));
    }
    /**
     * Teste la recherche d'étudiants par prénom.
     */
    @Test
    void testRechercherEtudiantParPrenom() {
        // Arrange
        Systeme systeme = new Systeme();
        Etudiant etudiant = new Etudiant("001", "Dupont", "Alice", Cursus.E1);

        Formulaire formulaire = new Formulaire();
        formulaire.ajouterEtudiant(etudiant);
        systeme.ajouterFormulaire(formulaire);

        // Act
        ArrayList<Etudiant> resultat = systeme.rechercherEtudiantParPrenom("alice");

        // Assert
        assertEquals(1, resultat.size());
        assertEquals(etudiant, resultat.get(0));
    }
    /**
     * Teste les statistiques avec un système vide.
     */
    @Test
    void testStatistiquesSystemeVide() {
        // Arrange
        Systeme systeme = new Systeme();

        // Assert
        assertEquals(0, systeme.nbreTotalFormulaire());
        assertEquals(0, systeme.nbreTotalEtudiant());
        assertEquals(0, systeme.nbreTotalFraude());
        assertEquals(0.0, systeme.moyNbreFraudeFormulaire());
        assertEquals(0.0, systeme.ecartType());
    }
    /**
     * Teste les statistiques avec des formulaires.
     */
    @Test
    void testStatistiquesAvecFormulaires() {
        // Arrange
        Systeme systeme = new Systeme();

        Etudiant etudiant1 = new Etudiant("001", "Dupont", "Alice", Cursus.E1);
        Etudiant etudiant2 = new Etudiant("002", "Martin", "Bob", Cursus.E2);

        Fraude fraude1 = new FraudeIAG(LocalDate.now(), "IA", "Texte généré", "ChatGPT");
        Fraude fraude2 = new FraudePapier(LocalDate.now(), "Papier", "Formules", 10.0, 15.0, true);
        Fraude fraude3 = new FraudeCalculatrice(LocalDate.now(), "Calculatrice", "Programme", "Casio", "prog.py");

        Formulaire formulaire1 = new Formulaire();
        formulaire1.ajouterEtudiant(etudiant1);
        formulaire1.ajouterEtudiant(etudiant2);
        formulaire1.ajouterFraude(fraude1);
        formulaire1.ajouterFraude(fraude2);

        Formulaire formulaire2 = new Formulaire();
        formulaire2.ajouterEtudiant(etudiant2);
        formulaire2.ajouterFraude(fraude3);

        systeme.ajouterFormulaire(formulaire1);
        systeme.ajouterFormulaire(formulaire2);

        // Assert
        assertEquals(2, systeme.nbreTotalFormulaire());
        assertEquals(2, systeme.nbreTotalEtudiant());
        assertEquals(3, systeme.nbreTotalFraude());
        assertEquals(1.5, systeme.moyNbreFraudeFormulaire());
        assertEquals(0.5, systeme.ecartType());
    }
    /**
     * Teste que le graphe est non orienté.
     */
    @Test
    void testGrapheNonOriente() {
        // Arrange
        Systeme systeme = new Systeme();

        Etudiant etudiant1 = new Etudiant("001", "Dupont", "Alice", Cursus.E1);
        Etudiant etudiant2 = new Etudiant("002", "Martin", "Bob", Cursus.E2);

        Formulaire formulaire = new Formulaire();
        formulaire.ajouterEtudiant(etudiant1);
        formulaire.ajouterEtudiant(etudiant2);

        // Act
        systeme.ajouterFormulaire(formulaire);

        // Assert
        assertTrue(systeme.getGraphe().containsKey(etudiant1));
        assertTrue(systeme.getGraphe().containsKey(etudiant2));

        List<Etudiant> voisinsEtudiant1 = systeme.getGraphe().get(etudiant1);
        List<Etudiant> voisinsEtudiant2 = systeme.getGraphe().get(etudiant2);

        assertTrue(voisinsEtudiant1.contains(etudiant2));
        assertTrue(voisinsEtudiant2.contains(etudiant1));
    }
    /**
     * Teste le graphe avec un seul étudiant.
     */
    @Test
    void testGrapheAvecUnSeulEtudiant() {
        // Arrange
        Systeme systeme = new Systeme();

        Etudiant etudiant = new Etudiant("001", "Dupont", "Alice", Cursus.E1);

        Formulaire formulaire = new Formulaire();
        formulaire.ajouterEtudiant(etudiant);

        // Act
        systeme.ajouterFormulaire(formulaire);

        // Assert
        assertTrue(systeme.getGraphe().containsKey(etudiant));
        assertTrue(systeme.getGraphe().get(etudiant).isEmpty());
    }
    /**
     * Teste la recherche par nom inconnu.
     */
    @Test
    void testRechercherEtudiantParNomInconnu() {
        // Arrange
        Systeme systeme = new Systeme();

        Etudiant etudiant = new Etudiant("001", "Dupont", "Alice", Cursus.E1);
        Formulaire formulaire = new Formulaire();
        formulaire.ajouterEtudiant(etudiant);
        systeme.ajouterFormulaire(formulaire);

        // Act
        ArrayList<Etudiant> resultat = systeme.rechercherEtudiantParNom("Inconnu");

        // Assert
        assertTrue(resultat.isEmpty());
    }
    /**
     * Teste la recherche par prénom inconnu.
     */
    @Test
    void testRechercherEtudiantParPrenomInconnu() {
        // Arrange
        Systeme systeme = new Systeme();

        Etudiant etudiant = new Etudiant("001", "Dupont", "Alice", Cursus.E1);
        Formulaire formulaire = new Formulaire();
        formulaire.ajouterEtudiant(etudiant);
        systeme.ajouterFormulaire(formulaire);

        // Act
        ArrayList<Etudiant> resultat = systeme.rechercherEtudiantParPrenom("Inconnu");

        // Assert
        assertTrue(resultat.isEmpty());
    }
    /**
     * Teste formulairesParEtudiant avec un étudiant absent.
     */
    @Test
    void testFormulairesParEtudiantAbsent() {
        // Arrange
        Systeme systeme = new Systeme();

        Etudiant etudiantPresent = new Etudiant("001", "Dupont", "Alice", Cursus.E1);
        Etudiant etudiantAbsent = new Etudiant("999", "Inconnu", "Personne", Cursus.E5);

        Formulaire formulaire = new Formulaire();
        formulaire.ajouterEtudiant(etudiantPresent);
        systeme.ajouterFormulaire(formulaire);

        // Act
        ArrayList<Formulaire> resultat = systeme.formulairesParEtudiant(etudiantAbsent);

        // Assert
        assertTrue(resultat.isEmpty());
    }
    /**
     * Teste formulairesParEpreuve avec une épreuve absente.
     */
    @Test
    void testFormulairesParEpreuveAbsente() {
        // Arrange
        Systeme systeme = new Systeme();

        Epreuve epreuvePresente = new Epreuve("MATH101", LocalDate.now(), LocalTime.of(9, 0), 2.0f, Modalite.EXAMEN_ECRIT);
        Epreuve epreuveAbsente = new Epreuve("INFO999", LocalDate.now(), LocalTime.of(14, 0), 1.5f, Modalite.QCM);

        Formulaire formulaire = new Formulaire(epreuvePresente);
        systeme.ajouterFormulaire(formulaire);

        // Act
        ArrayList<Formulaire> resultat = systeme.formulairesParEpreuve(epreuveAbsente);

        // Assert
        assertTrue(resultat.isEmpty());
    }
    /**
     * Teste que afficherListeFormulaires ne plante pas.
     */
    @Test
    void testAfficherListeFormulairesVide() {
        // Arrange
        Systeme systeme = new Systeme();

        // Act & Assert
        assertDoesNotThrow(() -> systeme.afficherListeFormulaires());
    }
    /**
     * Teste que afficherListeEpreuves ne plante pas.
     */
    @Test
    void testAfficherListeEpreuvesVide() {
        // Arrange
        Systeme systeme = new Systeme();

        // Act & Assert
        assertDoesNotThrow(() -> systeme.afficherListeEpreuves());
    }
    /**
     * Teste que afficherStatistiques ne plante pas.
     */
    @Test
    void testAfficherStatistiquesNePlantePas() {
        // Arrange
        Systeme systeme = new Systeme();

        // Act & Assert
        assertDoesNotThrow(() -> systeme.afficherStatistiques());
    }
    /**
     * Teste que afficherGraphe ne plante pas.
     */
    @Test
    void testAfficherGrapheVideNePlantePas() {
        // Arrange
        Systeme systeme = new Systeme();

        // Act & Assert
        assertDoesNotThrow(() -> systeme.afficherGraphe());
    }
}

