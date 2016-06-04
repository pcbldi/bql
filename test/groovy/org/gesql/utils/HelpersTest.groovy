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
}
