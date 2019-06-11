package heuristicsearch;

import java.util.List;

import dijkstras.Edge;
import dijkstras.Vertices;

public class HeuristicGraph {
	// FIELDS
		/**
		 * List object containing Vertices
		 */
		private final List<Vertices> VERTICES;
		/**
		 * List object containing Edges
		 */
		private final List<HeuristicEdge> EDGES;
		
		// CONSTRUCTORS
		/**
		 * Constructor for the Graph object used to build a representaion of edges and vertices
		 * 
		 * @param vertices
		 * @param edges
		 */
		public HeuristicGraph(List<Vertices> vertices, List<HeuristicEdge> edges) {
			this.VERTICES = vertices;
			this.EDGES = edges;
		}

		/**
		 * @return List of Vertices contained to build out the graph object
		 */
		public List<Vertices> getVERTICES() {
			return VERTICES;
		}

		/**
		 * @return List of Edges contained to build out the graph object
		 */
		public List<HeuristicEdge> getEDGES() {
			return EDGES;
		}
}
