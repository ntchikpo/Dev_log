import eseo.fraude.*;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.*;
/**
 * Tests unitaires des classes de fraude.
 */
class FraudeTest {
    /**
     * Teste le constructeur complet de FraudeIAG.
     */
    @Test
    void testFraudeIAGConstructeurComplet() {
        // Arrange & Act
        FraudeIAG fraude = new FraudeIAG(LocalDate.of(2026, 5, 10), "Utilisation de ChatGPT", "Réponse générée", "ChatGPT");

        // Assert
        assertEquals(LocalDate.of(2026, 5, 10), fraude.getDateReleve());
        assertEquals("Utilisation de ChatGPT", fraude.getDescription());
        assertEquals("Réponse générée", fraude.getContenu());
        assertEquals("ChatGPT", fraude.getNomService());
    }
    /**
     * Teste les setters de FraudeIAG.
     */
    @Test
    void testFraudeIAGSetters() {
        // Arrange
        FraudeIAG fraude = new FraudeIAG();

        // Act
        fraude.setDateReleve(LocalDate.of(2026, 5, 11));
        fraude.setDescription("Utilisation de Gemini");
        fraude.setContenu("Texte généré");
        fraude.setNomService("Gemini");

        // Assert
        assertEquals(LocalDate.of(2026, 5, 11), fraude.getDateReleve());
        assertEquals("Utilisation de Gemini", fraude.getDescription());
        assertEquals("Texte généré", fraude.getContenu());
        assertEquals("Gemini", fraude.getNomService());
    }
    /**
     * Teste le constructeur complet de FraudeIAGConnectee.
     */
    @Test
    void testFraudeIAGConnecteeConstructeurComplet() {
        // Arrange & Act
        FraudeIAGConnectee fraude = new FraudeIAGConnectee(LocalDate.of(2026, 5, 12), "Utilisation de Gemini en ligne", "Réponse générée en ligne", "Gemini", "192.168.1.1");

        // Assert
        assertEquals(LocalDate.of(2026, 5, 12), fraude.getDateReleve());
        assertEquals("Utilisation de Gemini en ligne", fraude.getDescription());
        assertEquals("Réponse générée en ligne", fraude.getContenu());
        assertEquals("Gemini", fraude.getNomService());
        assertEquals("192.168.1.1", fraude.getAdresseIP());
    }
    /**
     * Teste les setters de FraudeIAGConnectee.
     */
    @Test
    void testFraudeIAGConnecteeSetters() {
        // Arrange
        FraudeIAGConnectee fraude = new FraudeIAGConnectee();

        // Act
        fraude.setDateReleve(LocalDate.of(2026, 5, 13));
        fraude.setDescription("Utilisation IAG connectée");
        fraude.setContenu("Réponse en ligne");
        fraude.setNomService("ChatGPT");
        fraude.setAdresseIP("10.0.0.1");

        // Assert
        assertEquals(LocalDate.of(2026, 5, 13), fraude.getDateReleve());
        assertEquals("Utilisation IAG connectée", fraude.getDescription());
        assertEquals("Réponse en ligne", fraude.getContenu());
        assertEquals("ChatGPT", fraude.getNomService());
        assertEquals("10.0.0.1", fraude.getAdresseIP());
    }
    /**
     * Teste l'héritage de FraudeIAGConnectee.
     */
    @Test
    void testFraudeIAGConnecteeHeritage() {
        // Arrange & Act
        FraudeIAGConnectee fraude = new FraudeIAGConnectee();

        // Assert
        assertTrue(fraude instanceof FraudeIAG);
        assertTrue(fraude instanceof Fraude);
    }
    /**
     * Teste le constructeur complet de FraudePapier.
     */
    @Test
    void testFraudePapierConstructeurComplet() {
        // Arrange & Act
        FraudePapier fraude = new FraudePapier(LocalDate.of(2026, 5, 10), "Antisèche papier", "Formules mathématiques", 10.0, 15.0, true);

        // Assert
        assertEquals(LocalDate.of(2026, 5, 10), fraude.getDateReleve());
        assertEquals("Antisèche papier", fraude.getDescription());
        assertEquals("Formules mathématiques", fraude.getContenu());
        assertEquals(10.0, fraude.getLargeur());
        assertEquals(15.0, fraude.getLongueur());
        assertTrue(fraude.isEstPlie());
    }
    /**
     * Teste les setters de FraudePapier.
     */
    @Test
    void testFraudePapierSetters() {
        // Arrange
        FraudePapier fraude = new FraudePapier();

        // Act
        fraude.setDateReleve(LocalDate.of(2026, 5, 13));
        fraude.setDescription("Document caché");
        fraude.setContenu("Cours résumé");
        fraude.setLargeur(8.0);
        fraude.setLongueur(12.0);
        fraude.setEstPlie(false);

        // Assert
        assertEquals(LocalDate.of(2026, 5, 13), fraude.getDateReleve());
        assertEquals("Document caché", fraude.getDescription());
        assertEquals("Cours résumé", fraude.getContenu());
        assertEquals(8.0, fraude.getLargeur());
        assertEquals(12.0, fraude.getLongueur());
        assertFalse(fraude.isEstPlie());
    }
    /**
     * Teste le constructeur complet de FraudeCalculatrice.
     */
    @Test
    void testFraudeCalculatriceConstructeurComplet() {
        // Arrange & Act
        FraudeCalculatrice fraude = new FraudeCalculatrice(LocalDate.of(2026, 5, 12), "Programme stocké", "Algorithme de tri", "Casio", "TriRapide.py");

        // Assert
        assertEquals(LocalDate.of(2026, 5, 12), fraude.getDateReleve());
        assertEquals("Programme stocké", fraude.getDescription());
        assertEquals("Algorithme de tri", fraude.getContenu());
        assertEquals("Casio", fraude.getMarque());
        assertEquals("TriRapide.py", fraude.getProgrammeStocke());
    }
    /**
     * Teste les setters de FraudeCalculatrice.
     */
    @Test
    void testFraudeCalculatriceSetters() {
        // Arrange
        FraudeCalculatrice fraude = new FraudeCalculatrice();

        // Act
        fraude.setDateReleve(LocalDate.of(2026, 5, 14));
        fraude.setDescription("Calculatrice programmable");
        fraude.setContenu("Formules stockées");
        fraude.setMarque("Texas Instruments");
        fraude.setProgrammeStocke("formules.txt");

        // Assert
        assertEquals(LocalDate.of(2026, 5, 14), fraude.getDateReleve());
        assertEquals("Calculatrice programmable", fraude.getDescription());
        assertEquals("Formules stockées", fraude.getContenu());
        assertEquals("Texas Instruments", fraude.getMarque());
        assertEquals("formules.txt", fraude.getProgrammeStocke());
    }
    /**
     * Teste le polymorphisme des fraudes.
     */
    @Test
    void testPolymorphismeFraude() {
        // Arrange
        Fraude fraude1 = new FraudeIAG(LocalDate.now(), "IA", "Texte IA", "ChatGPT");
        Fraude fraude2 = new FraudePapier(LocalDate.now(), "Papier", "Formules", 10.0, 15.0, true);
        Fraude fraude3 = new FraudeCalculatrice(LocalDate.now(), "Calculatrice", "Programme", "Casio", "prog.py");
        Fraude fraude4 = new FraudeIAGConnectee(LocalDate.now(), "IA connectée", "Texte IA", "Gemini", "192.168.1.1");

        // Assert
        assertTrue(fraude1 instanceof Fraude);
        assertTrue(fraude2 instanceof Fraude);
        assertTrue(fraude3 instanceof Fraude);
        assertTrue(fraude4 instanceof Fraude);

        assertTrue(fraude1 instanceof FraudeIAG);
        assertTrue(fraude2 instanceof FraudePapier);
        assertTrue(fraude3 instanceof FraudeCalculatrice);
        assertTrue(fraude4 instanceof FraudeIAGConnectee);
    }
    /**
     * Teste le toString de FraudeIAG.
     */
    @Test
    void testToStringFraudeIAG() {
        // Arrange
        FraudeIAG fraude = new FraudeIAG(LocalDate.of(2026, 5, 10), "Utilisation IA", "Réponse suspecte", "ChatGPT");

        // Act
        String txt = fraude.toString();

        // Assert
        assertTrue(txt.contains("eseo.fraude.FraudeIAG"));
        assertTrue(txt.contains("2026-05-10"));
        assertTrue(txt.contains("Utilisation IA"));
        assertTrue(txt.contains("Réponse suspecte"));
        assertTrue(txt.contains("ChatGPT"));
    }
    /**
     * Teste le toString de FraudePapier.
     */
    @Test
    void testToStringFraudePapier() {
        // Arrange
        FraudePapier fraude = new FraudePapier(LocalDate.of(2026, 5, 10), "Antisèche papier", "Formules", 10.0, 15.0, true);

        // Act
        String txt = fraude.toString();

        // Assert
        assertTrue(txt.contains("eseo.fraude.FraudePapier"));
        assertTrue(txt.contains("2026-05-10"));
        assertTrue(txt.contains("Antisèche papier"));
        assertTrue(txt.contains("Formules"));
        assertTrue(txt.contains("10.0"));
        assertTrue(txt.contains("15.0"));
        assertTrue(txt.contains("true"));
    }
    /**
     * Teste le toString de FraudeCalculatrice.
     */
    @Test
    void testToStringFraudeCalculatrice() {
        // Arrange
        FraudeCalculatrice fraude = new FraudeCalculatrice(LocalDate.of(2026, 5, 12), "Programme stocké", "Algorithme", "Casio", "TriRapide.py");

        // Act
        String txt = fraude.toString();

        // Assert
        assertTrue(txt.contains("eseo.fraude.FraudeCalculatrice"));
        assertTrue(txt.contains("2026-05-12"));
        assertTrue(txt.contains("Programme stocké"));
        assertTrue(txt.contains("Algorithme"));
        assertTrue(txt.contains("Casio"));
        assertTrue(txt.contains("TriRapide.py"));
    }
    /**
     * Teste le toString de FraudeIAGConnectee.
     */
    @Test
    void testToStringFraudeIAGConnectee() {
        // Arrange
        FraudeIAGConnectee fraude = new FraudeIAGConnectee(LocalDate.of(2026, 5, 12), "Utilisation Gemini", "Réponse générée", "Gemini", "192.168.1.1");

        // Act
        String txt = fraude.toString();

        // Assert
        assertTrue(txt.contains("eseo.fraude.FraudeIAGConnectee"));
        assertTrue(txt.contains("2026-05-12"));
        assertTrue(txt.contains("Utilisation Gemini"));
        assertTrue(txt.contains("Réponse générée"));
        assertTrue(txt.contains("Gemini"));
        assertTrue(txt.contains("192.168.1.1"));
    }
}