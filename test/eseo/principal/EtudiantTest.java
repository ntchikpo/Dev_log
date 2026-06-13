import eseo.fraude.enumeration.Cursus;
import eseo.principal.Etudiant;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
/**
 * Tests unitaires de la classe Etudiant.
 */
class EtudiantTest {
    /**
     * Teste le constructeur complet.
     */
    @Test
    void testConstructeurComplet() {
        // Arrange & Act
        Etudiant etudiant = new Etudiant(
                "001",
                "Dupont",
                "Alice",
                Cursus.E1
        );

        // Assert
        assertEquals("001", etudiant.getNumeroApprenant());
        assertEquals("Dupont", etudiant.getNom());
        assertEquals("Alice", etudiant.getPrenom());
        assertEquals(Cursus.E1, etudiant.getCursus());
    }
    /**
     * Teste le constructeur vide et les setters.
     */
    @Test
    void testConstructeurVide() {
        // Arrange
        Etudiant etudiant = new Etudiant();

        // Act
        etudiant.setNumeroApprenant("002");
        etudiant.setNom("Martin");
        etudiant.setPrenom("Bob");
        etudiant.setCursus(Cursus.E2);

        // Assert
        assertEquals("002", etudiant.getNumeroApprenant());
        assertEquals("Martin", etudiant.getNom());
        assertEquals("Bob", etudiant.getPrenom());
        assertEquals(Cursus.E2, etudiant.getCursus());
    }
    /**
     * Teste les setters.
     */
    @Test
    void testSetters() {
        // Arrange
        Etudiant etudiant = new Etudiant("000", "AncienNom", "AncienPrenom",
                Cursus.E1
        );

        // Act
        etudiant.setNumeroApprenant("003");
        etudiant.setNom("Bernard");
        etudiant.setPrenom("Clara");
        etudiant.setCursus(Cursus.E3E);

        // Assert
        assertEquals("003", etudiant.getNumeroApprenant());
        assertEquals("Bernard", etudiant.getNom());
        assertEquals("Clara", etudiant.getPrenom());
        assertEquals(Cursus.E3E, etudiant.getCursus());
    }
    /**
     * Teste le toString.
     */
    @Test
    void testToString() {
        // Arrange
        Etudiant etudiant = new Etudiant("004", "Durand", "David", Cursus.E4
        );

        // Act
        String resultat = etudiant.toString();

        // Assert
        assertTrue(resultat.contains("004"));
        assertTrue(resultat.contains("Durand"));
        assertTrue(resultat.contains("David"));
        assertTrue(resultat.contains("E4"));
    }
}