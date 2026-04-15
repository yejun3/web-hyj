package ex1_generic;

public class AnnimalHospital<T extends Annimal> { 
	private T animal;
	
	public AnnimalHospital(T annimal) {
		this.animal=annimal;
	}
	public void treat() {
		animal.move();
	}

}
