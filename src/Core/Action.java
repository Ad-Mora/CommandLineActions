package Core;

import java.util.Map;

/**
 * Created by AdrianM on 2/7/15.
 */
public interface Action {

    public void execute(String command);

    public String getInfo();

    public String getActionName();

    public Map<String, String> flagsToHelp();

    public boolean isValidCommand(String command);


}




