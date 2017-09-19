package figura;

public class Triangulo extends Figura{
    


	@Override
	public boolean intersectaCon(Figura figura) {
 
		
		if(figura.getClass() == this.getClass())
			return intersectaConTri((Triangulo) figura);
			
		
			
		
		return false;
	}

	@Override
	public double area() {
		return (this.getBase()*this.getAltura())/2;
	}

	@Override
	public double perimetro() {
		return this.getPunto1().distanciaCon(this.getPunto2())+ this.getPunto1().distanciaCon(this.getPunto3())+
			   this.getPunto2().distanciaCon(this.getPunto3());
	}
    
	public boolean intersectaConTri(Triangulo tri){
		
	return true;
	}
	public boolean intersectaConRect(Triangulo tri){
		
		return true;
	}
	public boolean intersectaConCirc(Triangulo tri){
	
	return true;
	}
	public double getBase(){
		
		return this.getPunto2().distanciaCon(this.getPunto3());
	}
	
	public double getAltura(){
		return this.getPunto1().distanciaCon(new Punto(this.getPunto1().getX(), this.getPunto2().getY()));
	}
	
	public boolean esEquilatero(){
		
		if(this.getPunto1().distanciaCon(this.getPunto2())!=this.getPunto1().distanciaCon(this.getPunto3()))
		return false;
		if(this.getPunto1().distanciaCon(this.getPunto2())!=this.getPunto3().distanciaCon(this.getPunto2()))
		return false;
		if(this.getPunto1().distanciaCon(this.getPunto3())!=this.getPunto3().distanciaCon(this.getPunto2()))
		return false;
		
		return true;
	}
	
	public boolean esIsosceles(){
		
		if(this.getPunto1().distanciaCon(this.getPunto2())==this.getPunto1().distanciaCon(this.getPunto3()))
		return true;
		if(this.getPunto1().distanciaCon(this.getPunto2())==this.getPunto3().distanciaCon(this.getPunto2()))
		return true;
		if(this.getPunto1().distanciaCon(this.getPunto3())==this.getPunto3().distanciaCon(this.getPunto2()))
		return true;
		
		return false;
	}
	
	@Override
	public String toString() {
		return "Triangulo [punto1=" + punto1 + ", punto2=" + punto2 + ", punto3=" + punto3 + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((punto1 == null) ? 0 : punto1.hashCode());
		result = prime * result + ((punto2 == null) ? 0 : punto2.hashCode());
		result = prime * result + ((punto3 == null) ? 0 : punto3.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Triangulo other = (Triangulo) obj;
		if (punto1 == null) {
			if (other.punto1 != null)
				return false;
		} else if (!punto1.equals(other.punto1))
			return false;
		if (punto2 == null) {
			if (other.punto2 != null)
				return false;
		} else if (!punto2.equals(other.punto2))
			return false;
		if (punto3 == null) {
			if (other.punto3 != null)
				return false;
		} else if (!punto3.equals(other.punto3))
			return false;
		return true;
	}

	public Triangulo(Punto punto1, Punto punto2, Punto punto3) {
		super();
		this.punto1 = punto1;
		this.punto2 = punto2;
		this.punto3 = punto3;
	}
	
	public Triangulo(){
	this(new Punto(0,0),new Punto(0,0),new Punto(0,0));
	}

	public Punto getPunto1() {
		return punto1;
	}

	public void setPunto1(Punto punto1) {
		this.punto1 = punto1;
	}

	public Punto getPunto2() {
		return punto2;
	}

	public void setPunto2(Punto punto2) {
		this.punto2 = punto2;
	}

	public Punto getPunto3() {
		return punto3;
	}

	public void setPunto3(Punto punto3) {
		this.punto3 = punto3;
	}


	private Punto punto1;
	private Punto punto2;
	private Punto punto3;

}
