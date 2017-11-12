package pelicula;

public class Distra {

	private int[] distancia;
	private boolean[] visitados;
	private int[] papi;
	private int inicio;
	private Grafo grafo;
	private int cantNodos ;
	public Distra(Grafo grafo, int segmentoini) {
		
		this.grafo = grafo.clone();
		distancia = new int[grafo.getCantSegmentos()];
		visitados = new boolean[grafo.getCantSegmentos()];
		papi = new int[grafo.getCantSegmentos()];
		inicio = segmentoini;
		iniciarVectores(inicio);
		cargarCaminoDistra(inicio);
		System.out.println("pepe");
	}
	
	private void iniciarVectores(int EscenaIni) {
		
		for (int i = 0; i < distancia.length; i++) {
			distancia[i] = grafo.getMatAdy()[EscenaIni][i];
		}
	
		
		for (int i = 0; i < papi.length; i++) {
			papi[i] = 0;
		}
	}
	
	private void cargarCaminoDistra(int inicio) {
		cantNodos = grafo.getCantSegmentos();
		int contador = 1;
		int menor;
		
		distancia[inicio] = 0;
		visitados[inicio] = true;
		
		
		while(contador < cantNodos) {
		
			menor = buscarMenor();
			
			/** SI no hay mas menores, no lo hace**/
			if(menor > 0) {
				for (int i = 0; i < distancia.length; i++) {
					if(distancia[i] > distancia[menor] + grafo.getMatAdy()[menor][i] && !visitados[i]) {
						distancia[i] = distancia[menor] + grafo.getMatAdy()[menor][i];
						papi[i] = menor ;
					}
				}
			}
			
			visitados[menor] = true;
			contador ++;
		}
		
	}
	
	private int buscarMenor() {
		int menor = Integer.MAX_VALUE;
		int indice = -1 ;
		for (int i = 0; i < cantNodos; i++) {
			if(distancia[i] <  menor && !visitados[i]) {
				indice = i;
				menor = distancia[i];
			}
		}
		return indice;
	}
	
	public void muestraCostos(){
		for (int i = 0; i < distancia.length; i++) {
			System.out.print(distancia[i] + " ");
		}
	}
	
	public void MostrarRuta(int destino) {
		System.out.println(destino );
		destino = destino -1;
		while(papi[destino] != 0) {
			System.out.println(papi[destino] + 1);
			destino = papi[destino];
		}
		System.out.println(papi[destino] + 1);
	}
}
