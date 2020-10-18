package comicRest.repository;
import java.util.List;

import comicRest.dto.ComicDTO;

public interface IComicRepository {

	static final int NUMBER_RECORDS = 10;
	public List<ComicDTO> retrieve();
	
}
