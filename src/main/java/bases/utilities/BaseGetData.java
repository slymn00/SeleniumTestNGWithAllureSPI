package bases.utilities;

import java.nio.file.Paths;

public class BaseGetData {

    public static final int DEFAULT_WAIT = 20;
    public static final int DEFAULT_WAIT_LOADERBOX = 60;
    public static final String DEFAULT_DOWNLOAD_PATH = Paths.get("downloads").toAbsolutePath().toString();

    public enum Device {
        IPHONE_6_7_8("iPhone 6/7/8"),
        IPHONE_X("iPhone X"),
        CHROME("chrome"),
        FIREFOX("firefox");

        public final String value;

        Device(String value) {
            this.value = value;
        }
    }

    public enum Url {
        AMAZON_URL;
    }
}
