/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ru.avalon.java.site.helpers;

import ru.avalon.java.site.exceptions.ValidationException;

/**
 *
 * @author pashak
 */
public class Validation {
    private Validation(){
    }
    public static void require(String text, String error) throws ValidationException {
        if  (text == null || text.isEmpty()) {
            throw new ValidationException(error);
        }
    }
    
    public static void requireEquals(Object a, Object b, String error) throws ValidationException {
        if (!a.equals(b)) {
            throw new ValidationException(error);
        }
    }
    
    public static void requireNull(Object o, String error) throws ValidationException {
        if (o != null) {
            throw new ValidationException(error);
        }
    }
    
      public static void requireNotNull(Object o, String error) throws ValidationException {
        if (o == null) {
            throw new ValidationException(error);
        }
    }
    
}
