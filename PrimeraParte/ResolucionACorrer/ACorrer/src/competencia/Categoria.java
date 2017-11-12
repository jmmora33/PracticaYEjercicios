package competencia;

public class Categoria {
private int numero;
private int edadMin;
private int edadSup;
private char sexo;
private Medallero medallero;


public Categoria()
{
	this(0,0,0,'F');
}

public Categoria(int numero, int edadMin, int edadSup, char sexo) {
	super();
	this.numero = numero;
	this.edadMin = edadMin;
	this.edadSup = edadSup;
	this.sexo = sexo;
}
public Categoria(Categoria categoria)
{
this(categoria.getNumero(),categoria.getEdadMin(),categoria.getEdadSup(),categoria.getSexo());
}

@Override
public String toString() {
	return "Categoria [numero=" + numero + ", edadMin=" + edadMin + ", edadSup=" + edadSup + ", sexo=" + sexo
			+ ", medallero=" + medallero + "]";
}

public int getEdadMin() {
	return edadMin;
}
public void setEdadMin(int edadMin) {
	this.edadMin = edadMin;
}
public int getEdadSup() {
	return edadSup;
}
public void setEdadSup(int edadSup) {
	this.edadSup = edadSup;
}

public char getSexo() {
	return sexo;
}
public void setSexo(char sexo) {
	this.sexo = sexo;
}
public int getNumero() {
	return numero;
}
public void setNumero(int numero) {
	this.numero = numero;
}
public Medallero getMedallero() {
	return medallero;
}

public void setMedallero(Medallero medallero) {
	this.medallero = medallero;
}

}
