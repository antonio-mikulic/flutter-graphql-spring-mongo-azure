package mikulic.asc.helpers;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.microsoft.azure.functions.HttpRequestMessage;

import java.util.Map;

public class ObjectMapperHelper {
    public static String GetGraphQlBodyFromHttpRequest(HttpRequestMessage<String> request) throws JsonProcessingException {
        ObjectMapper mapper = new ObjectMapper();
        Map<String, Object> map2 = mapper.readValue(request.getBody(), Map.class);
        Object strObj = map2.get("query");
        return (String) strObj;
    }
}
