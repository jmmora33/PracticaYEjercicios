package torneo;

public class Luchador implements Comparable<Luchador> {
	
private int peso;
private int altura;

public Luchador (int peso, int altura) {
	this.peso=peso;
	this.altura=altura;
}

public Luchador () {
	this(1,1);
}

public Luchador(Luchador luchador)
{
 this(luchador.getPeso(), luchador.getAltura());	
}

	@Override
public String toString() {
	return "[peso=" + peso + ", altura= " + altura + "]";
}

	public static void main(String[] args) {
		Luchador luchador1 = new Luchador (250,200);
		Luchador luchador2= new Luchador (270,190);
		
		if(luchador1.compareTo(luchador2)==1)
			System.out.println("Luchador 1 supera a Luchador 2");
		else
			System.out.println("Luchador 2 supera a Luchador 1");
		
		if(luchador1.compareTo(luchador2)==0)
			System.out.println("Luchador 1 y Luchador 2 no se superan");

	}



	@Override
	public int compareTo(Luchador luchador) {
		
		if(this.getAltura() > luchador.getAltura())
			if(this.getPeso() >= luchador.getPeso())
				return 1;
				
		if(this.getAltura() < luchador.getAltura())
			if(this.getPeso() <= luchador.getPeso())
				return -1;
		
		
		if(this.getAltura() == luchador.getAltura())
			if(this.getPeso() > luchador.getPeso()){
				return 1;
			}	
			else{
			    return -1;
			}
			
		if(this.getPeso() == luchador.getPeso())
			if(this.getAltura() > luchador.getAltura()){
				return 1;
			}
			else{
			    return -1;
			}
		
		return 0;
	}


public int domina (Luchador luchador) {
	
	return this.compareTo(luchador); 
		
}
	
	
	public int getPeso() {
		return peso;
	}
	public void setPeso(int peso) {
		this.peso = peso;
	}
	public int getAltura() {
		return altura;
	}
	public void setAltura(int altura) {
		this.altura = altura;
	}

}
