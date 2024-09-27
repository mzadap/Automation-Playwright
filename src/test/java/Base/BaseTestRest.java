package Base;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.microsoft.playwright.APIRequest;
import com.microsoft.playwright.APIRequestContext;
import com.microsoft.playwright.APIResponse;
import com.microsoft.playwright.Playwright;
import com.microsoft.playwright.options.RequestOptions;
import setup.ConfigLoader;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class BaseTestRest {

    //API automation methods
    //GET, POST, PUT, DELETE


    Playwright playwright = Playwright.create();
    Map<String, String> map = new HashMap<>();

    public APIResponse getRequest(String pathParameter) {
        APIResponse response =  setUpRequest().get(pathParameter);
        return response;
    }

    public APIResponse postRequest(String pathParameter, String payload) {
       // String payload = "src/test/resources/API/post.json";
        APIResponse response = setUpRequest().post(pathParameter, RequestOptions.create().setData(payload));
        return response;

    }

    private APIRequestContext setUpRequest() {
        map.put("content-type", "application/json");
        APIRequestContext apiRequest = playwright.request().newContext(new APIRequest.NewContextOptions()
                .setBaseURL(ConfigLoader.getInstance().getApiUrl())
                .setExtraHTTPHeaders(map));
        return apiRequest;
    }

    public static String readJsonAsString(String filePath) {
        try {
            ObjectMapper mapper = new ObjectMapper();
            return mapper.readTree(new File(filePath)).toString();
        } catch (IOException e) {
            throw new RuntimeException("Failed to read JSON from file: " + filePath);
        }
    }
}
