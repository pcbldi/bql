package org.gesql

import spock.lang.*

class WholeQueryTest extends Specification {

  def "testing Very Baisc Query"() {
  when:
  SqlBuilder builder = new SqlBuilder()
  builder.select(["val"])
  .from("table1")
  then:
  builder.build() == "SELECT val FROM table1;"
  }

  def "testing Very Baisc Query with Closure"() {
  when:
  String query = SqlBuilder.build {
    select(["val1"])
    from(["table1"])
  }
  then:
  query == "SELECT val1 FROM table1;"
  }
}
