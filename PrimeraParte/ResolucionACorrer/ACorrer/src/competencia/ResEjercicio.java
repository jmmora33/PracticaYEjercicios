package competencia;

public class ResEjercicio {

	public static void main(String[] args) {
       Archivo archivo = new Archivo();
       Carrera carrera = new Carrera();
       String pathEntrada ="carrera.in";
       String pathResultado = "ganadores.out";
       carrera = archivo.leerCarrera(pathEntrada);
       setearCategorias(carrera);
       archivo.escribirResultado(pathResultado, carrera.obtenerGanadores());
       System.out.println(carrera.getCantCatFem()+" "+carrera.getCantCatMasc());
	}

	public static void setearCategorias(Carrera carrera)
	{
		for(Competidor competidor: carrera.getCompetidores())
		{  Categoria categoria = new Categoria();
			int i = 0 ; // PARA LAS DAMAS
			int j = 0; // PARA EL CABALLERO
			if(competidor.getSexo() =='F')
			{   do {
				   categoria = carrera.getFemeninas().get(i);
				   i++;
			     }while(competidor.getEdad() < categoria.getEdadMin() || competidor.getEdad() > categoria.getEdadSup() && i< carrera.getCantCatFem());
				
					if(categoria != null)
			          competidor.setCategoria(categoria);
			}else {
				  do {
					   categoria = carrera.getMasculinas().get(j);
					   j++;
				     }while(competidor.getEdad() < categoria.getEdadMin() || competidor.getEdad() > categoria.getEdadSup() && j< carrera.getCantCatMasc());
					
						if(categoria != null)
				          competidor.setCategoria(categoria);
				
			}
			
		}
		
		
	}
	

}
