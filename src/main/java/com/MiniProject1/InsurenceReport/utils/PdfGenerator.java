package com.MiniProject1.InsurenceReport.utils;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.List;

import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Component;

import com.MiniProject1.InsurenceReport.Entity.CitizenPlan;
import com.lowagie.text.Document;
import com.lowagie.text.Font;
import com.lowagie.text.FontFactory;
import com.lowagie.text.PageSize;
import com.lowagie.text.Paragraph;
import com.lowagie.text.pdf.PdfPTable;
import com.lowagie.text.pdf.PdfWriter;
@Component
public class PdfGenerator {
	public void generate(HttpServletResponse response,List<CitizenPlan> cp,File f)throws IOException
	{
		Document document=new Document(PageSize.A4);
		PdfWriter.getInstance(document,response.getOutputStream());
		PdfWriter.getInstance(document,new FileOutputStream(f));
		document.open();
		Font fontTiltle = FontFactory.getFont(FontFactory.TIMES_ROMAN);
		fontTiltle.setSize(20);

		Paragraph para=new Paragraph("Citizen plan info",fontTiltle);
		para.setAlignment(Paragraph.ALIGN_CENTER);
		document.add(para);
		PdfPTable table=new PdfPTable(11);
		table.setSpacingBefore(5);
		table.addCell("CitizenId");
		table.addCell("CitizenName");
		table.addCell("Gender");
		table.addCell("PlanName");
		table.addCell("PlanStatus");
		table.addCell("PlanStartDate");
		table.addCell("PlanEndDate");
		table.addCell("BenifitAmount");
		table.addCell("DeniadReason");
		table.addCell("TerminatedDate");
		table.addCell("TerminatedReason");
		
		for(CitizenPlan plan:cp)
		{
			table.addCell(String.valueOf(plan.getCitizenId()));	
			table.addCell(plan.getCitizenName());
			table.addCell(plan.getGender());
			table.addCell(plan.getPlanName());
			table.addCell(plan.getPlanStatus());

			if(null!=plan.getPlanStartDate())
			{
			table.addCell(plan.getPlanStartDate()+"");
			}else {
				table.addCell("N/A");
			}
			if(null!=plan.getPlanEndDate())
			{
			table.addCell(plan.getPlanEndDate()+"");
			}else {
				table.addCell("N/A");
			}
			if(null!=plan.getBenifitAmount())
			{
			table.addCell(String.valueOf(plan.getBenifitAmount()));
			}else {
				table.addCell("N/A");
			}
			if(null!=plan.getDeniadReason())
			{
			table.addCell(plan.getDeniadReason());
			}else {
				table.addCell("N/A");
			}
			if(null!=plan.getTerminatedDate())
			{
			table.addCell(plan.getTerminatedDate()+"");
			}else {
				table.addCell("N/A");
			}
			if(null!=plan.getTerminatedReason())
			{
			table.addCell(plan.getTerminatedReason());
			}else {
				table.addCell("N/A");
			}
		}
		document.add(table);
		document.close();
	}
	

}
