package comicRest;

import static org.easymock.EasyMock.*;
import static org.junit.Assert.assertEquals;
import com.google.common.collect.ImmutableList;

import java.time.LocalDate;
import java.time.temporal.TemporalAccessor;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.easymock.EasyMock;

import comic.dto.ComicDTO;

public class Test {

	@Test
	public void aNonEmptyListIsHandledCorrectlyInHtmlOutput() {
		ComicDTO model = EasyMock.createMock(ComicDTO.class);

		ComicDTO post1 = new ComicDTO();
		post1.setTitle("Second comic");
		post1.setDate(LocalDate.of(2020, 10, 19));

		ComicDTO post2 = new ComicDTO();
		post2.setTitle("First comic");
		post2.setDate(LocalDate.of(2020, 10, 18));
		List<ComicDTO> list = new ArrayList<ComicDTO>();
		expect(list).andReturn(ImmutableList.of(post1, post2));
		replay(list);

		 String expectedHtml = "[ {\n" +
	                "  \"title\" : \"First comic\",\n" +
	                "  \"publishing_date\" : 2020-10-18\n" +
	                "}, {\n" +
	                "  \"title\" : \"Second comic\",\n" +
	                "  \"publishing_date\" : 2020-10-19\n" +

	                "} ]";
		assertEquals(new Answer(200, expectedHtml), handler.process(new EmptyPayload(), Collections.emptyMap(), true));

		verify(model);
	}
}
