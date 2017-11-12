package figura;

import java.util.ArrayList;

public abstract class Figura {

protected ArrayList<Figura> figuras = new ArrayList<Figura>();


public ArrayList<Figura> getFiguras() {
	return figuras;
}

public void setFiguras(ArrayList<Figura> figuras) {
	this.figuras = figuras;
}

public void agruparFigura(Figura figura) {
	
 if(figura.intersectaCon(this))
	 figuras.add(figura);
}

public abstract boolean intersectaCon(Figura figura);
public abstract double area();
public abstract double perimetro();
}
