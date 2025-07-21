package com.sample.service;

import java.io.FileInputStream;
import java.io.FileOutputStream;

import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.stereotype.Service;

@Service
public class XlsmEditorService {

  // TODO: System.out.println -> log
  public void edit(){
    // TODO: propertiesから取得する
    // テンプレートファイル
    String inputPath  = "excel-template/sample-temp.xlsm";
    // 保存先
    String outputPath = "excel-output/output.xlsm";

    try (
        FileInputStream fis = new FileInputStream(inputPath);
        XSSFWorkbook workbook = new XSSFWorkbook(fis);
    ) {

      // 4枚目のシート取得
      Sheet sheet = workbook.getSheetAt(3);

      // Rowの取得
      Row row = sheet.getRow(4);

      // TODO: RequestBodyから取得→設定する
      row.getCell(0, Row.MissingCellPolicy.CREATE_NULL_AS_BLANK).setCellValue("1");
      row.getCell(17,Row.MissingCellPolicy.CREATE_NULL_AS_BLANK).setCellValue("山田 太郎");
      
      // 書き込み作業
      try (FileOutputStream out = new FileOutputStream(outputPath)) {
        workbook.write(out);
      }

      System.out.println("保存完了！ 保存先:" + outputPath);

    } catch (Exception e) {
        e.printStackTrace();
    }
  } 
}
