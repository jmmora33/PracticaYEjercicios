package acorrer;

public class Categoria {

	private int id;
	private int min,max;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getMin() {
		return min;
	}
	public void setMin(int min) {
		this.min = min;
	}
	public int getMax() {
		return max;
	}
	public void setMax(int max) {
		this.max = max;
	}
	
	
	public Categoria(int id, int min, int max) {
		this.id = id;
		this.min = min;
		this.max = max;
	}
	
	public boolean pertenece (int edad) {
		return edad>=min && edad<=max;
	}
}
