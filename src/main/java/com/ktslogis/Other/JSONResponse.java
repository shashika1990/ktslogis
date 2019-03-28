package com.ktslogis.Other;

public class JSONResponse {

    private String response;

    public JSONResponse() {
    }

    public JSONResponse(String response) {
        this.response = response;
    }

    public String getResponse() {
        return response;
    }

    public void setResponse(String response) {
        this.response = response;
    }

    @Override
    public String toString() {
        return "JSONResponse{" +
                "response='" + response + '\'' +
                '}';
    }
}
