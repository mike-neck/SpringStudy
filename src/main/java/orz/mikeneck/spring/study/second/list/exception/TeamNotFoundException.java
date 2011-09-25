package orz.mikeneck.spring.study.second.list.exception;

/**
 * Created by IntelliJ IDEA.
 * Account: mike
 * Date: 11/09/11
 * Time: 14:27
 * To change this template use File | Settings | File Templates.
 */
@SuppressWarnings("serial")
public class TeamNotFoundException extends Exception {

    public TeamNotFoundException() {
        super();
    }

    public TeamNotFoundException(String message) {
        super(message);
    }
}
