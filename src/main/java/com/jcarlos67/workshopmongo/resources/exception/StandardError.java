package com.jcarlos67.workshopmongo.resources.exception;


import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

@Getter
@Setter
public class StandardError implements Serializable {
  private static final long serialVersionUID = 1l;

  private Long timeStamp;
  private Integer status;
  private String error;
  private String message;
  private String path;

  private StandardError() {}

  public StandardError(Long timeStamp, Integer status, String error, String message, String path) {
    this.timeStamp = timeStamp;
    this.status = status;
    this.error = error;
    this.message = message;
    this.path = path;
  }
}
