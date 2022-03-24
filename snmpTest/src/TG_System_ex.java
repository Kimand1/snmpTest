import java.util.ArrayList;
import java.util.Hashtable;

public class TG_System_ex extends EgSnmpGenericTest {
	
	private String snmpOID = "";

	// main method
	public static void main(String[] args) {
		
		TG_System_ex tg_System_Monitor_ex = new TG_System_ex(args);
		tg_System_Monitor_ex.computeMeasures(new Hashtable());
	}

		
	public TG_System_ex(String[] arg0) {
		super(arg0);
		setMeasureCount(8);
		
		snmpPortNo = (String) getValueForParam("snmpPort");
		snmpVersion = (String) getValueForParam("snmpversion");
		community = (String) getValueForParam("snmpCommunity");
		snmpOID = (String) getValueForParam("snmpOID");
	}
	
	public void computeMeasures(Hashtable params) {
		
		/*
		 * Call the following method to walk the specified MIB OIDs. 
		 * The output of the snmpwalk command is assigned to the String arrays lhs and rhs
		 * lhs -> stores left hand side of the output 
		 * rhs -> stores right hand side of the output
		 */
		
		//".1.3.6.1.4.1.11563.1.2.2.1.0"
//		String CPU_Usage = (String)getValueForParam(".1.3.6.1.4.1.11563.1.2.2.1.0");
//		String Memory_Usage = (String)getValueForParam(".1.3.6.1.4.1.11563.1.2.2.2.0");
//		String Disk_Usage = (String)getValueForParam(".1.3.6.1.4.1.11563.1.2.2.3.0");
//		String Concurrent_Session = (String)getValueForParam(".1.3.6.1.4.1.11563.1.2.2.4.0");
//		String RX_total_Packets = (String)getValueForParam(".1.3.6.1.4.1.11563.1.2.2.5.0");
//		String TX_total_Packets = (String)getValueForParam(".1.3.6.1.4.1.11563.1.2.2.6.0");
//		String HA_status = (String)getValueForParam(".1.3.6.1.4.1.11563.1.2.2.7.0");
//		String ByPass_status = (String)getValueForParam(".1.3.6.1.4.1.11563.1.2.2.8.0");		
		
		
//		double a = Double.parseDouble(CPU_Usage);
//		double b = Double.parseDouble(Memory_Usage);
//		double c = Double.parseDouble(Disk_Usage);
//		double d = Double.parseDouble(Concurrent_Session);		
//		
//		RX_total_Packets = replaceString(RX_total_Packets);		
//		double e = Double.parseDouble(RX_total_Packets);
//		
//		TX_total_Packets = replaceString(TX_total_Packets);
//		double f = Double.parseDouble(TX_total_Packets);
//		
//		double g = 0;
//		HA_status = HA_status.toLowerCase().trim();
//		if("off".equals(HA_status)) {
//			g = 0;
//		}else if("master".equals(HA_status)) {
//			g = 1;
//		}else if("slave".equals(HA_status)) {
//			g = 2;
//		}else if("single".equals(HA_status)) {
//			g = 3;
//		}else if("down".equals(HA_status)) {
//			g = 4;
//		}else if("-master".equals(HA_status)) {
//			g = 5;
//		}else if("-slave".equals(HA_status)) {
//			g = 6;
//		}else if("-single".equals(HA_status)) {
//			g = 7;
//		}else {
//			g = 8;
//		}
//		
//		double h = 0;
//		ByPass_status = ByPass_status.toLowerCase().trim();
//		if("off".equals(ByPass_status)) {
//			h = 0;
//		}else if("off".equals(ByPass_status)) {
//			h = 1;
//		}else {
//			h = 2;
//		}
//		
//		
//		ArrayList arr = new ArrayList();
//		arr.add( new Double(a) );
//		arr.add( new Double(b) );
//		arr.add( new Double(c) );
//		arr.add( new Double(d) );
//		arr.add( new Double(e) );
//		arr.add( new Double(f) );
//		arr.add( new Double(g) );
//		arr.add( new Double(h) );
//		
//		addNewMeasure(arr);
		
	}// end of computeMeasures()
	
	public double egtMeasure(String OID) {
		boolean result = runSnmpCmdForOid(OID);
		double dVal = 0.0;
		String oidVal = null;
		
		if(result) {
			for(int i=0; i<lhs.length; i++)	{
				oidVal = rhs[i];
				try {
					dVal = convertOIDValue(oidVal);
				} catch (Exception e) {
					// TODO: handle exception
					dVal = 999.0;
				}
			}
		}
		
		return dVal;
	}
	
	
	//################################################################################
	//
	// 차장님 죄송합니다. 제가 일정이 있어서 여기까지밖에 못하고 갑니다. 내일 오면
	// 마져 제가 소스 마무리 하겠습니다. 감사합니다.
	// 김진래 드림.
	//
	//################################################################################
	
	
	public double convertOIDValue(String typeName) {
		double typeNum = 0.0;
		boolean numCompare = false;
		
		numCompare = numberCompare(typeName);
				
		if (numCompare) {
			
		} else {
			typeName = typeName.toLowerCase().trim();
			if (typeName.equalsIgnoreCase("off")) {
				typeNum = 1.0;
			} else if (typeName.equalsIgnoreCase("master")) {
				typeNum = 2.0;
			} else if (typeName.equalsIgnoreCase("slave")) {
				typeNum = 3.0;
			} else if (typeName.equalsIgnoreCase("single")) {
				typeNum = 4.0;
			} else if (typeName.equalsIgnoreCase("down")) {
				typeNum = 5.0;
			} else if (typeName.equalsIgnoreCase("-master")) {
				typeNum = 6.0;
			} else if (typeName.equalsIgnoreCase("-slave")) {
				typeNum = 7.0;
			} else if (typeName.equalsIgnoreCase("-single")) {
				typeNum = 8.0;
			} else {
				typeNum = 999.0;
			}
		}
		
		return typeNum;
	}
	
	public String replaceString(String txt) {
		String result = txt.replaceAll("[^0-9]",""); 
		return result;
	}
	
	public boolean numberCompare(String txt) {
		boolean result = false;
		
		txt.matches("[+-]?\\d*(\\.\\d+)?");
		
		return result;
	}
}
