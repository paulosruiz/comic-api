package comic.dto;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import com.fasterxml.jackson.annotation.JsonFormat;

public class ComicDTO {

	private String pictureURL;
	private String title;
	private String browserURL;

	private LocalDate publishingDate;
	
	public String getPublishingDate() {
		return publishingDate.format(DateTimeFormatter.ISO_DATE);
	}

	public void setDate(LocalDate parsedDate) {
		this.publishingDate = parsedDate;
	}

	public String getPictureURL() {
		return pictureURL;
	}

	public void setPictureURL(String pictureURL) {
		this.pictureURL = pictureURL;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getBrowserURL() {
		return browserURL;
	}

	public void setBrowserURL(String browserURL) {
		this.browserURL = browserURL;
	}

}
