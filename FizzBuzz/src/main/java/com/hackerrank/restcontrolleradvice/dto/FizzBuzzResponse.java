package com.hackerrank.restcontrolleradvice.dto;

public class FizzBuzzResponse {
  private String message;
  private int statusCode;

  public FizzBuzzResponse(String message, int statusCode) {
    this.message = message;
    this.statusCode = statusCode;
  }

  public FizzBuzzResponse() {
  }

  public String getMessage() {
    return message;
  }

  public void setMessage(String message) {
    this.message = message;
  }

  public int getStatusCode() {
    return statusCode;
  }

  public void setStatusCode(int statusCode) {
    this.statusCode = statusCode;
  }

}
