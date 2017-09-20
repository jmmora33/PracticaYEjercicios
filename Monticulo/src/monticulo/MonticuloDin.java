package monticulo;

import java.util.ArrayList;

public class MonticuloDin {

	public boolean agregar(Nodo valor){		
	this.ingresarValor(valor);
		reordenarInsert();
		
		return true;
	}

public void reordenarInsert(){
	Nodo aux;
	for (int i = this.getArbol().size() -1; i >= 1 ; i/=2) {
	 	if(this.getArbol().get(i).compareTo(this.getArbol().get(i/2)) < 0){
	 		aux = this.getArbol().get(i);
	 		this.ingresarValor(this.getArbol().get(i/2),i);
	 		this.ingresarValor(aux, i/2);
	 	}else
	 		break;
	}
}
	

   public Nodo sacar(){
	   
	   Nodo retorno = this.getArbol().get(0);
		    this.ingresarValor(this.getArbol().get(this.getArbol().size()), 0);
		    this.getArbol().remove(this.getArbol().size());
		    reordenarSacar();    
	   
   
	   return retorno;
   }
   
   public void reordenarSacar(){
		Nodo aux;
		for (int i = 1; i <= this.getTope(); i*=2) {
		    if((i*2+1)<=this.getTope() && this.getArbol().get(i*2+1).compareTo(this.getArbol().get(i*2)) < 0){
		    	
		    	if(this.getArbol().get(i).compareTo(this.getArbol().get(i*2+1)) < 0){
					aux = this.getArbol().get(i);
					this.ingresarValor(this.getArbol().get(i*2+1), i);
					this.ingresarValor(aux, i*2+1) ;
		    	}
		    	else
		    		break;
		    }else if(i*2 <=this.getTope() && this.getArbol().get(i).compareTo(this.getArbol().get(i*2)) > 0){
						aux = this.getArbol().get(i);
						this.ingresarValor(this.getArbol().get(i*2+1), i);
						this.ingresarValor(aux, i*2+1) ;
				} else
			        break;	
		}
   }
	
   public void ingresarValor(Nodo valor) {
	   
	   this.arbol.add(valor);
   }
   
   public void ingresarValor(Nodo valor, int posicion) {
	   
	   this.arbol.add(posicion, valor);
   }

   public static  ArrayList<Nodo> initArray(){
		 ArrayList<Nodo> retorno = new ArrayList<Nodo>();
		 retorno.add(new Nodo(0,0));
		 
		 return retorno;
	 }
	public MonticuloDin() {
		this(0,new ArrayList<Nodo>());
	}
	
	public MonticuloDin(int tope, ArrayList<Nodo> arbol) {
		super();
		this.tope = tope;
		this.arbol = arbol;
	}
	public int getTope() {
		return tope;
	}
	public void setTope(int tope) {
		this.tope = tope;
	}
	public ArrayList<Nodo> getArbol() {
		return arbol;
	}
	
	public void setArbol(ArrayList<Nodo> arbol) {
		this.arbol = arbol;
	}
	private int tope;
	private ArrayList<Nodo> arbol;

}
