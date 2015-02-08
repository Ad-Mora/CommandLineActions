package Launcher;

import Actions.Action;
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
        String quitCommand = "quit";

        String welcomeText = "Welcome to lazy mode. Type 'help' for help. Type 'quit' to quit.";
        String invalidCommandMessage = "Invalid command. Type 'help' for help.";

        while (true) {

            System.out.println(welcomeText);

            String fullCommand = in.nextLine();


            String mainCommand = Commands.getMainCommandFromCommand(fullCommand);

            if (fullCommand.equals(quitCommand)) {
                break;
            } else if (mainCommand != null) {
                Action nextAction = Commands.getActionFromCommand(fullCommand);
                nextAction.execute();
            } else {
                System.out.println(quitCommand);
            }

//            if (mainCommand != null) {
//                Action nextAction = Commands.getActionFromCommand(mainCommand);
//                nextAction.execute();
//            } else if (fullCommand.equals(quitCommand)) {
//                break;
//            } else {
//                System.out.println(invalidCommandMessage);
//            }
//
//            if (fullCommand.equals(quitCommand)) {
//                break;
//            } else if (Commands.isValidCommand(fullCommand)) {
//                Action nextAction = Commands.getActionFromCommand(fullCommand);
//                nextAction.execute();
//            } else {
//                System.out.println(invalidCommandMessage);
//            }



        }

    }
}
