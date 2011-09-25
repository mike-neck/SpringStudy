package orz.mikeneck.spring.study.second.regist

import groovy.sql.Sql
import orz.mikeneck.spring.study.util.SqlUtil
import orz.mikeneck.spring.study.util.PrepareTable

/**
 * Created by IntelliJ IDEA.
 * Account: mike
 * Date: 11/09/11
 * Time: 18:49
 * To change this template use File | Settings | File Templates.
 */
class CreateTeamData extends SqlUtil implements PrepareTable {

    def testData = 'src/test/resources/second/regist/team_list.csv'

    def remove = {sql.execute('DROP TABLE IF EXISTS team')}

    def create = {sql.execute('CREATE TABLE team (team_id INT PRIMARY KEY AUTO_INCREMENT, name VARCHAR(40))')}

    def insert = {file ->
        sql.execute("INSERT INTO team SELECT * FROM CSVREAD('${file}', 'team_id, name', 'UTF-8')")
    }

    @Override
    public void prepare() {
        open()
        remove()
        create()
        insert(testData)
        close()
    }

    @Override
    public void cleanup() {
        open()
        remove()
        close()
    }
}
