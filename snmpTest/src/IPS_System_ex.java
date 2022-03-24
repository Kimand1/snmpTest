import java.util.ArrayList;
import java.util.Hashtable;

public class IPS_System_ex extends GenericTest{

	public static void main(String[] args) {		
		IPS_System_ex ips_System_Monitor_ex = new IPS_System_ex(args);
		ips_System_Monitor_ex.computeMeasures(new Hashtable());
	}

	public IPS_System_ex(String[] arg0) {
		super(arg0);
		setMeasureCount(7);
		// TODO Auto-generated constructor stub
	}

public void computeMeasures(Hashtable params) {
		
		/*
		 * Call the following method to walk the specified MIB OIDs. 
		 * The output of the snmpwalk command is assigned to the String arrays lhs and rhs
		 * lhs -> stores left hand side of the output 
		 * rhs -> stores right hand side of the output
		 */
		
		//".1.3.6.1.4.1.11563.1.2.2.1.0"
		String CPU_Usage = (String)getValueForParam(".1.3.6.1.4.1.11563.1.2.2.101.0");
		String Memory_Usage = (String)getValueForParam(".1.3.6.1.4.1.11563.1.2.2.102.0");
		String Disk_Usage = (String)getValueForParam(".1.3.6.1.4.1.11563.1.2.2.103.0");
		String Concurrent_Session = (String)getValueForParam(".1.3.6.1.4.1.11563.1.2.2.104.0");
		String HA_status = (String)getValueForParam(".1.3.6.1.4.1.11563.1.2.2.107.0");
		String Traffic_In = (String)getValueForParam(".1.3.6.1.4.1.11563.1.2.2.105.0");
		String Traffic_Out = (String)getValueForParam(".1.3.6.1.4.1.11563.1.2.2.106.0");

		double a = Double.parseDouble(replaceString(CPU_Usage));
		double b = Double.parseDouble(replaceString(Memory_Usage));
		double c = Double.parseDouble(replaceString(Disk_Usage));
		double d = Double.parseDouble(replaceString(Concurrent_Session));		
		
		double e = 0;
		HA_status = HA_status.toLowerCase().trim();
		if("off".equals(HA_status)) {
			e = 0;
		}else if("master".equals(HA_status)) {
			e = 1;
		}else if("slave".equals(HA_status)) {
			e = 2;
		}else if("single".equals(HA_status)) {
			e = 3;
		}else if("down".equals(HA_status)) {
			e = 4;
		}else if("-master".equals(HA_status)) {
			e = 5;
		}else if("-slave".equals(HA_status)) {
			e = 6;
		}else if("-single".equals(HA_status)) {
			e = 7;
		}else {
			e = 8;
		}
		
		double f = Double.parseDouble(replaceString(Traffic_In));
		
		double g = Double.parseDouble(replaceString(Traffic_Out));
		
		
		ArrayList arr = new ArrayList();
		arr.add( new Double(a) );
		arr.add( new Double(b) );
		arr.add( new Double(c) );
		arr.add( new Double(d) );
		arr.add( new Double(e) );
		arr.add( new Double(f) );
		arr.add( new Double(g) );
		
		addNewMeasure(arr);
		
	}// end of computeMeasures()

	public String replaceString(String txt) {
		String result = txt.replaceAll("[^0-9]",""); 
		return result;
	}
	
}
