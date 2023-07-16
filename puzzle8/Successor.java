package puzzle8;

import java.util.ArrayList;
import java.util.List;

public class Successor {

	public Successor() {
	}
	
	// Função sucessora que pega um estado e retorna uma 
	// lista de possíveis estados que podem ser alcançados
	
	public List<TabuleiroNo> successor(TabuleiroNo node) {
		List<TabuleiroNo> list = new ArrayList<TabuleiroNo>();
		
		int lin = node.getRowBlank();
		int col = node.getColBlank();
		
		// Cima
		if((col !=0 || col != 1 || col != 2) && (lin !=0) ) {  
			TabuleiroNo upNode = node.createChild(lin-1, col);
			upNode.setDir(DIRECAO.CIMA);
			list.add(upNode);
		}
		
		// Baixo
		if((col !=0 || col != 1 || col != 2) && (lin !=2) ) {
			TabuleiroNo downNode = node.createChild(lin+1, col);
			downNode.setDir(DIRECAO.BAIXO);
			list.add(downNode);
		}
		
		// Direita
		if((lin != 0 || lin != 1 || lin != 2) && (col !=2)) {
			TabuleiroNo rightNode = node.createChild(lin, col+1);
			rightNode.setDir(DIRECAO.DIREITA);
			list.add(rightNode);
		}
		
		// Esquerda
		if((lin != 0 || lin != 1 || lin != 2) && (col !=0)) {
			TabuleiroNo leftNode = node.createChild(lin, col-1); 
			leftNode.setDir(DIRECAO.ESQUERDA);  
			list.add(leftNode);
		}
		
		return list;
	}
}
