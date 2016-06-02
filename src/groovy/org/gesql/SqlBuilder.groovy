package org.gesql


class SqlBuilder {

  String select(List items){
    buildQuery("SELECT",items)
  }

  private String buildQuery(String type, List qElems){
     String selectVars = qElems.collect { elem ->
      mapToParam(elem)
    }. join(",")
    type +" "+selectVars
  }

  private String mapToParam(def field){
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

  String from(List items){
    buildQuery("FROM", items)
  }

}