package puzzle8;

import java.util.ArrayList;
import java.util.List;

public class TabuleiroNo {
	private int[][] estadoAtual = new int [3][3];
	private List<TabuleiroNo> children;
	private TabuleiroNo parent;
	
	private static int[][] estadoFinal = new int[3][3];
	private static boolean existeSolucao = false;

	private int linhaZero;
	private int colunaZero;
	
	private DIRECAO direcao;
	private String stringState;
	
	public TabuleiroNo(int [][] estadoAtual) {
		this.estadoAtual = estadoAtual;
		
		this.children = new ArrayList<TabuleiroNo>();
		this.parent = null;
	
		this.stringState = stringBoard();
		this.direcao = null;
		
		// Encontra onde tá o zero
		for(int i=0; i<=2; i++) {
			for(int j=0; j<=2; j++) {
				if(estadoAtual[i][j]==0) {
					this.linhaZero = i;
					this.colunaZero = j;
					break;
				}
			}
		}
	}
	
	// Método que retorna uma versão String do baord
	public String stringBoard() {   	
		StringBuilder sb = new StringBuilder();
		for (int i =0; i<estadoAtual.length; i++) {
			for(int j = 0; j<estadoAtual[i].length;j++ ) {
				sb.append(estadoAtual[i][j]);
			}
		}
		return sb.toString();
	}
	
	// Adicionando um filho ao nó
	public void addChild(TabuleiroNo child) { 
		child.setParent(this);
		this.children.add(child);
	}
	
	public void setParent(TabuleiroNo parent) {
		this.parent = parent;
	}
	
	public TabuleiroNo getParent() {
		return parent;
	}
	
	public int getRowBlank() {
		return linhaZero;
	}
	
	public int getColBlank() {
		return colunaZero;
	}
	
	public int [][] getMatriz(){
		return estadoAtual;
	}
	
	public List<TabuleiroNo> getChildren(){
		return children;
	}
	
	public void setChildren(List<TabuleiroNo> childrens) {
		this.children = childrens;
	}
	
    // Criando os filhos do nó atual
	public TabuleiroNo createChild(int a, int b) {
		int temp[][] = new int[estadoAtual.length][estadoAtual.length];
		
		for(int i=0; i<estadoAtual.length; i++)
			for(int j=0; j<estadoAtual[i].length; j++)
			    temp[i][j]=estadoAtual[i][j];
		
		temp[linhaZero][colunaZero] = temp[a][b];
		temp[a][b] = 0;
		
		TabuleiroNo child = new TabuleiroNo(temp);
		addChild(child);
		return child;
	}
	
	public void setDir(DIRECAO d) {
		this.direcao = d;
	}
	
	public DIRECAO getDir() {
		return direcao;
	}
	
	public boolean isGaol() { // Checa se é o objetivo final
		boolean result = false;
		//int [][] goal = {{1,2,3},{8,0,4},{7,6,5}};
		//int [][] goal = {{1,2,3},{4,5,6},{7,8,0}};
		TabuleiroNo goalNode = new TabuleiroNo(TabuleiroNo.getEstadoFinal());
		result = this.equals(goalNode);
		return result;
	}
	
	@Override
	public boolean equals(Object object) {
		if(!(object instanceof TabuleiroNo)) {
			return false;
		}
		
		TabuleiroNo check = (TabuleiroNo) object;
		return check.getString().equals(this.getString());
	}
	
	@Override
	public int hashCode() {	//Hashcode gerado pela versao string do tabuleiro
		return this.getString().hashCode();
	}
	
	public String getString() {
		return stringState;
	}	
	
	public static int[][] getEstadoFinal() {
		return estadoFinal;
	}

	public static void setEstadoFinal(int[][] estadoFinal) {
		TabuleiroNo.estadoFinal = estadoFinal;
	}

	public static boolean ExisteSolucao() {
		return existeSolucao;
	}

	public static void setExisteSolucao(boolean existeSolucao) {
		TabuleiroNo.existeSolucao = existeSolucao;
	}
}
