package WebActions.BrowseWeb;

import WebActions.WebAction;
import Core.ExitCode;
import Utils.ChromeWindowUtils;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by AdrianM on 2/5/15.
 */
public class BrowseWebMain implements WebAction {

    private static final String MAIN_COMMAND = "go to";

    private static final String MAXIMIZE_FLAG = "--maximize";
    private static final String BRING_TO_FRONT_FLAG = "--front";
    private static final String NO_MAXIMIZE_FLAG = "--no-maximize";
    private static final String NO_BRING_TO_FRONT_FLAG = "--no-front";

    private String commandArgs;
    private String url;

    private boolean maximize = true;
    private boolean bringToFront = true;

    public BrowseWebMain() {
    }

    public String getInfoMessage() {
        return null;
    }

    public String getInvalidFormatMessage() {
        return null;
    }

    public Map<String, String> getFlagsToHelpDescriptionMap() {
        // TODO
        return new HashMap<String, String>();
    }

    public ExitCode processCommandArgs(String commandArgs) {

        if (!BrowseWebUtils.isValidURLFormat(commandArgs)) {
            return ExitCode.INVALID_FORMAT;
        }

        this.url = BrowseWebUtils.getURLFromCommandArgs(commandArgs);

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

        return ExitCode.CLEAR;
    }

    public ExitCode execute(String command) {


        ExitCode code = processCommandArgs(command);
        if (code == ExitCode.INVALID_FORMAT) {
            return code;
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
