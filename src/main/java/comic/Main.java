package comic;

import static spark.Spark.get;
import static spark.Spark.port;

public class Main {
	public static void main(String[] args) {
		port(8080); // Spark will run on port 8080
		get("/retrieve", (req, res) -> {
			ComicService cs = new ComicService();
			return cs.retrieveComics();
		});
	}
}