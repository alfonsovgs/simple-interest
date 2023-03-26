# simple-interest-microservice

Create a microservice with spring-boot that calculate and generates the list of payments of the simple interest of a
credit that must be paid in n terms and in weekly form:

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

## SimpleInterestCalculator

This class calculates interest based on the following

    interestByWeek = amount * rate / terms
    amortizationByWeek = amount / rate
    paymentByWeek = amortization + interest

    // for the next payment
    amount = amount + interestByWeek - paymentByWeek;

You can follow
this [excel](https://docs.google.com/spreadsheets/d/1CPdFy0TwUI0vQgZzc1Md0UsZrZv0hARCl-Lit0iQlkU/edit?usp=sharing) to
evaluate amounts.

## Run via Docker

Follow the next steps

- `.\mvnw clean`
- `.\mvnw install`
- `docker build -t interest-microservice -f Dockerfile .`
- `docker run -p 8080:8080 interest-microservice`
    - `test the endpoint: http://localhost:8080/api/interests/calculate`

### cURL

      curl --location 'http://localhost:8080/api/interests/calculate' \
      --header 'Content-Type: application/json' \
      --data '{
          "amount": 1000,
          "terms": 4,
          "rate": 10
        }'

## Code Coverage

To show the code coverage follow the next steps

- `.\mvnw clean`
- `.\mvnw test`

After running the test, Maven generates a report inside `.\target\site\jacoco\index.html`

### Coverage indicators

- 🟥 Red : Not Covered
- 🟨 Yellow : Partially Covered
- 🟩 Green : Completely Covered

## Health Endpoint

The project has the `spring-boot-starter-actuator` dependency and a `/health` endpoint has been published you can see it
at the following cURL.

`curl --location 'http://localhost:8080/health'`

## Deploy 
You can use this endpoint `https://simple-interest.fly.dev/api/interests/calculate` to test the api.
