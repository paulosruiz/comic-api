package comicRest.repository;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;

import comicRest.dto.ComicDTO;
import comicRest.dto.XkcdDTO;

public class XkcdRepository implements IComicRepository {

	final static String CURRENT_URL = "https://xkcd.com/info.0.json";
	final static String NUMBER_URL = "https://xkcd.com/NUMBER/info.0.json";

	public List<ComicDTO> retrieve() {

		final List<ComicDTO> list = new ArrayList<ComicDTO>();
		XkcdDTO currentXkcd = retrieveCurrent();
		int currentNumber = currentXkcd.getNum();

		// Add first one to the list
		ComicDTO comicObject = currentXkcd.toComicDTO();
		list.add(comicObject);

		// Add the other to the list
		for (int i = 1; i < this.NUMBER_RECORDS; i++) {
			currentXkcd = retrieveLastComics(currentNumber - i);
			comicObject = currentXkcd.toComicDTO();
			list.add(comicObject);
		}

		return list;
	}

	private XkcdDTO retrieveCurrent() {
		HttpRequest request = HttpRequest.newBuilder().GET().uri(URI.create(CURRENT_URL)).build();

		XkcdDTO result = map(request);
		return result;
	}

	private XkcdDTO retrieveLastComics(int id) {

		HttpRequest request = HttpRequest.newBuilder().GET()
				.uri(URI.create(NUMBER_URL.replace("NUMBER", String.valueOf(id))))
				// .setHeader("User-Agent", "Java 11 HttpClient Bot") // add request header
				.build();

		return map(request);
	}

	private XkcdDTO map(HttpRequest request) {
		HttpResponse<String> response;
		try {
			final HttpClient httpClient = HttpClient.newBuilder().version(HttpClient.Version.HTTP_1_1)
					.connectTimeout(Duration.ofSeconds(10)).build();
			response = httpClient.send(request, HttpResponse.BodyHandlers.ofString());
			ObjectMapper objectMapper = new ObjectMapper();
			objectMapper.disable(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES);
			// print response body
			XkcdDTO mapping = objectMapper.readValue(response.body(), XkcdDTO.class);

			return mapping;

		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

}
