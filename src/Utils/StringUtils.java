package Utils;

import Launcher.Commands;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Set;

/**
 * Created by AdrianM on 2/5/15.
 */
public class StringUtils {

    // look into popping off from an array list instead of these

    public static String getMainCommandFromCommand(String givenCommand) {

        Set<String> commandList = Commands.getCommandsToActionsMap().keySet();

        String mainCommand = null;

        for (String officialCommand : commandList) {

            if ((givenCommand + " ").indexOf(officialCommand) == 0) {
                mainCommand = officialCommand;
            }
        }

        return mainCommand;
    }

    public static String getArgsFromFullCommand(String command) {

        String mainCommand = getMainCommandFromCommand(command);
    }

}
