package com.example.JpaPractice.Models.Auth;

public class AuthLoginResponse {
    private String token;
    private String message;
    private boolean success;

    // Constructors
    public AuthLoginResponse() {}

    public AuthLoginResponse(String token, String message, boolean success) {
        this.token = token;
        this.message = message;
        this.success = success;
    }

    // Getters and Setters
    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public boolean isSuccess() {
        return success;
    }

    public void setSuccess(boolean success) {
        this.success = success;
    }
}