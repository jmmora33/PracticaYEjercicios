package reinas;

import java.util.ArrayList;

public class Reina {

	private int x,y;
	private ArrayList <Integer> conflicto = new ArrayList<>();
	private boolean tieneConflicto = false;
	public int getX() {
		return x;
	}

	public void setX(int x) {
		this.x = x;
	}

	public int getY() {
		return y;
	}

	public void setY(int y) {
		this.y = y;
	}
	
	public Reina (int x, int y) {
		this.x=x;
		this.y=y;
	}
	public boolean isTieneConflicto() {
		return this.tieneConflicto;
	}
	public void establecerConflicto(int reina){
		tieneConflicto = true;
		this.conflicto.add(reina);
	}
	
	public int obtenerConflicto(int index){
	   	return this.conflicto.get(index);
	}
	
	public boolean intersectaCon(Reina reina, int distancia) {
		if(this.x+distancia == reina.getX() && this.y+distancia == reina.getY())
			return true;
		if(this.x-distancia == reina.getX() && this.y-distancia == reina.getY())
			return true;
		if(this.x+distancia == reina.getX() && this.y-distancia == reina.getY())
			return true;
		if(this.x-distancia == reina.getX() && this.y+distancia == reina.getY())
			return true;
		return false;
	}
}
