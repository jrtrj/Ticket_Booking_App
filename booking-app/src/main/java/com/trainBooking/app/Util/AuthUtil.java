package com.trainBooking.app.Util;

import org.mindrot.jbcrypt.BCrypt;

public class AuthUtil {
    public static boolean verifyPasswd(String plainPassword, String hashedPassword) {
        return BCrypt.checkpw(plainPassword,hashedPassword);
    }
    public static String hashPasswd(String plainPassword) {
        return BCrypt.hashpw(plainPassword,BCrypt.gensalt());
    }
}
