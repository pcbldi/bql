package org.gesql.utils

import spock.lang.*

class HelpersTest extends Specification {

  def "testing kebabToUnderScore()"() {
  when:
  "nothing in when clause"
  then:
  underscoreStr == Helpers.kebabToUnderscore(kebabStr)
  where:
  underscoreStr                             | kebabStr
  "a_b"                                     | "a-b"
  "some_string with space and under_score"  | "some-string with space and under-score"
  "a string without any kebab"              | "a string without any kebab"
  "         "                               |  "         "
  }

  def "testing camelToUnderScore()"() {
  when:
  "nothing in when clause"
  then:
  underscoreStr == Helpers.camelToUnderscore(camelStr)
  where:
  underscoreStr                             | camelStr
  "a_b"                                     | "a_b"
  "random_class_name"                       | "randomClassName"
  "some_string with space and camel_case"   | "someString with space and camelCase"
  "a string without any camel"              | "a string without any camel"
  "         "                               |  "         "
  "class_name"                               |  "ClassName"
  }

}
