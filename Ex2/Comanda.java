import java.util.ArrayList;

public class Comanda {
    private String id;
    private ArrayList<Article> articles;

    public Comanda(String id) {
        this.id = id;
        this.articles = new ArrayList<>();
    }

    public void afegirArticle(Article article) {
        this.articles.add(article);
    }

    public void eliminarArticle(String codi) {
        articles.removeIf(article -> article.getCodi().equals(codi));
    }

    public void modificarQuantitat(String codi, int novaQuantitat) {
        for (Article article : articles) {
            if (article.getCodi().equals(codi)) {
                article.setQuantitat(novaQuantitat);
                break;
            }
        }
    }

    public double calcularPreuTotal() {
        return articles.stream().mapToDouble(Article::calcularPreuLinia).sum();
    }

    public ArrayList<Article> getArticles() {
        return articles;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Comanda ID: ").append(id).append("\n")
          .append("Preu Total: ").append(calcularPreuTotal()).append(" €\n")
          .append("Articles:\n");
        
        for (Article article : articles) {
            sb.append("\n").append(article);  // Per mostrar cada article detalladament
        }
        return sb.toString();
    }
}
