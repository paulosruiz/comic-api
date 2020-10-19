package comicRest;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertNotNull;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

import comic.dto.ComicDTO;
import comic.services.impl.ComicService;

public class ComicServiceTest {

	@Test
	public void getComics() {
		ComicService cs = new ComicService();
		List<ComicDTO> list = cs.getComics();

		assertNotNull("List Retrieved", list);

		assertEquals("List has 20 objects", list.size(), 20);

	}

	@Test
	public void map() {
		ComicService cs = new ComicService();

		ComicDTO post2 = new ComicDTO();
		post2.setTitle("First comic");
		post2.setBrowserURL("http://browser.url/urlbrowser");
		post2.setPictureURL("http://picture.url/urlpicture");
		post2.setDate(LocalDate.of(2020, 10, 18));

		List<ComicDTO> list = new ArrayList<ComicDTO>();
		list.add(post2);
		String result = cs.mapComic(list);

		String expected = "[{\"pictureURL\":\"http://picture.url/urlpicture\",\"title\":\"First comic\",\"browserURL\":\"http://browser.url/urlbrowser\",\"publishingDate\":\"2020-10-18\"}]";
		assertEquals("Test Map", expected, result);

	}

	@Test
	public void sort() {

		ComicService cs = new ComicService();
		List<ComicDTO> list = new ArrayList<ComicDTO>();

		ComicDTO post1 = new ComicDTO();
		post1.setTitle("Second comic");
		post1.setDate(LocalDate.of(2020, 10, 18));

		list.add(post1);

		ComicDTO post2 = new ComicDTO();
		post2.setTitle("First comic");
		post2.setDate(LocalDate.of(2020, 10, 19));
		list.add(post2);

		assertNotEquals("Different objects", post1, post2);

		assertEquals("Before Sorted Sorted by Date", post1, list.get(0));
		cs.sortByPublishDate(list);
		assertEquals("List Sorted by Date", post2, list.get(0));
	}

	
}
