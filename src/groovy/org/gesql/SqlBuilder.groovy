package org.gesql


class SqlBuilder {

  String selectP="";
  String fromP="";
  String whereP="";

  SqlBuilder select(List items){
    this.selectP= buildQuery("SELECT",items)
    this
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

  SqlBuilder from(List items){
    this.fromP=buildQuery("FROM", items)
    return this
  }

  SqlBuilder from(String fromP){
    this.fromP="FROM ${fromP}";
    return this;
  }

  String build(){
    [selectP, fromP, whereP]
    .findAll {it!=""}
    .join(" ").
    concat(";")
  }

  static String build(Closure closure){
    closure.delegate = new SqlBuilder();
    closure().build()
  }

}