import eseo.fraude.enumeration.Modalite;
import eseo.principal.Epreuve;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.time.LocalTime;

import static org.junit.jupiter.api.Assertions.*;
/**
 * Tests unitaires de la classe Epreuve.
 */
class EpreuveTest {
    /**
     * Teste le constructeur complet.
     */
    @Test
    void testConstructeurComplet() {
        // Arrange & Act
        Epreuve epreuve = new Epreuve("MATH101", LocalDate.of(2026, 5, 10), LocalTime.of(9, 0), 2.0f, Modalite.EXAMEN_ECRIT
        );

        // Assert
        assertEquals("MATH101", epreuve.getCodeECUE());
        assertEquals(LocalDate.of(2026, 5, 10), epreuve.getDatePassage());
        assertEquals(LocalTime.of(9, 0), epreuve.getHeure());
        assertEquals(2.0f, epreuve.getDuree());
        assertEquals(Modalite.EXAMEN_ECRIT, epreuve.getModalite());
    }
    /**
     * Teste le constructeur vide et les setters.
     */
    @Test
    void testConstructeurVide() {
        // Arrange
        Epreuve epreuve = new Epreuve();

        // Act
        epreuve.setCodeECUE("INFO202");
        epreuve.setDatePassage(LocalDate.of(2026, 5, 12));
        epreuve.setHeure(LocalTime.of(14, 0));
        epreuve.setDuree(1.5f);
        epreuve.setModalite(Modalite.QCM);

        // Assert
        assertEquals("INFO202", epreuve.getCodeECUE());
        assertEquals(LocalDate.of(2026, 5, 12), epreuve.getDatePassage());
        assertEquals(LocalTime.of(14, 0), epreuve.getHeure());
        assertEquals(1.5f, epreuve.getDuree());
        assertEquals(Modalite.QCM, epreuve.getModalite());
    }
    /**
     * Teste les setters.
     */
    @Test
    void testSetters() {
        // Arrange
        Epreuve epreuve = new Epreuve("OLD", LocalDate.of(2026, 1, 1), LocalTime.of(8, 0), 1.0f, Modalite.ORAL
        );

        // Act
        epreuve.setCodeECUE("PROJ303");
        epreuve.setDatePassage(LocalDate.of(2026, 6, 1));
        epreuve.setHeure(LocalTime.of(10, 30));
        epreuve.setDuree(3.0f);
        epreuve.setModalite(Modalite.PROJET);

        // Assert
        assertEquals("PROJ303", epreuve.getCodeECUE());
        assertEquals(LocalDate.of(2026, 6, 1), epreuve.getDatePassage());
        assertEquals(LocalTime.of(10, 30), epreuve.getHeure());
        assertEquals(3.0f, epreuve.getDuree());
        assertEquals(Modalite.PROJET, epreuve.getModalite());
    }
    /**
     * Teste le toString.
     */
    @Test
    void testToString() {
        // Arrange
        Epreuve epreuve = new Epreuve("JAVA101", LocalDate.of(2026, 5, 20), LocalTime.of(13, 30), 2.5f, Modalite.SUR_ORDINATEUR);

        // Act
        String resultat = epreuve.toString();

        // Assert
        assertTrue(resultat.contains("JAVA101"));
        assertTrue(resultat.contains("2026-05-20"));
        assertTrue(resultat.contains("13:30"));
        assertTrue(resultat.contains("2.5"));
        assertTrue(resultat.contains("SUR_ORDINATEUR"));
    }
}