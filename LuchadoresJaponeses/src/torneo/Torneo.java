package torneo;

public class Torneo {

	private int cantidadDeLuchadores;
	private Luchador[] Luchadores ;

	public Torneo (int cantidadDeLuchadores, Luchador []Luchador) {
		this.cantidadDeLuchadores=cantidadDeLuchadores;
		this.Luchadores=new Luchador [Luchador.length];
		for (int i=0;i<Luchador.length;i++) {
			this.Luchadores[i]=Luchador[i];
		}
	}
	

	
	public Torneo () {
		
	}
	
	public int [] resolverTorneo () {
		
		int [] vecDominantes = new int [Luchadores.length];
		for (int i=0;i<this.Luchadores.length;i++) {
			for(int j=i+1;j<this.Luchadores.length ;j++) {
				if(Luchadores[i].domina(Luchadores[j])==1)
					vecDominantes[i]++;
				else
					vecDominantes[j]++;
			}
				 
		}

			return vecDominantes;		 
					 	
	}
	


	///GET AND SET
	
	
	public int getCantidadDeLuchadores() {
		return cantidadDeLuchadores;
	}
	public void setCantidadDeLuchadores(int cantidadDeLuchadores) {
		this.cantidadDeLuchadores = cantidadDeLuchadores;
	}
	public Luchador[] getLuchadores() {
		return Luchadores;
	}
	
	public int pesoLuchador(int i) {
		return this.Luchadores[i].getPeso();
	}
	
	public int alturaLuchador(int i) {
		return this.Luchadores[i].getAltura();
	}
	



	
	/// METODOS
	
	
}
