package com.SendEmail.sendemailAllKind.Utils;

import java.time.LocalDateTime;

public class EmailUtils {
    public static String getEMailMessage(String name, String host, String token){

        return "Hello " +name +".\n\nYour account has been created. Please click the button below to verify your account. \n\n" + getVerificationUrl(host, token)+"\n\nThe support team.";
    }

    public static String getEMailNewProjectMessage(String name, String project_title, LocalDateTime date){

        return "Hello Dear " +name +".\n\nThank you for choosing us to work for you on "+ project_title +" project.\n\nWe promise integrity and warm collaboration to ensure" +
                "that the project meets your expectations.\n\nStarting date: "+ date.toLocalDate() +"\n\nBest regards, "+"\n\nTujenge Construction Company.";
    }


    public static String getVerificationUrl(String host, String token) {
        return host + "/api/users?token=" +token;
    }

    public static String ViewTheUplaodedFile(String host,String api){
        return host +""+api;
    }

}
