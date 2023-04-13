package com.MiniProject1.InsurenceReport;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

import com.MiniProject1.InsurenceReport.Entity.CitizenPlan;
import com.MiniProject1.InsurenceReport.Repository.InsurenceRepository;

@Component
public class ReportRunner implements ApplicationRunner {
	
	@Autowired
	private InsurenceRepository insurenceRepository;
	
	@Override
	public void run(ApplicationArguments args) throws Exception {
		//cash plan
		insurenceRepository.deleteAll();
		CitizenPlan c1=new CitizenPlan();
		c1.setCitizenName("denial");
		c1.setGender("male");
		c1.setPlanName("cash");
		c1.setPlanStatus("Approved");
		c1.setPlanStartDate(LocalDate.now());
		c1.setPlanEndDate(LocalDate.now().plusMonths(6));
		c1.setBenifitAmount(5000.00);
		
		CitizenPlan c2=new CitizenPlan();
		c2.setCitizenName("rashi");
		c2.setGender("female");
		c2.setPlanName("cash");
		c2.setPlanStatus("Denied");
		c2.setDeniadReason("she have an account");
		
		CitizenPlan c3=new CitizenPlan();
		c3.setCitizenName("lara");
		c3.setGender("female");
		c3.setPlanName("cash");
		c3.setPlanStatus("Terminated ");
		c3.setPlanStartDate(LocalDate.now().minusMonths(4));
		c3.setPlanEndDate(LocalDate.now().plusMonths(2));
		c3.setBenifitAmount(5000.00);
		c3.setTerminatedDate(LocalDate.now());
		c3.setTerminatedReason("she not paid properly");
		
		//food plan
		CitizenPlan c4=new CitizenPlan();
		c4.setCitizenName("daya");
		c4.setGender("male");
		c4.setPlanName("food");
		c4.setPlanStatus("Approved");
		c4.setPlanStartDate(LocalDate.now());
		c4.setPlanEndDate(LocalDate.now().plusMonths(6));
		c4.setBenifitAmount(5000.00);
		
		CitizenPlan c5=new CitizenPlan();
		c5.setCitizenName("rakshi");
		c5.setGender("female");
		c5.setPlanName("food");
		c5.setPlanStatus("Denied");
		c5.setDeniadReason("she have an account");
		
		CitizenPlan c6=new CitizenPlan();
		c6.setCitizenName("dayana");
		c6.setGender("female");
		c6.setPlanName("food");
		c6.setPlanStatus("Terminated ");
		c6.setPlanStartDate(LocalDate.now().minusMonths(4));
		c6.setPlanEndDate(LocalDate.now().plusMonths(2));
		c6.setBenifitAmount(5000.00);
		c6.setTerminatedDate(LocalDate.now());
		c6.setTerminatedReason("she not paid properly");
		
		//medical data 
		
		CitizenPlan c7=new CitizenPlan();
		c7.setCitizenName("karan");
		c7.setGender("male");
		c7.setPlanName("medical");
		c7.setPlanStatus("Approved");
		c7.setPlanStartDate(LocalDate.now());
		c7.setPlanEndDate(LocalDate.now().plusMonths(6));
		c7.setBenifitAmount(5000.00);
		
		CitizenPlan c8=new CitizenPlan();
		c8.setCitizenName("sakshi");
		c8.setGender("female");
		c8.setPlanName("medical");
		c8.setPlanStatus("Denied");
		c8.setDeniadReason("she have an account");
		
		CitizenPlan c9=new CitizenPlan();
		c9.setCitizenName("dayana");
		c9.setGender("female");
		c9.setPlanName("medical");
		c9.setPlanStatus("Terminated ");
		c9.setPlanStartDate(LocalDate.now().minusMonths(4));
		c9.setPlanEndDate(LocalDate.now().plusMonths(2));
		c9.setBenifitAmount(5000.00);
		c9.setTerminatedDate(LocalDate.now());
		c9.setTerminatedReason("she not paid properly");
		
		//employeement
		
		CitizenPlan c10=new CitizenPlan();
		c10.setCitizenName("deeksha");
		c10.setGender("male");
		c10.setPlanName("employeement");
		c10.setPlanStatus("Approved");
		c10.setPlanStartDate(LocalDate.now());
		c10.setPlanEndDate(LocalDate.now().plusMonths(6));
		c10.setBenifitAmount(5000.00);
		
		CitizenPlan c11=new CitizenPlan();
		c11.setCitizenName("rakshitha");
		c11.setGender("female");
		c11.setPlanName("employeement");
		c11.setPlanStatus("Denied");
		c11.setDeniadReason("she have an account");
		
		CitizenPlan c12=new CitizenPlan();
		c12.setCitizenName("dayana");
		c12.setGender("female");
		c12.setPlanName("employeement");
		c12.setPlanStatus("Terminated ");
		c12.setPlanStartDate(LocalDate.now().minusMonths(4));
		c12.setPlanEndDate(LocalDate.now().plusMonths(2));
		c12.setBenifitAmount(5000.00);
		c12.setTerminatedDate(LocalDate.now());
		c12.setTerminatedReason("she not paid properly");
		
		List<CitizenPlan> list=Arrays.asList(c1,c2,c3,c4,c5,c6,c7,c8,c9,c10,c11,c12);
		
		insurenceRepository.saveAll(list);
	}

}
