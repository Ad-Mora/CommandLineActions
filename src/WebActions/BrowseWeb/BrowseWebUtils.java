package WebActions.BrowseWeb;

import java.util.List;

/**
 * Created by AdrianM on 2/8/15.
 */
public class BrowseWebUtils {

    public static boolean isValidURLFormat(String commandArgs) {

        if (commandArgs.indexOf("\"") != 0) {
            return false;
        }

        if (commandArgs.lastIndexOf("\"") == 0) {
            return false;
        }

        return true;
   }

    public static String getURLFromCommandArgs(String commandArgs) {

        int firstQuoteIndex = commandArgs.indexOf("\""); // should be 0
        int lastQuoteIndex = commandArgs.lastIndexOf("\"");

        String url = commandArgs.substring(firstQuoteIndex + 1, lastQuoteIndex);

        return url;
    }

    public static String[] getFlagsFromCommandArgs(String commandArgs) {

        int lastQuoteIndex = commandArgs.indexOf("\"");
        String flags = commandArgs.substring(lastQuoteIndex + 2);
        String[] flagsArr = flags.split(" ");

        return flagsArr;


    }


}


