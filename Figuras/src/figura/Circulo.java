package figura;

public class Circulo extends Figura{
	
	
	

	public boolean estaAdentro(Punto p) {
		return p.distanciaCon(this.centro) <= this.radio;
	}
	
	private boolean intersectaConCir(Circulo that) {
		return this.centro.distanciaCon(that.centro)<=(this.radio+that.radio);
	}
	private boolean intersectaConTri(Triangulo tri){
		System.out.println("Soy un triangulo");
		return true;
	}
	
	private boolean intersectaConRec(Rectangulo that) {
		
//		Punto puntoN = new Punto(this.getCentro().getX(),this.getCentro().getY() +radio);
//		Punto puntoS = new Punto(this.getCentro().getX(),this.getCentro().getY() -radio);
//		Punto puntoE = new Punto(this.getCentro().getX() + radio,this.getCentro().getY());
//		Punto puntoO = new Punto(this.getCentro().getX() - radio,this.getCentro().getY() );
//		
	return (that.getV2().getDistanciaY(that.getV2().getY())- this.getCentro().getY() <= this.getRadio() && that.getV2().getDistanciaX(that.getV1().getX()) -this.getCentro().getY() <= this.getRadio()) ||
	(that.getV1().getDistanciaY(that.getV2().getY()) - this.getCentro().getY() <= this.getRadio() && that.getV1().getDistanciaX(that.getV1().getX()) -this.getCentro().getY() <= this.getRadio());


	}
	@Override
	public boolean intersectaCon(Figura figura) {

		if(figura.getClass() == this.getClass())
			return intersectaConCir((Circulo)figura);
		
		if(figura.getClass() == Triangulo.class)
			return intersectaConTri((Triangulo)figura);
		
		return false;
	}

	@Override
	public double area() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public double perimetro() {
		// TODO Auto-generated method stub
		return 0;
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
