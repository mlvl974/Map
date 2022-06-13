import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;

public class MapApp {

	public static void main(String[] args) {

		HashMap<Integer, Integer> orders = new HashMap<>();

		try {
			BufferedReader reader = new BufferedReader(new FileReader("mapdemo.csv"));
			String line;
			while ((line = reader.readLine()) != null) {
				
				System.out.println(line);
				

				String[] values = line.split(",");
			
				try {

					//key
					int userId = Integer.parseInt(values[0]);
					
					//value
					int cost = Integer.parseInt(values[1]);

					

					if (!orders.containsKey(userId))

					{

						orders.put(userId, cost);
					}

					else {
						orders.put(userId, orders.get(userId) + cost);
					}

				} catch (NumberFormatException e) {
					System.out.println("NumberFormatException occurred");
				}
			}

		} catch (IOException e) {
			e.printStackTrace();
		}

		
		System.out.println("\n =======Consolidated Orders=====");
		System.out.println(orders);

	}

}




