package acorrer;

public class Corredor{

	private int edad;
	private String sexo;
	private int categoria;
	
	public int getEdad() {
		return edad;
	}
	public void setEdad(int edad) {
		this.edad = edad;
	}
	public String getSexo() {
		return sexo;
	}
	public void setSexo(String sexo) {
		this.sexo = sexo;
	}
	public int getCategoria() {
		return categoria;
	}
	public void setCategoria(int categoria) {
		this.categoria = categoria;
	}
	
	public Corredor (int edad,String sexo,int categoria) {
		this.edad=edad;
		this.sexo=sexo;
		this.categoria=categoria;
	}
	
	
}
