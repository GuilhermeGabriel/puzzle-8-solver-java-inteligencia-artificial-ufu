package puzzle8;

import java.util.List;

public class DFS implements Search {
	private TabuleiroNo initialNode;
	
	public DFS(TabuleiroNo node) {
		this.initialNode = node;
	}
	
	public boolean search() {
		Utils info = new Utils(); // Classe que contem algumas estruturas de dados hashmap, fila, pilha
		
		TabuleiroNo node = initialNode;
		info.stack.push(node);  // Uma pilha � usada para simular uma recursao
		
		while(!(info.stack.isEmpty())) { // Loop continua enquanto a pilha n�o estiver vazia
			
			node = info.stack.pop(); // Remove o no do inicio da pilha
			
			// Coloca o n� no hashMap como visitado
			info.visited.put(node.hashCode(), node);
			
			// Se o objetivo for encontrado, um caminho � criado e um caminho � impresso
			if (node.isGaol()) {
				PathActions p = new PathActions(initialNode, node);
				p.printPath();
				TabuleiroNo.setExisteSolucao(true);
				return true;
			}
			
			// Fun��o sucessora que fornece os filhos do n�
			Successor s = new Successor();
			List<TabuleiroNo> list = s.successor(node);
			
			for(TabuleiroNo temp: list) {
				boolean vis = info.visited.containsKey(temp.hashCode());
				if(!vis){
					info.stack.push(temp);
				}
			}
			
		}
		
		return false;
	}
}
