package Launcher;

import Actions.Action;
import java.util.*;

import Actions.BrowseWeb.BrowseWebMain;
import Utils.StringUtils;

/**
 * Created by AdrianM on 2/4/15.
 */
public class Commands {

    public static Map<String, Action> getCommandsToActionsMap() {

        Map<String, Action> actionMap = new HashMap<String, Action>();

        // List all command-action pairs
        String browseCommand = "browse";
        Action browseAction = new BrowseWebMain();

        actionMap.put(browseCommand, browseAction);
        return actionMap;
    }

    public static Set<String> getSystemCommandsSet() {

        Set<String> systemCommands = new HashSet<String>();

        String helpCommand = "help";
        String configCommand = "config";

        systemCommands.add(helpCommand);
        systemCommands.add(configCommand);

        return systemCommands;
    }



    public static boolean isValidCommand(String command) {
        return getMainCommandFromCommand(command) != null;
    }

    public static Action getActionFromCommand(String fullCommand) {

        String mainCommand = getMainCommandFromCommand(fullCommand);
        Action desiredAction = getCommandsToActionsMap().get(mainCommand);

        String commandArgs = Utils.StringUtils.getArgsFromFullCommand(fullCommand);
        desiredAction.processCommand(commandArgs);

        return desiredAction;
    }
}
