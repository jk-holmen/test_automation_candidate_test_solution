# test-automation-candidate-test-solution

This is a solution for the candidate test for the role as Test Automation Engineer.

## Prerequisites
 
- Java 17
- Maven 3.9+

## Build and Run
 
 After cloning the project, in a terminal navigate into the project directory containing `pom.xml`. To run the tests and generate an xml report, run:

```
mvn clean test
```
Test results are printed to the console. XML reports are generated under `target/surefire-reports/`.
 
To generate an HTML test report, run:
 
```
mvn surefire-report:report
```
 
The report is created at `target/site/surefire-report.html`.

## Javadoc documentation

This project uses Javadoc comments. To generate the HTML documentation, run:

```
mvn javadoc:test-javadoc
```

The documentation is created at `target/reports/testapidocs/index.html`.

## Test cases

### Positive test

```Gherkin
Scenario: A request for a personal number is made with a single existing value
    Given a personal number exists in the dataset
    When a request for the personal number is made
    Then the API replies with status code `200 OK`
    And there is a matching record for the personal number
    And the result count is 1
```
To test this, the first personal number in the dataset is used.

The tested API endpoint is:
```
https://skatteverket.entryscape.net/rowstore/dataset/b4de7df7-63c0-4e7e-bb59-1f156a591763/json?testpersonnummer=189001019802
```

### Negative test

```Gherkin
Scenario: A request for a personal number is made with an empty value
    When a request for a personal number is made
    And the testpersonnummer parameter is empty
    Then the API replies with status code `400 Bad Request`
```

Note: `400 Bad Request` is expected instead of e.g. returning all records, or an empty record (implying that an empty string is a valid personal number which does not exist in the dataset).

The tested API endpoint is:
```
https://skatteverket.entryscape.net/rowstore/dataset/b4de7df7-63c0-4e7e-bb59-1f156a591763/json?testpersonnummer=
```

## Assumptions

- Each personal number in the dataset is unique.
- Personal numbers in the dataset are never removed.