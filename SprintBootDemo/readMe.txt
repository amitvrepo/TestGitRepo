Microservice1:(name SprintBootDemo)

1. We've developed a small software component (microservice) that can interact with our database and  can create, read, update, and delete records in our database.(Get, Post, Put, Delete) on records.
For example, if we have a database of medical research programs and research participants, our microservice can fetch information about a specific program, add a new participant, update existing data, or remove a participant from the program.

2. Upon receiving the delete request, microservice1 seamlessly triggers a notification mechanism using AMQ (ActiveMQ) within our Spring Boot framework and relayed to the designated microservice(amq-microservice)


Microservice2 (amq-microservice)

1. Developed Microservice2, which is dedicated to handling ActiveMQ (AMQ) operations. This microservice acts both as a message producer and receiver within our system.
When a delete request is made in Microservice1 , a message is automatically dispatched to Microservice2 via ActiveMQ ,Upon receiving this message, Microservice2 places it in a queue for further processing. Subsequently, the AMQ receiver within Microservice2 echoes the received message

Also integrated Log4j2, into our application to manage and track  the logging activities and use declarative transaction management of Spring. Done


Here are the steps I have tested the app :

Request Sent from Postman:

Create and send a request from Postman to the appropriate endpoint of the  microservice1 (/microservice1/api/v1/programs) to create the programs.

Request Received by Controller (MedicalResearchProgramController.java) ,The controller class receives the incoming request.It identifies the corresponding method to handle the request based on the endpoint and HTTP method. The controller delegates the processing of the request to the service class (MedicalResearchProgramService) ,It calls the appropriate method in the service class to handle the requested operation.

Angular :  
I wanted to provide you with an update on the development of our front-end application using Angular. I am starting to learn how to use Angular for our front-end app. It's something I haven't done much before, so I am spending some time getting used to it.

Furthermore, I would appreciate it if we could coordinate a suitable time for the demo. Please tell me when you are available, and I will do my best to work with your schedule.Thanks for your cooperation
