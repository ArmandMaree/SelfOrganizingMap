import java.util.*;
import java.io.*;

public class Main {
	public static void main(String[] args) {
		ArrayList<ArrayList<Double>> inputVectors = readCSVFile("../data/wine/wine.data");

		Map map = new Map(2, 0, 10, 10, 10);
		System.out.println(map);
		
		SelfOrganizingMap som = new SelfOrganizingMap(map, inputVectors);
	}

	public static ArrayList<ArrayList<Double>> readCSVFile(String csvFile) {
		BufferedReader br = null;
		String line = "";
		String cvsSplitBy = ",";
		ArrayList<ArrayList<Double>> inputVectors = new ArrayList<>();

		try {
			br = new BufferedReader(new FileReader(csvFile));

			while ((line = br.readLine()) != null) {
				// use comma as separator
				String[] parsedLine = line.split(cvsSplitBy);
				inputVectors.add(new ArrayList<>());

				for (int i = 0; i < parsedLine.length; i++) {
					inputVectors.get(inputVectors.size() - 1).add(Double.parseDouble(parsedLine[i]));
				}
			}
		}
		catch (Exception e) {
			e.printStackTrace();
			System.exit(1);
		}
		finally {
			if (br != null) {
				try {
					br.close();
				}
				catch (IOException e) {
					e.printStackTrace();
				}
			}
		}

		return inputVectors;
	}
}