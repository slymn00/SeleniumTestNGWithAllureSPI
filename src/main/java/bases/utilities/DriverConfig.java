package bases.utilities;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.dataformat.yaml.YAMLFactory;
import lombok.Data;

import java.io.File;
@Data
public class DriverConfig {

    private static DriverConfig instance;
    private boolean chromeHeadless;
    private boolean firefoxHeadless;
    private boolean mobileHeadless;
    private boolean isGrid;
    private String gridUrl;

    private DriverConfig() {
    }

    public static DriverConfig getInstance() {
        if (instance == null) {
            try {
                ObjectMapper mapper = new ObjectMapper(new YAMLFactory());
                instance = mapper.readValue(new File("src/test/resources/driver_config.yaml"), DriverConfig.class);
            } catch (Exception e) {
                Log.fail("driver_config Dosyası Okunurken hata alındı!", e);
            }
        }
        return instance;
    }
}
