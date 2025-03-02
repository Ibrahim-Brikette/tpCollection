package tp1;

import java.util.Objects;

public class Client { 
	private int code; 
	private String nom; 
	private String prenom;
	public Client(int code, String nom, String prenom) {
		this.code=code;
		this.nom=nom;
		this.prenom=prenom;
	}
	public int getCode() { 
		return code;
	}
	public void setCode(int code) { 
		this.code = code;
	}
	public String getNom() { 
		return nom;
	}
	public void setNom(String nom) {
		this.nom = nom;
	}
	public String getPrenom() { 
		return prenom;
	}
	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}
	
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Client other = (Client) obj;
		return code == other.code;
	}
	@Override
	public String toString() {
		return "Client de code=" + code + ", son nom est " + nom + ", son prenom est" + prenom ;
	}
	
	
	
}