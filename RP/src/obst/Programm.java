package obst;

public class Programm {

	public static void main(String[] args) {
		Obst banane = new Banane();
		
		System.out.println(banane.toString());
		
		banane.setGewicht(100);
		banane.setReife(true);
		banane.setVitamingehalt(100);
		((Banane)banane).setKruemmung(10);
		
		System.out.println(banane.getName());
		System.out.println(banane.getGewicht());
		System.out.println(banane.isReife());
		System.out.println(banane.getVitamingehalt() + "\n");
		
		Obst apfel = new Apfel();
		apfel.setGewicht(130);
		apfel.setReife(true);
		apfel.setVitamingehalt(100);
		
		System.out.println(apfel.getName());
		System.out.println(apfel.getGewicht());
		System.out.println(banane.isReife());
		System.out.println(banane.getVitamingehalt() + "\n");
		
		Banane bananeNeu = new Banane();
		bananeNeu.setKruemmung(10.5);
		System.out.println(bananeNeu.getName());
		System.out.println(bananeNeu.getKruemmung());
		
		Orange orangeNeu = new Orange(false);
		System.out.println("\n" +orangeNeu.getName());
		System.out.println(orangeNeu.isKerne());
		
		Obstkorb koerbchen = new Obstkorb();
		koerbchen.hinzufuegen(bananeNeu);
		koerbchen.hinzufuegen(apfel);
		koerbchen.hinzufuegen(orangeNeu);
		System.out.println(koerbchen.getAnzahl());
		System.out.println(koerbchen.getInhalt());
		
		System.out.println("\n" +orangeNeu.toString());
		
		
		}
	

}
