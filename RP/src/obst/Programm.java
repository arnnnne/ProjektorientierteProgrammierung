package obst;

public class Programm {

	public static void main(String[] args) {
		Obst banane = new Obst("Banane");
		banane.setGewicht(100);
		banane.setReife(true);
		banane.setVitamingehalt(100);
		
		System.out.println(banane.getName());
		System.out.println(banane.getGewicht());
		System.out.println(banane.isReife());
		System.out.println(banane.getVitamingehalt() + "\n");
		
		Obst apfel = new Obst("Apfel");
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
		
		Orange orangeNeu = new Orange();
		orangeNeu.setKerne(true);
		System.out.println("\n" +orangeNeu.getName());
		System.out.println(orangeNeu.isKerne());
		}
	

}
