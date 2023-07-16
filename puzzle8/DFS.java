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
		info.stack.push(node);  // Uma pilha é usada para simular uma recursao
		
		while(!(info.stack.isEmpty())) { // Loop continua enquanto a pilha não estiver vazia
			
			node = info.stack.pop(); // Remove o no do inicio da pilha
			
			// Coloca o nó no hashMap como visitado
			info.visited.put(node.hashCode(), node);
			
			// Se o objetivo for encontrado, um caminho é criado e um caminho é impresso
			if (node.isGaol()) {
				PathActions p = new PathActions(initialNode, node);
				p.printPath();
				TabuleiroNo.setExisteSolucao(true);
				return true;
			}
			
			// Função sucessora que fornece os filhos do nó
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
