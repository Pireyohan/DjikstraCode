package com.PireVidal.algo.blockchain.dijkstra;

import java.util.ArrayList;

// Maintenant on doit cr�e une objet graph et y implement l'algorythm de dijkstra
public class Graph {
	//Noeud
	private Node[] nodes;
	private int noOfNodes;
	// Arete
	private Edge[] edges;
	private int noOfEdges;
	
	//Constructeur Graph
	
	public Graph(Edge[] edges) { // l'objet graph prend en param�tre les informations sur une arrete, depart, arriv�, distance
		
		// On attribue a la valeur locale edges le tableau de coordonn�es du main
		this.edges = edges;
		
		// cr�e tous les noeuds
		// On calcule le nombre de noeud composant le reseaux et on l'attribue le nombre � l'entier noofedges
		// On obtient le nombre de noeud total du reseau
		
		this.noOfNodes = calculateNoOFNodes(edges); // calcul du nombre de noeuds
		
		// la variable node est un tableau compos�es deux deux attributs qui sont une distance depuis l'origine et une valeur boolenne de visiter.
		// on instancie le nombre de noeud correspondant au nombre de noeuds trouv� lors du parcours du tableau de coordonn�es Edges , contenant
		//la description de l'arrete entre deux points
		
		this.nodes = new Node[this.noOfNodes]; // on cr�e le nombre de noeuds n�cessaire en instanciant l'objet noeuds et en le placant dans une tableau de noeud

		for (int n = 0; n < this.noOfNodes; n++) {
			this.nodes[n] = new Node();
		}
		// ajoute toutes les ar�tes aux noeuds, chaque ar�te �tant ajout�e � deux noeuds (vers et depuis).
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
		// le noeud 0 est la source de d�part 
		this.nodes[0].setDistanceFromSource(0);
		int nextNode = 0;
		// visite� tous les nodes
		for (int i = 0; i < this.nodes.length; i++) {
			// boucle autour de ces adjacents du noeud actuel
			ArrayList<Edge> currentNodeEdges = this.nodes[nextNode].getEdges();

			for (int joinedEdge = 0; joinedEdge < currentNodeEdges.size(); joinedEdge++) {
				int neighbourIndex = currentNodeEdges.get(joinedEdge).getNeighbourIndex(nextNode);
				// si ce n'est pas visit�
				if (!this.nodes[neighbourIndex].isVisited()) {
					int tentative = this.nodes[nextNode].getDistanceFromSource()
							+ currentNodeEdges.get(joinedEdge).getLength();
					if (tentative < nodes[neighbourIndex].getDistanceFromSource()) {
						nodes[neighbourIndex].setDistanceFromSource(tentative);
					}
				}
			}
			// tous les bords sont v�rifi�s donc le noeud est visit�
			nodes[nextNode].setVisited(true);
			// le noeud suivant doit avoir la distance la plus courte
			nextNode = getNodeShortesDistance();
		}
	}

	// maintenant nous allons impl�menter la m�thode de distance la plus courte
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
	// afficher le r�sultat
	public void printResult() {
		String output= "Nombre de noeuds = "+ this.noOfNodes;
		output+= "\nNombre d'ar�tes = "+ this.noOfEdges;
		
		for (int i= 0 ; i< this.nodes.length; i++) {
			output+= "\nLa distance la plus courte entre le n�ud 0 et le n�ud "+ i + " est " +nodes[i].getDistanceFromSource(); 
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
