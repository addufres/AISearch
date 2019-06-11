package heuristicsearch;

import dijkstras.Vertices;

public class HeuristicEdge {
	// FIELDS
		/**
		 * ID for edge object
		 */
		private final String ID;
		/**
		 * Source Vertex of edge object
		 */
		private final Vertices SOURCE;
		/**
		 * Destination Vertex of edge object
		 */
		private final Vertices DESTINATION;
		/**
		 * Weight or cost of edge object
		 */
		private final int WEIGHT;
		/**
		 * Heuristic value for cost of edge object
		 */
		private final int HEURISTIC_VAL;
		
		//CONSTRUCTORS
		/**
		 * Constructor for HeuristicEdge object
		 * 
		 * @param id
		 * @param source
		 * @param destination
		 * @param weight
		 * @param heuristicVal
		 */
		public HeuristicEdge(String id, Vertices source, Vertices destination, int weight, int heuristicVal) {
			this.ID = id;
			this.SOURCE = source;
			this.DESTINATION = destination;
			this.WEIGHT = weight;
			this.HEURISTIC_VAL = heuristicVal;
		}
		
		// GETTERS
		/**
		 * @return String object representing the id of this edge
		 */
		public String getID() {
			return ID;
		}

		/**
		 * @return Vertices object of the source of this edge
		 */
		public Vertices getSOURCE() {
			return SOURCE;
		}

		/**
		 * @return Vertices object of the destination for this edge
		 */
		public Vertices getDESTINATION() {
			return DESTINATION;
		}

		/**
		 * @return int of the weight or cost of this edge
		 */
		public int getWEIGHT() {
			return WEIGHT;
		}

		// TOSTRING
		/* (non-Javadoc)
		 * @see java.lang.Object#toString()
		 */
		@Override
		public String toString() {
			return "Edge [SOURCE=" + SOURCE + ", DESTINATION=" + DESTINATION + "]";
		}
}
