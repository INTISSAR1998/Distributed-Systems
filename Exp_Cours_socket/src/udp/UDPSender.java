package udp;

import java.net.*; import java.io.*;

public class UDPSender {
public static void main(String[] args) {
try {
InetAddress receiver = InetAddress.getByName(args[0]);
int port = Integer.parseInt(args[1]);
DatagramSocket theSocket = new DatagramSocket();
DataInputStream userInput = new DataInputStream(System.in);
while (true) {
String theLine = userInput.readLine();
if (theLine.equals(".")) break;
byte[] data = new byte[theLine.length()];
//theLine.getBytes(0, theLine.length(), data, 0);
data=theLine.getBytes();
DatagramPacket theOutput =
new DatagramPacket(data, data.length, receiver, port);
theSocket.send(theOutput);
}} catch (Exception e) { System.err.println(e);}
} }

