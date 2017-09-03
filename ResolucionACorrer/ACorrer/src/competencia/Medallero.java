package competencia;

public class Medallero {
private int numero;
private int oro;
private int plata;
private int bronce;


public int getNumero() {
	return numero;
}
public void setNumero(int numero) {
	this.numero = numero;
}
public int getOro() {
	return oro;
}
public void setOro(int oro) {
	this.oro = oro;
}
public int getPlata() {
	return plata;
}
public void setPlata(int plata) {
	this.plata = plata;
}
public int getBronce() {
	return bronce;
}
public void setBronce(int bronce) {
	this.bronce = bronce;
}

@Override
public String toString()
{
  return this.getNumero() + " " + this.getOro() + " " + this.getPlata()+" " + this.getBronce();	
}

}
