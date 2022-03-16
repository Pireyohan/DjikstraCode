package com.PireVidal.algo.blockchain.dijkstra;

public class Main {

	public static void main(String[] args) {
		/**********************Expression pour la blockchain ******************************************/
		Edge[] edges = { new Edge(0, 2, 1), new Edge(0, 3, 4), new Edge(0, 4, 2), new Edge(0, 1, 3), new Edge(1, 3, 2),
				new Edge(1, 4, 3), new Edge(1, 5, 1), new Edge(2, 4, 1), new Edge(3, 5, 4), new Edge(4, 5, 2),
				new Edge(4, 6, 7), new Edge(4, 7, 2), new Edge(5, 6, 4), new Edge(6, 7, 5) 
				};
		
		
		// Exemple résentation power point 		
		//  A= 0  B=1 C=2  D=3 E=4 F=5 G=6
		
		Edge[] edges2 = { new Edge(0, 1, 34), new Edge(1, 4, 20), new Edge(4, 6, 15), new Edge(0, 2, 25), new Edge(1, 3, 15),
				new Edge(2, 1, 12), new Edge(2, 3, 24), new Edge(2, 5, 37), new Edge(3, 5, 11), new Edge(3, 4, 13),
				new Edge(5, 6,16)
				};
		// Exam Blanc
		Edge[] edges3 = { new Edge(0, 1, 2), new Edge(0, 2, 1), new Edge(1, 2, 2), new Edge(1, 3, 1), new Edge(1, 4, 3),
				new Edge(2, 4, 3), new Edge(2, 3, 4), new Edge(3, 4, 3), new Edge(3, 5, 6), new Edge(2, 5, 5),
				new Edge(4, 5,1), new Edge(3, 6, 5), new Edge(5, 6, 2)
				};
		
		Graph g = new Graph(edges3);
		g.calculateShortesDistances();

		g.printResult(); // ouf
	}

}
