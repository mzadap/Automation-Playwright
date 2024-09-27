package setup;

import java.io.FileInputStream;
import java.io.InputStream;
import java.util.Properties;

public class ConfigLoader {

    Properties properties = new Properties();

    static ConfigLoader loader = new ConfigLoader();
    public ConfigLoader() {
        try {
            InputStream stream = new FileInputStream("src/main/java/resources/config.properties");
            properties.load(stream);

        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public String getBrowser() {
        //Logger logger1 = Logger.getLogger(ConfigLoader.class);
        return properties.getProperty("browser");
    }

    public String getUrl() {
        return properties.getProperty("url");
    }

    public static ConfigLoader getInstance() {
        return loader;
    }

    public String getApiUrl() {
        return properties.getProperty("api_url");
    }

}
