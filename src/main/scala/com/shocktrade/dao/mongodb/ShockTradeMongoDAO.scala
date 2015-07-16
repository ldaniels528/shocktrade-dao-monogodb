package com.shocktrade.dao.mongodb

import com.mongodb.casbah.Imports._
import com.mongodb.casbah.commons.conversions.scala._

/**
 * ShockTrade MongoDB Data Access Object (DAO)
 * @author lawrence.daniels@gmail.com
 */
trait ShockTradeMongoDAO {
  // define the connection parameters
  protected val DATABASE_NAME = "shocktrade"
  protected val DEFAULT_CONCERN = WriteConcern.JournalSafe // Safe | JournalSafe

  // register the time/date helpers
  RegisterJodaTimeConversionHelpers()

  /**
   * Creates a new database connection
   */
  def getConnection = {
    // create the options
    val options = new MongoOptions()
    options.connectionsPerHost = 100
    options.maxWaitTime = 2000
    options.socketKeepAlive = false
    options.threadsAllowedToBlockForConnectionMultiplier = 50

    // create the connection
    MongoConnection(List(
      new ServerAddress("dev801", 27017),
      new ServerAddress("dev802", 27017),
      new ServerAddress("dev803", 27017)
    ), options)
  }

  /**
   * Returns a new reference to the specified collection
   */
  def getCollection(name: String)(implicit conn: MongoConnection) = conn(DATABASE_NAME)(name)

}