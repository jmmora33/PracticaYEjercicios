package montaña;

import java.util.Arrays;

public class Montaña {


	
	public int mover(){
		int x = 0;
		this.setValle(true); // El primero siempre es valle
		int cima = 0, i = 1;
		
		cima = this.getCapacidadCarro(); // Es el punto de inicio del carro.
		
		while(i < this.getCoordenadasY().length   && cima <= this.getCapacidadCarro()){
		x += Math.abs(this.getCoordenadasY()[i] - this.getCoordenadasY()[i-1]);
		if(!this.isValle())
			this.setValle(true);
		else{
			cima = i + 1 < this.getCoordenadasY().length ? this.getCoordenadasY()[i+1] : this.getCoordenadasY()[i];
			this.setValle(false);
			this.setCapacidadCarro(this.getCapacidadCarro() -1);
		}
		
		
		i++;
		}
	
		if(cima > this.getCapacidadCarro()){
            x+=Math.abs(this.getCapacidadCarro() - this.getCoordenadasY()[i-1]);
			this.setValorYFinal(this.getCapacidadCarro());
		}else{
			this.setValorYFinal(this.getCoordenadasY()[i-1]);
			
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
	
	public int getValorYFinal() {
		return valorYFinal;
	}

	public void setValorYFinal(int valorYFinal) {
		this.valorYFinal = valorYFinal;
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
	private int valorYFinal;

}
