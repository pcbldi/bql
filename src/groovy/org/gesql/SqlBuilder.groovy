package org.gesql


class SqlBuilder {

  String select(List items){
    String q = "SELECT "
    String selectVars = items.collect { item ->
      item
    }. join(",")

    q + selectVars
  }

}