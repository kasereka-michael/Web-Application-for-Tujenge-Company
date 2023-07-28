package com.SendEmail.sendemailAllKind.AdditionalOperation;

public class OperationHolder {

    public static String getTheCorrectApi(String api){
        String apiHolder = "";
        if(api.equals("Design")){
            apiHolder ="design";
        }else if(api.equals("Construction")){
            apiHolder ="construction";
        }else if(api.equals("3D video")){
            apiHolder ="3dimplementation";
        }else if(api.equals("Supervision")){
            apiHolder ="supervision";
        }
        return apiHolder;
    }
}
