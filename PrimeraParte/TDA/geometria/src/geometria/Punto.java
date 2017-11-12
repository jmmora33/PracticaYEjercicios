package geometria;

public class Punto {
	public double x;

	public double y;

	public Punto(double x, double y) {
		this.x = x;
		this.y = y;
	}
	
	public double distanciaCon (final Punto that){
		return (Math.sqrt(	Math.pow(this.x - that.x, 2) +
							Math.pow(this.y - that.y, 2))
				);
	}
}
