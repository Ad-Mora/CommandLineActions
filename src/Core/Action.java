package Core;

/**
 * Created by AdrianM on 2/7/15.
 */
public interface Action {

    public String getInfoMessage();

    public String getInvalidFormatMessage();

    public ExitCode execute(String command);

}




