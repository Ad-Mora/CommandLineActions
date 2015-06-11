package WebActions;

import Core.Action;
import Core.ExitCode;

import java.util.Map;

/**
 * Created by AdrianM on 2/4/15.
 */
public interface WebAction extends Action {

    public Map<String, String> getFlagsToHelpDescriptionMap();

    public String getInvalidFormatMessage();

    public String getInfoMessage();


}
