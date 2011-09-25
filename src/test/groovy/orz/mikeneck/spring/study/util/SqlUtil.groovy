package orz.mikeneck.spring.study.util

import groovy.sql.Sql

/**
 * Created by IntelliJ IDEA.
 * Account: mike
 * Date: 11/09/11
 * Time: 18:51
 * To change this template use File | Settings | File Templates.
 */
class SqlUtil {

    Sql sql

    def open = {
        this.sql = Sql.newInstance(
                'jdbc:h2:/Users/mike/h2database/spring-study', 'mike', 'mike', 'org.h2.Driver')}

    def close = { sql.close() }
}
