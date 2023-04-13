package com.MiniProject1.InsurenceReport.utils;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.List;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletResponse;

import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.MiniProject1.InsurenceReport.Entity.CitizenPlan;
import com.MiniProject1.InsurenceReport.Repository.InsurenceRepository;

@Component
public class ExcelGenerator {
	public void generate(HttpServletResponse response,List<CitizenPlan> cp,File file)throws IOException
	{
		HSSFWorkbook workbook = new HSSFWorkbook();
		HSSFSheet sheet = workbook.createSheet("CITIZEN_PLANS_INFO");
		HSSFRow row = sheet.createRow(0);

		row.createCell(0).setCellValue("CitizenId");
		row.createCell(1).setCellValue("CitizenName");
		row.createCell(2).setCellValue("Gender");
		row.createCell(3).setCellValue("PlanName");
		row.createCell(4).setCellValue("PlanStatus");
		row.createCell(5).setCellValue("PlanStartDate");
		row.createCell(6).setCellValue("PlanEndDate");
		row.createCell(7).setCellValue("BenifitAmount");
		row.createCell(8).setCellValue("DeniadReason");
		row.createCell(9).setCellValue("TerminatedDate");
		row.createCell(10).setCellValue("TerminatedReason");
		int dataRowIndex = 1;

		for (CitizenPlan plan : cp) {
			HSSFRow row1 = sheet.createRow(dataRowIndex);
			row1.createCell(0).setCellValue(plan.getCitizenId());
			row1.createCell(1).setCellValue(plan.getCitizenName());
			row1.createCell(2).setCellValue(plan.getGender());
			row1.createCell(3).setCellValue(plan.getPlanName());
			row1.createCell(4).setCellValue(plan.getPlanStatus());

			if(null!=plan.getPlanStartDate())
			{
			row1.createCell(5).setCellValue(plan.getPlanStartDate()+"");
			}else
			{
				row1.createCell(5).setCellValue("N/A");
			}
			if(null!=plan.getPlanEndDate())
			{
			row1.createCell(6).setCellValue(plan.getPlanEndDate()+"");
			}else
			{
				row1.createCell(6).setCellValue("N/A");
			}
			if(null!=plan.getBenifitAmount())
			{
			row1.createCell(7).setCellValue(plan.getBenifitAmount());
			}else
			{
				row1.createCell(7).setCellValue("N/A");
			}
			if(null!=plan.getDeniadReason())
			{
			row1.createCell(8).setCellValue(plan.getDeniadReason());
			}else
			{
				row1.createCell(8).setCellValue("N/A");
			}
			if(null!=plan.getTerminatedDate())
			{
			row1.createCell(9).setCellValue(plan.getTerminatedDate()+"");
			}else
			{
				row1.createCell(9).setCellValue("N/A");
			}
			if(null!=plan.getTerminatedReason())
			{  
			   row1.createCell(10).setCellValue(plan.getTerminatedReason());
			}else
			{
				row1.createCell(10).setCellValue("N/A");
			}

			dataRowIndex++;
		}
		
		FileOutputStream fos=new FileOutputStream(file);
		workbook.write(fos);
		fos.close();
		ServletOutputStream sos = response.getOutputStream();
		workbook.write(sos);
		workbook.close();
		sos.close();	
	}
	

	

	

}
