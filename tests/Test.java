import WebActions.BrowseWeb.BrowseWebUtils;

/**
 * Created by AdrianM on 2/8/15.
 */
public class Test {

    public static void main(String[] args) {

        String commandArgs = "\"test\"";
        String out = BrowseWebUtils.getURLFromCommandArgs(commandArgs);
        System.out.println(out);

    }
}
