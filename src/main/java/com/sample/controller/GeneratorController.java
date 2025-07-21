package com.sample.controller;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sample.dto.ResponseDto;
import com.sample.service.XlsmEditorService;

@RestController
public class GeneratorController {
  @Autowired
  private XlsmEditorService xlsmEditorService;

  @PostMapping("/api/v1/excel/generator")
  public ResponseEntity<ResponseDto> excelGenerator() {
    xlsmEditorService.edit();

    ResponseDto res = ResponseDto.builder()
      .status("200")
      .code("SUCCESS")
      .message("Excel作成完了しました。")
      .data(new ArrayList<>())
      .build();

    return ResponseEntity.ok().body(res);
  }
}
