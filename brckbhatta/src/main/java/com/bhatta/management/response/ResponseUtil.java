package com.bhatta.management.response;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class ResponseUtil {
	private static Logger logger=LoggerFactory.getLogger(ResponseUtil.class);
	
	public static ResponseObject<Object> populateResponseObject(final Object baseRsponseModel,
			final String responseStatus,final Error error){
		ResponseObject<Object> response=new ResponseObject<>();
		response.setResponse(baseRsponseModel);
		Status status=new Status();
		status.setResponseStatus(responseStatus);
		status.setError(error);
		response.setStatus(status);
		return response;
	}
}
