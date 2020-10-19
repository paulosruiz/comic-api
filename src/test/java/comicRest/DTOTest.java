package comicRest;

import static org.junit.Assert.assertEquals;

import java.time.LocalDate;

import org.junit.Test;

import comic.dto.ComicDTO;
import comic.dto.PdlDTO;
import comic.dto.XkcdDTO;

public class DTOTest {

	private static final int NUM = 33;
	private static final String XKCD_PICTURE_URL = "https://xkcd.com/" + NUM;
	
	private static final String TITLE = "First Comic";
	private static final String BROWSER_URL = "http://browser.url/urlbrowser";
	private static final String YEAR = "2020";
	private static final String MONTH = "10";
	private static final String DAY = "18";
	
	private static final String PDL_PUBLISHING_DATE = "Sun, 18 Oct 2020 16:33:27 +0000";
	private static final String PDL_GUID_URL = "http://www.poorlydrawnlines.com/?p=7793";
	private static final String PDL_PICTURE_URL = "http://feedproxy.google.com/~r/PoorlyDrawnLines/~3/EKcE_QiSL8U/";
	  
	private static final String RES_PUBLISHING_DATE = YEAR + "-" + MONTH + "-" + DAY;
	private static final String RES_XKCD_BROWSER_URL = "https://xkcd.com/" + NUM;
	@Test
	public void XkcdToComic() {

		XkcdDTO xkcd = new XkcdDTO();

		xkcd.setDay(DAY);
		xkcd.setMonth(MONTH);

		//xkcd.set
		xkcd.setYear(YEAR);
		xkcd.setImg(XKCD_PICTURE_URL);
		xkcd.setNum(NUM);
		xkcd.setTitle(TITLE);

		ComicDTO comic = xkcd.toComicDTO();

		assertEquals("Publishing Date", RES_PUBLISHING_DATE, comic.getPublishingDate());
		assertEquals("Title", TITLE, comic.getTitle());
		assertEquals("Browser URL ", RES_XKCD_BROWSER_URL, comic.getBrowserURL());
		assertEquals("Picture URL", XKCD_PICTURE_URL, comic.getPictureURL());

	}

	@Test
	public void PDLToComic() {

		PdlDTO pdl = new PdlDTO();

		pdl.setGuid(PDL_GUID_URL);
		pdl.setLink(PDL_PICTURE_URL);
		pdl.setPublishedDate(PDL_PUBLISHING_DATE);
		pdl.setTitle(TITLE);
		
		ComicDTO comic = pdl.toComicDTO();
		
		assertEquals("Browser URL ", PDL_GUID_URL, comic.getBrowserURL());
		assertEquals("Picture URL", PDL_PICTURE_URL, comic.getPictureURL());

		assertEquals("Publishing Date", RES_PUBLISHING_DATE, comic.getPublishingDate());
		assertEquals("Title", TITLE, comic.getTitle());


	}
}
