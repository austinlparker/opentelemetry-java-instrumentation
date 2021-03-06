/*
 * Copyright The OpenTelemetry Authors
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package io.opentelemetry.auto.typedspan;

import io.opentelemetry.trace.Span;

public interface DbRedisSemanticConvention {
  void end();

  Span getSpan();

  /**
   * Sets a value for db.system
   *
   * @param dbSystem An identifier for the database management system (DBMS) product being used. See
   *     below for a list of well-known identifiers..
   */
  public DbRedisSemanticConvention setDbSystem(String dbSystem);

  /**
   * Sets a value for db.connection_string
   *
   * @param dbConnectionString The connection string used to connect to the database..
   *     <p>It is recommended to remove embedded credentials.
   */
  public DbRedisSemanticConvention setDbConnectionString(String dbConnectionString);

  /**
   * Sets a value for db.user
   *
   * @param dbUser Username for accessing the database..
   */
  public DbRedisSemanticConvention setDbUser(String dbUser);

  /**
   * Sets a value for db.jdbc.driver_classname
   *
   * @param dbJdbcDriverClassname The fully-qualified class name of the [Java Database Connectivity
   *     (JDBC)](https://docs.oracle.com/javase/8/docs/technotes/guides/jdbc/) driver used to
   *     connect..
   */
  public DbRedisSemanticConvention setDbJdbcDriverClassname(String dbJdbcDriverClassname);

  /**
   * Sets a value for db.name
   *
   * @param dbName If no tech-specific attribute is defined, this attribute is used to report the
   *     name of the database being accessed. For commands that switch the database, this should be
   *     set to the target database (even if the command fails)..
   *     <p>In some SQL databases, the database name to be used is called &#34;schema name&#34;.
   */
  public DbRedisSemanticConvention setDbName(String dbName);

  /**
   * Sets a value for db.statement
   *
   * @param dbStatement The database statement being executed..
   *     <p>The value may be sanitized to exclude sensitive information.
   */
  public DbRedisSemanticConvention setDbStatement(String dbStatement);

  /**
   * Sets a value for db.operation
   *
   * @param dbOperation The name of the operation being executed, e.g. the [MongoDB command
   *     name](https://docs.mongodb.com/manual/reference/command/#database-operations) such as
   *     `findAndModify`..
   *     <p>While it would semantically make sense to set this, e.g., to a SQL keyword like `SELECT`
   *     or `INSERT`, it is not recommended to attempt any client-side parsing of `db.statement`
   *     just to get this property (the back end can do that if required).
   */
  public DbRedisSemanticConvention setDbOperation(String dbOperation);

  /**
   * Sets a value for net.peer.name
   *
   * @param netPeerName Remote hostname or similar, see note below..
   */
  public DbRedisSemanticConvention setNetPeerName(String netPeerName);

  /**
   * Sets a value for net.peer.ip
   *
   * @param netPeerIp Remote address of the peer (dotted decimal for IPv4 or
   *     [RFC5952](https://tools.ietf.org/html/rfc5952) for IPv6).
   */
  public DbRedisSemanticConvention setNetPeerIp(String netPeerIp);

  /**
   * Sets a value for net.peer.port
   *
   * @param netPeerPort Remote port number..
   */
  public DbRedisSemanticConvention setNetPeerPort(long netPeerPort);

  /**
   * Sets a value for net.transport
   *
   * @param netTransport Transport protocol used. See note below..
   */
  public DbRedisSemanticConvention setNetTransport(String netTransport);

  /**
   * Sets a value for db.redis.database_index
   *
   * @param dbRedisDatabaseIndex The index of the database being accessed as used in the [`SELECT`
   *     command](https://redis.io/commands/select), provided as an integer. To be used instead of
   *     the generic `db.name` attribute..
   */
  public DbRedisSemanticConvention setDbRedisDatabaseIndex(long dbRedisDatabaseIndex);
}
