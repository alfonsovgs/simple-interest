# simple-interest-microservice
Create a microservice with spring-boot that calculate and generates the list of payments of the simple interest of a credit that must be paid in n terms and in weekly form:

    Input: {  
	    "amount": Double,  
	    "terms":Integer,  
	    "rate":Double  
    }  
      
    Output: {  
	    [   
		    {
			    "payment_number":Integer,  
			    "amount": Double,
			    "payment_date":Date  
		    }  
		    …  
	    ]  
    }  


## Validations
- The max terms (weeks) where the payment can be paid is 52, the minimum should be 4.
- The rate should bigger than 1%, lesser than 100%.
- The amount should be more than $1.00, the max should be lesser than $999,999.00
- The response should be expressed as an array of objects.

## Must Be:

- Containerized with docker.
- storing the data [request and response] in a h2 database.

## It's a Plus:

- having /health endpoint.
- at least 50% coverage

To complete the exam, you must send a GitHub repository link with the code


# PROPOSAL
The application will be structured:
    
    - Presentation: Provides an interface to communicate with Application layer.
    - Application: Mediates between the presentation and domain layer.
    - Domain: Defines business entities and rules.
    - Infrastructure: Provides capabilities to define external services.

