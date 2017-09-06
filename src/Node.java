import java.util.*;
import java.text.*;

class Node {
	private ArrayList<Double> vector;
	private Random rand = new Random();

	public Node(int numDimensions, double min, double max) {
		vector= new ArrayList<>();

		for (int i = 0; i < numDimensions; i++) {
			vector.add(rand.nextDouble() * (max - min) + min);
		}
	}

	public double euclideanDistance(ArrayList<Double> inputVector) {
		double sum = 0;

		for (int i = 0; i < vector.size(); i++) {
			sum += Math.pow(inputVector.get(i) - vector.get(i), 2);
		}

		return Math.sqrt(sum);
	}

	@Override
	public String toString() {
		NumberFormat formatter = new DecimalFormat("#0.00");   
		String s = "[";

		for (int i = 0; i < vector.size(); i++) {
			s += formatter.format(vector.get(i));

			if (i != vector.size() - 1) {
				s += ",";
			}
		}

		s += "]";

		return s;
	}
}