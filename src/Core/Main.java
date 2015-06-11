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

//        This is hardcoded; fix this
        System.setProperty("webdrive.chrome.drive",
                "/Users/AdrianM/Documents/CodingProjects/JavaProjects/CommandLineActions/chromedriver");

        Scanner in = new Scanner(System.in);

        String welcomeText = "Welcome to CLA. Type 'help' for help. Type 'quit' to quit.";
        String invalidCommandMessage = "Invalid command. Type 'help' for help.";

        while (true) {

            System.out.println();
            System.out.println(welcomeText);

            String command = in.nextLine();
            String actionName = CommandUtils.getActionNameFromCommand(command);
            Action nextAction = Commands.getAction(actionName);

            if (nextAction != null) {

                ExitCode code = nextAction.execute(command);

                if (code.equals(ExitCode.INVALID_FORMAT)) {
                    System.out.println(nextAction.getInvalidFormatMessage());
                } else if (code.equals(ExitCode.QUIT)) {
                    break;
                }

            } else {
                System.out.println(invalidCommandMessage);
            }
        }

    }
}
