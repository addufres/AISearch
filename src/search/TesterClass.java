package search;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
//import static org.junit.Assert.assertNotNull;
//import static org.junit.Assert.assertTrue;

public class TesterClass {

	// FIELDS
	private List<Vertices> nodes;
	private List<Edge> edges;
	
	public static void main(String args[]) {
		TesterClass tc = new TesterClass();
		tc.testExecute();
	}
	
	public void testExecute() {
		nodes = new ArrayList<Vertices>();
		edges = new ArrayList<Edge>();
		
		for(int i = 0; i < 12; i++) {
			Vertices location = new Vertices("Node_" + i, "Node_" + i);
			nodes.add(location);
		}
		//    edge name    vertex start   vertex end   weight
		addLane("Edge_0", 		0, 			1, 			2);
		addLane("Edge_1", 0, 4, 1);
		addLane("Edge_2", 1, 2, 1);
		addLane("Edge_3", 1, 5, 3);
		addLane("Edge_4", 2, 3, 2);
		addLane("Edge_5", 3 ,7 ,1);
		addLane("Edge_6", 4, 8, 1);
		addLane("Edge_7", 5, 4, 5);
		addLane("Edge_8", 5, 6, 1);
		addLane("Edge_9", 5, 9, 4);
		addLane("Edge_10", 6, 2, 3);
		addLane("Edge_11", 6, 10, 10);
		addLane("Edge_12", 7, 11, 15);
		addLane("Edge_13", 8, 9, 8);
		addLane("Edge_14", 9, 10, 3);
		addLane("Edge_15", 10, 11, 1);
		addLane("Edge_16", 7, 6, 5);
		
		// Check graph from location Loc_1 to Loc_10
		Graph graph = new Graph(nodes, edges);
		DijkstrasAlgorithm da = new DijkstrasAlgorithm(graph);
		da.execute(nodes.get(0));
		LinkedList<Vertices> path = da.getPath(nodes.get(10));
		
//		assertNotNull(path);
//		assertTrue(path.size() > 0);
		
		for(Vertices v : path) {
			System.out.println(v);
		}
	}
	
	private void addLane(String laneId, int sourceLocation, int destinationLocation, int duration) {
		Edge lane = new Edge(laneId, nodes.get(sourceLocation), nodes.get(destinationLocation), duration);
		edges.add(lane);
	}
}
