package comic.repository.interfaces;
import java.util.List;

import comic.dto.ComicDTO;

public interface IComicRepository {

	
	
	public List<ComicDTO> retrieve(int qty);
	
}
