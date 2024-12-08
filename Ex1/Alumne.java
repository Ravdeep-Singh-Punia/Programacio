import java.util.ArrayList;

public class Alumne {
	
	// Atributs
	private String nom;
	public ArrayList<Modul> modulsMatricula = new ArrayList<>();
	
	// Mètodes Constructor
	public Alumne(String nom) {
		this.nom = nom;
	}
	
	public String getNom() {
		return nom;
	}
	
	public void setNom(String nom) {
		this.nom = nom;
	}
	
	public ArrayList<Modul> getListaModuls() {
		return modulsMatricula;
	}
	
	public void afegirModul(Modul modul) {
		modulsMatricula.add(modul);
	}
	
	public String toString() {
		return "Alumne{" + "nom=" + nom + ", modulsMatricula=" + getListaModuls() + '}';
	}
}
