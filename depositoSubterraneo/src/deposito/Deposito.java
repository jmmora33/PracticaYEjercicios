package deposito;

public class Deposito {

	int altura;
	int superficie;
	
	public Deposito(int superficie, int altura) {
		super();
		this.altura = altura;
		this.superficie = superficie;
	}
   
	public Deposito() {
		this(0, 0);
	}
	public int getAltura() {
		return altura;
	}

	public void setAltura(int altura) {
		this.altura = altura;
	}

	public int getSuperficie() {
		return superficie;
	}

	public void setSuperficie(int superficie) {
		this.superficie = superficie;
	}
	
	public int getVolumen () {
		return altura*superficie;
	}
	
	public int getVolumen (int altura) {
		return altura*superficie;
	}
}
