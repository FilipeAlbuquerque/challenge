How to build and Run

The project was developed and built with:

Java 1.8.0_181
Maven 3.6.1

To test, compile and create the package, execute the following command from the root folder of the app:

mvn clean package

To run the app:

java -jar {jarFile} {patients} {medicines}

Examples:

java -jar target/HospitalSimulator-1.0.jar D,D,T,H,H,H P,I

java -jar target/HospitalSimulator-1.0.jar D,D,T,H,H,H

java -jar target/HospitalSimulator-1.0.jar T,T,T,H,F An,P

java -jar target/HospitalSimulator-1.0.jar T,T,T,H,F P,As

The main method is in the Aplication class
