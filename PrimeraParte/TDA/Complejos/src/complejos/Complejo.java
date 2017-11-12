package complejos;

import java.util.ArrayList;
import java.util.Collections;

public class Complejo implements Comparable<Complejo> {
	private double real;
	private double im;
	
	public int compareTo(Complejo c){
		if(this.modulo()<c.modulo())
			return -1;
		if(this.modulo()==c.modulo())
			return 0;
		return 1;	
	}

	public Complejo(double real, double im) {
		this.real = real;
		this.im = im;
	}

	public Complejo() {
		this(0, 0);// invoca al otro constructor
	}
	
	public double modulo(){
		return Math.sqrt(Math.pow(real, 2)+Math.pow(im, 2));
	}
	
	public Complejo suma(Complejo c) {
		Complejo aux = new Complejo(real + c.real, im + c.im);
		return aux;
	}
	
	public Complejo restar(Complejo c){
		Complejo aux=new Complejo(real-c.real,im-c.im);
		return aux;
	}
	public String toString(){
		return "("+real+";"+im+")";
	}
	
	/*public Complejo clone(Complejo c){
		Complejo aux=new Complejo(c.real,c.im);
		return aux;
	}*/
	
	public Complejo clone(){
		return new Complejo(real,im);
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		long temp;
		temp = Double.doubleToLongBits(im);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		temp = Double.doubleToLongBits(real);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)//si las referencias son iguales
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())//compara las clases del objeto llamador y del parametro
			return false;
		Complejo other = (Complejo) obj;//se define una variable referencia de complejo y castear el obj pasado como parametro(se usa como hijo)
		if (Double.doubleToLongBits(im) != Double.doubleToLongBits(other.im))//compara parte im
			return false;
		if (Double.doubleToLongBits(real) != Double.doubleToLongBits(other.real))//compara parte real
			return false;
		return true;
	}

	public static void main(String[] args) {
		Complejo c1 = new Complejo();
		Complejo c2 = new Complejo(3, 5);
		Complejo c3 = new Complejo(1, 1);
		c1 = c2.suma(c3);
		System.out.println(c1);
		System.out.println("el modulo de "+c1+" es "+c1.modulo());
		ArrayList<Complejo> vec=new ArrayList<Complejo>();
		vec.add(c1);
		vec.add(c2);
		vec.add(c3);
		System.out.println("sin ordenar");
		for(int i=0;i<3;i++){
			System.out.println(vec.get(i));
		}
		System.out.println("ordenado");
		Collections.sort(vec);
		for(int i=0;i<3;i++){
			System.out.println(vec.get(i));
		}
		
		
	}

}
