# racing-post-test

    # Pre requisites to run the tests
        1. Make sure Maven and Java is installed globally. you can test with the below command
          ## mvn --version  
          ## java --version
        2. By default tests will run in chrome, But if you want to run tests in firefox 
           then make sure you have the latest chrome and firefox installed in your machine
           Chrome Version: 87.0.4280.67
           Firefox Version: 83.0
           
    # Running Tests and check the report 
    
        1) Once you have cloned the repository, Please be on the main folder
        2) a) Run the below command to run the tests in chrome browser
                ## mvn clean verify  
            b) If you want to run in firfox browser then use the below command
                ## mvn clean verify --Dwebdriver.driver=firefox
        3) you can check the report in below folder
           ## target/site/index.html    
           
           In Reports you can see the below scenarios.And each step is producing a screenshot and attached next to the step.   
            1) Checking next big race event date should be in the future
            2) Big race event detail page should have the default active tab as Card
            3) Big race events page should have Todays Offers list sites