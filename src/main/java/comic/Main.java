package comic;

import static spark.Spark.get;
import static spark.Spark.port;

public class Main {
	// TODO ordena��o no servi�o
	// Date (improve Date handle)
	// Test
	// Mock dos servi�os via repositorio
// porta 8080
	// docker compose
	// co rotinas
	
	public static void main(String[] args) {
		port(8080); // Spark will run on port 8080
		get("/retrieve", (req, res) -> {
			ComicService cs = new ComicService();
			return cs.retrieveComics();
		});
	}
}