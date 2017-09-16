package figura;

public class Circulo {
	
	private double radio;
	private Punto centro;
	
	public Circulo() {
		this.centro = new Punto(0,0);
		this.radio=0;
	}
	
	public Circulo(double x, double y, double radio) {
		this.centro = new Punto(x,y);
		this.radio = radio;
	}
	

	public boolean estaAdentro(Punto p) {
		return p.distanciaCon(this.centro) <= this.radio;
	}
	
	public boolean intersectaCon(Circulo that) {
		return this.centro.distanciaCon(that.centro)<=(this.radio+that.radio);
	}
	
	//TODO
	public boolean intersectaCon(Rectangulo that) {
		Rectangulo rec = generarRec(this);
		
		if(rec.intersectaCon(that) && ) {
			
		}
		else
			return false;
	}
	
	public Rectangulo generarRec (Circulo that) {
		
		double x1 = that.centro.x - that.radio;
		double y1 = that.centro.y + that.radio;
		
		Punto p1 = new Punto(x1,y1);
		
		double x2 = that.centro.x + that.radio;
		double y2 = that.centro.y - that.radio;
		
		Punto p2 = new Punto(x2,y2);
		Rectangulo rec = new Rectangulo(p1,p2);
		return rec;
	}
	
}
