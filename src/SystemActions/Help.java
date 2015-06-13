package SystemActions;

import Core.Action;
import java.util.Map;

/**
 * Created by AdrianM on 2/5/15.
 */
public class Help implements Action {

    @Override
    public void execute(String command) {

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
