import java.util.*;

public class Map {
	private ArrayList<ArrayList<Node>> nodes;
	
	public Map(int numDimensions, double min, double max, int x, int y) {
		nodes = new ArrayList<>();

		for (int i = 0; i < x; i++) {
			nodes.add(new ArrayList<>());

			for (int j = 0; j < y; j++) {
				nodes.get(i).add(new Node(numDimensions, min, max));
			}
		}
	}

	public Node getBestMatchingUnit(ArrayList<Double> inputVector) {
		Node bmu = nodes.get(0).get(0);
		double bmuDistance = bmu.euclideanDistance(inputVector);

		for (int i = 0; i < nodes.size(); i++) {
			ArrayList<Node> row = nodes.get(i);

			for (int j = 0; j < row.size(); j++) {
				if (i == 0 && j == 0) { // skip node at [0,0]
					continue;
				}

				Node node = row.get(j);
				double nodeDistance = bmu.euclideanDistance(inputVector);

				if (nodeDistance < bmuDistance) {
					bmu = node;
					bmuDistance = nodeDistance;
				}
			}
		}

		return bmu;
	}

	public void adjustNodes(ArrayList<Double> inputVector, Node bestMatchingUnit, double radius) {
		// TODO
	}

	@Override
	public String toString() {
		String s = "";

		for (int i = 0; i < nodes.size(); i++) {
			ArrayList<Node> row = nodes.get(i);

			for (int j = 0; j < row.size(); j++) {
				Node node = row.get(j);
				s += node.toString();

				if (j != row.size() - 1) {
					s += ",";
				}
			}

			if (i != nodes.size() - 1) {
				s += "\n";
			}
		}

		return s;
	}
}