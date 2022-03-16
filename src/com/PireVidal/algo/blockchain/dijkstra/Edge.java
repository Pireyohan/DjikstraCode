package com.PireVidal.algo.blockchain.dijkstra;


public class Edge {
		private int fromNodeIndex;
		private int toNodeIndex;
		private int length;
		
		
		public Edge(int fromNodeIndex, int toNodeIndex, int length) {
			
			this.fromNodeIndex = fromNodeIndex;
			this.toNodeIndex = toNodeIndex;
			this.length = length;
		}


		public int getFromNodeIndex() {
			return fromNodeIndex;
		}


		public void setFromNodeIndex(int fromNodeIndex) {
			this.fromNodeIndex = fromNodeIndex;
		}


		public void setToNodeIndex(int toNodeIndex) {
			this.toNodeIndex = toNodeIndex;
		}


		public void setLength(int length) {
			this.length = length;
		}


		public int getToNodeIndex() {
			return toNodeIndex;
		}


		public int getLength() {
			return length;
		}
		//déterminer le mode de voisinage d'un noeud fourni, sur la base des deux noeuds reliés par cette arête.
		public int getNeighbourIndex (int nodeIndex) {
			if(this.fromNodeIndex==nodeIndex) {
				return this.toNodeIndex;
			}else {
				return this.fromNodeIndex;
			}
			
		}
		
		
    }


    

