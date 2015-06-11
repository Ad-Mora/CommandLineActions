package Core;

import java.util.*;

import WebActions.BrowseWeb.BrowseWebMain;
import SystemActions.Config;
import SystemActions.Help;
import SystemActions.Quit;

/**
 * Created by AdrianM on 2/4/15.
 */
public class Commands {

    public static Map<String, Action> getCommandsToActionsMap() {

        Map<String, Action> actionMap = new HashMap<String, Action>();

        // List all command-action pairs
        String browseCommand = "go to";
        Action browseAction = new BrowseWebMain();

        String helpCommand = "help";
        Action helpAction = new Help();

        String configCommand = "config";
        Action configAction = new Config();

        String quitCommand = "quit";
        Action quitAction = new Quit();

        actionMap.put(browseCommand, browseAction);
        actionMap.put(helpCommand, helpAction);
        actionMap.put(configCommand, configAction);
        actionMap.put(quitCommand, quitAction);

        return actionMap;
    }

    public static Action getAction(String actionName) {
        return getCommandsToActionsMap().get(actionName);
    }


}
