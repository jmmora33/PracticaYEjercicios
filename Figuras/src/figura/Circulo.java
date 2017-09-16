package figura;

public class Circulo {
	
	
	

	public boolean estaAdentro(Punto p) {
		return p.distanciaCon(this.centro) <= this.radio;
	}
	
	public boolean intersectaCon(Circulo that) {
		return this.centro.distanciaCon(that.centro)<=(this.radio+that.radio);
	}
	
	//TODO
	public boolean intersectaCon(Rectangulo that) {
		
//		return (that.getV2().getDistanciaY(that.getV2().getY())- this.getCentro().getY() <= this.getRadio() && that.getV2().getDistanciaX(that.getV1().getX()) -this.getCentro().getY() <= this.getRadio()) ||
//			(that.getV1().getDistanciaY(that.getV2().getY()) - this.getCentro().getY() <= this.getRadio() && that.getV1().getDistanciaX(that.getV1().getX()) -this.getCentro().getY() <= this.getRadio());
//	
		
		
		return true; 
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

	
	public double getRadio() {
		return radio;
	}

	public void setRadio(double radio) {
		this.radio = radio;
	}

	public Punto getCentro() {
		return centro;
	}

	public void setCentro(Punto centro) {
		this.centro = centro;
	}
	
	public Circulo() {
		this.centro = new Punto(0,0);
		this.radio=0;
	}
	
	public Circulo(double x, double y, double radio) {
		this.centro = new Punto(x,y);
		this.radio = radio;
	}
	private double radio;
	private Punto centro;
	
}
