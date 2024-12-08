public class Article {
    private String codi;
    private String nom;
    private int quantitat;
    private double preuUnitari;

    public Article(String codi, String nom, int quantitat, double preuUnitari) {
        this.codi = codi;
        this.nom = nom;
        this.quantitat = quantitat;
        this.preuUnitari = preuUnitari;
    }

    public double calcularPreuLinia() {
        return this.quantitat * this.preuUnitari;
    }

    public String getCodi() {
        return codi;
    }

    public String getNom() {
        return nom;
    }

    public int getQuantitat() {
        return quantitat;
    }

    public double getPreuUnitari() {
        return preuUnitari;
    }

    public void setQuantitat(int quantitat) {
        this.quantitat = quantitat;
    }

    @Override
    public String toString() {
        return "Codi: " + codi + "\n" +
               "Nom: " + nom + "\n" +
               "Quantitat: " + quantitat + "\n" +
               "Preu Unitari: " + preuUnitari + " $\n" +
               "Preu Línia: " + calcularPreuLinia() + " $\n";
    }
}
