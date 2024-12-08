public class Modul {

    private String codi;
    private String nom;

    // Constructor
    public Modul(String codi, String nom) {
        this.codi = codi;
        this.nom = nom;
    }

    // Mètodes getters
    public String getCodi() {
        return codi;
    }

    public String getNom() {
        return nom;
    }

    // Mètodes setters
    public void setCodi(String codi) {
        this.codi = codi;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    // Mètode toString
    @Override
    public String toString() {
        return "Modul{" + "codi=" + getCodi() + ", nom=" + getNom() + '}';
    }
}
