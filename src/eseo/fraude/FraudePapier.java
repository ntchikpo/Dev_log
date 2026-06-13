import java.time.LocalDate;

public class FraudePapier extends Fraude {

    private double largeur;
    private double longueur;
    private boolean estPlie;

    public FraudePapier() {}

    public FraudePapier(LocalDate dateReleve, String description, String contenu, double largeur, double longueur, boolean estPlie) {
        super(dateReleve, description, contenu);
        this.largeur = largeur;
        this.longueur = longueur;
        this.estPlie = estPlie;
    }

    public double getLargeur() {
        return largeur;
    }
    public void setLargeur(double largeur) {
        this.largeur = largeur;
    }

    public double getLongueur() {
        return longueur;
    }
    public void setLongueur(double longueur) {
        this.longueur = longueur;
    }

    public boolean isEstPlie() {
        return estPlie;
    }
    public void setEstPlie(boolean estPlie) {
        this.estPlie = estPlie;
    }

    @Override
    public String toString() {
        return "FraudePapier{" + super.toString() +
                ", largeur=" + largeur +
                ", longueur=" + longueur +
                ", estPlie=" + estPlie +
                '}';
    }
}