package lab_exercise_7;
import java.util.*;

//traffic signal aggregated to junction
class trafficsignal {
private String signalid;
private String status;
public trafficsignal(String signalid, String status) {
this.signalid = signalid;
this.status = status;
}
public String getstatus() {
return status;
}
public void setstatus(String status) {
this.status = status;
}
public String toString() {
return "signal " + signalid + " is " + status;
}
}
//junction aggregated to city
class junction {
private String name;
private List<trafficsignal> signals;
public junction(String name) {
this.name = name;
this.signals = new ArrayList<>();
}
public void addsignal(trafficsignal signal) {
signals.add(signal);
}
public void displaysignal() {
System.out.println("junction: " + name);
for (trafficsignal signal : signals) {
System.out.println(" " + signal);

}
}
}
//city 
class city {
private String cityname;
private List<junction> junctions;
public city(String cityname) {
this.cityname = cityname;
this.junctions = new ArrayList<>();
}
public void addjunction(junction jun) {
junctions.add(jun);
}
public void displaytrafficstatus() {
System.out.println("traffic report for: " + cityname);
for (junction jun : junctions) {
jun.displaysignal();
}
}
}
//main class
public class Traffic_Management1  {
public static void main(String[] args) {
	
Scanner sc = new Scanner(System.in);
System.out.print("Enter city name: ");
city cit = new city(sc.nextLine());
System.out.print("Enter number of junctions: ");
int numjunctions = sc.nextInt();
sc.nextLine();
int numsignal;
for (int i = 0; i < numjunctions; i++) {
System.out.print("Enter junction name: ");
junction junc = new junction(sc.nextLine());
System.out.print("Enter number of traffic signals: ");
numsignal = sc.nextInt();
sc.nextLine();
for (int j = 0; j < numsignal; j++) {

System.out.print("Enter signal ID: ");
String signalid = sc.nextLine();
System.out.print("Enter signal status (Red/Green/Yellow): ");
String status = sc.nextLine();
junc.addsignal(new trafficsignal(signalid, status));
}
cit.addjunction(junc);
}
cit.displaytrafficstatus();
sc.close();
}
}