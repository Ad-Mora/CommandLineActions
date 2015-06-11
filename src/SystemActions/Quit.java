package SystemActions;

import Core.ExitCode;

/**
 * Created by AdrianM on 2/7/15.
 */
public class Quit {

    public String getInvalidFormatMessage() {
        return "";
    }

    public ExitCode processCommandArgs(String commandArgs) {
        return ExitCode.QUIT;
    }

    public void execute() {}




}
