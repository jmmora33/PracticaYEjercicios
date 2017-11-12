package monticulo;

import java.util.Comparator;

public class OrdenarNodos implements Comparator<Nodo>{

	
	@Override
	public  int compare(Nodo nodo1, Nodo nodo2)  {
		return nodo1.getPrioridad() < nodo2.getPrioridad()?1: nodo1.getPrioridad() > nodo2.getPrioridad() ?-1:0;
	}

}
