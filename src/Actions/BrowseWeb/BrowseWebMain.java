package Actions.BrowseWeb;

import Actions.Action;
import Utils.ChromeWindowUtils;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by AdrianM on 2/5/15.
 */
public class BrowseWebMain implements Action {

    private boolean maximize = true;
    private boolean bringToFront = true;
    private String url;

    public BrowseWebMain() {
    }

    public void processCommand(String command) {

        String[] args = Utils.StringUtils.getCommandArgsFromCommand(commandArr);

        String maximizeFlag = "--maximize";
        String bringToFrontFlag = "--front";

        String nomaximizeFlag = "--no-maximize";
        String noBringToFrontFlag = "--no-front";

        this.url = args[0];

        List<String> flags = Utils.StringUtils.getFlagsFromArgs(args);

        for (String flag : flags) {

            if (flag.equals(maximizeFlag)) {
                this.maximize = true;
            }
            if (flag.equals(bringToFrontFlag)) {
                this.bringToFront = true;
            }

            if (flag.equals(nomaximizeFlag)) {
                this.maximize = false;
            }
            if (flag.equals(noBringToFrontFlag)) {
                this.bringToFront = false;
            }
        }
    }

    public String getMainArgumentHelpDescription() {
        // TODO
        return "";
    }

    public Map<String, String> getFlagsToHelpDescriptionMap() {
        // TODO
        return new HashMap<String, String>();
    }

    public void execute() {

        if (this.url == null) {
            throw new RuntimeException("URL is null; command was never processed");
        }

        WebDriver driver = new ChromeDriver();
        if (this.maximize) {
            ChromeWindowUtils.maximizeChromeWindow(driver);
        }
        if (this.bringToFront) {
            ChromeWindowUtils.bringWindowToFront(driver);
        }

        Utils.ChromeNavigationUtils.goToURL(driver, this.url);




    }
}
