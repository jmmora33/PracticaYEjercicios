package geometria;

public class Circulo {
	private double radio;
	private Punto centro;
	
	public Circulo(double radio, Punto centro) {
		this.radio = radio;
		this.centro = centro;
	}
	
	public boolean estaAdentro(Punto p){
		
		return (p.distanciaCon(this.centro) <= this.radio);
		
	}
	
	public boolean insertaCon(Circulo that){
		return this.centro.distanciaCon(that.centro) <= (this.radio + that.radio);
	}
}
