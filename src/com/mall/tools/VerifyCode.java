package com.mall.tools;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.util.Random;

import com.mall.constant.Constant;


/**
 * 
 * @描述: 验证码JavaBean
 * @类名: VerifyCode 
 * @创建人: 黄土高坡的宝宝
 * @创建日期: 2017年11月9日
 */
public class VerifyCode {

	private static Random random = new Random();//创建Random实例
	
	private static char [] codechars = Constant.CODE_SOURCE.toCharArray();//全部可能字符串的char数组
	
	private static Font codeFont = new Font(Constant.FONT_NAME, Font.PLAIN, 16);
	
	private static String codeText;
	
	public static String getCodeText() {
		return codeText;
	}

	/*随机生成指定长度的字符串*/
	private static String randString( int length ){
		
		char [] codechar = new char [length];
		int randNum ;
		for (int i = 0; i < length; i++) {
			randNum = Math.abs(random.nextInt()) % codechars.length;
			codechar[i] = codechars[randNum];
		}
		return new String(codechar);
	}
	
	/*得到指定长度的验证码*/
	public static String getVerifyCode( int length ){ 
		
		codeText = randString(length);
		return  codeText;
	}
	
	/*随机生成颜色*/
	public static Color getRandColor(int fc, int bc){
		
		if( fc > 255 ){
			fc = 255;
		}
		
		if( bc > 255 ){
			bc = 255;
		}
		
		int r = fc + random.nextInt( bc - fc);
		int g = fc + random.nextInt( bc - fc);
		int b = fc + random.nextInt( bc - fc);
		
		return new Color(r, g, b);
	}
	
	public static BufferedImage getImage(String verifyCode){
		
		try{
			
			int iLength = verifyCode.length();//验证码长度
			int width = 22 * iLength;//宽度
			int height = 20;//长度
			
			int CharWidth = ( width - 24 )/ iLength ;//字符距左边宽度
			int CharHeight = 16;//字符距上边宽度
			
			
			BufferedImage bi = new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB);//创建图像
			
			Graphics g = bi.getGraphics();//绘画环境
			
			g.setColor(getRandColor(200, 240));//设定背景色
			
			g.fillRect(0, 0, width, height);
			g.setFont(codeFont);
			g.setColor(getRandColor(10, 50));
			g.drawRect(0, 0, width-1, height-1);
			g.setColor(getRandColor(160, 200));
			
			for (int i = 0; i < 155; i++) {
				
				int x = random.nextInt(width);
				int y = random.nextInt(height);
				int x1 = random.nextInt(12);
				int y1 = random.nextInt(12);
				g.drawLine(x, y, x+x1, y+y1);
			}
			
			for (int i = 0; i < iLength; i++) {
				String rand = verifyCode.substring(i, i+1);
				g.setColor(new Color(20+ random.nextInt(60), 20+ random.nextInt(120), 20+ random.nextInt(180)));
				g.drawString(rand, CharWidth*i+14, CharHeight);
			}
			
			g.dispose();
			return bi;
			
		} catch(Exception e){
			System.out.println(e.getMessage());
		}
		return null;
	}
	
	
}
