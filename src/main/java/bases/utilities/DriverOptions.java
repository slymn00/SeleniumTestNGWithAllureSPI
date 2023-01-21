package bases.utilities;

import org.openqa.selenium.PageLoadStrategy;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxOptions;

import java.util.HashMap;
import java.util.Map;

public class DriverOptions {

    private static final String START_FULLSCREEN = "--start-fullscreen";
    private static final String HEADLESS = "--headless";
    private static final String headlessUserAgend="user-agent=Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/102.0.5005.115 Safari/537.36";
    private static String driverType;

    public ChromeOptions chromeUp() {

        HashMap<String, Object> chromePrefs = new HashMap<>();
        chromePrefs.put("credentials_enable_service", false);
        chromePrefs.put("profile.password_manager_enabled", false);
        chromePrefs.put("plugins.always_open_pdf_externally", true);
        chromePrefs.put("download.default_directory", BaseGetData.DEFAULT_DOWNLOAD_PATH);

        ChromeOptions chromeUp = new ChromeOptions();
        chromeUp.addArguments("--no-sandbox");
        chromeUp.addArguments("--disable-dev-shm-usage");
        chromeUp.addArguments("--whitelisted-ips");
        chromeUp.addArguments("'--disable-gpu'");
        chromeUp.addArguments(headlessUserAgend);
        chromeUp.addArguments("--ignore-certificate-errors");
        chromeUp.addArguments("--ignore-ssl-errors");
        chromeUp.addArguments("--enable-features=NetworkServiceInProcess");
        chromeUp.addArguments("--disable-features=NetworkService");
        chromeUp.addArguments("--aggressive-cache-discard");
        chromeUp.addArguments("--disable-cache");
        chromeUp.addArguments("--disable-application-cache");
        chromeUp.addArguments("--disable-offline-load-stale-cache");
        chromeUp.addArguments("--disk-cache-size=0");
        chromeUp.addArguments("--dns-prefetch-disable");
        chromeUp.addArguments("--no-proxy-server");
        // chromeUp.addArguments("--log-level=3");
        chromeUp.addArguments("--silent");
        chromeUp.addArguments("--disable-browser-side-navigation");
        chromeUp.addArguments("--disable-notifications");
        chromeUp.addArguments("--disable-extensions");
        chromeUp.addArguments("--disable-popup-blocking");
        chromeUp.setPageLoadStrategy(PageLoadStrategy.NORMAL);
        chromeUp.setExperimentalOption("prefs", chromePrefs);

        setDriverType("chrome");

        if (DriverConfig.getInstance().isChromeHeadless()) chromeUp.addArguments(HEADLESS,"--window-size=1920x1080");
        else chromeUp.addArguments(START_FULLSCREEN);

        return chromeUp;
    }

    public FirefoxOptions firefoxUp() {
        FirefoxOptions firefoxUp = new FirefoxOptions();
        setDriverType("firefox");

        firefoxUp.addArguments("--no-sandbox");
        firefoxUp.addArguments("--disable-dev-shm-usage");
        firefoxUp.addArguments("--whitelisted-ips");
        firefoxUp.addArguments("'--disable-gpu'");
        firefoxUp.addArguments("--disable-notifications");
        firefoxUp.addArguments("--disable-extensions");
        firefoxUp.addArguments("--disable-popup-blocking");

        if (DriverConfig.getInstance().isFirefoxHeadless()){
            firefoxUp.setHeadless(true);
        } else {
            firefoxUp.addArguments(START_FULLSCREEN);
        }

        return firefoxUp;

    }

    public ChromeOptions mobileUp(String device) {

        Map<String, String> mobileEmulation = new HashMap<>();
        mobileEmulation.put("deviceName", device);
        setDriverType("mobile");

        ChromeOptions mobileOptions = new ChromeOptions();

        mobileOptions.addArguments("--disable-dev-shm-usage");
        mobileOptions.addArguments("--disable-gpu");
        mobileOptions.addArguments("--no-sandbox");
        mobileOptions.addArguments("--whitelisted-ips");
        mobileOptions.addArguments("--disable-extensions");
        mobileOptions.addArguments("--window-size=1920x1080");
        mobileOptions.addArguments(headlessUserAgend);
        mobileOptions.addArguments("--ignore-certificate-errors");
        mobileOptions.addArguments("--ignore-ssl-errors");
        mobileOptions.addArguments("--enable-features=NetworkServiceInProcess");
        mobileOptions.addArguments("--disable-features=NetworkService");
        mobileOptions.addArguments("--aggressive-cache-discard");
        mobileOptions.addArguments("--disable-cache");
        mobileOptions.addArguments("--disable-application-cache");
        mobileOptions.addArguments("--disable-offline-load-stale-cache");
        mobileOptions.addArguments("--disk-cache-size=0");
        mobileOptions.addArguments("--dns-prefetch-disable");
        mobileOptions.addArguments("--no-proxy-server");
        mobileOptions.addArguments("--log-level=3");
        mobileOptions.addArguments("--silent");
        mobileOptions.addArguments("--disable-browser-side-navigation");
        mobileOptions.addArguments("--disable-notifications");


        mobileOptions.setExperimentalOption("mobileEmulation", mobileEmulation);

        if (DriverConfig.getInstance().isMobileHeadless()) mobileOptions.addArguments(HEADLESS);
        else mobileOptions.addArguments(START_FULLSCREEN);

        return mobileOptions;
    }

    /**
     *
     * @return chrome,firefox,chrome-headless,firefox-headless,mobile tipi döner
     */
    public static String getDriverType() {
        return driverType;
    }

    public static void setDriverType(String driverType) {

        DriverOptions.driverType = driverType;
    }
}
