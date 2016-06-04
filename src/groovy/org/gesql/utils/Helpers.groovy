package org.gesql.utils


class Helpers {

  static String camelToUnderscore(String str){
    String result="";
    str.getChars().eachWithIndex { Character c, long index->
      if(Character.isUpperCase(c) && (index!=0)){
	result+="_${Character.toLowerCase(c)}"
      }
      else{
	result+=Character.toLowerCase(c)
      }

    }
    result;
  }

  static String kebabToUnderscore(String str){
    str.replaceAll("-","_")

  }

  String sanitizeString(String str){

  }

}