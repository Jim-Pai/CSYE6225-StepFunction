package com.amazonaws.lambda.demo;

import com.amazonaws.services.lambda.runtime.Context;
import com.amazonaws.services.lambda.runtime.RequestHandler;

public class CallRegistrationService implements RequestHandler<Object, String> {

    @Override
    public String handleRequest(Object input, Context context) {
        context.getLogger().log("Input: " + input);
        if(input.toString().startsWith("Inactive"))
        		return "" + input + ", Call Registration Service.";
        
        
        return input.toString();
    }

}
