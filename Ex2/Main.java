import java.util.ArrayList;
import java.util.Scanner;
import java.io.IOException;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ArrayList<Comanda> comandes = new ArrayList<>();

        try {
            comandes = GestorFitxer.llegirFitxer("comandes.txt");
        } catch (IOException e) {
            System.out.println("Error llegint el fitxer: " + e.getMessage());
        }

        int opcio;
        do {
            System.out.println("1. Mostrar comandes");
            System.out.println("2. Modificar una comanda");
            System.out.println("3. Afegir una línia comanda");
            System.out.println("4. Eliminar una línia comanda");
            System.out.println("5. Modificar una línia comanda");
            System.out.println("0. Sortir");
            opcio = scanner.nextInt();
            scanner.nextLine();  

            switch (opcio) {
                case 1:
                    comandes.forEach(System.out::println);
                    break;
                case 2:
                    System.out.print("Introduïu el codi de la comanda a modificar: ");
                    String idComanda = scanner.nextLine();
                    Comanda comanda = trobarComanda(idComanda, comandes);
                    if (comanda != null) {
                        System.out.print("Introduïu el codi de l'article a modificar: ");
                        String codiArticle = scanner.nextLine();
                        System.out.print("Introduïu la nova quantitat: ");
                        int novaQuantitat = scanner.nextInt();
                        comanda.modificarQuantitat(codiArticle, novaQuantitat);
                    } else {
                        System.out.println("Comanda no trobada!");
                    }
                    break;
                case 3:
                    System.out.print("Introduïu el codi de la comanda on afegir l'article: ");
                    idComanda = scanner.nextLine();
                    comanda = trobarComanda(idComanda, comandes);
                    if (comanda != null) {
                        System.out.print("Introduïu el codi de l'article: ");
                        String codi = scanner.nextLine();
                        System.out.print("Introduïu el nom de l'article: ");
                        String nom = scanner.nextLine();
                        System.out.print("Introduïu la quantitat: ");
                        int quantitat = scanner.nextInt();
                        System.out.print("Introduïu el preu unitari: ");
                        double preu = scanner.nextDouble();
                        Article article = new Article(codi, nom, quantitat, preu);
                        comanda.afegirArticle(article);
                    } else {
                        System.out.println("Comanda no trobada!");
                    }
                    break;
                case 4:
                    System.out.print("Introduïu el codi de la comanda on eliminar l'article: ");
                    idComanda = scanner.nextLine();
                    comanda = trobarComanda(idComanda, comandes);
                    if (comanda != null) {
                        System.out.print("Introduïu el codi de l'article a eliminar: ");
                        String codiEliminar = scanner.nextLine();
                        comanda.eliminarArticle(codiEliminar);
                    } else {
                        System.out.println("Comanda no trobada!");
                    }
                    break;
                case 5:
                    System.out.print("Introduïu el codi de la comanda on modificar l'article: ");
                    idComanda = scanner.nextLine();
                    comanda = trobarComanda(idComanda, comandes);
                    if (comanda != null) {
                        System.out.print("Introduïu el codi de l'article a modificar: ");
                        String codiModificar = scanner.nextLine();
                        System.out.print("Introduïu la nova quantitat: ");
                        int novaQuantitat = scanner.nextInt();
                        comanda.modificarQuantitat(codiModificar, novaQuantitat);
                    } else {
                        System.out.println("Comanda no trobada!");
                    }
                    break;
                case 0:
                    System.out.println("Sortint...");
                    break;
                default:
                    System.out.println("Opció no vàlida!");
            }
        } while (opcio != 0);

        try {
            GestorFitxer.escriureFitxer("comandes.txt", comandes);
        } catch (IOException e) {
            System.out.println("Error escrivint el fitxer: " + e.getMessage());
        }
    }

    private static Comanda trobarComanda(String id, ArrayList<Comanda> comandes) {
        for (Comanda comanda : comandes) {
            if (comanda.toString().contains(id)) {  
                return comanda;
            }
        }
        return null;
    }
}
