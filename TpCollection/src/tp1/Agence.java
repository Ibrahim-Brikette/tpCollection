package tp1;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;

public class Agence { 
	private String nom; 
	private ListeVoitures vs=new ListeVoitures();
	
	private Map<Client, ListeVoitures> ClientVoitureLoue=new HashMap<Client, ListeVoitures>(); 
	public Agence(String nom) {
		this.nom=nom;
	}
	public String getNom() { 
		return nom;
		
	
	}
	
	public void setNom(String nom) { 
		this.nom = nom;
	
	
	}
	public void ajoutVoiture(Voiture v) throws VoitureException{
	
		vs.ajoutVoiture(v);
	}
	public void suppVoiture(Voiture v)throws VoitureException{
	
		vs.supprimeVoiture(v);
	}
	
	public void loueClientVoiture(Client cl, Voiture v) throws VoitureException{
		if(!ClientVoitureLoue.containsKey(cl)) {
			ListeVoitures vCl=new ListeVoitures();
			vCl.ajoutVoiture(v);
			ClientVoitureLoue.put(cl, vCl);
		}
		else {
			ListeVoitures vCl=ClientVoitureLoue.get(cl);
			if (vCl.exist(v)) throw  new VoitureException(" impossible de loue la meme voiture deux fois en meme temps");
			vCl.ajoutVoiture(v);
		}
	
	}
	
	
	
	public void retourClientVoiture(Client cl , Voiture v) throws VoitureException{
	
	
	}
	public void setListeVoiture(ListeVoitures vs) {
		this.vs=vs;
	}
	public List<Voiture> selectVoitureSelonCritere(Critere c) { 
		List<Voiture> vCritere= new ArrayList<Voiture>();
		for(Map.Entry<Client,ListeVoitures> entry: ClientVoitureLoue.entrySet()) {
			ListeVoitures voitureValue=entry.getValue();
			Iterator<Voiture> it=voitureValue.iterateur();
			while(it.hasNext()) {
				Voiture v=it.next();
				if(c.estSatisfaitPar(v)) vCritere.add(v);
			}
		}
		return vCritere;
	}
	public Set<Client> ensembleClientsLoueurs(){ 
		Set<Client> loueurs=new HashSet<Client>();
		for(Map.Entry<Client,ListeVoitures> entry: ClientVoitureLoue.entrySet()) {
			if(entry.getValue()!=null) loueurs.add(entry.getKey());
		}
		return loueurs;
	
	
	}
	public Collection<ListeVoitures> collectionVoituresLouees() { 
		return ClientVoitureLoue.values();
	
	}
	public void afficheLesClientsEtLeursListesVoitures(){ 
		for(Map.Entry<Client,ListeVoitures> entry : ClientVoitureLoue.entrySet()) {
			System.out.println(entry.getKey().toString());
			System.out.println("les Voitues loué sont:   ");
			entry.getValue().affiche();
			System.out.println("---------------------------------------------------------------------");
		}
	 
	}
	
	public Map<Client, ListeVoitures> triCodeCroissant(){ 
		TreeMap<Client,ListeVoitures> mapTree= new TreeMap<>(new CodeComparator());
		mapTree.putAll(ClientVoitureLoue);
		return mapTree;
	  
	
	}
	public static void afficheMap(Map<Client,ListeVoitures> affMap) {
		for(Map.Entry<Client,ListeVoitures> entry : affMap.entrySet()) {
			System.out.println(entry.getKey().toString());
			System.out.println("les Voitues loué sont");
			entry.getValue().affiche();
			System.out.println("---------------------------------------------------------------------");
		}
		
	}
	public Map<Client, ListeVoitures> triNomCroissant(){ 
		TreeMap<Client,ListeVoitures> mapTree= new TreeMap<>(new NomComparator());
		mapTree.putAll(ClientVoitureLoue);
		return mapTree;
	} 
	public static void main(String[] args) {
		Voiture v1=new Voiture(001,"Ferrari SF",20000);
		Voiture v2=new Voiture(002,"Ferrari Peurosangui",50000);
		Voiture v3=new Voiture(003,"Aston Martin Valkery ",1000000);
		Voiture v4=new Voiture (004,"Ferrari Spider",60000);
		ListeVoitures parking=new ListeVoitures();
		Agence agence=new Agence("SuperCarRentals");
		Client c1=new Client(111,"ibra","brikette");
		Client c2=new Client(112,"ahmed","bn");
		Client c3=new Client(110,"omar","brikette");
		Client c4=new Client(109,"slouma","brikette");
		try {
			parking.ajoutVoiture(v1);
			parking.ajoutVoiture(v2);
			parking.ajoutVoiture(v3);
			parking.ajoutVoiture(v4);
			agence.setListeVoiture(parking);
			
			agence.loueClientVoiture(c1, v4);
			agence.loueClientVoiture(c1, v3);
			agence.loueClientVoiture(c2,v1);
			agence.loueClientVoiture(c3,v2);
			agence.afficheLesClientsEtLeursListesVoitures();
			
			//faux
			//ArrayList<ListeVoitures> voi= (ArrayList<ListeVoitures>) agence.collectionVoituresLouees();
			ArrayList<ListeVoitures> voi=new ArrayList<>(agence.collectionVoituresLouees());
			Iterator<ListeVoitures> it=voi.iterator();
			while(it.hasNext()) {
				ListeVoitures lv=it.next();
				lv.affiche();
				System.out.println("----------------------------");
			}
			System.out.println("tri selon le Code");
			Agence.afficheMap(agence.triCodeCroissant());
			System.out.println("tri selon le Nom");
			Agence.afficheMap(agence.triNomCroissant());
			
			
			
		}
		catch(VoitureException e ) {
			System.out.println(e.getMessage());
		}
	}
}
