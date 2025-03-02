package tp1;

public class VoitureException extends Exception{
	
	private String m;
	public VoitureException() {}
	public VoitureException(String m) {
		this.m=m;
	}
	@Override
	public String getMessage() {
		// TODO Auto-generated method stub
		return m;
	}
	
	
	
}
