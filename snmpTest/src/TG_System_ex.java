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
		double a = getMeasure(snmpOID);
		
		ArrayList arr = new ArrayList();
		arr.add( new Double(a) );
		
		addNewMeasure(arr);		
		
	}// end of computeMeasures()
	
	public double getMeasure(String OID) {
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
					dVal = -999.0;
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
			typeNum = Double.parseDouble(replaceString(typeName)); 
		} else {
			typeName = typeName.toLowerCase().trim();
			if (typeName.equalsIgnoreCase("off")) {
				typeNum = -1.0;
			} else if (typeName.equalsIgnoreCase("master")) {
				typeNum = -2.0;
			} else if (typeName.equalsIgnoreCase("slave")) {
				typeNum = -3.0;
			} else if (typeName.equalsIgnoreCase("single")) {
				typeNum = -4.0;
			} else if (typeName.equalsIgnoreCase("down")) {
				typeNum = -5.0;
			} else if (typeName.equalsIgnoreCase("-master")) {
				typeNum = -6.0;
			} else if (typeName.equalsIgnoreCase("-slave")) {
				typeNum = -7.0;
			} else if (typeName.equalsIgnoreCase("-single")) {
				typeNum = -8.0;
			} else if (typeName.equalsIgnoreCase("on")) {
				typeNum = -9.0;
			}else {
				typeNum = -999.0;
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
