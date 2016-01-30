package com.skc.domain

class Employee {
  
  Long id
  String name
  String designation
  
  // contrains are defined as static 
  static constraints = {
    name(blank:false, nullable:false,size:3..500)
    designation(nullable:false)
  }
}
