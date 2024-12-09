package com.br.uff.anuncios.util;

public class EmailUtils {

    public static boolean isEmailUff(String email){
        if(email == null) return false;
        return email.endsWith("@id.uff.br") || email.endsWith(".uff.br");
    }

}
