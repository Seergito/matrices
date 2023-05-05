package Matrices;


public class Hilo extends Thread{

	private double A[][];
	private double B[][];
	private double C[][];
	private int i;
	
	public Hilo(double[][] a, double[][] b, double[][] c, int i) {
		A = a;
		B = b;
		C = c;
		this.i = i;
	}
	
	public void run() {
		int colC=C[0].length;
		int colB=B[0].length;
		for (int j=0;j<colC;j++) {
			C[i][j]=0;
			for (int r=0;r<colB;r++) {
				C[i][j]=C[i][j]+A[i][r]*B[r][j];
			}
			
		}
	}
	
	
	
}
