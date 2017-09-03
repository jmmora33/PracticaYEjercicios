package competencia;
import java.io.*;
import java.util.*;

public class Archivo {


public Carrera leerCarrera(String miPath)
{
  Carrera carrera = new Carrera();
  ArrayList<Categoria> categoriaFem;
  ArrayList<Categoria> categoriaMasc;
  Categoria categoria = new Categoria();// COntendra el objeto a dejar en la lista
  ArrayList<Competidor> competidores;
  Competidor competidor=new Competidor();
  ArrayList<Integer> llegada;
  try {
	Scanner sc = new Scanner(new File(miPath));
	carrera.setCantParticipantes(sc.nextInt());
	carrera.setCantCatFem(sc.nextInt());
	carrera.setCantCatMasc(sc.nextInt());
	carrera.setLleganALaMeta(sc.nextInt());
	
	categoriaFem = new ArrayList<Categoria>(carrera.getCantCatFem());
	categoriaMasc = new ArrayList<Categoria>(carrera.getCantCatMasc());
	competidores = new ArrayList<Competidor>(carrera.getCantParticipantes());
	llegada = new ArrayList<Integer>(carrera.getLleganALaMeta());
	for(int i= 0; i< carrera.getCantCatFem(); i ++)
	{   categoria.setNumero(i+1);
		categoria.setEdadMin(sc.nextInt());
		categoria.setEdadSup(sc.nextInt());
		categoria.setSexo('F');
		categoriaFem.add(new Categoria(categoria));
		
	}
	carrera.setFemeninas(categoriaFem);

	for(int i= 0; i< carrera.getCantCatMasc(); i ++)
	{   categoria.setNumero(i+1);
		categoria.setEdadMin(sc.nextInt());
		categoria.setEdadSup(sc.nextInt());
		categoria.setSexo('M');
		categoriaMasc.add(new Categoria(categoria)) ;
		
	}
	carrera.setMasculinas(categoriaMasc);

	for (int i = 0; i < carrera.getCantParticipantes(); i++) {
		competidor.setNumero(i+1);
		competidor.setEdad(sc.nextInt());
		competidor.setSexo(sc.next().charAt(0));
		competidores.add(new Competidor(competidor));
	}
	carrera.setCompetidores(competidores);
	
	for (int i = 0; i < carrera.getLleganALaMeta(); i++) {
		llegada.add(sc.nextInt());
	}
	carrera.setLlegada(llegada);
	sc.close();
} catch (FileNotFoundException e) {
System.err.println("ERROR ARCHIVO"+e);
}
  
  return carrera;

}


// escribe por categoria
public void escribirResultado(String miPath,Medallero[] resultado)
{
	
 try {
	PrintWriter escritor = new PrintWriter(new FileWriter(miPath));
	for(Medallero medallero : resultado)		
		escritor.println(medallero);

			escritor.close();
} catch (IOException e) {
	System.err.println("Error de escritura"+e);
}
 

}


}