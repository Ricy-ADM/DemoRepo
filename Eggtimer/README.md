# Countdown Timer Automation using BDD framework.(Cucumber)



Created a basic framework from scratch to automate Cowntdown scenerio flows 

There is a single feature file with one scenario. The scenario has 4 steps, out of which one step is failing because of timer issue.


Prerequisites:-

1. Java
2. maven
3. IDE (eclipse or intellij)


Setting up the projects and dependencies :-

1. Go to the project folder and execute the below commands on terminal :-
	> mvn clean
	> mvn install
2. Or from eclipse right click on pom.xml file and clean and install maven dependencies.
3. Framework is fully configured and, objectrepository and keyword files are separate from main class files
4. Also framework consists of reusable components

Running the project :-
 
Run Mainrunner java class from src>test>java>Eggtimer.Eggtimer.MainRunner.java
Or mvn test from the terminal(not working for now)

 Platform Limitations :-
 
 1. Project configured and test on macOS High Sierra for chrome 74 and firefox
 2. Project can run on windows as well, just need to change the path of driver dependencies for ChromeDriver.exe and Geckodriver.exe in SeleniumTest.java file.(I have not tested due to not availability of windows machine)
 
 Highlights/improvements :-
 
 1. You will get illegal state exception on chromedriver on mac if the mode is not executable. Hence change the mode of the file by Chmod +x chromedriver.
 2. setup mvn test goal to execute from maven
 3. Time handling should be accurate as it fails randomly sometimes because of sync issues.
 4. Can Validate titles and url as well because countdown is reflecting on those as well.
 5. Script is able to handle unit time in seconds, if it will be in minutes then script will fail.
 
 Bug :-
 
 1. e.ggtimer website stays on count 1 for more then 1 second before the timer expires. (Automation Report showing the same)
 
 
 BDD HTML Reports :-
 	Generate Report :- execute 'mvn verify' command at home folder
        Location :- target>cucumber-html-reports
  
 
 
 
 
 
 
	


