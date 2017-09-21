package monticulo;

public class Persona implements Comparable<Persona>{

	public Persona(String nombre, int edad){
		
		this.setEdad(edad);
		this.setNombre(nombre);
	}
	
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public int getEdad() {
		return edad;
	}
	public void setEdad(int edad) {
		this.edad = edad;
	}
	private String nombre ;
	private int edad;
	@Override
	public int compareTo(Persona that) {
		return this.getEdad() > that.getEdad()?1:this.getEdad()<that.getEdad()?-1:0;
	}

	@Override
	public String toString() {
		return "Mi nombre es " + nombre + ", y tengo la siguiente edad " + edad + " " ;
	}
	
}
