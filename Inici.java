import java.io.*;
import java.util.*;

public class Inici {

    public static void main(String[] args) {
        menuOpcions();
    }

    // Menú principal
    static void menuOpcions() {
	System.out.println("");
		System.out.println("\t\t<===================== MENU ======================>");
	System.out.println("");
        System.out.println("\t 1. Consultar Alumnes: <");
	System.out.println("");
        System.out.println("\t 2. Consultar Modul: <");
	System.out.println("");
        System.out.println("\t 3. Consultar Alumnes i moduls matriculats: <");
	System.out.println("");
        System.out.println("\t 4. Crear Alumne i desar a fitxer: <");
	System.out.println("");
        System.out.println("\t 5. Crear Modul i desar a fitxer: <");
	System.out.println("");
        System.out.println("\t 6. Afegir Moduls a Alumne: <");
	System.out.println("");
        System.out.println("\t 7. Modificar Alumne: <");
	System.out.println("");
        System.out.println("\t 8. Modificar Modul: <");
	System.out.println("");
        System.out.println("\t 9. Acabar / Sortir: <");
	    System.out.println();
        System.out.println("\t * ESCULL UNA OPCIÓ:....... ");
	System.out.println("");
	   System.out.println("\t\t<==================================================>");
        
        Scanner sc = new Scanner(System.in);
        int opcio = sc.nextInt();
        
        switch (opcio) {
            case 1:
                llistarAlumnes();
                break;
            case 2:
                llistarModuls();
                break;
            case 3:
                llistarAlumnesModuls();
                break;
            case 4:
                crearAlumne();
                break;
            case 5:
                crearModul();
                break;
            case 6:
                afegirModulsAAlumne();
                break;
            case 7:
                modificarAlumne();
                break;
            case 8:
                modificarModul();
                break;
            default:
                System.exit(0);
        }
    }

    // Alumnes
    static void llistarAlumnes() {
        try {
            File myObj = new File("FITXERS_ALUMNES.txt");
            Scanner myReader = new Scanner(myObj);
            
            while (myReader.hasNextLine()) {
                String data = myReader.nextLine();
                Alumne objAlu = new Alumne(data);
                System.out.println(objAlu.toString());
            }
            
            myReader.close();
        } catch (FileNotFoundException e) {
            System.out.println("Error: fitxer no trobat.");
            e.printStackTrace();
        }
    }

    // Mòduls
    static void llistarModuls() {
        try {
            File myObj = new File("FITXERS_MODULS.txt");
            Scanner myReader = new Scanner(myObj);
        
            while (myReader.hasNextLine()) {
                String data = myReader.nextLine();
                String[] myArray = data.split("[.]");
                Modul objModul = new Modul(myArray[0], myArray[1]);
                System.out.println(objModul.toString());
            }
        
            myReader.close();
        } catch (FileNotFoundException e) {
            System.out.println("Error: fitxer no trobat.");
            e.printStackTrace();
        }
    }

    // Alumnes i mòduls matriculats
    static void llistarAlumnesModuls() {
        ArrayList<Alumne> llistaAlumnes = new ArrayList<>();
        try {
            File myObj = new File("FITXERS_ALUMNES_MODULS.txt");
            Scanner myReader = new Scanner(myObj);
            
            while (myReader.hasNextLine()) {
                String data = myReader.nextLine();
                char primera = data.charAt(0);
                
                String[] myArray = data.split("[.]");
                
                if (primera != '0') {
                    Alumne objAlu = new Alumne(myArray[0]);
                    llistaAlumnes.add(objAlu);
                } else {
                    Modul objModul = new Modul(myArray[0], myArray[1]);
                    llistaAlumnes.get(llistaAlumnes.size() - 1).afegirModul(objModul);
                }
            }
            
            myReader.close();
    
            for (Alumne sortida : llistaAlumnes) {
                System.out.println(sortida);
            }
        } catch (FileNotFoundException e) {
            System.out.println("Error: fitxer no trobat.");
            e.printStackTrace();
        }
    }

    // Crear un alumne 
    static void crearAlumne() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Introdueix el nom de l'alumne:");
        String nom = sc.nextLine();
        try (FileWriter writer = new FileWriter("FITXERS_ALUMNES.txt", true)) {
            writer.write(nom + "\n");
            System.out.println("Alumne desat correctament.");
        } catch (IOException e) {
            System.out.println("Error al desar l'alumne.");
            e.printStackTrace();
        }
    }

    // Crear un mòdul 
    static void crearModul() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Introdueix el codi del mòdul:");
        String codi = sc.nextLine();
        System.out.println("Introdueix el nom del mòdul:");
        String nom = sc.nextLine();
        try (FileWriter writer = new FileWriter("FITXERS_MODULS.txt", true)) {
            writer.write(codi + "." + nom + "\n");
            System.out.println("Mòdul desat correctament.");
        } catch (IOException e) {
            System.out.println("Error al desar el mòdul.");
            e.printStackTrace();
        }
    }

    // Afegir mòduls a un alumne
    static void afegirModulsAAlumne() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Introdueix el nom de l'alumne:");
        String alumne = sc.nextLine();
        System.out.println("Introdueix el codi del mòdul:");
        String codiModul = sc.nextLine();
        System.out.println("Introdueix el nom del mòdul:");
        String nomModul = sc.nextLine();

        try (FileWriter writer = new FileWriter("FITXERS_ALUMNES_MODULS.txt", true)) {
            writer.write(alumne + "\n" + codiModul + "." + nomModul + "\n");
            System.out.println("Mòdul afegit a l'alumne correctament.");
        } catch (IOException e) {
            System.out.println("Error al desar el mòdul per l'alumne.");
            e.printStackTrace();
        }
    }

    // Modificar un alumne
    static void modificarAlumne() {
        System.out.println("Funcionalitat pendent d'implementar: Modificar Alumne");
    }

    // Modificar un mòdul
    static void modificarModul() {
        System.out.println("Funcionalitat pendent d'implementar: Modificar Modul");
    }
}
