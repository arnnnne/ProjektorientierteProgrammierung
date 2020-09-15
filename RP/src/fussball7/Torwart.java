package fussball7;

public class Torwart extends Spieler{
	
	private int reaktion;

	public Torwart(int id, String name, int alter, int staerke, int torschuss, int motivation, int reaktion){
		super(id, name, alter, staerke, torschuss, motivation, 0, 0);
		this.reaktion = reaktion;
		
	}
	
	public int getReaktion() {
		return reaktion;
	}

	public void setReaktion(int reaktion) {
		this.reaktion = reaktion;
	}
	
	@Override
	public String toString() {
		String text;
		text = super.toString();
		text = text + "\nReaktion = " + reaktion;
		return text;
	}
	

	

}
