package comic.repository.interfaces;
import java.util.List;

import comic.dto.ComicDTO;

public interface IComicRepository {

	
	
	static int getNumberRecords() {
		return 10;
	}
	public List<ComicDTO> retrieve();
	
}
