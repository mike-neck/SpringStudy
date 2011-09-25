package orz.mikeneck.spring.study.util.ticket

import orz.mikeneck.spring.study.util.PrepareTable
import orz.mikeneck.spring.study.util.SqlUtil

/**
 * Created by IntelliJ IDEA.
 * User: mike
 * Date: 11/09/19
 * Time: 17:44
 * To change this template use File | Settings | File Templates.
 */
class PrepareEvent extends SqlUtil implements PrepareTable {

    String EVENT_DATA = $/
1, test1, 2011-09-30 09:59:59
2, test2, 2011-09-30 10:00:00
3, test3, 2011-10-01 10:00:00
4, test4, 2011-10-02 10:00:00
5, test5, 2011-10-02 10:00:01
/$

    def setData = {
        EVENT_DATA.eachLine {line ->
            println line
            if (line.trim().length() > 0) {
                def records = line.trim().split(',')
                def insert = new StringWriter()
                insert << "INSERT INTO event VALUES("
                insert << "${records[0]},"
                insert << "'${records[1].trim()}',"
                insert << "TIMESTAMP '${records[2].trim()}'"
                insert << ")"
                println insert.toString()
                sql.executeInsert(insert.toString())
            }
        }
    }

    def erase = {
        def truncate = 'TRUNCATE TABLE event'
        sql.execute(truncate)
    }

    @Override
    void prepare() {
        def task = [open, setData, close]
        task.each {it()}
    }

    @Override
    void cleanup() {
        def task = [open, erase, close]
        task.each {it()}
    }
}
