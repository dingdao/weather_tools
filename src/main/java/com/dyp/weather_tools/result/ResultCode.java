package com.dyp.weather_tools.result;

public enum ResultCode {

	// weather error: 500100
	WEATHER_CITY_ERROR(500100, "No weather info for this city"),
	
	SUCCESS(200, "success"),
	FAIL(500, "failed");
	
	

		
	private Integer code;
	
	private String message;
	
	ResultCode(Integer code, String message) {
		this.code = code;
		this.message = message;
	}

	public Integer getCode() {
		return code;
	}

	public void setCode(Integer code) {
		this.code = code;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}
	
}
