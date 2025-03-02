package tp1;

import java.util.*;

public class ListeVoitures { 
private List<Voiture> voitures;



public ListeVoitures(List<Voiture> voitures) { 
	if (voitures!=null)
	this.voitures=new ArrayList<Voiture>(voitures);
	else {
		this.voitures=new ArrayList<Voiture>();
	}
}
public ListeVoitures() {
	this.voitures=new ArrayList<Voiture>();
}

public List<Voiture> getVoitures() { 
	return voitures;
}
public void setVoitures(List<Voiture> voitures) {
	ArrayList<Voiture> v=(ArrayList<Voiture>)voitures;	
	this.voitures=v;


}

public void ajoutVoiture(Voiture v) throws VoitureException{
	if(v==null) throw new VoitureException("voiture null c'est impo");
	voitures.add(v);
 }
public void supprimeVoiture(Voiture v) throws VoitureException{ 
	if(v==null) throw new VoitureException("voiture null c'est impo");
	if(voitures.indexOf(v)==-1) throw new VoitureException("comment supprimer une voiture qui n'existe pas ?");
	voitures.remove(v);
}
public Iterator<Voiture> iterateur(){ 
return voitures.iterator();
}
public int size(){ 
return voitures.size();
}
public void affiche(){ 
	
	Iterator<Voiture>i=iterateur();
	//or it can be 
	//Iterator <Voiture> i=voitures.iterator();
	while(i.hasNext()) {
		Voiture v=i.next();
		System.out.println(v.toString());
		
	}
 }
public boolean exist(Voiture v) {
	return(voitures.indexOf(v)!=-1);
}


}