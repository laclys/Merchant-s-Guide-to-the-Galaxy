/*
 * @author Zhang yy
 * @version 1.0
 */
package main.java.com.zhangyy.lac.main;
import main.java.com.zhangyy.lac.main.GlobalVar;
import main.java.com.zhangyy.lac.model.Dao;
import main.java.com.zhangyy.lac.model.Temp;
import main.java.com.zhangyy.lac.model.Translator;
import main.java.com.zhangyy.lac.model.lineParser;
public class StartMerchantGuide {
	public static void main(String[] args) {

		Temp t1 = new Temp();
		//���Ŷ������������������"glob is I"���ı�...START
		String line1 = "glob is I";
		String line2 = "prok is V";		
		String line3 = "pish is X";		
		String line4 = "tegj is L";
		System.out.println(line1);
		System.out.println(line2);
		System.out.println(line3);
		System.out.println(line4);
		//�����м���������ʺ�������ĸ��Ӧ����
		t1.setGlobTemp(lineParser.symbolParser(line1));
		t1.setProkTemp(lineParser.symbolParser(line2));
		t1.setPishTemp(lineParser.symbolParser(line3));
		t1.setTegjTemp(lineParser.symbolParser(line4));
		GlobalVar.setGLOB(t1.getGlobTemp());
		GlobalVar.setPROK(t1.getProkTemp());
		GlobalVar.setPISH(t1.getPishTemp());
		GlobalVar.setTEGJ(t1.getTegjTemp());
		//���Ŷ������������������"glob is I"���ı�...END
		
		//���۽���������������"glob glob Silver is 34 Credits"���ı�...START
		String line5 = "glob glob Silver is 34 Credits";
		String line6 = "glob prok Gold is 57800 Credits";		
		String line7 = "pish pish Iron is 3910 Credits";
		System.out.println(line5);
		System.out.println(line6);
		System.out.println(line7);
		//�����м�����������еĵ���ת��Ϊ������ĸ����������
		t1.setSilverTempPriceParser(lineParser.PriceParser(line5)[0] + lineParser.PriceParser(line5)[1]);
		t1.setGoldTempPriceParser(lineParser.PriceParser(line6)[0] + lineParser.PriceParser(line6)[1]);
		t1.setIronTempPriceParser(lineParser.PriceParser(line7)[0] + lineParser.PriceParser(line7)[1]);
		//���۽���������������"glob glob Silver is 34 Credits"���ı�...END
		
		//��������ת�������⣬����"how much is xxx��"...START
		String line8 = "how much is pish tegj glob glob ?";
		System.out.println(line8);
		//��how much������еĵ���ȡ��ת����������ĸ�����洢���м������
		t1.setNumeralQuestionTemp(lineParser.numeralQuestionParser(line8));
		//��������ת�������⣬����"how much is xxx ?"..END
		
		//����ѯ�ʼ�Ǯ�����⣬����"how many Credits is glob prok Iron ?"...START
		String line9 = "how many Credits is glob prok Silver ?";
		String line10 = "how many Credits is glob prok Gold ?";
		String line11 = "how many Credits is glob prok Iron ?";
		System.out.println(line9);
		System.out.println(line10);
		System.out.println(line11);
		//����ѯ�ʼ�Ǯ�еĵ��ʲ�ת��Ϊ������ĸ�����洢���м������
		t1.setSilverPriceQuestionTemp((lineParser.priceQuestionParser(line9)[0]));
		t1.setGoldPriceQuestionTemp((lineParser.priceQuestionParser(line10)[0]));
		t1.setIronPriceQuestionTemp((lineParser.priceQuestionParser(line11)[0]));
		//����ѯ�ʼ�Ǯ�еĽ�Ǯ���Silver��Gold��Iron �����洢���м������
		t1.setSilverSymbolTemp(Integer.parseInt((lineParser.priceQuestionParser(line9)[1])));
		t1.setGoldSymbolTemp(Integer.parseInt((lineParser.priceQuestionParser(line10)[1])));
		t1.setIronSymbolTemp(Integer.parseInt((lineParser.priceQuestionParser(line11)[1])));
		//����ѯ�ʼ�Ǯ�����⣬����"how many Credits is glob prok Iron ?"...END
		
		//�����������������޷���������...START
		String line12 = "how much wood could a woodchuck chuck if a woodchuck could chuck wood ?";
		System.out.println(line12);
		//�����������������޷���������...END
		
		//THINKING...
		System.out.println("");	
		System.out.println("caculating , wait a moment...");
		System.out.println(".............................");
		System.out.println("ahha , got it.");
		System.out.println("");
		//OUTPUT RESULT...	���÷���������������ĸ=>���������ֵ�ת��
		System.out.println("pish tegj glob glob is "+Translator.romanToArabic(t1.getNumeralQuestionTemp()));
		System.out.println("glob prok Silver is "+Dao.calculate(Translator.romanToArabic(t1.getSilverTempPriceParser()), Translator.romanToArabic(t1.getSilverPriceQuestionTemp()), t1.getSilverSymbolTemp())+" Credits");
		System.out.println("glob prok Gold is "+Dao.calculate(Translator.romanToArabic(t1.getGoldTempPriceParser()), Translator.romanToArabic(t1.getGoldPriceQuestionTemp()), t1.getGoldSymbolTemp())+" Credits");
		System.out.println("glob prok Iron is "+Dao.calculate(Translator.romanToArabic(t1.getIronTempPriceParser()), Translator.romanToArabic(t1.getIronPriceQuestionTemp()), t1.getIronSymbolTemp())+" Credits");
		System.out.println(lineParser.garbageParser(line12));;


	}

}
