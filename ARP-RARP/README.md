# ARP - RARP

ARP - Address Resolution Protocol is used to fetch the Mac address for the given IP address.<br/>
RARP - Reverse Address Resolution Protocol is the reverse of ARP. It is used to fetch the IP address for the corresponding Mac address.
<br/><br/>

In this algorithm, a table of IP and corresponding Mac address is maintained. In client side the user can provide the IP or Mac address, which is send to server and 
the corresponding Mac or IP address respectively is found and return to the client.

## Steps to run the program

- Clone or download the file from repository.
- First run the Server File.
```
javac Server.java
java Server
```
- And next, run the Client File.
```
javac Client.java
java Client
```
