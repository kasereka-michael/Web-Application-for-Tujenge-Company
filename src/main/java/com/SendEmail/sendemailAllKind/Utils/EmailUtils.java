package com.SendEmail.sendemailAllKind.Utils;

public class EmailUtils {
    public static String getEMailMessage(String name, String host, String token){

        return "Hello " +name +".\n\nYour account has been created. Please click the button below to verify your account. \n\n" + getVerificationUrl(host, token)+"\n\nThe support team.";
    }

    public static String getVerificationUrl(String host, String token) {
        return host + "/api/users?token=" +token;
    }
}
