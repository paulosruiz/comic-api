package comic.dto;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.Date;
import java.util.Locale;
import java.util.Optional;

public class PdlDTO {

	String title, link, guid;
	String publishedDate;

	/*public PdlDTO(String title, String link, String guid, String publishedDate) {

		this.title = title;
		this.link = link;
		this.guid = guid;
		this.publishedDate = publishedDate;
	}*/
	
	  public PdlDTO(Optional<String> title, Optional<String> link, Optional<String>
	  guid, Optional<String> publishedDate) {
	  
	  this.title = title.get(); this.link = link.get(); this.guid = guid.get();
	  this.publishedDate = publishedDate.get();
	  
	  }
	 

	private String getTitle() {
		return title;
	}

	private void setTitle(String title) {
		this.title = title;
	}

	private String getLink() {
		return link;
	}

	private void setLink(String link) {
		this.link = link;
	}

	private String getGuid() {
		return guid;
	}

	private void setGuid(String guid) {
		this.guid = guid;
	}

	private String getPublishedDate() {
		return publishedDate;
	}

	private void setPublishedDate(String publishedDate) {
		this.publishedDate = publishedDate;
	}

	public ComicDTO toComicDTO() {
		ComicDTO ret = new ComicDTO();
		ret.setBrowserURL(this.guid);
		ret.setPictureURL(this.link);
		ret.setTitle(this.title);

		DateFormat dateFormat = new SimpleDateFormat("EEE, d MMM yyyy HH:mm:ss Z", Locale.US);

		try {
			ret.setDate(dateFormat.parse(this.publishedDate).toInstant().atZone(ZoneId.systemDefault()).toLocalDate());

		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return ret;
	}

}
