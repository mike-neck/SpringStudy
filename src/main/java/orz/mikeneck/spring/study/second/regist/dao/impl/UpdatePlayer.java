package orz.mikeneck.spring.study.second.regist.dao.impl;

import org.springframework.jdbc.core.SqlParameter;
import org.springframework.jdbc.object.SqlUpdate;

import javax.sql.DataSource;
import java.sql.Types;

/**
 * Created by IntelliJ IDEA.
 * Account: mike
 * Date: 11/09/12
 * Time: 22:05
 * To change this template use File | Settings | File Templates.
 */
public class UpdatePlayer extends SqlUpdate {

    private static final String SQL =
            "UPDATE player"
            + " SET"
            + " name = ?,"
            + " team_id = ?"
            + " WHERE"
            + " player_id = ?";

    public UpdatePlayer(DataSource dataSource) {
        super(dataSource, SQL);
        super.declareParameter(new SqlParameter("name", Types.VARCHAR));
        super.declareParameter(new SqlParameter("team_id", Types.INTEGER));
        super.declareParameter(new SqlParameter("player_id", Types.INTEGER));
        compile();
    }
}
