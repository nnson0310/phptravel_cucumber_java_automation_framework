package helpers;

import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import commons.GlobalConstants;
import data.UserCredentails;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class ReadJson {

    private ObjectMapper objectMapper;

    private ReadJson() {
        objectMapper = new ObjectMapper();
        objectMapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
    }

    public static ReadJson getReadJson() {
        return new ReadJson();
    }

    public Map<String, String> getValidUserCredentials() throws IOException {
        UserCredentails credentials = objectMapper.readValue(
                new File(GlobalConstants.getGlobalConstants().getTestDataPath() + "user-credentials.json"),
                UserCredentails.class
        );
        Map<String, String> userInfo = new HashMap<String, String>();
        userInfo.put("email", credentials.getEmail());
        userInfo.put("password", credentials.getPassword());
        return userInfo;
    }
}
