package org.gesql.utils


class Helpers {

  static camelToUnderscore = { String str->
    String result="";
    str.getChars().eachWithIndex{ Character c, long index->
      if(Character.isUpperCase(c) && (index!=0)){
	result+="_${Character.toLowerCase(c)}"
      }
      else{
	result+=Character.toLowerCase(c)
      }
    }
    result;
  }

  static kebabToUnderscore = { String str ->
    str.replaceAll("-","_")
  }

  static sanitizeString = camelToUnderscore >> kebabToUnderscore

}