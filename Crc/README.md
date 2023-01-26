# Cyclic Redundancy Check (CRC)

CRC is a method of detecting accidential errors/changes in the data or information transmitted over a network.

## Algorithm
### Sender's Side 
- The binary data is first augmented by adding k-1 zeros in the end of the data
- Use modulo-2 binary division to divide binary data by the key and store remainder of division.
- Append the remainder at the end of the data to form the encoded data and send the same

### Receiver's Side
- Perform the modulo-2 binary division with the recieved data.
- If the remainder of this operation is zero then, the data has no changes.
- Else, the data has been changes in between the transmission.
