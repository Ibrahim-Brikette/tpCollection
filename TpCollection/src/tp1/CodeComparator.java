package tp1;

import java.util.Comparator;

public class CodeComparator implements Comparator<Client>{

	@Override
	public int compare(Client o1, Client o2) {
		// TODO Auto-generated method stub
		return Integer.compare(o1.getCode(), o2.getCode());
	}
	

}
