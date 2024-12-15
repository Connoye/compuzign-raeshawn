# Instructions
<br>
Please write a command line interface in whichever programming or scripting language you'd like to manage an Artifactory SaaS instance via its API. You can register one for free here: Sign Up. The CLI should be easily usable, extensible, and documented.

# Features
Please implement at least five of the following APIs, with at least one example of each HTTP verb:
- System Ping
- System Version
- Create User
- Delete User
- Get Storage Info
- Create Repository
- Update repository
- List repositories

# Authentication
- Run the APIs against Artifactory with a token, but base the CLI login on user/password.
- Provide us with a user + password for initial usage of the CLI with your instance.

# General Guidelines
- Upload the final CLI package/zip to your Artifactory in a local repository and allow easy installation from it.
- Have a help menu displaying all the functions and usage.
- This is an ״open-book ״ test, so feel free to use search engines but don't copy your work from pre-existing public solutions.
- Omission of some features or details is acceptable - our shared goal is for you to showcase your skills to the best of your ability and submit a solution you’re proud of.
- Please write documentation of the sources used and the decisions made during the assignment.
- All code should be hosted in a public git repository.
- The assignment duration is up to a week since I sent it to you. Extensions can be provided in special cases.

# Documentation

## _Pre-requisite_
- [Java version 17](https://www.oracle.com/java/technologies/javase/jdk17-archive-downloads.html)

## _Credentials_
- Username: [In documentation]
- Password: [In documentation]

## _How to run CLI?_
After downloading the compuzign-raeshawn-1.0-SNAPSHOT.jar file (Located using the Final Package File link above), open your terminal and navigate to where the jar file was saved. Ensure that Java version 17 is installed on your desktop/laptop. Run the following command to start the CLI project:
<br/>
#### _java -jar compuzign-raeshawn-1.0-SNAPSHOT.jar_

# Approach
This CLI exhibits flexibility, modularity, and user-friendliness by showing how to administer an Artifactory SaaS instance programmatically. Maven was used with the Java framework to create this project. The Apache HttpClient 5 library was used from the maven repository to make the service calls to the JFrog Platform REST APIs to execute the different commands as needed.

## _Why Maven?_
Maven is a popular choice for Java developers, particularly for developing projects that depend on HTTP communication, because it provides several advantages when creating HTTP request applications. The following are some main reasons:
- ### Dependency Management
  - Maven makes managing dependencies, including HTTP client libraries, easier. Maven lets you define dependencies in the pom.xml file rather than downloading and handling JAR files by hand.
  - Project Standardization
  - Your project adheres to a standard directory organization and builds structure when you use Maven. This facilitates new developers' comprehension of the project and their ability to work together efficiently.
- ### Scalability and Maintainability
  - Maven makes it simple to handle dependencies, modularize projects, and guarantee a consistent build process for more complex projects. A large HTTP project can be effectively managed by dividing it into smaller modules, sometimes known as multi-module projects.
- ### Community and Documentation
  - When working on your HTTP request projects, you'll find a wealth of resources, tutorials, and assistance because Maven is popular and has a vibrant community.
# Sources
1.	[JFrog Platform REST APIs](https://jfrog.com/help/r/jfrog-rest-apis/jfrog-platform-rest-apis)
2.	[Password Validation](https://www.geeksforgeeks.org/how-to-validate-a-password-using-regular-expressions-in-java/)
3.	[Email Validation](https://www.geeksforgeeks.org/check-email-address-valid-not-java/)
4.	[How to set up and use a JFrog Artifactory as a local Maven repository](https://www.theserverside.com/video/How-to-set-up-and-use-a-JFrog-Artifactory-Maven-repository)
5.	[Understanding the Basics of JFrog Artifactory](https://medium.com/@riimoonriimoon/understanding-the-basics-of-jfrog-artifactory-8167ce582c86)
