package com.practice.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.practice.service.ExcelService;

import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
public class PracticeController {

	 private final ExcelService excelService;

	 @PostMapping("/uploadExcel")
	 public ResponseEntity<String> uploadExcelFile(@RequestParam("file") MultipartFile file) {
		 System.out.println("여기옴?");
	        try {
	            excelService.processExcelFile(file);
	            return ResponseEntity.ok("Excel file uploaded and processed successfully.");
	        } catch (Exception e) {
	        	System.out.println(e);
	            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Failed to process the Excel file.");
	        }
	    }
}
