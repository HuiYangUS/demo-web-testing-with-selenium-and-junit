## Demo Automated Testing Framework
- [demo test app](https://acme-test.uipath.com/)
- This framework targets (imo) a very good practice web app for automated testing
- This project includes some of the popular scenarios such as search, form submission or table data extraction
- This project also includes some of the uncommon scenarios such as file download, workbook reading & validation

#### ``[Setup]``
- Selenium 
- JUnit

#### ``[Reports]``
- mvn clean surefire-report:report -Dtest=DemoSearchTest
- mvn clean surefire-report:report -Dtest=DemoSearchTest,MyFirstWebTest