package SystemActions;

import Core.Action;
import Core.ExitCode;

/**
 * Created by AdrianM on 2/7/15.
 */
public class Quit implements Action {

    public ExitCode execute(String command) {
        return ExitCode.QUIT;
    }
}
