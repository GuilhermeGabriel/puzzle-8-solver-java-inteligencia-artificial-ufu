package puzzle8;

import java.util.List;

public class BFS implements Search{
	
	private TabuleiroNo initialNode;
	
	// Construtor que recebe e seta o no inicial
	public BFS(TabuleiroNo node) {
		this.initialNode = node;
	}
	
	public boolean search() {
		Utils info = new Utils(); // Classe que contem algumas estruturas de dados hashmap, fila, pilha

		TabuleiroNo node = initialNode; 
		info.queue.add(node);  //No inicial é adicionado na fila
		
		while(!(info.queue.isEmpty())) {   // Loop continua enquanto a fila não estiver vazia
			
			node = info.queue.remove();   // Remove o no do inicio da fila
			
			info.visited.put(node.hashCode(), node);   //Coloca o nó no hashMap como visitado
			
			//Se o objetivo for encontrado, um caminho é criado e um caminho é impresso
			if (node.isGaol()) {
				PathActions p = new PathActions(initialNode, node);
				p.printPath();
				TabuleiroNo.setExisteSolucao(true);
				return true;
			}
			
			//Função sucessora que fornece os filhos do nó
			Successor s = new Successor();
			List<TabuleiroNo> list = s.successor(node);
			
			for(TabuleiroNo temp: list) {
				boolean vis = info.visited.containsKey(temp.hashCode());
				
				if(!vis){
					info.queue.add(temp);
				}
			}

		}

		return false;
	}
}
