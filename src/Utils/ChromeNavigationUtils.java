package Utils;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

/**
 * Created by AdrianM on 2/7/15.
 */
public class ChromeNavigationUtils {

    public static void goToURL(WebDriver driver, String url) {
        driver.get(url);
    }
}
