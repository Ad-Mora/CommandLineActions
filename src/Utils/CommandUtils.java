package Utils;

import Core.Commands;

import java.util.Set;

/**
 * Created by AdrianM on 2/5/15.
 */
public class CommandUtils {

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

    public static String getArgsFromFullCommand(String fullCommand) {

        String mainCommand = getMainCommandFromCommand(fullCommand);
        int argsBeginIndex = mainCommand.length() + 1;

        return fullCommand.substring(argsBeginIndex);
    }

}
