package puzzle8;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class Utils {
	// Classe info que é usada em todas as pesquisas esta classe  
	// possui estruturas de dados como fila, fila de prioridade, pilha e hashmap
	
	public Queue<TabuleiroNo> queue;
	public Stack<TabuleiroNo> stack;
	public HashMap<Integer,TabuleiroNo> visited; 
	
	public Utils() {
		queue = new LinkedList<TabuleiroNo>();
		stack = new Stack<TabuleiroNo>();
		visited = new HashMap<Integer,TabuleiroNo>();	
	}
}
