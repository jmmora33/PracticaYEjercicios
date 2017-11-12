package subte;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Grafo {
	
	///PARAA GRAFO
	private Scanner sc;
	private PrintWriter salida;
	private int cantidadDeLineas;
	private int cantidadDeEstaciones;
	private int estacionInicial;
	private int estacionFinal;
	private int [] estaciones;
	private Nodo [] nodos;
	private List< List< Integer > > listaAdyacencia = new ArrayList< List<Integer> >();
	
	///PARA DIJKSTRA 
    private final int MAX = 10005;  //maximo numero de v�rtices
    private final int INF = 1<<30;  //definimos un valor grande que represente la distancia infinita inicial, basta conque sea superior al maximo valor del peso en alguna de las aristas
   // private List< List< Nodo > > listaAdyacencia = new ArrayList< List<Nodo> >(); //lista de adyacencia
    private int distancia[ ];          //distancia[ u ] distancia de v�rtice inicial a v�rtice con ID = u
    private boolean visitado[ ];   //para v�rtices visitados
    //private PriorityQueue<Integer> colaDePrioridad = new PriorityQueue<Integer>(); //priority queue propia de Java, usamos el comparador definido para que el de menor valor este en el tope
    private int previo[];              //para la impresion de caminos
	private int [][] matrizAdyacencia;
    
    
	public Grafo (String entrada, String salida) throws FileNotFoundException {
		sc = new Scanner (new File (entrada));
		this.salida = new PrintWriter (new File (salida));
		cantidadDeLineas = sc.nextInt();
		cantidadDeEstaciones = sc.nextInt();
		nodos = new Nodo[cantidadDeLineas];
		/**Carga estaciones en el vector**/
		for (int i = 0; i < cantidadDeLineas; i++) {
			int tamVector = sc.nextInt(); 
			estaciones = new int [tamVector];
			for (int j = 0; j < tamVector ; j++) {
				estaciones[j] = sc.nextInt();
			}
			/**Lo guardo en el vector de lineas**/
			nodos[i] = new Nodo (i,estaciones);
		}
		
		estacionInicial = sc.nextInt();
		estacionFinal = sc.nextInt();
		
		
		///INICIO MATRIZ DE ADYACENCIA, DISTANCIA Y VISITADOS
		matrizAdyacencia = new int [cantidadDeLineas][cantidadDeLineas];
		distancia = new int [cantidadDeLineas];
		visitado = new boolean [cantidadDeLineas];
		previo = new int [cantidadDeLineas];
		///INICIAR LISTA DE ADYACENCIA
        for( int i = 0 ; i < cantidadDeLineas ; ++i ) 
        	listaAdyacencia.add(new ArrayList<Integer>()) ; //inicializamos lista de adyacencia
		
        
        //CARGAR LISTA DE ADYACENCIA
        for (int i = 0; i < nodos.length - 1; i++) {
			for (int j = i+1; j < nodos.length; j++) {
				if(this.estacionEnComun(nodos[i], nodos[j])) {
					this.cargarListaDeAdyacencia(nodos[i], nodos[j],1);
					matrizAdyacencia[nodos[i].getnLinea()][nodos[j].getnLinea()] = 1;
					matrizAdyacencia[nodos[j].getnLinea()][nodos[i].getnLinea()] = 1;
				}
				else {
					this.cargarListaDeAdyacencia(nodos[i], nodos[j],0);
				}
					
			}
		}
       
        for (int i = 0; i < matrizAdyacencia.length; i++) {
			for (int j = 0; j < matrizAdyacencia.length; j++) {
				System.out.print(matrizAdyacencia[i][j] + " ");
			}
			System.out.println(" ");
		}
        
       int nodoInicial = -1;
       for (int i = 0; i < nodos.length; i++) {
    	   if (nodos[i].contiene(estacionFinal)) {
    		   nodoInicial = i;
    		   break;
    	   }	   
       }
       
       int nodoFinal = -1;
       for (int i = 0; i < nodos.length; i++) {
    	   if (nodos[i].contiene(estacionInicial)) {
    		   nodoFinal = i;
    		   break;
    	   }	   
       }
       
       if (nodoInicial == nodoFinal) {
    	   System.out.println("LLega directo con la linea " + (nodoInicial+1) + " , No tiene ningun transbordo");
       }
       else {
    	   this.init();
    	   this.dijkstra(nodoInicial);
    	   System.out.println("De la estacion: " + estacionInicial + " A la estacion: " + estacionFinal );
    	   this.costocamino(nodoFinal);
    	   System.out.println("Un camino recomendado es: ");
    	   System.out.print((nodoInicial+1));
    	   this.mostrarCamino (nodoFinal);
       }
	}
	
	private void costocamino(int destino){
		int num= distancia[destino]+1;
		System.out.println("La cantidad de Lineas a tomar es: " + num);
		}
	
	private void mostrarCamino(int nodoFinal) {
		if( previo[ nodoFinal ] != -1 )    //si aun poseo un vertice previo
	            mostrarCamino(previo[nodoFinal] );  //recursivamente sigo explorando
	        System.out.print(" -> " + (nodoFinal+1));     
		}

	private boolean estacionEnComun(Nodo nodo, Nodo nodo2) {
		
		for (int i = 0; i < nodo.getEstaciones().length; i++) {

				if(nodo2.contiene(nodo.getEstaciones()[i]))
					return true;
		}
		return false;
	}
	
	private void cargarListaDeAdyacencia(Nodo origen, Nodo destino, int numero) {
		listaAdyacencia.get(origen.getnLinea()).add(numero); 	
		listaAdyacencia.get(destino.getnLinea()).add(numero); 	
	}
	
    public void dijkstra (int nodoInicial) {
    	for(int i=0;i<this.cantidadDeLineas;i++)
    		{
    		int numero = matrizAdyacencia[nodoInicial][i];
    		if (numero == 0 )
    			numero = INF;
    		distancia[i]=numero;
    		}
    	visitado[nodoInicial]=true;
    	distancia[nodoInicial]=0;
    	for(int j=1;j<this.cantidadDeLineas;j++)
    		{
    		int v=minimo();
    		visitado[v]=true;
    		for(int w=0; w<this.cantidadDeLineas;w++)
    			if(!visitado[w])
    				if(sonAdyacentes(v,w) && (distancia[v]+this.matrizAdyacencia[v][w])<distancia[w])
    					{
    					distancia[w]=distancia[v]+this.matrizAdyacencia[v][w];
    					previo[w]=v;
    					}
    		}
    	System.out.println(Arrays.toString(distancia));

    	}
    
    
    
    private int minimo()
		{
		double mx=0xFFFF;
		int v=1;
		for (int j=1; j<this.cantidadDeLineas; j++)
			if(!visitado[j] && (distancia[j]<=mx))
				{
				mx=distancia[j];
				v=j;
				}
		return v;
		}
    
    private void init(){
        for( int i = 0 ; i < cantidadDeLineas ; ++i ){
            distancia[ i ] = INF;  //inicializamos todas las distancias con valor infinito
            visitado[ i ] = false; //inicializamos todos los v�rtices como no visitados
            previo[ i ] = -1;      //inicializamos el previo del vertice i con -1
        }
    }
    
    private boolean sonAdyacentes(int nodo1, int nodo2) {
    	if (this.matrizAdyacencia[nodo1][nodo2]==1)
    	 	return true;
    	return false;
    }

    
    
    }
