package GraphBasics;

import java.util.HashSet;

public class GraphClient {
	public static void main(String args[])
	{
		Graph graph=new Graph();
		graph.addVertex("A");
		graph.addVertex("B");
		graph.addVertex("C");
		graph.addVertex("D");
		graph.addVertex("E");
		graph.addVertex("F");
		
		graph.addEdge("A","B",1);
		graph.addEdge("A","C",2);
		graph.addEdge("B","A",1);
		graph.addEdge("B","C",3);
		graph.addEdge("B","D",5);
		graph.addEdge("B","E",4);
		graph.addEdge("C","A",2);
		graph.addEdge("C","B",3);
		graph.addEdge("C","D",4);
		graph.addEdge("D","C",4);
		graph.addEdge("D","B",5);
		graph.addEdge("D","E",3);
		graph.addEdge("E","B",4);
		graph.addEdge("E","D",3);
		
		//HashSet<String> processed=new HashSet<String>();
		graph.display();
		//System.out.println(graph.hasPath("A","F"));
		System.out.println(graph.numOfEdges());
		//graph.removeVertex("B");
		//graph.display();
		System.out.println(graph.BFS("A","F"));
		System.out.println(graph.DFS("A","B"));
	}
}
