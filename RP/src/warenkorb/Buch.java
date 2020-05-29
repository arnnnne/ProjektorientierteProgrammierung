package warenkorb;

public class Buch extends Ware{
	
	private String isbn;
	
	public Buch(String warenNr, String bezeichnung, double preis, double mwst, String isbn) {
		super(warenNr, bezeichnung, preis, mwst);
		this.isbn = isbn;
	}

	public String getIsbn() {
		return isbn;
	}

	public void setIsbn(String isbn) {
		this.isbn = isbn;
	}
	
	public String toString() {
		String text = super.toString();
		text = text + "Isbn: " + getIsbn() + "\n";
		return text;
	}
	

}
