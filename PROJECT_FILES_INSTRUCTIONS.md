## Read-only Files
The following files are marked read-only. You cannot edit these files
in the editor; however, it is possible from the terminal. You must not
modify or delete these files because doing so results in a zero score.

* BankingSystem/src/test/java/banking/HiddenTest.java
* BankingSystem/src/test/java/banking/SampleTest.java
* BankingSystem/src/test/java/banking/UnitTestSuite.java

## Build Instructions
* From inside banking folder
* To build: `mvn clean`
* To build and run tests: `mvn clean install`
* To run specific SampleTest: `mvn clean test -Dtest=SampleTest`

