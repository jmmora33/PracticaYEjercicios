package figura;

public class Rectangulo {
	
	private Punto v1, v2;

	public Rectangulo(Punto v1, Punto v2) {
		super();
		this.v1 = v1;
		this.v2 = v2;
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
	//v1 mas arriba y a la izq, v2 mas abajo y a la derecha
	public boolean intersectaCon(Rectangulo that) {
		return (Math.abs(this.v1.x - that.v1.x) <= Math.abs(this.v2.x - this.v1.x) && 
				Math.abs(this.v1.y - that.v1.y) <= Math.abs(that.v2.y - that.v1.y)) ;
	}
	
	
}
