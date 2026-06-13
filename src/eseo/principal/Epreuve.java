import java.time.LocalDate;
import java.time.LocalTime;

public class Epreuve {

    private String codeECUE;
    private LocalDate datePassage;
    private LocalTime heure;
    private float duree;
    private Modalite modalite;

    public Epreuve() {}

    public Epreuve(String codeECUE, LocalDate datePassage, LocalTime heure, float duree, Modalite modalite) {
        this.codeECUE = codeECUE;
        this.datePassage = datePassage;
        this.heure = heure;
        this.duree = duree;
        this.modalite = modalite;
    }

    public String getCodeECUE() {
        return codeECUE;
    }
    public void setCodeECUE(String codeECUE) {
        this.codeECUE = codeECUE;
    }

    public LocalDate getDatePassage() {
        return datePassage;
    }
    public void setDatePassage(LocalDate datePassage) {
        this.datePassage = datePassage;
    }

    public LocalTime getHeure() {
        return heure;
    }
    public void setHeure(LocalTime heure) {
        this.heure = heure;
    }

    public float getDuree() {
        return duree;
    }
    public void setDuree(float duree) {
        this.duree = duree;
    }

    public Modalite getModalite() {
        return modalite;
    }
    public void setModalite(Modalite modalite) {
        this.modalite = modalite;
    }

    @Override
    public String toString() {
        return "Epreuve{" +
                "codeECUE='" + codeECUE + '\'' +
                ", datePassage=" + datePassage +
                ", heure=" + heure +
                ", duree=" + duree +
                ", modalite=" + modalite +
                '}';
    }
}