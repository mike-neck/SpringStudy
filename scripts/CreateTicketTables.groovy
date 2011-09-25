
/**
 * Created by IntelliJ IDEA.
 * Account: mike
 * Date: 11/09/17
 * Time: 14:35
 * To change this template use File | Settings | File Templates.
 */

@Grab('com.h2database:h2:1.3.159')
import org.h2.Driver
import groovy.sql.Sql

def sql = Sql.newInstance('jdbc:h2:/Users/mike/h2database/spring-study', 'mike', 'mike', 'org.h2.Driver')
def createTable = 'CREATE TABLE IF NOT EXIST '
def primaryKey = 'PRIMARY KEY'
def auto = 'AUTO_INCREMENT'
def intType = 'INT'
def varChar = {size -> "VARCHAR($size)"}
def dateType = 'DATETIME'
def notNull = 'NOT NULL'
def timeStamp = 'TIMESTAMP'


def user = "${createTable} user(user_id ${intType} ${primaryKey} ${auto}, name ${varChar(255)} ${notNull})"
sql.execute(user)

def event = new StringWriter()
event << "${createTable} event("
event << "event_id ${intType} ${primaryKey} ${auto},"
event << "name ${varChar(255)} ${notNull},"
event << "date ${dateType})"
sql.execute(event.toString())

def rank = new StringWriter()
rank << "${createTable} rank("
rank << "rank_id ${intType} ${primaryKey} ${auto},"
rank << "name ${varChar(255)} ${notNull},"
rank << "price ${intType} ${notNull},"
rank << "event_id ${intType} ${notNull})"
sql.execute(rank.toString())

def ticket = new StringWriter()
ticket << "${createTable} ticket("
ticket << "ticket_id ${intType} ${primaryKey} ${auto},"
ticket << "event_id ${intType} ${notNull},"
ticket << "rank_id ${intType} ${notNull})"
sql.execute(ticket.toString())

def reservation = new StringWriter()
reservation << "${createTable} reservation("
reservation << "reservation_id ${intType} ${primaryKey},"
reservation << "user_id ${intType} ${notNull},"
reservation << "reserved_time_stamp ${timeStamp} ${notNull})"
sql.execute(reservation.toString())

sql.close()

