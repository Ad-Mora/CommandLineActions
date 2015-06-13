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

        while (true) {

            System.out.println();
            System.out.println(welcomeText);

            Command command = new Command(in.nextLine());
            String actionName = command.getActionName();
            Action nextAction = Actions.getAction(actionName);

            if (command.isValid()) {
                nextAction.execute(command.toString());
            } else if command.quit() {
                break;
            } else {
                System.out.println(command.getInvalidCommandMsg());
            }

//            if (nextAction != null) {
//
//                if (nextAction.commandIsValid(command)) {
//
//                    ExitCode code = nextAction.execute(command);
//                    if (code.equals(ExitCode.QUIT)) {
//                        break;
//                    }
//                } else {
//                    System.out.println(Commands.invalidCommandMsg(actionName));
//                }
//
//            } else {
//                System.out.println(Commands.invalidCommandMessage());
//            }
        }
    }
}
