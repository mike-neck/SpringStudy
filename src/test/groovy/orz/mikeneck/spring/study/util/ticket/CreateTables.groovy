package orz.mikeneck.spring.study.util.ticket

import orz.mikeneck.spring.study.util.SqlUtil
import org.junit.Before
import org.junit.After
import org.junit.Test

/**
 * Created by IntelliJ IDEA.
 * Account: mike
 * Date: 11/09/17
 * Time: 16:13
 * To change this template use File | Settings | File Templates.
 */
class CreateTables extends SqlUtil {

    def createTable = 'CREATE TABLE IF NOT EXISTS '
    def primaryKey = 'PRIMARY KEY'
    def auto = 'AUTO_INCREMENT'
    def intType = 'INT'
    def varChar = {size -> "VARCHAR($size)"}
    def dateType = 'DATETIME'
    def notNull = 'NOT NULL'
    def timeStamp = 'TIMESTAMP'

    @Test
    public void setUpUser() {
        def user = new StringWriter()
        user << "${createTable} account("
        user << "account_id ${intType} ${primaryKey} ${auto},"
        user << "name ${varChar(255)} ${notNull})"
        sql.execute(user.toString())
    }

    @Test
    public void setUpEvent() {
        def event = new StringWriter()
        event << "${createTable} event("
        event << "event_id ${intType} ${primaryKey} ${auto},"
        event << "name ${varChar(255)} ${notNull},"
        event << "date ${dateType})"
        sql.execute(event.toString())

        def truncate = "TRUNCATE TABLE event"
        sql.execute(truncate)

        def insert = "INSERT INTO event VALUES(1, 'test', TIMESTAMP '2011-09-19 10:30:59')"
        sql.executeInsert(insert)

        def select = "SELECT event_id, name, date AS tmstmp, FORMATDATETIME(date, 'yyyyMMddHHmmss') AS fomratDate FROM event"
        sql.eachRow(select, {item ->
            assert item.getAt('EVENT_ID') == 1
            assert item.getAt('NAME') == 'test'
            assert item.getAt('fomratDate') == '20110919103059'
        })

        sql.execute(truncate)
    }

    @Test
    public void setUpRank() {
        def rank = new StringWriter()
        rank << "${createTable} rank("
        rank << "rank_id ${intType} ${primaryKey} ${auto},"
        rank << "name ${varChar(255)} ${notNull},"
        rank << "price ${intType} ${notNull},"
        rank << "event_id ${intType} ${notNull})"
        sql.execute(rank.toString())
    }

    @Test
    public void setUpTicket() {
        def ticket = new StringWriter()
        ticket << "${createTable} ticket("
        ticket << "ticket_id ${intType} ${primaryKey} ${auto},"
        ticket << "event_id ${intType} ${notNull},"
        ticket << "rank_id ${intType} ${notNull})"
        sql.execute(ticket.toString())
    }

    @Test
    public void setUpReservation() {
        def reservation = new StringWriter()
        reservation << "${createTable} reservation("
        reservation << "reservation_id ${intType} ${primaryKey},"
        reservation << "user_id ${intType} ${notNull},"
        reservation << "reserved_time_stamp ${timeStamp} ${notNull})"
        sql.execute(reservation.toString())
    }

    @Before
    public void setUp() {
        open()
    }

    @After
    public void tearDown() {
        close()
    }
}
