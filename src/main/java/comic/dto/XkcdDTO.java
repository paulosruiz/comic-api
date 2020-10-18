package comic.dto;

import java.time.LocalDate;

public class XkcdDTO {

	private static final String XKCD_BASE_URL = "https://xkcd.com/";
	private String img;
	private String title;
	private int num;
	private String month, day, year;

	public String getImg() {
		return img;
	}

	public void setImg(String img) {
		this.img = img;
	}

	public int getNum() {
		return num;
	}

	public void setNum(int num) {
		this.num = num;
	}

	public String getMonth() {
		return month;
	}

	public void setMonth(String month) {
		this.month = month;
	}

	public String getDay() {
		return day;
	}

	public void setDay(String day) {
		this.day = day;
	}

	public String getYear() {
		return year;
	}

	public void setYear(String year) {
		this.year = year;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public ComicDTO toComicDTO() {
		ComicDTO ret = new ComicDTO();
		ret.setBrowserURL(XKCD_BASE_URL + this.num);
		ret.setPictureURL(this.img);
		ret.setTitle(this.title);

		ret.setDate(LocalDate.of(Integer.valueOf(this.year).intValue(), Integer.valueOf(this.month).intValue(),
				Integer.valueOf(this.day).intValue()));
		
		// ret.setPublishingDate(this.year + "-" + this.month + "-" + this.day);

		return ret;
	}

}
