import java.time.LocalDate;

public class FraudeCalculatrice extends Fraude {

    private String marque;
    private String programmeStocke;

    public FraudeCalculatrice() {}

    public FraudeCalculatrice(LocalDate dateReleve, String description, String contenu, String marque, String programmeStocke) {
        super(dateReleve, description, contenu);
        this.marque = marque;
        this.programmeStocke = programmeStocke;
    }

    public String getMarque() {
        return marque;
    }
    public void setMarque(String marque) {
        this.marque = marque;
    }

    public String getProgrammeStocke() {
        return programmeStocke;
    }
    public void setProgrammeStocke(String programmeStocke) {
        this.programmeStocke = programmeStocke;
    }

    @Override
    public String toString() {
        return "FraudeCalculatrice{" + super.toString() +
                ", marque='" + marque + '\'' +
                ", programmeStocke='" + programmeStocke + '\'' +
                '}';
    }
}