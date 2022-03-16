package com.PireVidal.algo.blockchain.dijkstra;

import java.util.ArrayList;

// Maintenant on doit crée une objet graph et y implement l'algorythm de dijkstra
public class Graph {
	//Noeud
	private Node[] nodes;
	private int noOfNodes;
	// Arete
	private Edge[] edges;
	private int noOfEdges;
	
	//Constructeur Graph
	
	public Graph(Edge[] edges) { // l'objet graph prend en paramétre les informations sur une arrete, depart, arrivé, distance
		
		// On attribue a la valeur locale edges le tableau de coordonnées du main
		this.edges = edges;
		
		// crée tous les noeuds
		// On calcule le nombre de noeud composant le reseaux et on l'attribue le nombre à l'entier noofedges
		// On obtient le nombre de noeud total du reseau
		
		this.noOfNodes = calculateNoOFNodes(edges); // calcul du nombre de noeuds
		
		// la variable node est un tableau composées deux deux attributs qui sont une distance depuis l'origine et une valeur boolenne de visiter.
		// on instancie le nombre de noeud correspondant au nombre de noeuds trouvé lors du parcours du tableau de coordonnées Edges , contenant
		//la description de l'arrete entre deux points
		
		this.nodes = new Node[this.noOfNodes]; // on crée le nombre de noeuds nécessaire en instanciant l'objet noeuds et en le placant dans une tableau de noeud

		for (int n = 0; n < this.noOfNodes; n++) {
			this.nodes[n] = new Node();
		}
		// ajoute toutes les arêtes aux noeuds, chaque arête étant ajoutée à deux noeuds (vers et depuis).
		this.noOfEdges = edges.length;
		for (int edgeToAdd = 0; edgeToAdd < this.noOfEdges; edgeToAdd++) {
			this.nodes[edges[edgeToAdd].getFromNodeIndex()].getEdges().add(edges[edgeToAdd]);
			this.nodes[edges[edgeToAdd].getToNodeIndex()].getEdges().add(edges[edgeToAdd]);
		}
	}

	private int calculateNoOFNodes(Edge[] edges) {
		int noOfNodes = 0;
		for (Edge e : edges) {
			if (e.getToNodeIndex() > noOfNodes)
				noOfNodes = e.getToNodeIndex();
			if (e.getFromNodeIndex() > noOfNodes)
				noOfNodes = e.getFromNodeIndex();
		}
		noOfNodes++;
		return noOfNodes;
	}

	public void calculateShortesDistances() {
		// le noeud 0 est la source de départ 
		this.nodes[0].setDistanceFromSource(0);
		int nextNode = 0;
		// visiteé tous les nodes
		for (int i = 0; i < this.nodes.length; i++) {
			// boucle autour de ces adjacents du noeud actuel
			ArrayList<Edge> currentNodeEdges = this.nodes[nextNode].getEdges();

			for (int joinedEdge = 0; joinedEdge < currentNodeEdges.size(); joinedEdge++) {
				int neighbourIndex = currentNodeEdges.get(joinedEdge).getNeighbourIndex(nextNode);
				// si ce n'est pas visité
				if (!this.nodes[neighbourIndex].isVisited()) {
					int tentative = this.nodes[nextNode].getDistanceFromSource()
							+ currentNodeEdges.get(joinedEdge).getLength();
					if (tentative < nodes[neighbourIndex].getDistanceFromSource()) {
						nodes[neighbourIndex].setDistanceFromSource(tentative);
					}
				}
			}
			// tous les bords sont vérifiés donc le noeud est visité
			nodes[nextNode].setVisited(true);
			// le noeud suivant doit avoir la distance la plus courte
			nextNode = getNodeShortesDistance();
		}
	}

	// maintenant nous allons implémenter la méthode de distance la plus courte
	private int getNodeShortesDistance() {
		int storedNodeIndex = 0;
		int storedDist = Integer.MAX_VALUE;

		for (int i = 0; i < this.nodes.length; i++) {
			int currentDist = this.nodes[i].getDistanceFromSource();

			if (!this.nodes[i].isVisited() && currentDist < storedDist) {
				storedDist = currentDist;
				storedNodeIndex = i;
			}
		}
		return storedNodeIndex;
	}
	// afficher le résultat
	public void printResult() {
		String output= "Nombre de noeuds = "+ this.noOfNodes;
		output+= "\nNombre d'arêtes = "+ this.noOfEdges;
		
		for (int i= 0 ; i< this.nodes.length; i++) {
			output+= "\nLa distance la plus courte entre le nœud 0 et le nœud "+ i + " est " +nodes[i].getDistanceFromSource(); 
		}
		System.out.println(output);
	}

	public Node[] getNodes() {
		return nodes;
	}

	public int getNoOfNodes() {
		return noOfNodes;
	}

	public Edge[] getEdges() {
		return edges;
	}

	public int getNoOfEdges() {
		return noOfEdges;
	}

}
