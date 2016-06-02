package org.gesql


Class SqlBuilder {

  String select(list items){
    items.collect { item ->
      item
    }. join(",")
  }

}