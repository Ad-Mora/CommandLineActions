package Core;

import java.util.Set;

/**
 * Created by AdrianM on 6/13/15.
 */
public class Command {

    private String command;
    private String actionName;

    public Command(String command) {
        this.command = command;
        this.actionName = getActionName();
    }

    public String getActionName() {
        Set<String> actionNames = Actions.getCommandsToActionsMap().keySet();

        for (String actionName : actionNames) {
            if (this.command.startsWith(actionName)) {
                return actionName;
            }
        }
        return "";
    }

    public String toString() {
        return this.command;
    }
}
