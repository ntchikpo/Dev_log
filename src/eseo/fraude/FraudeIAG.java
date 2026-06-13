import java.time.LocalDate;

public class FraudeIAG extends Fraude {

    private String nomService;

    public FraudeIAG() {}

    public FraudeIAG(LocalDate dateReleve, String description, String contenu, String nomService) {
        super(dateReleve, description, contenu);
        this.nomService = nomService;
    }

    public String getNomService() {
        return nomService;
    }
    public void setNomService(String nomService) {
        this.nomService = nomService;
    }

    @Override
    public String toString() {
        return "FraudeIAG{" + super.toString() +
                ", nomService='" + nomService + '\'' +
                '}';
    }
}