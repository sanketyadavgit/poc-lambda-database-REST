package com.poc;

import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBAttribute;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBHashKey;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBTable;

@DynamoDBTable(tableName="participants")
public class participants {
	
	@DynamoDBHashKey
	private String participant_name;
	@DynamoDBAttribute
	private int id;
	@DynamoDBAttribute
	private String role;

	public participants() {
		
    }
	public participants (String participant_name, int id, String role) {
		this.participant_name = participant_name;
		this.id = id;
		this.role = role;
	}
		
	public String getParticipant_name() {
		return participant_name;
	}
	public void setParticipant_name(String participant_name) {
		this.participant_name = participant_name;
	}
	
	public String getRole() {
		return role;
	}
	public void setRole(String role) {
		this.role = role;
	}
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
}
