package com.scaler.parkinglot.dtos;

public abstract class ResponseDto {
    private ResponseStatusDto responseStatus;

    public ResponseStatusDto getResponseStatus() {
        return responseStatus;
    }

    public void setResponseStatus(ResponseStatusDto responseStatus) {
        this.responseStatus = responseStatus;
    }
}
