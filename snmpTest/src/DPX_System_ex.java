import java.util.ArrayList;
import java.util.Hashtable;

public class DPX_System_ex extends GenericTest{

	// main method
	public static void main(String[] args) {
		
		DPX_System_ex dpx_System_Monitor_ex = new DPX_System_ex(args);
		dpx_System_Monitor_ex.computeMeasures(new Hashtable());
	}
	
	public DPX_System_ex(String[] arg0) {
		super(arg0);
		setMeasureCount(12);
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
		String CPU_Usage = (String)getValueForParam(".1.3.6.1.4.1.11563.1.2.2.1.0");
		String Memory_Usage = (String)getValueForParam(".1.3.6.1.4.1.11563.1.2.2.2.0");
		String Disk_Usage = (String)getValueForParam(".1.3.6.1.4.1.11563.1.2.2.3.0");
		String Concurrent_Session = (String)getValueForParam(".1.3.6.1.4.1.11563.1.2.2.4.0");
		String RX_total_Packets = (String)getValueForParam(".1.3.6.1.4.1.11563.1.2.2.5.0");
		String TX_total_Packets = (String)getValueForParam(".1.3.6.1.4.1.11563.1.2.2.6.0");
		String HA_status = (String)getValueForParam(".1.3.6.1.4.1.11563.1.2.2.7.0");
		String ByPass_status = (String)getValueForParam(".1.3.6.1.4.1.11563.1.2.2.8.0");
		String Rx_Total_PPS = (String)getValueForParam(".1.3.6.1.4.1.11563.1.2.2.9.0");
		String Tx_Total_PPS = (String)getValueForParam(".1.3.6.1.4.1.11563.1.2.2.10.0");
		String Rx_Total_BPS = (String)getValueForParam(".1.3.6.1.4.1.11563.1.2.2.11.0");
		String Tx_Total_BPS = (String)getValueForParam(".1.3.6.1.4.1.11563.1.2.2.12.0");


		
		double a = Double.parseDouble(CPU_Usage);
		double b = Double.parseDouble(Memory_Usage);
		double c = Double.parseDouble(Disk_Usage);
		double d = Double.parseDouble(Concurrent_Session);		
		
		RX_total_Packets = replaceString(RX_total_Packets);		
		double e = Double.parseDouble(RX_total_Packets);
		
		TX_total_Packets = replaceString(TX_total_Packets);
		double f = Double.parseDouble(TX_total_Packets);
		
		double g = 0;
		HA_status = HA_status.toLowerCase().trim();
		if("off".equals(HA_status)) {
			g = 0;
		}else if("master".equals(HA_status)) {
			g = 1;
		}else if("slave".equals(HA_status)) {
			g = 2;
		}else if("single".equals(HA_status)) {
			g = 3;
		}else if("down".equals(HA_status)) {
			g = 4;
		}else if("-master".equals(HA_status)) {
			g = 5;
		}else if("-slave".equals(HA_status)) {
			g = 6;
		}else if("-single".equals(HA_status)) {
			g = 7;
		}else {
			g = 8;
		}
		
		double h = 0;
		ByPass_status = ByPass_status.toLowerCase().trim();
		if("off".equals(ByPass_status)) {
			h = 0;
		}else if("off".equals(ByPass_status)) {
			h = 1;
		}else {
			h = 2;
		}
		
		double i = Double.parseDouble(Rx_Total_PPS);
		double j = Double.parseDouble(Tx_Total_PPS);
		double k = Double.parseDouble(Rx_Total_BPS);
		double l = Double.parseDouble(Tx_Total_BPS);

		
		ArrayList arr = new ArrayList();
		arr.add( new Double(a) );
		arr.add( new Double(b) );
		arr.add( new Double(c) );
		arr.add( new Double(d) );
		arr.add( new Double(e) );
		arr.add( new Double(f) );
		arr.add( new Double(g) );
		arr.add( new Double(h) );
		arr.add( new Double(i) );
		arr.add( new Double(j) );
		arr.add( new Double(k) );
		arr.add( new Double(l) );
		
		addNewMeasure(arr);
		
	}// end of computeMeasures()

	public String replaceString(String txt) {
		String result = txt.replaceAll("[^0-9]",""); 
		return result;
	}
}
