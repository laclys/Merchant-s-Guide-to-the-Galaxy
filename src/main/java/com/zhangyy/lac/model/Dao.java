/*
 * @author Zhang yy
 * @version 1.0
 */
package main.java.com.zhangyy.lac.model;
//how many���㹫ʽ
public class Dao {
	 public static int calculate(int arabicPriceParser,int arabicPriceQuestion,int symbolTemp) {
		 int result = arabicPriceQuestion * symbolTemp / arabicPriceParser;		 
		 return result;
	 }
}
