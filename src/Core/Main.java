package Core;

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
        String quitCommand = "quit";

        while (true) {

            System.out.println();
            System.out.println(welcomeText);

            String command = in.nextLine();
            String actionName = Commands.getActionName(command);
            Action nextAction = Actions.getAction(actionName);

            if (Commands.isValidCommand(nextAction, command)) {
                nextAction.execute(command);
            } else if (command.equals(quitCommand)) {
                break;
            } else {
                System.out.println(Commands.getInvalidCommandMsg(command));
            }
        }















    }
}
