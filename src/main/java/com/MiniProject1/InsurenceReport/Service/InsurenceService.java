package com.MiniProject1.InsurenceReport.Service;

import java.io.IOException;
import java.util.List;

import javax.servlet.http.HttpServletResponse;

import com.MiniProject1.InsurenceReport.Entity.CitizenPlan;
import com.MiniProject1.InsurenceReport.request.SearchRequest;

public interface InsurenceService {
	
	public List<CitizenPlan> getAllData();
	public List<String> getPlanName();
	public List<String> getPlanStatus();
	public List<CitizenPlan> search(SearchRequest search);
	public boolean exportPdf(HttpServletResponse response) throws IOException;
	public boolean exportExcel(HttpServletResponse response) throws IOException;
	 

}
