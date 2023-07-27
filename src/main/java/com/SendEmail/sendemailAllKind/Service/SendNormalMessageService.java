package com.SendEmail.sendemailAllKind.Service;

public interface SendNormalMessageService {
    String sendMessageToProjectOwner(String toPhoneNumber, String projectOwner, String projectTitle);
}
