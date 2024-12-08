import java.io.*;
import java.util.ArrayList;

public class GestorFitxer {
    public static ArrayList<Comanda> llegirFitxer(String nomFitxer) throws IOException {
        ArrayList<Comanda> comandes = new ArrayList<>();
        BufferedReader reader = new BufferedReader(new FileReader(nomFitxer));
        String linia;
        Comanda comandaActual = null;

        while ((linia = reader.readLine()) != null) {
            if (linia.startsWith("Comanda")) {
                if (comandaActual != null) comandes.add(comandaActual);
                String[] parts = linia.split("\\.");
                comandaActual = new Comanda(parts[0]);
            } else if (linia.startsWith("art")) {
                String[] parts = linia.split("\\.");
                Article article = new Article(parts[0], parts[1], Integer.parseInt(parts[2]), Double.parseDouble(parts[3]));
                if (comandaActual != null) comandaActual.afegirArticle(article);
            }
        }
        if (comandaActual != null) comandes.add(comandaActual);
        reader.close();
        return comandes;
    }

    public static void escriureFitxer(String nomFitxer, ArrayList<Comanda> comandes) throws IOException {
        BufferedWriter writer = new BufferedWriter(new FileWriter(nomFitxer));
        for (Comanda comanda : comandes) {
            writer.write(comanda.toString());
            writer.newLine();
            for (Article article : comanda.getArticles()) {
                writer.write(article.toString());
                writer.newLine();
            }
        }
        writer.close();
    }
}
