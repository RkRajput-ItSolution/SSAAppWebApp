package com.usa.nj.gov.ed.service;

import java.util.Date;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.usa.nj.gov.ed.request.IndvInfoRequest;
import com.usa.nj.gov.ed.response.PlanInfoResponse;

public class CcapRulesService implements IRuleService {

	private static final Logger log = LoggerFactory.getLogger(CcapRulesService.class);

	/**
	 * This method is used to execute CCAP Business conditions
	 */
	@Override
	public PlanInfoResponse executeRules(IndvInfoRequest request) {
		log.debug("** ccap plan rules execution started **");
		Double income = request.getMonthlyIncome();
		Integer kidsCount = request.getNoOfKids();
		PlanInfoResponse response = new PlanInfoResponse();
		response.setPlanName(request.getPlanName());
		if (income < 1000 && kidsCount > 0) {
			// Approve
			response.setPlanStatus("AP");
			response.setBenefitAmt(300.00);
			response.setPlanStartDate(new Date());
			response.setPlanEndDate(new Date());// add +30
		} else {
			// Denied
			response.setPlanStatus("DN");
			response.setDenialReason("High Income or No Childs");
		}
		log.debug("** ccap plan rules execution ended **");
		log.info("** ccap plan rules execution completed successfully **");
		return response;
	}

}
