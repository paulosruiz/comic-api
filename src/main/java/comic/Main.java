package comic;

import static spark.Spark.get;
import static spark.Spark.port;

import comic.service.interfaces.IComicService;
import comic.services.impl.ComicService;

public class Main {
	public static void main(String[] args) {
		port(8080); // Spark will run on port 8080
		get("/retrieve", (req, res) -> {
			IComicService comic = new ComicService();
			return comic.retrieveComics();
		});
	}
}