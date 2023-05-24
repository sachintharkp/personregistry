# Person Registry

Interview Case: People Registry
One of our clients has requested a proof of concept (POC) for a REST
service to replace their legacy backend for their people registry
system. The POC should allow users to save and retrieve information
about a person using their social security number as the identifier.
For each person, the service should store their name, the name of
their spouse (if applicable), and the name and age of their children.
The client also requested an endpoint that returns the name of the
oldest child for a given person, along with the person's social
security number. The number of stored persons is low, and it is
acceptable to lose data on restarts.
Your task is to create the domain model and functionality to save and
retrieve persons. You should assume that another team member will
build the REST application framework and handle JSON serialization.
The other team member is a junior and may require your advice on
naming and design of endpoints.
Please note that you should not submit a complete Spring application
or rely on any external dependencies except for the Java SDK and
possibly a test framework. You should only submit the necessary code
to implement the domain model and the functionality to save and
retrieve persons. You should aim for production-ready code where it
makes sense but stick to a minimal viable solution.
Please document any assumptions you make, and do not spend more than
an hour on this task, as the client will not pay for your time.
Once you have completed the code, please submit it before the
interview. You can attach the files in a mail or send a link to a
public git repository.


### Decisions/Assumptions
*Assumption - No Twin children. To reduce complexity of calculations for oldest child.
*Decision - Taken Social security number as String .

## Installation

### Build the Project

run 
```
### Run the Application

You can run the project using PersonRegistry.class. This class only created to check the results.

### Test the Application
You can see all the test cases covered by this application in PersonRegistryServiceTest.class

## Create a Person
#### Reguired fields and Validations
***Social number and name are required fields to create a person .If these fields not provided SocialNumberMandatoryException will throw.
***If user try to create person with exisiting social number, SocialNumberAlreadyExistException will throw. 


## Get a Person
#### Reguired fields and Validations
**Valid Social number should provide to get a person , if not PersonNotFoundException exception will throw.
**If user tries to retrieve a person without socail number , SocialNumberMandatoryException exception will throw.

## Get a Person oldest child
#### Reguired fields and Validations
**Valid Social number should provide to get a person , if not PersonNotFoundException exception will throw.
**If user tries to retrieve a person without socail number , SocialNumberMandatoryException exception will throw.
**If a user tries to get old child when there is no child exist for the given person NoChildRecordExistException exception will throw.