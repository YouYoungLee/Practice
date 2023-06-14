package com.practice.service;

import java.io.IOException;
import java.io.InputStream;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.practice.entity.Member;
import com.practice.repository.*;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
@RequiredArgsConstructor
public class ExcelService {

    private final MemberRepository memberRepository;

    public void processExcelFile(MultipartFile file) throws IOException {
    	System.out.println("여기는 옴?");
    	
    	Workbook workbook = new XSSFWorkbook(file.getInputStream());
        
    	System.out.println("여기는 옴2?");

        Sheet sheet = workbook.getSheetAt(0); // 엑셀 시트의 첫 번째 시트를 가져옵니다.
        
        System.out.println("여기는 옴3?");
        
        for (Row row : sheet) {
            // 각 행의 데이터를 추출하여 데이터베이스에 저장하는 로직을 작성합니다.
     
        	
        	System.out.println("여기는 옴4?");
        	
        	Cell nameCell = row.getCell(0);
            Cell phoneNumberCell = row.getCell(1);
            	
            String name = nameCell.getStringCellValue();
            String phoneNumber = phoneNumberCell.getStringCellValue();

            Member member = new Member();
            
            member.setName(name);
            member.setPhoneNumber(phoneNumber);
            System.out.println("여기는 옴6?");
            memberRepository.save(member);

        workbook.close();
    }  
}
}
