# Cron Expression Parser

Maven based java project, parses a cron string and expands each field
to show the times at which it will run.
This consider the standard cron format with five time fields (minute, hour, day of
month, month, and day of week) plus a command. It does not handle the special
time strings such as "@yearly". Input is single line argument given as below.

```
your-program ＂*/15 0 1,15 * 1-5 /usr/bin/find＂ 
```
The output is formatted as a table with the field name taking the first 14 columns and the times as a space-separated list following it.
Produced output:  
```
minutes        0 15 30 45
hours          0
day of month   1 15
month          1 2 3 4 5 6 7 8 9 10 11 12
day of week    1 2 3 4 5
command        /usr/bin/find
```

## How to build?
1. Clone this repository
2. Install the required dependencies:
    
    ```
    # navigate to dir having pom.xml file and run
    mvn clean package
    ```

## How to Run?

```
java -jar target/cronparser-0.0.1.jar "59 23 31 12 7 /usr/bin/find"
```

### Example
```shell
ankitver-mac:cronparser ankitver$ java -jar target/cronparser-0.0.1.jar "*/10 1-5,9-12 1-15 */2 1-4 /usr/bin/find"
minute         0 10 20 30 40 50
hour           1 2 3 4 5 9 10 11 12
day of month   1 2 3 4 5 6 7 8 9 10 11 12 13 14 15
month          1 3 5 7 9 11
day of week    1 2 3 4
command        /usr/bin/find 
```

For more examples: [Example test file](src/test/java/com/assignment/cronparser/testOutput.log)

## Allowed values
| Field          | Allowed Values                                           | Allowed special characters | Mandatory? |
| -----------    | -----------                                              | -----------                | ---------- |
| Minutes        | `0-59`                                                   | `*` `,` `-` `/`            | Yes        |
| Hours          | `0-23`                                                   | `*` `,` `-` `/`            | Yes        |
| Day of month   | `1-31`                                                   | `*` `,` `-` `/`            | Yes        |
| Month          | `1-12`                 | `*` `,` `-` `/`            | Yes        |
| Day of week    | `1-7`  | `*` `,` `-` `/`            | Yes        |

The order of the fields must be preserved and all fields are manadatory.