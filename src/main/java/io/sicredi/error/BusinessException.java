package io.sicredi.error;

public class BusinessException extends RuntimeException {

  public BusinessException(String message) {
    super(message);
  }
}
