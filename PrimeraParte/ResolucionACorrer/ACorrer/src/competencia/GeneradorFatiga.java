package competencia;
import java.util.*;
import java.io.*;

public class GeneradorFatiga {

	public static void main(String[] args) throws IOException {
		char[] sexo = {'M','F'};
		Random random = new Random();
      PrintWriter pr = new PrintWriter(new FileWriter("carrera.in"));
      pr.println("1000000 30 30 1000000");
     
      for (int i = 0; i < 30; i++) {
    	  int cate = i +10;
    	  pr.println( cate+" "+cate);	
      }
      for (int i = 0; i < 30; i++) {
    	  int cate = i +10;
    	  pr.println( cate+" "+cate);	
      }
      
      for(int i = 0; i < 1000000 ; i++)
    		 pr.println(random.nextInt(30)+10 + " "+sexo[random.nextInt(2)]);
      
      for (int i = 0; i < 1000000; i++) 
	     pr.println(i +1);
	
	pr.close();
	}
         
}
