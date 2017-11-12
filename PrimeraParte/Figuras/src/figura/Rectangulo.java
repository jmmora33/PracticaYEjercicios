package figura;

public class Rectangulo extends Figura {
	
	

	
	@Override
	public boolean intersectaCon(Figura figura) {

		if(this.getClass()  == figura.getClass())
			return intersectaConRec((Rectangulo)figura);
		
		if(figura.getClass() == Triangulo.class)
			return intersectaConTri((Triangulo)figura);
		
		if(figura.getClass() == Circulo.class)
			return intersectaConCir((Circulo)figura);
		
		
		return false;
	}

	@Override
	public double area() {
		
		return Math.pow(this.getV1().distanciaCon(this.getPunto3()),2) +
			   Math.pow(this.getV1().distanciaCon(this.getPunto4()), 2);
	}

	@Override
	public double perimetro() {

		return this.getV1().distanciaCon(this.getPunto3())*2 + this.getV1().distanciaCon(this.getPunto4())*2;
	}
	
	//v1 mas arriba y a la izq, v2 mas abajo y a la derecha
	private boolean intersectaConRec(Rectangulo that) {
		return (Math.abs(this.v1.getX() - that.v1.getX()) <= Math.abs(this.v2.getX() - this.v1.getX()) && 
				Math.abs(this.v1.getY() - that.v1.getY()) <= Math.abs(that.v2.getY() - that.v1.getY())) ;
	}
	private boolean intersectaConCir(Circulo that) {
		System.out.println("Soy un circulo");
		return true;
	}

	private boolean intersectaConTri(Triangulo that) {
		System.out.println("Soy un triangulo");
		return true;
	}

	

	public Rectangulo(Punto p1, Punto p2) {
		super();
		
		//EL p1 siempre va a ser el de arriba a la derecha.
		if(p1.getX() < p2.getX() && p1.getY() > p2.getY()){
			this.v1 = p1;
			this.v2 = p2;
		}else{
			this.v1 = p2;
			this.v2 = p1;
		}
	
	}

	public Punto getV1() {
		return v1;
	}

	public void setV1(Punto v1) {
		this.v1 = v1;
	}

	public Punto getV2() {
		return v2;
	}

	public void setV2(Punto v2) {
		this.v2 = v2;
	}		
	
	public Punto getPunto3() {
		
		return new Punto(this.getV2().getX(),this.getV1().getY()); 
	}
	public Punto getPunto4() {
		
		return new Punto(this.getV1().getX(),this.getV2().getY()); 
	}
	private Punto v1, v2;
}
