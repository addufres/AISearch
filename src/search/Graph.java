package search;

import java.util.List;

/**
 * @author dufresa
 *
 */
public class Graph {

	// FIELDS
	/**
	 * List object containing Vertices
	 */
	private final List<Vertices> VERTICES;
	/**
	 * List object containing Edges
	 */
	private final List<Edge> EDGES;
	
	// CONSTRUCTORS
	/**
	 * Constructor for the Graph object used to build a representaion of edges and vertices
	 * 
	 * @param vertices
	 * @param edges
	 */
	public Graph(List<Vertices> vertices, List<Edge> edges) {
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
	public List<Edge> getEDGES() {
		return EDGES;
	}
	
	
}
