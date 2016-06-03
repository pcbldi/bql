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
}
