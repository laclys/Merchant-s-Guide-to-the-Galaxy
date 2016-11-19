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
		//符号定义解析器，解析形如"glob is I"的文本...START
		String line1 = "glob is I";
		String line2 = "prok is V";		
		String line3 = "pish is X";		
		String line4 = "tegj is L";
		System.out.println(line1);
		System.out.println(line2);
		System.out.println(line3);
		System.out.println(line4);
		//利用中间变量将单词和罗马字母对应起来
		t1.setGlobTemp(lineParser.symbolParser(line1));
		t1.setProkTemp(lineParser.symbolParser(line2));
		t1.setPishTemp(lineParser.symbolParser(line3));
		t1.setTegjTemp(lineParser.symbolParser(line4));
		GlobalVar.setGLOB(t1.getGlobTemp());
		GlobalVar.setPROK(t1.getProkTemp());
		GlobalVar.setPISH(t1.getPishTemp());
		GlobalVar.setTEGJ(t1.getTegjTemp());
		//符号定义解析器，解析形如"glob is I"的文本...END
		
		//定价解析器，解析形如"glob glob Silver is 34 Credits"的文本...START
		String line5 = "glob glob Silver is 34 Credits";
		String line6 = "glob prok Gold is 57800 Credits";		
		String line7 = "pish pish Iron is 3910 Credits";
		System.out.println(line5);
		System.out.println(line6);
		System.out.println(line7);
		//利用中间变量将句子中的单词转换为罗马字母并储存起来
		t1.setSilverTempPriceParser(lineParser.PriceParser(line5)[0] + lineParser.PriceParser(line5)[1]);
		t1.setGoldTempPriceParser(lineParser.PriceParser(line6)[0] + lineParser.PriceParser(line6)[1]);
		t1.setIronTempPriceParser(lineParser.PriceParser(line7)[0] + lineParser.PriceParser(line7)[1]);
		//定价解析器，解析形如"glob glob Silver is 34 Credits"的文本...END
		
		//解析数字转化的问题，形如"how much is xxx？"...START
		String line8 = "how much is pish tegj glob glob ?";
		System.out.println(line8);
		//将how much问题句中的单词取得转化成罗马字母，并存储在中间变量中
		t1.setNumeralQuestionTemp(lineParser.numeralQuestionParser(line8));
		//解析数字转化的问题，形如"how much is xxx ?"..END
		
		//解析询问价钱的问题，形如"how many Credits is glob prok Iron ?"...START
		String line9 = "how many Credits is glob prok Silver ?";
		String line10 = "how many Credits is glob prok Gold ?";
		String line11 = "how many Credits is glob prok Iron ?";
		System.out.println(line9);
		System.out.println(line10);
		System.out.println(line11);
		//解析询问价钱中的单词并转化为罗马字母，并存储在中间变量中
		t1.setSilverPriceQuestionTemp((lineParser.priceQuestionParser(line9)[0]));
		t1.setGoldPriceQuestionTemp((lineParser.priceQuestionParser(line10)[0]));
		t1.setIronPriceQuestionTemp((lineParser.priceQuestionParser(line11)[0]));
		//解析询问价钱中的金钱类别（Silver，Gold，Iron ）并存储在中间变量中
		t1.setSilverSymbolTemp(Integer.parseInt((lineParser.priceQuestionParser(line9)[1])));
		t1.setGoldSymbolTemp(Integer.parseInt((lineParser.priceQuestionParser(line10)[1])));
		t1.setIronSymbolTemp(Integer.parseInt((lineParser.priceQuestionParser(line11)[1])));
		//解析询问价钱的问题，形如"how many Credits is glob prok Iron ?"...END
		
		//处理其他解析器都无法理解的问题...START
		String line12 = "how much wood could a woodchuck chuck if a woodchuck could chuck wood ?";
		System.out.println(line12);
		//处理其他解析器都无法理解的问题...END
		
		//THINKING...
		System.out.println("");	
		System.out.println("caculating , wait a moment...");
		System.out.println(".............................");
		System.out.println("ahha , got it.");
		System.out.println("");
		//OUTPUT RESULT...	利用翻译器进行罗马字母=>阿拉伯数字的转换
		System.out.println("pish tegj glob glob is "+Translator.romanToArabic(t1.getNumeralQuestionTemp()));
		System.out.println("glob prok Silver is "+Dao.calculate(Translator.romanToArabic(t1.getSilverTempPriceParser()), Translator.romanToArabic(t1.getSilverPriceQuestionTemp()), t1.getSilverSymbolTemp())+" Credits");
		System.out.println("glob prok Gold is "+Dao.calculate(Translator.romanToArabic(t1.getGoldTempPriceParser()), Translator.romanToArabic(t1.getGoldPriceQuestionTemp()), t1.getGoldSymbolTemp())+" Credits");
		System.out.println("glob prok Iron is "+Dao.calculate(Translator.romanToArabic(t1.getIronTempPriceParser()), Translator.romanToArabic(t1.getIronPriceQuestionTemp()), t1.getIronSymbolTemp())+" Credits");
		System.out.println(lineParser.garbageParser(line12));;


	}

}
