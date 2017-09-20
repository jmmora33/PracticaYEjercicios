package figura;

public class Circulo extends Figura{
	

	public boolean estaAdentro(Punto p) {
		return p.distanciaCon(this.centro) <= this.radio;
	}
	
	
	public boolean estaContenido(Rectangulo that){
		
		return this.getCentro().getX() <= that.getV2().getX() && this.getCentro().getX() >= that.getV1().getX()
				&& this.getCentro().getY() >= that.getV2().getY() && this.getCentro().getY() <= that.getV1().getY();
	}
	
	private boolean intersectaConRec(Rectangulo that) {
		
			return this.estaAdentro(that.getV1()) || this.estaAdentro(that.getV2()) || 
				   this.estaAdentro(that.getPunto3())|| this.estaAdentro(that.getPunto4()) || this.estaContenido(that); 
	}
	private boolean intersectaConCir(Circulo that) {
		return this.centro.distanciaCon(that.centro)<=(this.radio+that.radio);
	}
	private boolean intersectaConTri(Triangulo tri){
		System.out.println("Soy un triangulo");
		return true;
	}
	@Override
	public boolean intersectaCon(Figura figura) {

		if(figura.getClass() == this.getClass())
			return intersectaConCir((Circulo)figura);
		
		if(figura.getClass() == Triangulo.class)
			return intersectaConTri((Triangulo)figura);
		
		if(figura.getClass() == Rectangulo.class)
			return intersectaConRec((Rectangulo)figura);
		
		return false;
	}

	@Override
	public double area() {
		return Math.PI * Math.pow(radio, 2);
	}

	@Override
	public double perimetro() {
		
		return  2*Math.PI*radio;
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
