# The Immigrant Dream Backend

There are 3 APIs in this project \
Data is stored in h2 in-memory db

## /contact-data
* This API handles data for users who send inquiries to us

## /stories
* This API handles immigrants stories

## /businesses
* This API handles immigrants business

## Envrironment variables
Set environment variables for the placeholders in application.properties file \
if you want to see the content in the in-memory h2 db \
Example:
* username=sa
* password=yellow
* receiverOne=email@mail.com
* etc

Once the project is cloned and ran, you can see the documentation at
* [Swagger-ui](http://localhost:8000/swagger-ui/index.html)
* [Swagger-docs](http://localhost:8000/v2/api-docs)