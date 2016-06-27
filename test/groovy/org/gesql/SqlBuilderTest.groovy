package org.gesql

import spock.lang.*

class SqlBuilderTest extends Specification {

  def "canary"() {

  given: "Creating new object"
    SqlBuilder sqlBuilder = new SqlBuilder();

  expect: "New object is created."
    assert sqlBuilder
  }

  def "testing select with builder"() {

  when: "testing basic select"
    SqlBuilder builder = new SqlBuilder()
    builder.select(paramsList)
  then:
  builder.selectP == params
  where:
  paramsList                          | params
  ["val1"]                            | "SELECT val1"
  ["val1", "val2"]                    | "SELECT val1,val2"
  ["val1", "val2","val3"]             | "SELECT val1,val2,val3"
  }


  def "testing Select with maps as keys"() {
  when:
  SqlBuilder builder = new SqlBuilder()
  builder.select(paramsList)
  then:
  builder.selectP == params
  where:
  paramsList                          | params
  [["key":"value"]]                   | "SELECT key as value"
  [["key1":"value1"],["key2":"value2"]] | "SELECT key1 as value1,key2 as value2"
  [["key":"value"],"val2"]            | "SELECT key as value,val2"
  }

  def "testing Select with List as keys"() {
  when:
  SqlBuilder builder = new SqlBuilder()
  builder.select(paramsList)
  then:
  builder.selectP == params
  where:
  paramsList                          | params
  ["key1", "key2"]                    | "SELECT key1,key2"
  ["key"]                             | "SELECT key"
  []                                  | "SELECT "
  }


  def "testing from"() {

  when:
  SqlBuilder builder = new SqlBuilder()
  builder.from(paramsList)
  then:
  builder.fromP == params
  where:
  paramsList                          | params
  ["val1"]                            | "FROM val1"
  ["val1", "val2"]                    | "FROM val1,val2"
  ["val1", "val2","val3"]             | "FROM val1,val2,val3"
  }


  def "testing From with maps as keys"() {
  when:
  SqlBuilder builder = new SqlBuilder()
  builder.from(paramsList)
  then:
  builder.fromP == params
  where:
  paramsList                          | params
  [["key":"value"]]                   | "FROM key as value"
  [["key1":"value1"],["key2":"value2"]] | "FROM key1 as value1,key2 as value2"
  [["key":"value"],"val2"]            | "FROM key as value,val2"
  }

  def "testing selectAll"() {
  when:
  SqlBuilder builder = new SqlBuilder()
  builder.selectAll()
  then:
  builder.selectP == "SELECT *"
  }


}