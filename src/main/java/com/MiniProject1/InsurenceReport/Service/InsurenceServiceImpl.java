package com.MiniProject1.InsurenceReport.Service;

import java.io.File;
import java.io.IOException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;


import javax.servlet.http.HttpServletResponse;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.stereotype.Service;

import com.MiniProject1.InsurenceReport.Entity.CitizenPlan;
import com.MiniProject1.InsurenceReport.Repository.InsurenceRepository;
import com.MiniProject1.InsurenceReport.request.SearchRequest;
import com.MiniProject1.InsurenceReport.utils.EmailUtils;
import com.MiniProject1.InsurenceReport.utils.ExcelGenerator;
import com.MiniProject1.InsurenceReport.utils.PdfGenerator;

@Service
public class InsurenceServiceImpl implements InsurenceService {


	@Autowired
	private InsurenceRepository insurenceRepository;
	
	@Autowired
	private PdfGenerator pdfGenerator;
	
	@Autowired
	private ExcelGenerator  excelGenerator;
	
	@Autowired
	private EmailUtils emailUtils;
	
	@Override
	public List<CitizenPlan> getAllData() {
		
		return insurenceRepository.findAll();
	}

	public List<String> getPlanName() {
		
		return insurenceRepository.getPlanName();
	}
	
	public List<String> getPlanStatus() {
		
		return insurenceRepository.getPlanStatus();
	}
 
	
	@Override
	public List<CitizenPlan> search(SearchRequest search) {
		CitizenPlan plan=new CitizenPlan();
		if(null!=search.getPlanName()&&!"".equals(search.getPlanName()))
		{
			plan.setPlanName(search.getPlanName());
		}
		if(null!=search.getPlanStatus()&&!"".equals(search.getPlanStatus()))
		{
			plan.setPlanStatus(search.getPlanStatus());
		}
		if(null!=search.getGender()&&!"".equals(search.getGender()))
		{
			plan.setGender(search.getGender());
		}
		if(null!=search.getPlanStartDate()&&!"".equals(search.getPlanStartDate()))
		{
			String date=search.getPlanStartDate();
			DateTimeFormatter formatter=DateTimeFormatter.ofPattern("yyyy-MM-dd");
			LocalDate local=LocalDate.parse(date,formatter);
			plan.setPlanStartDate(local);
		}
		if(null!=search.getPlanEndDate()&&!"".equals(search.getPlanEndDate()))
		{
			String date=search.getPlanEndDate();
			DateTimeFormatter formatter=DateTimeFormatter.ofPattern("yyyy-MM-dd");
			LocalDate local=LocalDate.parse(date,formatter);
			plan.setPlanEndDate(local);
		}
		return insurenceRepository.findAll(Example.of(plan));
	}

	@Override
	public boolean exportExcel(HttpServletResponse response) throws IOException {
		
		List<CitizenPlan> cp = insurenceRepository.findAll();
		File f=new File("Plans.xls");
		
		excelGenerator.generate(response, cp,f);
		
		String subject="test mail subject";
		String body="<h1>test mail body</h1>";
		String to="pavankumarreddy.b1996@gmail.com";
		
		emailUtils.sendEmail(subject, body, to,f);
		f.delete();
		return true;
	}

	@Override
	public boolean exportPdf(HttpServletResponse response) throws IOException {
		File f=new File("Report.pdf");
		List<CitizenPlan> list=insurenceRepository.findAll();
		pdfGenerator.generate(response, list, f);
		String subject="test mail subject";
		String body="<h1>test mail body</h1>";
		String to="pavankumarreddy.b1996@gmail.com";
		emailUtils.sendEmail(subject, body, to, f);
		f.delete();
		return true;
	}
	
	
}
