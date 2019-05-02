package com.usa.nj.gov.ed.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.usa.nj.gov.ed.request.IndvInfoRequest;
import com.usa.nj.gov.ed.response.PlanInfoResponse;
import com.usa.nj.gov.ed.service.EdRulesService;

@RestController
public class EdRulesRestController {

	private static final Logger logger = LoggerFactory.getLogger(EdRulesRestController.class);

	@Autowired
	private EdRulesService service;

	/**
	 * This method is used determine Eligibility
	 * 
	 * @param request
	 * @return PlanInfoResponse
	 */

	@PostMapping(value = "/determineElig", consumes = { "application/xml", "application/json" }, produces = {
			"application/xml", "application/json" })
	public @ResponseBody PlanInfoResponse checkEligibility(@RequestBody IndvInfoRequest request) {
		logger.debug("** checkEligibility() started **");
		PlanInfoResponse response = service.findEligibility(request);
		logger.debug("** checkEligibility() ended **");
		logger.info("** Eligibility Determination Completed Successfully **");
		return response;
	}

}
