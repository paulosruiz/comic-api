package comic.service.interfaces;

import java.util.List;

import comic.dto.ComicDTO;

public interface IComicService {
	public List<ComicDTO> retrieveComics();
}
