/*
 * @author Zhang yy
 * @version 1.0
 */
package main.java.com.zhangyy.lac.model;
import java.util.List;
/*
 * 翻译器：将罗马字母（I，V，X，L，C，D，M）根据规则翻译成对应的阿拉伯数字。
 */
public class Translator {
	static final String END_INPUT_IDENTIFIER = "END";	//identifier to stop input
	static List<String> tradeRules ;	//rules on the trade

	public static int romanToArabic(String romanStr){
		
		int arabicValue = 0;
		String[] romanSymbols = {"I","IV","V","IX","X","XL","L","XC","C","CD","D","CM","M"};
		int[] arabicNumber = {1,4,5,9,10,40,50,90,100,400,500,900,1000};
		String romanStrModified = trimAll(romanStr).toUpperCase();
		for(int i=0; i<romanStrModified.length(); i++){
			String charOne = String.valueOf(romanStrModified.charAt(i));
			if (!(charOne.equals("I") || charOne.equals("V")
					|| charOne.equals("X") || charOne.equals("L")
					|| charOne.equals("C") || charOne.equals("D")
					|| charOne.equals("M"))){
				System.out.println("input error: Roman number limits 'I','V','X','L','C','D','M'");
				arabicValue = 0;
				break;
			}
			boolean strTwoFlag = false;
			if(i<romanStrModified.length()-1){
				String strTwo = romanStrModified.substring(i, i+2);
				for(int j=0; j<romanSymbols.length; j++){
					if(strTwo.equals(romanSymbols[j])){
						strTwoFlag = true;
						arabicValue = arabicValue+arabicNumber[j];
						i++;
						break;
					}
				}
			}
			if(!strTwoFlag){
				for(int k=0; k<romanSymbols.length; k++){
					if(charOne.equals(romanSymbols[k])){
						arabicValue = arabicValue+arabicNumber[k];
						break;
					}
				}
			}
		}
		return arabicValue;
		
	}
	//出去杂乱符号
	public static String trimAll(String dirtyStr){
		return dirtyStr.replaceAll("[ |��]", " ").trim();
	}


}
