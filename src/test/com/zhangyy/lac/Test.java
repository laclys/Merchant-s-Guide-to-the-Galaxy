/*
 * @author Zhang yy
 * @version 1.0
 */
package test.com.zhangyy.lac;
import static org.junit.Assert.*;

import main.java.com.zhangyy.lac.main.GlobalVar;
import main.java.com.zhangyy.lac.model.Dao;
import main.java.com.zhangyy.lac.model.Translator;
import main.java.com.zhangyy.lac.model.lineParser;
//�Թ����������õĺ�������һһ����
public class Test {
    //�������ֺͰ��������ֵ�ת������
	@org.junit.Test
	public void testRomanToArabic() {
	//fail("Not yet implemented");
	assertEquals(2006, Translator.romanToArabic("MMVI"));
	assertEquals(1944, Translator.romanToArabic("MCMXLIV"));
	assertEquals(1903, Translator.romanToArabic("MCMIII"));
	}
	//���Ӵ���-���Ŷ������������
	@org.junit.Test
	public void testSymbolParser() {
	//fail("Not yet implemented");
	assertEquals("M", lineParser.symbolParser("glob is M"));
	assertEquals("X", lineParser.symbolParser("pish is X"));
	assertEquals("I", lineParser.symbolParser("prok is I"));
	assertEquals("V", lineParser.symbolParser("tegj is V"));
	}
	//���Ӵ���-���۽���������
	@org.junit.Test
	public void testPriceParser() {
	//fail("Not yet implemented");
	assertEquals( GlobalVar.GLOB, lineParser.PriceParser("glob pish Silver is 99 Credits")[0]);
	assertEquals( GlobalVar.PISH, lineParser.PriceParser("glob pish Silver is 99 Credits")[1]);
	assertEquals( GlobalVar.silverTemp, lineParser.PriceParser("glob pish Silver is 99 Credits")[2]);
	
	assertEquals( GlobalVar.TEGJ, lineParser.PriceParser("tegj prok Gold is 57800 Credits")[0]);
	assertEquals( GlobalVar.PROK, lineParser.PriceParser("tegj prok Gold is 57800 Credits")[1]);
	assertEquals( GlobalVar.goldTemp, lineParser.PriceParser("tegj prok Gold is 57800 Credits")[2]);
	
	assertEquals( GlobalVar.TEGJ, lineParser.PriceParser("tegj tegj Iron is 3910 Credits")[0]);
	assertEquals( GlobalVar.TEGJ, lineParser.PriceParser("tegj tegj Iron is 3910 Credits")[1]);
	assertEquals( GlobalVar.ironTemp, lineParser.PriceParser("pish pish Iron is 3910 Credits")[2]);

	
	}
	//���Ӵ���-��������ת�����������
	@org.junit.Test
	public void testNumeralQuestionParser() {
	//fail("Not yet implemented");
	assertEquals( GlobalVar.PISH + GlobalVar.TEGJ + GlobalVar.GLOB + GlobalVar.PROK, lineParser.numeralQuestionParser("how much is pish tegj glob prok ?"));
	}

	//���Ӵ���-����ѯ�ʼ�Ǯ���������
	@org.junit.Test
	public void testPriceQuestionParser() {
	//fail("Not yet implemented");
	assertEquals( GlobalVar.GLOB + GlobalVar.PROK + GlobalVar.PISH + GlobalVar.TEGJ, lineParser.priceQuestionParser("how many Credits is glob prok pish tegj Silver ?")[0]);
	assertEquals( GlobalVar.getSilverTemp(), lineParser.priceQuestionParser("how many Credits is glob prok pish tegj Silver ?")[1]);
	
	assertEquals( GlobalVar.GLOB + GlobalVar.PROK + GlobalVar.PISH + GlobalVar.TEGJ, lineParser.priceQuestionParser("how many Credits is glob prok pish tegj Gold ?")[0]);
	assertEquals( GlobalVar.getGoldTemp(), lineParser.priceQuestionParser("how many Credits is glob prok pish tegj Gold ?")[1]);

	assertEquals( GlobalVar.GLOB + GlobalVar.PROK + GlobalVar.PISH + GlobalVar.TEGJ, lineParser.priceQuestionParser("how many Credits is glob prok pish tegj Iron ?")[0]);
	assertEquals( GlobalVar.getIronTemp(), lineParser.priceQuestionParser("how many Credits is glob prok pish tegj Iron ?")[1]);

	}
	//���Ӵ���-�����������������޷������������
	@org.junit.Test
	public void testGarbageParser() {
	//fail("Not yet implemented");
	assertEquals("I have no idea what you are talking about", lineParser.garbageParser("how much wood could a woodchuck chuck?"));
	}
	//Dao����
	@org.junit.Test
	public void testCalculate() {
	//fail("Not yet implemented");
	assertEquals(6, Dao.calculate(1, 2, 3));
	assertEquals(100, Dao.calculate(3, 100, 3));
	}	
	
	
}
