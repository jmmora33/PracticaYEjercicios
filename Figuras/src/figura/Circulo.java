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
		
		Punto puntoN = new Punto(this.getCentro().getX(),this.getCentro().getY() +radio);
		Punto puntoS = new Punto(this.getCentro().getX(),this.getCentro().getY() -radio);
		Punto puntoE = new Punto(this.getCentro().getX() + radio,this.getCentro().getY());
		Punto puntoO = new Punto(this.getCentro().getX() - radio,this.getCentro().getY() );
//		return (that.getV2().getDistanciaY(that.getV2().getY())- this.getCentro().getY() <= this.getRadio() && that.getV2().getDistanciaX(that.getV1().getX()) -this.getCentro().getY() <= this.getRadio()) ||
//			(that.getV1().getDistanciaY(that.getV2().getY()) - this.getCentro().getY() <= this.getRadio() && that.getV1().getDistanciaX(that.getV1().getX()) -this.getCentro().getY() <= this.getRadio());
//	PARA ESTE Y OESTE
		if(this.getCentro().getX() <= that.getV2().getX() && this.getCentro().getX() >= that.getV1().getX() &&
				this.getCentro().getY() >= that.getV2().getY() && this.getCentro().getY() <= that.getV1().getY()	)	
				return true ;  
		
		return false;		
				
	}
	public boolean esMenor(Punto p1, Punto p2, int distancia) {
		
		
		return p1.getDistanciaX(p2.getX()) <= distancia && p1.getDistanciaY(p2.getY()) <= distancia;
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
