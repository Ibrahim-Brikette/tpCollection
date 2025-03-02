package tp1;

import java.util.Objects;

public class CritereMarque implements Critere {
	private String marque;
	public CritereMarque(String marque) { 
	this.marque = marque;}
	public boolean estSatisfaitPar(Voiture v) { 
		return Objects.equals(marque, v.getMarque());
	} 
}
