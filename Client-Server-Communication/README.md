# Client - Server - Communication

In this program client sends the data (when the server is available). The server reads the data and display the data untill the String "Completed" is given by the client.
Here UDP is used as transport layer protocol.

## Steps to run the program
- Clone or download the files from the repository.
- First run the Server.java
```
javac Server.java
java Server
```
- Second run the Client.java
```
javac Client.java
java Client
```
Enter some random String in Client side and the string will be displayed in the server side. To complete the program enter "Completed" in the client side, both the server and client terminate their job.
