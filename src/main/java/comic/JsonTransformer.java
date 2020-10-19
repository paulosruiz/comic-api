package comic;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import spark.ResponseTransformer;

public class JsonTransformer implements ResponseTransformer {

	ObjectMapper objMap = new ObjectMapper();

	@Override
	public String render(Object model) {

		try {
			return objMap.writeValueAsString(model);
		} catch (JsonProcessingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;

		// gson.toJson(model);
	}

}
