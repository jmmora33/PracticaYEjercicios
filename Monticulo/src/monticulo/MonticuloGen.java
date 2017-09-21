package monticulo;

import java.util.ArrayList;


@SuppressWarnings("rawtypes")
public class MonticuloGen<T extends Comparable> {

	public boolean agregar(T valor){		
	this.ingresarValor(valor);
		reordenarInsert();
		
		return true;
	}

@SuppressWarnings("unchecked")
public void reordenarInsert(){
	T aux;
	for (int i = this.getArbol().size() -1; i >= 1 ; i/=2) {
	 	if(this.getArbol().get(i).compareTo(this.getArbol().get(i/2)) > 0){
	 		aux = this.getArbol().get(i);
	 		this.ingresarValor(this.getArbol().get(i/2),i);
	 		this.ingresarValor(aux, i/2);
	 	}else
	 		break;
	}
}
	

   public T sacar(){
	   
	   //No hay nada en la cola
	   if(this.getArbol().size() == 0)
		   return null;
	   
	   T retorno = this.getArbol().get(0);
		    this.ingresarValor(this.getArbol().get(this.getArbol().size()-1), 0);
		    this.getArbol().remove(this.getArbol().size()-1);
		    reordenarSacar();    
	   
   
	   return retorno;
   }
   
   @SuppressWarnings("unchecked") 
   public void reordenarSacar(){
		T aux;
		for (int i = 0; i < this.getArbol().size(); i*=2) {
		    if((i*2+1) < this.getArbol().size()  && this.getArbol().get(i*2+1).compareTo(this.getArbol().get(i*2)) > 0){
		    	
		    	if(this.getArbol().get(i).compareTo(this.getArbol().get(i*2+1)) < 0){
					aux = this.getArbol().get(i);
					this.ingresarValor(this.getArbol().get(i*2+1), i);
					this.ingresarValor(aux, i*2+1) ;
		    	}
		    	else
		    		break;
		    }else if(i*2 < this.getArbol().size() && this.getArbol().get(i).compareTo(this.getArbol().get(i*2)) < 0){
						aux = this.getArbol().get(i);
						this.ingresarValor(this.getArbol().get(i*2+1), i);
						this.ingresarValor(aux, i*2+1) ;
				} else
			        break;	
		}
  }
   
	
   public void ingresarValor(T valor) {
	   
	   this.arbol.add(valor);
   }
   
   public void ingresarValor(T valor, int posicion) {
	   
	   this.arbol.set(posicion, valor);
   }

 
	public MonticuloGen() {
		this(0,new ArrayList<T>());
	}
	
	public MonticuloGen(int tope, ArrayList<T> arbol) {
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
	public ArrayList<T> getArbol() {
		return arbol;
	}
	
	public void setArbol(ArrayList<T> arbol) {
		this.arbol = arbol;
	}
	private int tope;
	private ArrayList<T> arbol;

}
