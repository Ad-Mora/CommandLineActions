package WebActions.BrowseWeb;

import Core.Action;
import Utils.ChromeWindowUtils;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by AdrianM on 2/5/15.
 */
public class BrowseWebMain implements Action {

    private static final String MAIN_COMMAND = "go to";

    private static final String MAXIMIZE_FLAG = "--maximize";
    private static final String BRING_TO_FRONT_FLAG = "--front";
    private static final String NO_MAXIMIZE_FLAG = "--no-maximize";
    private static final String NO_BRING_TO_FRONT_FLAG = "--no-front";

    private String commandArgs;
    private String url;

    private boolean maximize = true;
    private boolean bringToFront = true;


    public void processCommandArgs(String commandArgs) {

//        this.url = BrowseWebUtils.getURLFromCommandArgs(commandArgs);

        String[] flags = BrowseWebUtils.getFlagsFromCommandArgs(commandArgs);

        for (String flag : flags) {

            if (flag.equals(MAXIMIZE_FLAG)) {
                this.maximize = true;
            } else if (flag.equals(BRING_TO_FRONT_FLAG)) {
                this.bringToFront = true;
            } else if (flag.equals(NO_MAXIMIZE_FLAG)) {
                this.maximize = false;
            } else if (flag.equals(NO_BRING_TO_FRONT_FLAG)) {
                this.bringToFront = false;
            }
        }
    }

    public void execute(String command) {

        processCommandArgs(command);
        WebDriver driver = new ChromeDriver();

        if (this.maximize) {
            ChromeWindowUtils.maximizeChromeWindow(driver);
        }
        if (this.bringToFront) {
            ChromeWindowUtils.bringWindowToFront(driver);
        }

        Utils.ChromeNavigationUtils.goToURL(driver, this.url);

    }

    @Override
    public String getInfo() {
        return null;
    }

    @Override
    public String getActionName() {
        return null;
    }

    @Override
    public Map<String, String> flagsToHelp() {
        return null;
    }

    @Override
    public boolean isValidCommand(String command) {
        return false;
    }

}
