package orz.mikeneck.spring.study.second.regist.dao.impl;

import org.springframework.jdbc.core.SqlParameter;
import org.springframework.jdbc.object.SqlUpdate;

import javax.sql.DataSource;
import java.sql.Types;

/**
 * Created by IntelliJ IDEA.
 * Account: mike
 * Date: 11/09/12
 * Time: 21:55
 * To change this template use File | Settings | File Templates.
 */
public class DeletePlayer extends SqlUpdate {

    private static final String SQL =
            "DELETE"
            + " FROM player"
            + " WHERE player_id = ?";

    public DeletePlayer(DataSource dataSource) {
        super(dataSource, SQL);
        super.declareParameter(new SqlParameter("player_id", Types.INTEGER));
        compile();
    }
}
