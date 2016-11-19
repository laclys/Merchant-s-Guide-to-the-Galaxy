/*
 * @author Zhang yy
 * @version 1.0
 */
package main.java.com.zhangyy.lac.model;
import main.java.com.zhangyy.lac.main.GlobalVar;
/*
 * 句子解析器包含：符号定义解析器，定价解析器，解析数字转化的问题，
 * 解析询问价钱的问题，处理其他解析器都无法理解的问题。五类
 */
public class lineParser {
     //符号定义解析器
	 public static String symbolParser(String line) {
		 String result ="";
		 String[] ss = line.split(" ");
		 if (ss.length == 3 && ss[1].equalsIgnoreCase("is")) {
			 if(ss[0].substring(0,4).equalsIgnoreCase("glob")){
				 result = ss[2];
				 
				 }
			 if(ss[0].substring(0,4).equalsIgnoreCase("prok")){
				 result = ss[2];
				 
				 }
			 if(ss[0].substring(0,4).equalsIgnoreCase("pish")){
				 result = ss[2];
				 
				 }
			 if(ss[0].substring(0,4).equalsIgnoreCase("tegj")){
				 result = ss[2];
				 				 }
		 }else{
			 result = "";
		 }
		return result;
		 
	 }
	 //定价解析器
	 public static String[] PriceParser(String line){
		 String[] result = new String[3];;		 
		 String[] ss = line.split(" ");
		 if (ss.length == 6 && ss[3].equalsIgnoreCase("is")) {
			 //ss[0]
			 if(ss[0].substring(0,4).equalsIgnoreCase("glob")){
				 result[0] = GlobalVar.getGLOB();
				 
				 }
			 if(ss[0].substring(0,4).equalsIgnoreCase("prok")){
				 result[0] = GlobalVar.getPROK();
				 
				 }
			 if(ss[0].substring(0,4).equalsIgnoreCase("pish")){
				 result[0] = GlobalVar.getPISH();
				 
				 }
			 if(ss[0].substring(0,4).equalsIgnoreCase("tegj")){
				 result[0] = GlobalVar.getTEGJ();
				 }
			 //ss[1]
			 if(ss[1].substring(0,4).equalsIgnoreCase("glob")){
				 result[1] = GlobalVar.getGLOB();
				 
				 }
			 if(ss[1].substring(0,4).equalsIgnoreCase("prok")){
				 result[1] = GlobalVar.getPROK();
				 
				 }
			 if(ss[1].substring(0,4).equalsIgnoreCase("pish")){
				 result[1] = GlobalVar.getPISH();
				 
				 }
			 if(ss[1].substring(0,4).equalsIgnoreCase("tegj")){
				 result[1] = GlobalVar.getTEGJ();
				 }
			 //ss[2]
			 if(ss[2].substring(0,4).equalsIgnoreCase("silv")){
				 GlobalVar.setSilverTemp(ss[4]);
				 result[2] = ss[4];
				 
				 }
			 if(ss[2].substring(0,4).equalsIgnoreCase("gold")){
				 GlobalVar.setGoldTemp(ss[4]);
				 result[2] = ss[4];
				 
				 }
			 if(ss[2].substring(0,4).equalsIgnoreCase("iron")){
				 GlobalVar.setIronTemp(ss[4]);
				 result[2] = ss[4];
				 }			 

			 
		 }
		 
		 
		 return result;
	 }
	 //解析数字转化的问题
	 public static String numeralQuestionParser(String line) {
		 StringBuffer result =new StringBuffer();
		 String[] ss = line.split(" ");
		 for (int i = 3; i < ss.length-1; i++) {
			 if (ss[i].substring(0,4).equalsIgnoreCase("glob")) {
				 result.append(GlobalVar.getGLOB());
			}
			 if (ss[i].substring(0,4).equalsIgnoreCase("prok")) {
				 result.append(GlobalVar.getPROK());
			}

			 if (ss[i].substring(0,4).equalsIgnoreCase("pish")) {
				 result.append(GlobalVar.getPISH());
			}
			 if (ss[i].substring(0,4).equalsIgnoreCase("tegj")) {
				 result.append(GlobalVar.getTEGJ());
			}
			
		}
		 return result.toString();
	 }
	 //解析询问价钱的问题
	 public static String[] priceQuestionParser(String line) {
		 StringBuffer temp =new StringBuffer();
		 String[] result = new String[2];
		 String[] ss = line.split(" ");
		 for (int i = 4; i < ss.length-2; i++) {
			 if (ss[i].substring(0,4).equalsIgnoreCase("glob")) {
				 temp.append(GlobalVar.getGLOB());
			}
			 if (ss[i].substring(0,4).equalsIgnoreCase("prok")) {
				 temp.append(GlobalVar.getPROK());
			}

			 if (ss[i].substring(0,4).equalsIgnoreCase("pish")) {
				 temp.append(GlobalVar.getPISH());
			}
			 if (ss[i].substring(0,4).equalsIgnoreCase("tegj")) {
				 temp.append(GlobalVar.getTEGJ());
			}
			
		}
		 if(ss[ss.length-2].substring(0,4).equalsIgnoreCase("silv")){
			 result[1] = GlobalVar.getSilverTemp();
		 }
		 if(ss[ss.length-2].substring(0,4).equalsIgnoreCase("gold")){
			 result[1] = GlobalVar.getGoldTemp();
		 }
		 if(ss[ss.length-2].substring(0,4).equalsIgnoreCase("iron")){
			 result[1] = GlobalVar.getIronTemp();
		 }			 
		 result[0] = temp.toString();
		 return result;
		 
	 }
	 //处理其他解析器都无法理解的问题
	 public static String garbageParser(String line) {
		 String result ="";
		 String[] ss = line.split(" ");
		 if (ss[3].equalsIgnoreCase("is")) {
			 
		 }else{
			 result ="I have no idea what you are talking about";
		 }

		 return result;
		 
	 }
}
