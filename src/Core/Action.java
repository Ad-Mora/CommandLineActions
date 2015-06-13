package Core;

/**
 * Created by AdrianM on 2/7/15.
 */
public interface Action {

    public ExitCode execute(String command);

    public String getInfo();

    public String getActionName();


}




