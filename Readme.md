# Parrot Says

Parrot Says meant to be a safety solution whether for corporations, colleges or universities. By using Parrot Says App or just tweeting, users can report any issue to responsible staff in seconds. 

The mobile app allows users to send anonymously all reports/comments with the geolocation and an optional picture in it. Logins are not required.

The Admin Portal allows the staff to manage the reports, if needed they may send it to be investigated by a security guard. If there is a critical situation, they can send a push notification to everyone with the app installed.

The security guards can log in to the App and retrieve the list of reports to be investigated, along with corresponding details about each report. They also can send back to the staff their investigation result.

Additionally, when people refer to the organization on Twitter, it is caught, analyzed by AWS Comprehend Service and can become a report, depending upon the extracted sentiment, and hazardous condition spotting. 
 
 
## Infrastructure
### 1. Parrot Says API (Spring Boot + MySQL)
### 2. Parrot Says Web Admin Portal (React Hooks)
### 3. Parrot Says Mobile App (Android Native: Java)
### 4. AWS Comprehend Services
### 5. AWS SNS + Google Firebase Cloud Message

## License
[MIT](https://choosealicense.com/licenses/mit/)

