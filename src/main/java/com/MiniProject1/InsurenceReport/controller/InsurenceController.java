package com.MiniProject1.InsurenceReport.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.MiniProject1.InsurenceReport.Entity.CitizenPlan;
import com.MiniProject1.InsurenceReport.Service.InsurenceService;
import com.MiniProject1.InsurenceReport.request.SearchRequest;

@Controller
@RequestMapping("/insurence")
public class InsurenceController  {

	@Autowired
	private InsurenceService insurenceService;
	
	@PostMapping("/search")
	public String handleSearch(@ModelAttribute("search")SearchRequest search,Model model)
	{
		System.out.println(search);
		List<CitizenPlan> plans=insurenceService.search(search);
		model.addAttribute("plans", plans);
		init(model);
		return "index";
	}
	@GetMapping("/")
	public String getView(Model model)
	{
		model.addAttribute("search",new SearchRequest());
		init(model);
		return "index";
	}

	private void init(Model model) {
		//model.addAttribute("search",new SearchRequest());
		model.addAttribute("names",insurenceService.getPlanName());
		model.addAttribute("status",insurenceService.getPlanStatus());
	}
	
	@GetMapping("/excel")
	public void excelExport(HttpServletResponse response) throws IOException 
	{
		 response.setContentType("application/octet-stream"); 
		  String headerKey="Content-Disposition"; 
		  String headerValue="attachment;filename=Report.xls"; 
		  response.setHeader(headerKey,headerValue); 
		  insurenceService.exportExcel(response);
	}

	@GetMapping("/pdf")
	public void pdfExport(HttpServletResponse response) throws IOException 
	{
		 response.setContentType("application/pdf"); 
		  String headerKey="Content-Disposition"; 
		  String headerValue="attachment;filename=Report.pdf"; 
		  response.setHeader(headerKey,headerValue); 
		  insurenceService.exportPdf(response);
	}
}
