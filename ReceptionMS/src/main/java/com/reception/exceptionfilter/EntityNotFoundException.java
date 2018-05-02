package com.reception.exceptionfilter;

public class EntityNotFoundException extends RuntimeException{
    public EntityNotFoundException(String mes){
      super(mes);
   }
}