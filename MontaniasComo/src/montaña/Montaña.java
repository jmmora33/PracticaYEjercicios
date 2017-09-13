package montaña;

import java.util.Arrays;

public class Montaña {


	
	public int mover(){
		int x = 0;
		this.setValle(true); // El primero siempre es valle
		int cima;
		
		for (int i = 0; i < coordenadasY.length -1; i++){
			cima= Math.abs(this.getCoordenadasY()[i+1] - this.getCoordenadasY()[i]);
			if(cima <= this.getCapacidadCarro()){
				x += cima ;
				if(!this.isValle())
					this.setValle(true);
				else{
					this.setCapacidadCarro(this.getCapacidadCarro() -1);
					this.setValle(false);
				}
			}else{
				x += this.getCapacidadCarro()- this.getCoordenadasY()[i]; 
			}
					
			}
		
			
		return x;
	}
	
	
	
	
	
	
	
	
	
	
	public int getCantCambios() {
		return cantCambios;
	}
	public void setCantCambios(int cantCambios) {
		this.cantCambios = cantCambios;
	}
	public int[] getCoordenadasY() {
		return coordenadasY;
	}
	public void setCoordenadasY(int[] coordenadasY) {
		this.coordenadasY = coordenadasY;
	}

	public int getCapacidadCarro() {
		return capacidadCarro;
	}
	public void setCapacidadCarro(int capacidadCarro) {
		this.capacidadCarro = capacidadCarro;
	}
	
	public boolean isValle() {
		return valle;
	}
	public void setValle(boolean valle) {
		this.valle = valle;
	}
	

	@Override
	public String toString() {
		return "Montaña [cantCambios=" + cantCambios + ", coordenadasY=" + Arrays.toString(coordenadasY)
				+ ", capacidadCarro=" + capacidadCarro + ", valle=" + valle + "]";
	}


	private int cantCambios; // CAMBIOS DE CONCAVIDAD
	private int[] coordenadasY;
	private int capacidadCarro;
	private boolean valle;
}
