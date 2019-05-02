package com.usa.nj.gov.ed.service;

import com.usa.nj.gov.ed.request.IndvInfoRequest;
import com.usa.nj.gov.ed.response.PlanInfoResponse;

public interface IRuleService {

	public PlanInfoResponse executeRules(IndvInfoRequest request);

}
