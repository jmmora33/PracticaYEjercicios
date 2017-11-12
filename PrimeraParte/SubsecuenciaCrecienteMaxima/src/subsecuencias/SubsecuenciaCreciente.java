package subsecuencias;

public class SubsecuenciaCreciente {

	public static void main(String[] args) {
		int[] secuencia ={1,-3,3,4,-10,12,22,-5,-4,-1,5};
		int[][] secuenciasMaximas = new int[secuencia.length][secuencia.length];
		int creciente;
        int maximo = 0;
        int posicion = -1;
		
		for(int i = 0; i < secuencia.length-1 ; i++){
			creciente = 0;
			secuenciasMaximas[i][i] = creciente;
			for (int j = 1 + i, ultPos = 0; j < secuencia.length; j++) {
				if(secuencia[ultPos] < secuencia[j]){
					secuenciasMaximas[i][j] = ++creciente ;	
					ultPos = j;
				}
				else
					secuenciasMaximas[i][j] = 1 ;
						
			}	
		}
		
		for (int i = 0; i < secuenciasMaximas.length; i++) {
			if(secuenciasMaximas[i][secuenciasMaximas.length -1] > maximo){
				maximo = secuenciasMaximas[i][secuenciasMaximas.length -1];
				posicion  = i;
			}
			
			
		}
	
			imprimir(secuenciasMaximas);
			
			
			int[] resultadoMaximo = new int[maximo];
			resultadoMaximo[0]= secuencia[posicion];
			for (int i = 1,  j = 1; i < secuenciasMaximas.length; i++) {
				if(secuenciasMaximas[posicion][i] > 1){
					resultadoMaximo[j] = secuencia[i];
					j++;
				}
					
			}
			System.out.println("Cantidad Maxima : "+ maximo);
			System.out.println("La secuencia empieza con:"+ resultadoMaximo[0]);
			System.out.println("La subsecuencia es : " + resultadoMaximo.toString());
	}

	public static void imprimir(int[][] mat){
		
		for (int i=0;i<mat.length;i++){
			for (int a=0;a<mat[0].length;a++) {
					System.out.print(mat[i][a]+"\t");
			}
		System.out.println(" ");
	} //O(N2) PARA RECORRER
		
	}
	
}
