package comicRest;

import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.databind.ObjectMapper;

import comicRest.dto.ComicDTO;
import comicRest.repository.IComicRepository;
import comicRest.repository.PdlRepository;
import comicRest.repository.XkcdRepository;

public class ComicService {

	private List<IComicRepository> repositories;

	ComicService() {

		this.repositories = new ArrayList<IComicRepository>();
		this.repositories.add(new XkcdRepository());
		this.repositories.add(new PdlRepository());

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
