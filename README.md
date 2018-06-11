# Boggle Solver Rest API

http://localhost:8090/boggle

This is a Spring Boot application that is easily run within the Eclipse IDE. This application will take a 4x4 Boogle Board and provide all the words and scores based on Boggle rules (https://en.wikipedia.org/wiki/Boggle).

# To run this application
Download this project into your Eclipse IDE
Start this application as a Spring Boot project

Execute the following curl to ensure the project is functioning correctly

curl -X POST \
  http://localhost:8090/boggle \
  -H 'content-type: application/json' \
  -d '{
	"boardSize": "4x4",
	"boardString": "abcdrvsstuqattda"
}'

## Caveats
* This code has some places to focus on larger and smaller boards, but minor updates will need to be made to fully support these boards
* This project has been designed to support happy path processing. Additional minor updates can be made to enforce improved exception handling
* This application runs on port 8090, as the web application to support this project will run on port 8080

#Resources
Alphabet Words dictionary obtained from https://github.com/dwyl/english-words/blob/master/words_alpha.txt

Spring Boot Open Source project used during development of application

Eclipse Oxygen IDE used during development of application

Postman was used to test Rest APIs during development of application