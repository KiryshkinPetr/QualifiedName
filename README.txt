QualifiedName

  What is it?
  -----------
 
  QualifiedName application for the construction of a qualified name.


  Files Includes With This Project:
  ---------------------------------
        Parser.java 			implementation of the parser to generate qualified name

	QName.java 			implementation of a qualified name

	IllegalNameException.java 	implementation of an exception that will intercept in case 
							of incorrect data when generating qualified name

	ParserTest.java 		testing parser

  
  How To Run
  ----------
  To build and run the test, it is necessary that you have installed maven 3.
  For verify maven 3 installation in your machine, run the console and run the command: mvn --version 

  The result of execution must be a notice in the console: 

  Apache Maven 3.0.5 (r01de14724cdef164cd33c7c8c2fe155faf9602da; 2013-02-19 15:51:28 + 0200) 
  Maven home: the value of M2_HOME 
  .................................................. ............................

  Start the console and navigate to the downloaded project where the file resides pow.xml.

  Run the commands:
	mvn validate    Validates whether project is correct and all necessary
			information is available to complete the build process.

	mvn compile	Compile the source code of the project.

	mvn test	run tests using a suitable unit testing framework.

  After execution of the command: mvn test should show the message (in the case of a successful passing tests):

  ...........................................................................................................

  -------------------------------------------------------
   T E S T S
  -------------------------------------------------------
  Running com.codenvy.testtask.qname.ParserTest
  Tests run: 7, Failures: 0, Errors: 0, Skipped: 0, Time elapsed: 0.424 sec
  
  Results :
  
  Tests run: 7, Failures: 0, Errors: 0, Skipped: 0
  
  [INFO] ------------------------------------------------------------------------
  [INFO] BUILD SUCCESS
  [INFO] ------------------------------------------------------------------------
  [INFO] Total time: 2.003s
  [INFO] Finished at: Fri Sep 19 11:33:11 EEST 2014
  [INFO] Final Memory: 7M/247M
  [INFO] ------------------------------------------------------------------------ 