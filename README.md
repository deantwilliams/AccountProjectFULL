# Project Setup
Download project and run the following at project root level
```
mvn clean install
```
```
java -jar backend/target/backend-0.0.1-SNAPSHOT.jar
```

Transfer into the frontend folder and run
```
npm run dev
```

## Viewed on
http://localhost:8080 or http://localhost:8081 for website (changes randomly)
http://localhost:8088 for api


## NOTE
If using Google Chrome, it is required that you disable web security by going to the location of Chrome and running the following in command prompt:
```
chrome.exe --user-data-dir="C:/Chrome dev session" --disable-web-security
```
