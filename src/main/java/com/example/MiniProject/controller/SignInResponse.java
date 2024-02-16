package com.example.MiniProject.controller;

public class SignInResponse {
    private boolean success;
    private Long userId;

    public SignInResponse(boolean success, Long userId) {
        this.success = success;
        this.userId = userId;
    }

    public boolean isSuccess() {
        return success;
    }

    public void setSuccess(boolean success) {
        this.success = success;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }
}

