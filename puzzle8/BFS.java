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
		info.queue.add(node);  //No inicial � adicionado na fila
		
		while(!(info.queue.isEmpty())) {   // Loop continua enquanto a fila n�o estiver vazia
			
			node = info.queue.remove();   // Remove o no do inicio da fila
			
			info.visited.put(node.hashCode(), node);   //Coloca o n� no hashMap como visitado
			
			//Se o objetivo for encontrado, um caminho � criado e um caminho � impresso
			if (node.isGaol()) {
				PathActions p = new PathActions(initialNode, node);
				p.printPath();
				TabuleiroNo.setExisteSolucao(true);
				return true;
			}
			
			//Fun��o sucessora que fornece os filhos do n�
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
