package orz.mikeneck.spring.study.second.list;

/**
 * Created by IntelliJ IDEA.
 * Account: mike
 * Date: 11/09/11
 * Time: 15:53
 * To change this template use File | Settings | File Templates.
 */
public class TeamListFixture {

    private static String REMOVE = "DROP TABLE IF EXISTS team";

    private static String CREATE = "CREATE TABLE team (team_id INT PRIMARY KEY AUTO_INCREMENT, name VARCHAR(40))";

    public static String remove() {
        return REMOVE;
    }

    public static String create() {
        return CREATE;
    }

    public static String insert(String file) {
        return "INSERT INTO team SELECT * FROM CSVREAD('" + file + "', 'team_id, name', 'UTF-8')";
    }
}
