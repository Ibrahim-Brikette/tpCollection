package tp1;

import java.util.Comparator;

public class NomComparator implements Comparator<Client> {

	@Override
	public int compare(Client o1, Client o2) {
		// TODO Auto-generated method stub
		return o1.getNom().compareTo(o2.getNom());
	}
	

}
