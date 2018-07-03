import java.util.*;

public class Run {

	public static void main(String[] args) {
		int A[] = new int[5];
		int B[] = new int[5];
		int M = 3;
		int X = 5;
		int Y = 200;

		A[0] = 40;
		A[1] = 40;
		A[2] = 100;
		A[3] = 80;
		A[4] = 20;

		B[0] = 3;
		B[1] = 3;
		B[2] = 2;
		B[3] = 2;
		B[4] = 3;
		System.out.println(solution(A, B, M, X, Y));

	}

	/* Ordenacao de vetor String */
	public static String[] ordenarVetor(String vector[]) {
		int maximo = 0, contador = 0;
		for (String s : vector) {
			if ((s == null) && (maximo == 0)) {
				maximo = contador;
				break;
			}
			contador++;
		}
		Arrays.sort(vector, 0, maximo);

		for (int linha = 0; linha < maximo; linha++) {
			System.out.println(vector[linha]);
		}
		return vector;
	}

	
	/* Contagem de vezes que um elevador se move para levar as pessoas */
	/*
	 * vetor A contem o peso da pessoa, vetor B contem o andar que ela deseja ir M =
	 * numero de pisos do hotel, X = pessoas limites, Y = pesso maximo
	 */
	public static int solution(int[] A, int[] B, int M, int X, int Y) {
		boolean saiu=false;
		int contagemPeso = 0;
		int quantidadePessoa=0;
		int levaPessoa = 0;
		int movimentos = 1;
		int inicio =0;
		int fim =0;
		int descida =1;
		for (int pessoa = 0; pessoa < A.length; pessoa++) {
			/* 40,40,100,80,20 */
			contagemPeso = contagemPeso + A[pessoa];
			quantidadePessoa++;
			if ((contagemPeso <= Y) && (quantidadePessoa<=X) && (pessoa!=(A.length-1))) {
				levaPessoa = 1;
			} else {
				if ((levaPessoa == 1)||(pessoa==(A.length-1))) {
					fim=(pessoa==(A.length-1))?pessoa+1:pessoa;
					for(int andar=0;andar<=X;andar++) {
						saiu=false;
						for(int p=inicio;p<fim;p++) {
							if(andar==B[p]&&saiu==false) {
								movimentos++;
								saiu=true;
							}
						}
					}
					inicio=fim;					
					contagemPeso = A[pessoa];
					quantidadePessoa=1;
					levaPessoa = 0;
				}
			}
		}
		return movimentos+descida;
	}

}
