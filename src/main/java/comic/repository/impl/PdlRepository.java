package comic.repository.impl;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import com.apptastic.rssreader.Item;
import com.apptastic.rssreader.RssReader;

import comic.dto.ComicDTO;
import comic.dto.PdlDTO;
import comic.repository.interfaces.IComicRepository;

//Poorly Draw Lines
public class PdlRepository implements IComicRepository {

	private final String FEED_URL = "http://feeds.feedburner.com/PoorlyDrawnLines";

	public List<ComicDTO> retrieve() {

		List<ComicDTO> listToReturn = new ArrayList<ComicDTO>();

		RssReader reader = new RssReader();
		Stream<Item> rssFeed = null;

		try {
			rssFeed = reader.read(FEED_URL);
			List<Item> articles = rssFeed.limit(IComicRepository.getNumberRecords()).collect(Collectors.toList());

			for (Item item : articles) {
				PdlDTO PDLComic = new PdlDTO(item.getTitle(), item.getLink(), item.getGuid(), item.getPubDate());
				ComicDTO comicObject = PDLComic.toComicDTO();
				listToReturn.add(comicObject);
			}
		} catch (IOException e) { // TODO Auto-generated catch block e.printStackTrace(); }

			/*
			 * SyndFeed feed; try { feed = new SyndFeedInput().build(new XmlReader(new
			 * URL(FEED_URL))); List<Item> feedList = feed.getEntries();
			 * 
			 * if (!feedList.isEmpty()) {
			 * 
			 * 
			 * for (int i = 0; i < IComicRepository.getNumberRecords() && i<
			 * feedList.size(); i++) { Item item = (Item) feedList.get(i);
			 * 
			 * 
			 * PdlDTO PDLComic = new PdlDTO(item.getTitle(), item.getLink(),
			 * item.getGuid().toString(), item.getPubDate().toString()); ComicDTO
			 * comicObject = PDLComic.toComicDTO(); listToReturn.add(comicObject); } } }
			 * catch (IllegalArgumentException e) { // TODO Auto-generated catch block
			 * e.printStackTrace(); } catch (MalformedURLException e) { // TODO
			 * Auto-generated catch block e.printStackTrace(); } catch (FeedException e) {
			 * // TODO Auto-generated catch block e.printStackTrace(); } catch (IOException
			 * e) { // TODO Auto-generated catch block e.printStackTrace();
			 * 
			 * }
			 */
		}
		return listToReturn;

	}

}
