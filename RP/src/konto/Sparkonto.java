package konto;

public class Sparkonto extends Konto {

	public Sparkonto(double kontostand, double kreditlimit, double zinssatz) {
		super(kontostand, kreditlimit, zinssatz);
		kreditlimit = 0;
	}

}
