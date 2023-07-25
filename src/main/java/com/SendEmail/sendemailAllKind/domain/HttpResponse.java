package com.SendEmail.sendemailAllKind.domain;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Data;
import lombok.experimental.SuperBuilder;
import org.springframework.http.HttpStatus;

import java.nio.channels.FileChannel;
import java.util.Map;
@Data
@SuperBuilder
@JsonInclude(JsonInclude.Include.NON_DEFAULT)
public class HttpResponse {
    protected String timesStamp;
    protected int statusCode;
    protected HttpStatus status;
    protected String message ;
    protected String DeveloperMessage;
    protected String path;
    protected String requestMethod;
    protected Map<?,?> data;


}
