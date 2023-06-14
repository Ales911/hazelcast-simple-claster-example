mvn clean install 

start java -jar target\hazelcast-client-0.0.1-SNAPSHOT.jar


curl localhost:8081/book
curl localhost:8081/book/xxx

curl --location --request POST "localhost:8081/book" --header "Content-Type: application/json" --data-raw "{\"isbn\": \"isbn1\", \"author\": \"author1\", \"title\": \"title1\"}"
curl --location --request POST "localhost:8081/book" --header "Content-Type: application/json" --data-raw "{\"isbn\": \"isbn2\", \"author\": \"author2\", \"title\": \"title2\"}"
curl --location --request POST "localhost:8081/book" --header "Content-Type: application/json" --data-raw "{\"isbn\": \"isbn3\", \"author\": \"author3\", \"title\": \"title3\"}"
curl --location --request POST "localhost:8081/book" --header "Content-Type: application/json" --data-raw "{\"isbn\": \"isbn4\", \"author\": \"author4\", \"title\": \"title4\"}"

curl --location --request PUT "localhost:8081/book/xxx" --header "Content-Type: application/json" --data-raw "{\"isbn\": \"isbn3\", \"author\": \"author33\", \"title\": \"title33\"}"

curl --location --request DELETE "localhost:8081/book/xxx"