# CUCUMBER POM SERIES

## Intro

Cucumber BDD project

## Features overview

## Features overview
*   [x] **AccountPage** User logged we need to verify some web elements on account page
    Steps: Connects to  automationpractice.com.
    Sign In with given credentials
    Checks Accounts page title
    Checks accounts sections count and number.

*   [x] **ContactUs** Filling contact us form from static excelsheet
    Steps : Checks if user is on the right page.
    Loops the given sheet to fill the Contact us form and submit.
    checks if the success message appears

*   [x] **LoginPage** Login to application
    Steps: Checks the Login page Title
    Checks if the forget password link should be displayed
    fills form with given credentials and makes sure that the user gets redirected to My account page


## Project Structure
```
.
├── .gitignore
├── pom.xml                 #Dependencies and modules
├── README.md
├── serenity.properties     # Serenity plugin properties file
└───src                     # Project artifacts
    ├───main                # Source code and resources
    │   ├───java            # Java source code for the artifact
    └───test                # Tests of each component
        ├───java            # Java source code for tests
        └───resoaurces      # Configuration files
```
        
## License
(http://automationpractice.com/)

 
