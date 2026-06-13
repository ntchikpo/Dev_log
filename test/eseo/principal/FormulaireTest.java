import eseo.fraude.Fraude;
import eseo.fraude.FraudeIAG;
import eseo.fraude.enumeration.Cursus;
import eseo.fraude.enumeration.Modalite;
import eseo.principal.Epreuve;
import eseo.principal.Etudiant;
import eseo.principal.Formulaire;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.lang.reflect.Field;
import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.*;
/**
 * Tests unitaires de la classe Formulaire.
 */
class FormulaireTest {
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
        Formulaire formulaire = new Formulaire();

        // Assert
        assertTrue(formulaire.getId() > 0);
        assertEquals(LocalDate.now(), formulaire.getDateCreation());
        assertEquals(LocalDate.now(), formulaire.getDateModification());
        assertNotNull(formulaire.getEtudiants());
        assertNotNull(formulaire.getFraudes());
        assertTrue(formulaire.getEtudiants().isEmpty());
        assertTrue(formulaire.getFraudes().isEmpty());
    }
    /**
     * Teste le constructeur avec épreuve.
     */
    @Test
    void testConstructeurAvecEpreuve() {
        // Arrange
        Epreuve epreuve = new Epreuve("MATH101", LocalDate.now(), null, 2.0f, Modalite.EXAMEN_ECRIT);

        // Act
        Formulaire formulaire = new Formulaire(epreuve);

        // Assert
        assertEquals(epreuve, formulaire.getEpreuve());
        assertEquals(LocalDate.now(), formulaire.getDateCreation());
        assertEquals(LocalDate.now(), formulaire.getDateModification());
        assertNotNull(formulaire.getEtudiants());
        assertNotNull(formulaire.getFraudes());
    }
    /**
     * Teste l'ajout d'un étudiant et la mise à jour de la date.
     */
    @Test
    void testAjouterEtudiantMetAJourListeEtDate() {
        // Arrange
        Formulaire formulaire = new Formulaire();
        Etudiant etudiant = new Etudiant("001", "Dupont", "Alice", Cursus.E1);

        // Act
        formulaire.ajouterEtudiant(etudiant);

        // Assert
        assertEquals(1, formulaire.getEtudiants().size());
        assertEquals(etudiant, formulaire.getEtudiants().get(0));
        assertEquals(LocalDate.now(), formulaire.getDateModification());
    }
    /**
     * Teste l'ajout d'une fraude et la mise à jour de la date.
     */
    @Test
    void testAjouterFraudeMetAJourListeEtDate() {
        // Arrange
        Formulaire formulaire = new Formulaire();

        Fraude fraude = new FraudeIAG(
                LocalDate.now(),
                "Copie",
                "Description",
                "ChatGPT"
        );

        // Act
        formulaire.ajouterFraude(fraude);

        // Assert
        assertEquals(1, formulaire.getFraudes().size());
        assertEquals(fraude, formulaire.getFraudes().get(0));
        assertEquals(LocalDate.now(), formulaire.getDateModification());
    }
    /**
     * Teste le setter de l'épreuve.
     */
    @Test
    void testSetEpreuve() {
        // Arrange
        Formulaire formulaire = new Formulaire();
        Epreuve epreuve = new Epreuve("INFO202", LocalDate.now(), null, 1.5f, Modalite.QCM);

        // Act
        formulaire.setEpreuve(epreuve);

        // Assert
        assertEquals(epreuve, formulaire.getEpreuve());
    }
    /**
     * Teste le toString.
     */
    @Test
    void testToString() {
        // Arrange
        Formulaire formulaire = new Formulaire();

        // Act
        String txt = formulaire.toString();

        // Assert
        assertTrue(txt.contains("eseo.principal.Formulaire"));
        assertTrue(txt.contains("id="));
        assertTrue(txt.contains("dateCreation"));
        assertTrue(txt.contains("dateModification"));
    }
}