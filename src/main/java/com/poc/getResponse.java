package com.poc;

//providing inputs for GET and POST method from here

public class getResponse {
	
	String request_type; // to decide the request type
	
	participants participants; // for accepting input json while POST request
	
	String participant_name; // query parameter for GET request
//	int statusCode;

	public String getRequest_type() {
		return request_type;
	}

	public void setRequest_type(String request_type) {
		this.request_type = request_type;
	}

	public participants getParticipants() {
		return participants;
	}

	public void setParticipants(participants participants) {
		this.participants = participants;
	}

	public String getParticipant_name() {
		return participant_name;
	}

	public void setParticipant_name(String participant_name) {
		this.participant_name = participant_name;
	}

//	public int getStatusCode() {
//		return statusCode;
//	}
//
//	public void setStatusCode(int statusCode) {
//		this.statusCode = statusCode;
//	}

//	public void jsonResponse(String newName) {
//		this.name = name + newName;
//		statusCode = 200;
//	}

}