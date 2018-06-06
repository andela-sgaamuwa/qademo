# Ebyokola Bucketlist API Test Plan

## Introduction 
The Ebyokola bucketlist API serves as the backend to the Ebyokola Application that can be accessed at https://ebyokola-ft.herokuapp.com. The API only has a handful of functionality, though we shall only be automating three features as shall be listed in the scope below. Manual testing has been carried out or shall be carried out on the rest of the features. 

## Scope

*	### In Scope
    * The login feature for the API to receive a token to access the system
    *	The create bucketlist feature to add a bucketlist for a user in the system
    *	The create a bucketlist item feature to add several items to the bucketlist
    *	The register feature, though this shall only be tested manually and will not be automated
*	### Out of Scope
    *	Edit feature for both the bucketlists and the bucketlist items
    *	The delete feature for both the bucketlists and their items
    *	Returning all the current user’s bucketlists

## Quality Objective
There are a number of reasons for carrying out the testing for the API, some of which include:
*	Ensure the responses from the different API routes match what is expected in the project specifications
*	Provide an automation test suite that can be run each time changes are made to ensure that the quality of the responses is up to par 
*	Have the automated test run regularly to identify any bugs that might creep up during development work 

## Roles and Responsibilities
The testing team currently has only one member, Samuel Gaamuwa who shall be taking on the different roles, i.e. QA Analyst, Test Manager, Configuration Manager, as well as QA Engineer. As such he shall be responsible for all the quality assurance tasks.

## Test Methodology
* ### Overview
    The API is developed using the Agile methodology that calls for continuous incremental development, retrospection and planning. As such, the QA team shall follow the same methodology to account for the continuously changing project requirements. 
* ### Test Levels
    All the features in the Application shall undergo *manual/exploratory testing*, This is meant to ensure that any potential bugs can be discovered and brought to the attention of the user. 
    The team shall also be automating certain features that are commonly used to reduce the amount of time needed to carry out regression testing during releases, the automated tests should ensure that the app works as per the minimum requirements. It will not be as exhaustive due to the limited time and manpower.
* ### Test Completeness
    Testing shall be deemed complete if the following criteria is met:
    * There are automated tests for the three earlier mentioned features and all automated tests pass consistently
    * There are manual tests for the rest of the features 
    * All discovered and noted bugs have been either fixed or resolved in another manner e.g. wont be fixed

## Test Deliverables
These are some the artifacts expected as a result of the testing phase/lifecycle: 
* TestPlan
* Test Automation Harness
* Test Cases 

## Resource & Environment Needs
* ### Testing tools 
    As the current tester is familiar with the Java language, we shall be using that to create the automation for the tests. Below is a list of some of the tools that shall complement this: 
    * Intellij IDEA is the IDE of choice
    * Git for version control
    * Google Sheets shall be used to keep track of the manual testing. 

* ### Test Environment
    Java as a language is platform independent so it should be possible to run the tests on various platforms. Development will be done on the unix based macOS platform so this should be the default for running the tests. 

## Terms/Acronyms
Acronym | Definition
--------- | ---------
API | Application Program Interface

