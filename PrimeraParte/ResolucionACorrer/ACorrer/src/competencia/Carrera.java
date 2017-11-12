package competencia;
import java.util.*;

public class Carrera {

private int cantParticipantes;
private int cantCatFem;
private int cantCatMasc;
private int lleganALaMeta;
private ArrayList<Categoria> femeninas;
private ArrayList<Categoria> masculinas;
private ArrayList<Competidor> competidores;
private ArrayList<Integer> llegada;




public ArrayList<Integer> getLlegada() {
	return llegada;
}
public void setLlegada(ArrayList<Integer> llegada) {
	this.llegada = llegada;
}
public int getCantParticipantes() {
	return cantParticipantes;
}
public void setCantParticipantes(int cantParticipantes) {
	this.cantParticipantes = cantParticipantes;
}
public int getCantCatFem() {
	return cantCatFem;
}
public void setCantCatFem(int cantCatFem) {
	this.cantCatFem = cantCatFem;
}
public int getCantCatMasc() {
	return cantCatMasc;
}
public void setCantCatMasc(int cantCatMasc) {
	this.cantCatMasc = cantCatMasc;
}
public int getLleganALaMeta() {
	return lleganALaMeta;
}
public void setLleganALaMeta(int lleganALaMeta) {
	this.lleganALaMeta = lleganALaMeta;
}
public ArrayList<Categoria> getFemeninas() {
	return femeninas;
}
public void setFemeninas(ArrayList<Categoria> femeninas) {
	this.femeninas = femeninas;
}
public ArrayList<Categoria> getMasculinas() {
	return masculinas;
}
public void setMasculinas(ArrayList<Categoria> masculinas) {
	this.masculinas = masculinas;
}
public ArrayList<Competidor> getCompetidores() {
	return competidores;
}
public void setCompetidores(ArrayList<Competidor> competidores) {
	this.competidores = competidores;
}


public Medallero[] obtenerGanadores()
{
   Medallero[] medallero = new Medallero[this.getCantCatFem() + this.getCantCatMasc()];
   
   // RESETEO VECTOR
    for (int i = 0; i < medallero.length; i++) {
		medallero[i] = new Medallero();
	}
    
    // NUMERO VECTORES
    for (int i = 0; i < this.getCantCatFem(); i++) 
    	medallero[i].setNumero(i+1);
    for (int i = 0; i < this.getCantCatMasc(); i++) 
    	medallero[i + this.getCantCatFem()].setNumero(i+1);
    
  for (int i = 0; i < this.lleganALaMeta; i++) {
	  
	Competidor competidor = this.getCompetidores().get(this.getLlegada().get(i)-1);
	
	if(competidor.getSexo() == 'F')
	{
		if(medallero[competidor.getCategoria().getNumero()-1].getOro() == 0) 
			medallero[competidor.getCategoria().getNumero()-1].setOro(competidor.getNumero());
		else if(medallero[competidor.getCategoria().getNumero()-1].getPlata() == 0) 
			medallero[competidor.getCategoria().getNumero()-1].setPlata(competidor.getNumero());
		else if(medallero[competidor.getCategoria().getNumero()-1].getBronce() == 0) 
			medallero[competidor.getCategoria().getNumero()-1].setBronce(competidor.getNumero());
	}else {
		
		if(medallero[competidor.getCategoria().getNumero() + this.getCantCatFem() -1].getOro() == 0) 
			medallero[competidor.getCategoria().getNumero()+ this.getCantCatFem() -1].setOro(competidor.getNumero());
		else if(medallero[competidor.getCategoria().getNumero()+ this.getCantCatFem() -1].getPlata() == 0) 
			medallero[competidor.getCategoria().getNumero()+ this.getCantCatFem() -1].setPlata(competidor.getNumero());
		else if(medallero[competidor.getCategoria().getNumero()+ this.getCantCatFem() -1].getBronce() == 0) 
			medallero[competidor.getCategoria().getNumero()+ this.getCantCatFem() -1].setBronce(competidor.getNumero());	}
  }
return medallero;
}

	
}
