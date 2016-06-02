package org.gesql


class SqlBuilder {

  String select(List items){
    String q = "SELECT "
    String selectVars = items.collect { item ->
      mapToSelectParam(item)
    }. join(",")
    q + selectVars
  }

  private String mapToSelectParam(def field){
    String result
    switch(field.getClass()){
    case Map: def elemAsList = field.collect{k,v-> [k,v]}.flatten()
              result = "${elemAsList.first()} as ${elemAsList.last()}"
	      break;
    case String: result= field; break;
    case Closure: result = field(); break;
    default: result= ""
    }
    return result
  }

}