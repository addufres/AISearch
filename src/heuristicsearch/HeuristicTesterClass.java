package heuristicsearch;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

import dijkstras.Vertices;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

public class HeuristicTesterClass {
	
	private List<Vertices> nodes;
	private List<HeuristicEdge> edges;
	
	public static void main(String[] args) {
		HeuristicTesterClass htc = new HeuristicTesterClass();
		htc.execute();
	}
	
	public void execute() {
		nodes = new ArrayList<Vertices>();
		edges = new ArrayList<HeuristicEdge>();
		for(int i = 0; i< 12; i++) {
			Vertices node = new Vertices("Node_" + i, "Node_" + i);
			nodes.add(node);
		}
		
        addLane("Edge_0", 		0, 			1, 			2, 			12);
        addLane("Edge_1", 0, 4, 1, 12);
        addLane("Edge_2", 1, 2, 1, 16);
        addLane("Edge_3", 1, 5, 3, 7);
        addLane("Edge_4", 2, 3, 2, 14);
        addLane("Edge_5", 3, 7, 1, 15);
        addLane("Edge_6", 4, 8, 1, 12);
        addLane("Edge_7", 5, 4, 5, 12);
        addLane("Edge_8", 5, 6, 1, 11);
        addLane("Edge_9", 5, 9, 4, 4);
        addLane("Edge_10", 6, 2, 3, 16);
        addLane("Edge_11", 6, 10, 10, 1);
        addLane("Edge_12", 7, 11, 15, 0);
        addLane("Edge_13", 8, 9, 8, 4);
        addLane("Edge_14", 9, 10, 3, 1);
        addLane("Edge_15", 10, 11, 1, 0);
        addLane("Edge_16", 7, 6, 5, 11);
        
        
        // Check from node Loc_1 to Loc_10
        HeuristicGraph graph = new HeuristicGraph(nodes, edges);
        AStarAlgorithm astar = new AStarAlgorithm(graph);
        astar.execute(nodes.get(0));
        LinkedList<Vertices> path = astar.getPath(nodes.get(10));
        
        assertNotNull(path);
        assertTrue(path.size() > 0);
        
        for(Vertices v : path) {
        	System.out.println(v);
        }
	}
	
	private void addLane(String laneId, int sourceLocation, int destinationLocation, int cost, int heuristicValue) {
		HeuristicEdge lane = new HeuristicEdge(laneId, nodes.get(sourceLocation), nodes.get(destinationLocation), cost, heuristicValue);
		edges.add(lane);
	}
	
}
