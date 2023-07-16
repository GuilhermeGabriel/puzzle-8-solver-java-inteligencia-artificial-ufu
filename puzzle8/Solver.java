package puzzle8;

import java.util.Scanner;

public class Solver {

	public static void main(String[] args) {
		int[][] tabuleiroInicial = new int[3][3];
		int[][] tabuleiroFinal = new int[3][3];
		
		System.out.println("Bem vindo ao 8 puzzle solver by: Guilherme e Bruno"); 
		
		System.out.println("Digite o tabuleiro que deseja resolver: ");
		Scanner scanner = new Scanner(System.in);
		for(int i=0;i<3;i++)
			for(int j=0;j<3;j++)
				tabuleiroInicial[i][j]=scanner.nextInt();
		
		System.out.println("Digite o tabuleiro objetivo final: ");
		for(int i=0;i<3;i++)
			for(int j=0;j<3;j++)
				tabuleiroFinal[i][j]=scanner.nextInt();
				
		System.out.println("Por favor selecione um algoritmo abaixo:\n");
		System.out.println("1. BFS");
		System.out.println("2. DFS\n");
		
		TabuleiroNo tabuleiroNode = new TabuleiroNo(tabuleiroInicial);
		TabuleiroNo.setEstadoFinal(tabuleiroFinal);
		Search search = null;
			
		int input = scanner.nextInt();scanner.close();
		
		if(input==1) search = new BFS(tabuleiroNode);
		if(input==2) search = new DFS(tabuleiroNode);

		System.out.println("Processando...");
		search.search();
		
		if(!TabuleiroNo.ExisteSolucao())System.out.println("Não existe solução.");
		
		System.out.println("Fim.");
	}

}