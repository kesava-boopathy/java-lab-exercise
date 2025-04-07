package lab_exercise_7;

import java.util.*;

class Device{
String deviceName;
String status;
Device(String deviceName){
this.deviceName=deviceName;
this.status="off";
}
void changeStatus(String newStatus) {
this.status=newStatus;
}
void displayDevice() {
System.out.printf("Device Name:%s\nStatus:%s", deviceName,status);
}
}


class Room{
String roomNo;
List <Device> devices;
Room(String roomNo){
this.roomNo=roomNo;
this.devices=new ArrayList<>();
}
void addDevice(Device device){
devices.add(device);
}
void displayRoom() {
System.out.printf("\t\nRoom number:%s\n", roomNo);
for(Device device:devices) {
device.displayDevice();
}
}
}

class Home{
private String homeName;
List<Room>rooms;
Home(String homeName){
this.homeName=homeName;
this.rooms=new ArrayList<>();
}
void addRoom(Room room) {
rooms.add(room);
}

void displayHome() {
System.out.printf("\n\tHome Name:%s", homeName);
for(Room room:rooms) {
room.displayRoom();
}
}
}

public class Smart_Home {
public static void main(String args[]) {
Home home=new Home("My");
Device d1=new Device("Light");
Room r1=new Room("R1");
r1.addDevice(d1);
home.addRoom(r1);
home.displayHome();
d1.changeStatus("on");
home.displayHome();
}
}