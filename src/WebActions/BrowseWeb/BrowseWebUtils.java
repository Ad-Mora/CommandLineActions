package WebActions.BrowseWeb;

import java.util.List;

/**
 * Created by AdrianM on 2/8/15.
 */
public class BrowseWebUtils {

    public static boolean isValidURLFormat(String commandArgs) {
        return true;
   }

    public static String getURLFromCommand(String command) {

        command.split(" ");

        return url;
    }

    public static String[] getFlagsFromCommandArgs(String commandArgs) {

        int lastQuoteIndex = commandArgs.indexOf("\"");
        String flags = commandArgs.substring(lastQuoteIndex + 2);
        String[] flagsArr = flags.split(" ");

        return flagsArr;


    }


}


