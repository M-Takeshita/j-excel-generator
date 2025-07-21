package com.sample.dto;

import java.util.List;

import lombok.Builder;
import lombok.Data;

@Builder
@Data
public class ResponseDto {
  private String status;
  private String message;
  private String code;
  private List<Object> data;
}
