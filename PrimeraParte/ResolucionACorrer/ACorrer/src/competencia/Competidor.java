package competencia;

public class Competidor {

private int numero;
private int edad;
private char Sexo;
private Categoria categoria;


public Categoria getCategoria() {
	return categoria;
}
public void setCategoria(Categoria categoria) {
	this.categoria = categoria;
}
public Competidor() {
	this(0,0,'F');
}
public Competidor(int numero, int edad, char sexo) {
	super();
	this.numero = numero;
	this.edad = edad;
	Sexo = sexo;
}

public Competidor(Competidor competidor)
{
	
this(competidor.getNumero(),competidor.getEdad(),competidor.getSexo());

}
@Override
public String toString() {
	return "Competidor [numero=" + numero + ", edad=" + edad + ", Sexo=" + Sexo + "]";
}


public int getNumero() {
	return numero;
}
public void setNumero(int numero) {
	this.numero = numero;
}
public int getEdad() {
	return edad;
}
public void setEdad(int edad) {
	this.edad = edad;
}
public char getSexo() {
	return Sexo;
}
public void setSexo(char sexo) {
	Sexo = sexo;
}


	
}
