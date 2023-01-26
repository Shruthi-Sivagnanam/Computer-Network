# Simulation of DNS - Domain Name Server

The Domain Name System (DNS) Server is a server that is specifically used for matching website hostnames to their corresponding IP addresses.
 
<br/>

Here, the server side maintains a table of hostnames and IP address. The user can make request from the client side, the request is passed to the server using UDP Socket
(in this program). The server resolves the request and send back the hostname or IP address.

## How to run the program
- Compile the programs
```
javac Server.java
javac Client.java
```
- Run the server first and then the client
```
java Server
java Client
```

