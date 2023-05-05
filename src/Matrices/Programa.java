package Matrices;



import java.util.ArrayList;
import java.util.Scanner;

public class Programa {
	

	public static void main(String[] args) {
		
		Scanner teclado=new Scanner(System.in);

		// Pido las dimensiones de las matrices a multiplicar A y B
		
		System.out.print("Dime numero de filas de la matriz A: ");
		int filasA=teclado.nextInt();
		System.out.print("Dime numero de columnas de la matriz A: ");
		int columnasA=teclado.nextInt();
		System.out.println("Para multiplicar matrices el nº de filas de B es igual al nº de columnas de A");
		int filasB=columnasA;
		System.out.print("Dime numero de columnas de la matriz B: ");
		int columnasB=teclado.nextInt();
		
		double A[][]=new double[filasA][columnasA];
		double B[][]=new double[filasB][columnasB];
		int filasC=filasA;
		int columnasC=columnasB;
		double C[][]=new double[filasC][columnasC];
		
		// Relleno con nº aleatorios 
		for (int i=0;i<filasA;i++) {
			for (int j=0;j<columnasA;j++) {
				A[i][j]=Math.random()*10;
			}
		}
		for (int i=0;i<filasB;i++) {
			for (int j=0;j<columnasB;j++) {
				B[i][j]=Math.random()*10;
			}
		}
		
		long inicio=System.currentTimeMillis();
		//Calculo la multiplicacion (matriz C)
		for (int i=0;i<filasC;i++) {
			for (int j=0;j<columnasC;j++) {
				C[i][j]=0;
				for (int r=0;r<columnasB;r++) {
					C[i][j]=C[i][j]+A[i][r]*B[r][j];
				}
				
			}
		}
		long fin=System.currentTimeMillis();
		long tiempo=fin-inicio;
		System.out.println("Tiempo sin threads (ms): "+tiempo);
		
		ArrayList<Hilo> hilos=new ArrayList<Hilo>();
		inicio=System.currentTimeMillis();
		
		//Calculo la multiplicacion (matriz C)
				
		for (int i=0;i<filasC;i++) {
			Hilo hilo=new Hilo(A,B,C,i);
			hilo.start();
			hilos.add(hilo);
		}
		
		for (int i=0;i<hilos.size();i++) {
			try {
				hilos.get(i).join();
			} catch (InterruptedException e) {e.printStackTrace();}
		}
		
		fin=System.currentTimeMillis();
		tiempo=fin-inicio;
		System.out.println("Tiempo con threads (ms): "+tiempo);
		teclado.close();
	}

}
