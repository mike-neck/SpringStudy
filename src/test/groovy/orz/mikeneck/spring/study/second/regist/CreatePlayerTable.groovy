package orz.mikeneck.spring.study.second.regist

import orz.mikeneck.spring.study.util.SqlUtil
import orz.mikeneck.spring.study.util.PrepareTable

/**
 * Created by IntelliJ IDEA.
 * Account: mike
 * Date: 11/09/11
 * Time: 19:07
 * To change this template use File | Settings | File Templates.
 */
class CreatePlayerTable extends SqlUtil implements PrepareTable {

    def remove = {sql.execute('DROP TABLE IF EXISTS player')}

    def create = {
        sql.execute(
        'CREATE TABLE player(player_id INT PRIMARY KEY AUTO_INCREMENT,name VARCHAR(255) NOT NULL,team_id INT NOT NULL)')
    }

    @Override
    public void prepare() {
        def execute = [open, remove, create, close]
        execute.each {it()}
    }

    @Override
    public void cleanup() {
        def execute = [open, remove, close]
        execute.each {it()}
    }
}
