package comic;

import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.databind.ObjectMapper;

import comic.dto.ComicDTO;
import comic.repository.impl.PdlRepository;
import comic.repository.impl.XkcdRepository;
import comic.repository.interfaces.IComicRepository;

public class ComicService {

	private List<IComicRepository> repositories;

	ComicService() {

		this.repositories = new ArrayList<IComicRepository>();
		this.repositories.add(new PdlRepository());

		this.repositories.add(new XkcdRepository());

	}

	public String retrieveComics() {

		List<ComicDTO> listComics = new ArrayList<>();
		String jsonStr = null;

		for (IComicRepository repo : repositories) {
			listComics.addAll(repo.retrieve());
		}

		// Sort
		listComics.sort((a, b) -> b.getPublishingDate().compareTo(a.getPublishingDate()));

		ObjectMapper objMap = new ObjectMapper();
		
		try {
			jsonStr = objMap.writeValueAsString(listComics);
			return jsonStr;
		} catch (Exception e) {

		}
		return jsonStr;

	}

}
