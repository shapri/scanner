# scanner

RUN:  mvn clean package

java -jar target/scanner-1.0-SNAPSHOT.jar ./src/test/resources/multipleChunksWithIllegalRow.txt

or directly using the Main class:

java scanner.Main C:\temp\scanner\src\test\resources\multipleChunksWithIllegalRow.txt