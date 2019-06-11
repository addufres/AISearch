package heuristicsearch;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;

import dijkstras.Edge;
import dijkstras.Graph;
import dijkstras.Vertices;

public class AStarAlgorithm {
	// FINAL FIELDS
		/**
		 * List of Vertices objects to hold the nodes for the graph object used to traverse the search
		 */
		private final List<Vertices> NODES;
		/**
		 * List of the Edge object to hold all the costs
		 */
		private final List<HeuristicEdge> EDGES;
		// FIELDS
		/**
		 * Close set
		 */
		private Set<Vertices> close;
		/**
		 * Open set
		 */
		private Set<Vertices> open;
		/**
		 * Keeps track of all the nodes that come before in the algorithm
		 */
		private Map<Vertices, Vertices> predecessors;
		/**
		 * Keeps track of the cost of any particular vertex
		 */
		private Map<Vertices, Integer> distance;
		
		/**
		 * Constructor for the algorithm 
		 * Contructs a graph object to use during the search
		 * @param graph
		 */
		public AStarAlgorithm(HeuristicGraph graph) {
			// create a copy of the array so that you can work with the array
			this.NODES = new ArrayList<Vertices>(graph.getVERTICES());
			this.EDGES = new ArrayList<HeuristicEdge>(graph.getEDGES());
		}
		
		/**
		 * Execution method that sets the open, close, distance, and predecessors
		 * 
		 * Also kicks off the search itself running through the open set until its size is 0 at which point it terminates the search.
		 * 
		 * @param source is the Vertex to begin the search at.
		 */
		public void execute(Vertices source) {
			close = new HashSet<Vertices>();
			open = new HashSet<Vertices>();
			distance = new HashMap<Vertices, Integer>();
			predecessors = new HashMap<Vertices, Vertices>();
			// set the distance to 0 initially since there is nothing to come before it at the start
			distance.put(source, 0);
			// set the source into the open dataset initially to begin the search there
			// otherwise it fails immediately on step two when it sees nothing in open set
			open.add(source);
			while(open.size() > 0){
				Vertices node = getMinimum(open);
				close.add(node);
				open.remove(node);
				findMinimalDistances(node);
			}
		}
		
		/**
		 * findMinimalDistances compares the distances between to Vertices 
		 * and adds the minimal value to the open set if the target is less than the neighbors of the passed in?? double check that lol 
		 * 
		 * @param nodePassed is the Vertex passed in to compare against
		 */
		private void findMinimalDistances(Vertices nodePassed) {
			List<Vertices> nodesAdjacent = getNeighbors(nodePassed);
			for(Vertices targetNode : nodesAdjacent) {
				if(getShortestDistance(targetNode) > getShortestDistance(nodePassed)
						+ getDistance(nodePassed, targetNode)) {
					distance.put(targetNode, getShortestDistance(nodePassed) 
							+ getDistance(nodePassed, targetNode));
					predecessors.put(targetNode, nodePassed);
					open.add(targetNode);
				}
			}
		}
		
		/**
		 * Gets the distance of node if it equals the target value
		 * 
		 * @param node
		 * @param target
		 * @return int distance of node
		 */
		private int getDistance(Vertices node, Vertices target) {
			for(HeuristicEdge e : EDGES) {
				if(e.getSOURCE().equals(node)
						&& e.getDESTINATION().equals(target)) {
					return e.getWEIGHT();
				}
			}
			throw new RuntimeException("That shouldn't happen.");
		}
		
		/**
		 * Gets the neighbors of the node passed in if close set does not contain the passed in node
		 * 
		 * @param node
		 * @return List of Vertices that are adjacent to node passed in and not in close set
		 */
		private List<Vertices> getNeighbors(Vertices node) {
			List<Vertices> neighbors = new ArrayList<Vertices>();
			for(HeuristicEdge e : EDGES) {
				if(e.getSOURCE().equals(node)
						&& !isSettled(e.getDESTINATION())) {
					neighbors.add(e.getDESTINATION());
				}
			}
			return neighbors;
		}
		
		/**
		 * Gets vertex with minimum distance in open set 
		 * 
		 * @param vertices
		 * @return Vertices with minimum distance
		 */
		private Vertices getMinimum(Set<Vertices> vertices) {
			Vertices min = null;
			for(Vertices v : vertices) {
				if(min == null){
					min = v;
				} else {
					if(getShortestDistance(v) < getShortestDistance(min)) {
						min = v;
					}
				}
			}
			return min;
		}
		
		/**
		 * Returns whether or not passed in Vertex is in close set
		 * 
		 * @param vertex
		 * @return boolean whether or not vertex is in close set
		 */
		private boolean isSettled(Vertices vertex) {
			return close.contains(vertex);
		}
		
		/**
		 * Gets the shortest distance on a particular node
		 * 
		 * @param vDistance
		 * @return int of the shortest distance of a individual node
		 */
		private int getShortestDistance(Vertices vDistance) {
			Integer d = distance.get(vDistance);
			if(d == null) {
				return Integer.MAX_VALUE;
			} else {
				return d;
			}
		}
		
		/**
		 * This returns the path from the source to the selected target and will return NULL if no path exists or is found
		 * 
		 * @param target
		 * @return LinkedList<Vertices> or null if no path can be found 
		 */
		public LinkedList<Vertices> getPath(Vertices target) {
			LinkedList<Vertices> path = new LinkedList<Vertices>();
			Vertices step = target;
			// check for existence of path
			if(predecessors.get(step) == null) {
				return null;
			}
			path.add(step);
			while(predecessors.get(step) != null){
				step = predecessors.get(step);
				path.add(step);
			}
			// Put it into the correct order
			Collections.reverse(path);
			return path;
		}
}
