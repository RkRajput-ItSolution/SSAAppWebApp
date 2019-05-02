package com.usa.nj.gov.ed.service;

import java.util.Date;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.usa.nj.gov.ed.request.IndvInfoRequest;
import com.usa.nj.gov.ed.response.PlanInfoResponse;

public class SnapRulesService implements IRuleService {

	private static final Logger log = LoggerFactory.getLogger(SnapRulesService.class);

	/**
	 * This method is used to execute SNAP Business Rules
	 */
	@Override
	public PlanInfoResponse executeRules(IndvInfoRequest request) {
		log.debug("** snap plan rules execution started **");
		Double income = request.getMonthlyIncome();

		PlanInfoResponse response = new PlanInfoResponse();
		response.setPlanName(request.getPlanName());
		if (income > 1000) {
			// denied
			response.setPlanStatus("DN");
			response.setDenialReason("Due To High Income");
		} else {
			// approved
			response.setPlanStatus("AP");
			response.setBenefitAmt(300.00);
			response.setPlanStartDate(new Date());
			response.setPlanEndDate(new Date());// add +30
		}
		log.debug("** snap plan rules execution ended **");
		log.info("** snap rules executed successfully **");
		return response;
	}

}
