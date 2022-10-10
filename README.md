# CUCUMBER POM SERIES

## Intro
[Prerequisite]
Java & Maven should be installed & configured on environment variables

[Steps]
1. Download this project from GitHub
2. Open the project with your favorite IDE
3. and from your terminal user 'mvn test' to run the project
        -Since we have used SureFire Plugin runner files with names like (**Test.java,**/*TestCase.java,**/*Test.java) gets executed.
4. Once run finishes you will see appearing 3 new folders under root directory containig test reports (Pdf & html files) and you can also access Cucumber reports from the url you will get on the Run console

```
   .
   ├── test output(PDF)             #This folder contains PDF reports
   ├── test output(SPARK)           #This Folder contains HTML report that you can check with any browser
   └── test output-thread           #This folder contains reports informations to visulize on browser
```

[Dependencies]
```
Java = Java SE 8
Selenium = 4.0.0-beta-4
junit = "4.13.2"
lombok = "1.8.24"
serenity = "3.3.4"
cucumber-java = "7.8.0"
```

## Features overview
*   [x] **Account** User logged we need to verify some web elements on account page
    Steps: Connects to automationpractice.com.
    Sign In with given credentials
    Checks Accounts page title
    Checks accounts sections count and number.

*   [x] **Contact Us** Filling contact us form from static excelsheet
    Steps : Checks if user is on the right page.
    Loops the given sheet to fill the Contact us form and submit.
    checks if the success message appears

*   [x] **Log In** Login to application
    Steps: Checks the Login page Title
    Checks if the forget password link should be displayed
    fills form with given credentials and makes sure that the user gets redirected to My account page

*   [ ] **Buy Order** Fill cart and buy operation
    Steps: 
    - Sign In operation
    - Access the Women's T-shirt section
    - get to a product add it to cart
    - Make order steps


## Project Structure
Here is the project structure:
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

 
