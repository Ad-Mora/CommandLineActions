package Core;

import java.util.Set;

/**
 * Created by AdrianM on 6/13/15.
 */
public class Commands {

    public static String getActionName(String command) {
        Set<String> actionNames = Actions.getCommandsToActionsMap().keySet();
        for (String actionName : actionNames) {
            if (command.startsWith(actionName)) {
                return actionName;
            }
        }
        return "";
    }

    public static boolean isValidCommand(String command, Action action) {

        String actionName = action.getActionName();
        return !actionName.equals("") && action.isValidCommand(command);
    }

    public static String getInvalidCommandMsg(String command, String actionName) {

        if (!actionName.equals("")) {
            return "Invalid command. Type 'help " + actionName + "' for help with this module. Type 'quit' to quit.";
        }
        return "Invalid command. Type 'help' for help. Type 'quit' to quit.";
    }

    public static String removeExtraSpaces(String command) {

        String cleanString = command.replaceAll("\\s+", " ");
        return cleanString.trim();
    }
}
