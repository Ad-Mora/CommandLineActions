package Core;

import Utils.CommandUtils;

import java.io.IOException;
import java.net.URISyntaxException;
import java.util.Scanner;

/**
 * Created by AdrianM on 2/3/15.
 */

public class Main {

    public static void main(String[] args) throws IOException, URISyntaxException, InterruptedException {

        System.setProperty("webdrive.chrome.drive",
                "/Users/AdrianM/Documents/CodingProjects/JavaProjects/CommandLineActions/chromedriver");

        Scanner in = new Scanner(System.in);

        String welcomeText = "Welcome to CLA. Type 'help' for help. Type 'quit' to quit.";
        String invalidCommandMessage = "Invalid command. Type 'help' for help.";

        while (true) {

            System.out.println();
            System.out.println(welcomeText);

            String fullCommand = in.nextLine();
            String mainCommand = CommandUtils.getMainCommandFromCommand(fullCommand);
            String commandArgs = Utils.CommandUtils.getArgsFromFullCommand(fullCommand);

            if (mainCommand != null) {

                Action nextAction = Commands.getCommandsToActionsMap().get(mainCommand);
                ExitCode code = nextAction.processCommandArgs(commandArgs);

                if (code.equals(ExitCode.INVALID_FORMAT)) {
                    System.out.println(nextAction.getInvalidFormatMessage());
                } else if (code.equals(ExitCode.QUIT)) {
                    break;
                }

                nextAction.execute();

            } else {
                System.out.println(invalidCommandMessage);
            }
        }

    }
}
