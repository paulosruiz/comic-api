package comic.services.impl;

import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.databind.ObjectMapper;

import comic.dto.ComicDTO;
import comic.repository.impl.PdlRepository;
import comic.repository.impl.XkcdRepository;
import comic.repository.interfaces.IComicRepository;
import comic.service.interfaces.IComicService;

public class ComicService implements IComicService {

	private List<IComicRepository> repositories;

	final int NUMBER_COMICS = 10;

	public ComicService() {

		this.repositories = new ArrayList<IComicRepository>();
		this.repositories.add(new PdlRepository());
		this.repositories.add(new XkcdRepository());

	}

	public String retrieveComics() {

		List<ComicDTO> listComics = getComics();

		sortByPublishDate(listComics);

		return mapComic(listComics);

	}

	public String mapComic(List<ComicDTO> listComics) {
		ObjectMapper objMap = new ObjectMapper();

		String jsonStr = null;

		try {
			jsonStr = objMap.writeValueAsString(listComics);
		} catch (Exception e) {

		}
		return jsonStr;
	}

	public void sortByPublishDate(List<ComicDTO> listComics) {
		// Sort
		listComics.sort((a, b) -> b.getPublishingDate().compareTo(a.getPublishingDate()));
	}

	public List<ComicDTO> getComics() {
		List<ComicDTO> listComics = new ArrayList<ComicDTO>();
		for (IComicRepository repo : repositories) {
			listComics.addAll(repo.retrieve(NUMBER_COMICS));
		}
		return listComics;
	}

}
