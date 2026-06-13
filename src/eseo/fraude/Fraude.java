import java.time.LocalDate;

public abstract class Fraude {

    private LocalDate dateReleve;
    private String description;
    private String contenu;

    public Fraude() {}

    public Fraude(LocalDate dateReleve, String description, String contenu) {
        this.dateReleve = dateReleve;
        this.description = description;
        this.contenu = contenu;
    }

    public LocalDate getDateReleve() {
        return dateReleve;
    }
    public void setDateReleve(LocalDate dateReleve) {
        this.dateReleve = dateReleve;
    }

    public String getDescription() {
        return description;
    }
    public void setDescription(String description){
        this.description = description;
    }

    public String getContenu() {
        return contenu;
    }
    public void setContenu(String contenu) {
        this.contenu = contenu;
    }

    @Override
    public String toString() {
        return "dateReleve=" + dateReleve +
                ", description='" + description + '\'' +
                ", contenu='" + contenu + '\'';
    }
}