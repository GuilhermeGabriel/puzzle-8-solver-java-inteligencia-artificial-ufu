package puzzle8;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class PathActions {
	// Esta classe fornece um objeto que é usado para rastrear 
	// o caminho do objetivo e então imprime o caminho
	
	List<TabuleiroNo> path;
	
	// Os argumentos são goalNode e intialNode para que um caminho possa ser encontrado.
	public PathActions(TabuleiroNo initialNode, TabuleiroNo goalNode) {  
		path = this.getPath(initialNode, goalNode);
	}

	// Dado um goalNode e initialNode, este método usa os pais do nó para rastrear seu caminho de volta
	private List<TabuleiroNo> getPath(TabuleiroNo initialNode, TabuleiroNo goalNode) {  
		TabuleiroNo tempNode = goalNode;
		List<TabuleiroNo> list = new ArrayList<TabuleiroNo>();
		
		while(!(tempNode.equals(initialNode))) {
			list.add(tempNode);
			tempNode = tempNode.getParent();
		}
		
		list.add(initialNode);
		
		// Uma lista do caminho é retornada na ordem inversa
		return list;  
	}
	
	// Esse método nos permite imprimir o caminho 
	// na ordem correta do nó inicial ao nó objetivo 
	public void printPath() {
		int size = path.size();

		for(int i=size-1;i>=0;i--) {
			System.out.println("Direção Movida: " + path.get(i).getDir());
			System.out.println("No atual: \n");
			System.out.println(Arrays.deepToString(path.get(i).getMatriz()).replace("], ", "]\n").replace("[[", "[").replace("]]", "]"));
			System.out.println();
		}
		
		System.out.println("Solução encontrada possui: " + (size-1) + " passos!");
	}
}
