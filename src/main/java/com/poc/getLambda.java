package com.poc;

import com.amazonaws.services.dynamodbv2.AmazonDynamoDB;
import com.amazonaws.services.dynamodbv2.AmazonDynamoDBClientBuilder;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBMapper;
import com.amazonaws.services.dynamodbv2.model.ResourceNotFoundException;
import com.amazonaws.services.lambda.runtime.Context;

public class getLambda {
	
	public static Object handleLambdaRequest(getResponse getResponse, Context context) throws ResourceNotFoundException {
		
		AmazonDynamoDB client = AmazonDynamoDBClientBuilder.defaultClient();
	    DynamoDBMapper dynamoDBMap = new DynamoDBMapper(client);
	    participants participant = null;
	    
	    switch (getResponse.getRequest_type().toUpperCase()) {
	    case "GET":
	    	// retrieve data from table with the hash key (partition key) given
	    	participant = dynamoDBMap.load(participants.class, getResponse.getParticipant_name());
	    	
	    	if (participant == null) {
	    		throw new ResourceNotFoundException("No data found for: " + getResponse.getParticipant_name());
	    	}
	    	return participant;
	    	
			/* Below code queries data using QueryRequest
			 * 
			 * Map<String,String> expressionAttributesNames = new HashMap<>();
			 * expressionAttributesNames.put("#participant_name","participant_name");
			 * 
			 * Map<String,AttributeValue> expressionAttributeValues = new HashMap<>();
			 * expressionAttributeValues.put(":participantNameValue",new
			 * AttributeValue().withS(getResponse.getParticipant_name()));
			 * 
			 * QueryRequest queryRequest = new QueryRequest() .withTableName("participants")
			 * .withKeyConditionExpression("#participant_name = :participantNameValue")
			 * .withExpressionAttributeNames(expressionAttributesNames)
			 * .withExpressionAttributeValues(expressionAttributeValues);
			 * 
			 * QueryResult queryResult = client.query(queryRequest);
			 * 
			 * List<Map<String,AttributeValue>> attributeValues = queryResult.getItems();
			 * 
			 * if(attributeValues.size()>0) { return attributeValues.get(0); } else { return
			 * null; }
			 */
	        
	    case "POST":
	    	// Insert participant in table
	    	participant = getResponse.getParticipants();
	    	dynamoDBMap.save(participant);
	    	return participant;
	    	
	    default:
	    	break;
	    }
	    return null;
	  }
}