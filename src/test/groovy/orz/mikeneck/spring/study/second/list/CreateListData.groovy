package orz.mikeneck.spring.study.second.list

import groovy.sql.Sql
import orz.mikeneck.spring.study.util.SqlUtil

/**
 * Created by IntelliJ IDEA.
 * Account: mike
 * Date: 11/09/11
 * Time: 16:14
 * To change this template use File | Settings | File Templates.
 */
class CreateListData extends SqlUtil {

    public void createData() {
        open()
        sql.execute(TeamListFixture.remove())
        sql.execute(TeamListFixture.create())
        sql.execute(TeamListFixture.insert('src/test/resources/second/list/team_list.csv'))
        sql.eachRow('SELECT * FROM team', {
            println "${it.team_id} ${it.name}"
        })
        close()
    }

    public void removeData() {
        open()
        sql.execute(TeamListFixture.remove())
        close()
    }
}
