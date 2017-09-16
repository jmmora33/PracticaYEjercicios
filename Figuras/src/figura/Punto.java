package figura;

public  class Punto {

	protected double x;
	protected double y;
	
	
	
	public Punto(double x, double y) {
		this.x = x;
		this.y = y;
	}
	public double getX() {
		return x;
	}
	public void setX(double x) {
		this.x = x;
	}
	public double getY() {
		return y;
	}
	public void setY(double y) {
		this.y = y;
	}
	
	public double getDistanciaX(double valor) {
		
		return Math.abs(this.getX()-valor);
	}
	
	public double getDistanciaY(double valor) {
		
		return Math.abs(this.getY()-valor);
	}
	
	public double distanciaCon(Punto that) {
		return Math.sqrt(Math.pow(this.x-that.x, 2)+Math.pow(this.y-that.y, 2));
	}
//	
//	public  boolean intersectaCon(Punto that) {
//		
//	}
//	
//	public  double distanciaEntreCentros(Punto that);
	
	
}
