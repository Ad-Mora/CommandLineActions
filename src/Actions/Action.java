package Actions;

import java.util.Map;

/**
 * Created by AdrianM on 2/4/15.
 */
public interface Action {

    public String getMainArgumentHelpDescription();

    public Map<String, String> getFlagsToHelpDescriptionMap();

    public void processCommand(String command);

    public void execute();



}
