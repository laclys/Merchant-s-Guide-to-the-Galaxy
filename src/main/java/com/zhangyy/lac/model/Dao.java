/*
 * @author Zhang yy
 * @version 1.0
 */
package main.java.com.zhangyy.lac.model;
//how many¼ÆËã¹«Ê½
public class Dao {
	 public static int calculate(int arabicPriceParser,int arabicPriceQuestion,int symbolTemp) {
		 int result = arabicPriceQuestion * symbolTemp / arabicPriceParser;		 
		 return result;
	 }
}
