/**
 */
package com.framework.common.tools;

import java.io.*;
import java.util.LinkedList;

/***
 * 创建日期:2021/6/26
 * Title:IO工具类
 * Description：对本文件的详细描述，原则上不能少于30字
 * 
 */
public class IoUtil {

	/**
	 * 
	 * 功能:追加内容到文件末尾(使用BufferWrite进行文本内容的追加)
	 * 作者: Administrator
	 * 创建日期:2014年7月3日
	 * @param file
	 * @param content
	 */
	public static void bufferWriteAppend(File file, String content) {
		if(file.exists()){
			//在文本文本中追加内容
			BufferedWriter out = null;
			try {
				//FileOutputStream(file, true),第二个参数为true是追加内容，false是覆盖
				out = new BufferedWriter(new OutputStreamWriter(
						new FileOutputStream(file, true)));
				out.write(content);
				out.newLine(); //换行
			} catch (Exception e) {
				e.printStackTrace();
			} finally {
				try {
					out.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
     }


	/**
	 *
	 * 功能:追加内容到文件末尾(使用FileWriter进行文本内容的追加)
	 * 作者: Administrator
	 * 创建日期:2014年7月3日
	 * @param file
	 * @param content
	 */
	private void fileWriterAppend(File file, String content){
		if(file.exists()){
			FileWriter writer = null;
			try {
				//FileWriter(file, true),第二个参数为true是追加内容，false是覆盖
				writer = new FileWriter(file, true);
				writer.write(content);
				//换行
				writer.write("\r\n");
			} catch (IOException e) {
				e.printStackTrace();
			} finally {
				try {
					if(writer != null){
						writer.close();
					}
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
	}


	/**
	 * 
	 * 功能:追加内容到文件末尾
	 * 作者: Administrator
	 * 创建日期:2014年7月3日
	 * @param fileName
	 * @param content
	 */
	public static void bufferWriteAppend(String fileName, String content){
		File file = new File(fileName);
		bufferWriteAppend(file,content);
	}





	/**
	 * 
	 * 功能:以行为单位读取文件
	 * 作者: Administrator
	 * 创建日期:2014年7月4日
	 * @param file
	 */
    public static String bufferReadLine(File file) {
		if(file.exists()){
			StringBuffer sb = new StringBuffer();
			BufferedReader reader = null;
			try {
				reader = new BufferedReader(new InputStreamReader(
						new FileInputStream(file)));
				String tempString = null;
				// 一次读入一行，直到读入null为文件结束
				while ((tempString = reader.readLine()) != null) {
					sb.append(tempString);
				}
			} catch (Exception e) {
				e.printStackTrace();
			} finally {
				if (reader != null) {
					try {
						reader.close();
					} catch (Exception e) {
						e.printStackTrace();
					}
				}
			}
			return sb.toString();
		}else{
			return "";
		}
    }
    
	/**
	 * 
	 * 功能:以行为单位读取文件
	 * 作者: Administrator
	 * 创建日期:2014年7月4日
	 * @param fileName
	 */
    public static String bufferReadLine(String fileName) {
    	File file = new File(fileName);
    	return bufferReadLine(file).trim();
    }



	/**
	 *
	 * 功能:以行为单位读取文件
	 * 作者: Administrator
	 * 创建日期:2014年7月4日
	 * @param file
	 */
	public static LinkedList<String> bufferReadLineList(File file) {
		LinkedList list = new LinkedList();
		if(file.exists()){
			BufferedReader reader = null;
			try {
				reader = new BufferedReader(new InputStreamReader(
						new FileInputStream(file)));
				String tempString = null;
				 // 一次读入一行，直到读入null为文件结束
				while ((tempString = reader.readLine()) != null){
					list.add(tempString);
				}
			} catch (Exception e) {
				e.printStackTrace();
			} finally {
				if (reader != null) {
					try {
						reader.close();
					} catch (Exception e) {
						e.printStackTrace();
					}
				}
			}
		}
		return list;
	}


	/**
	 *
	 * 功能:以行为单位读取文件
	 * 作者: Administrator
	 * 创建日期:2014年7月4日
	 * @param fileName
	 */
	public static LinkedList<String> bufferReadLineList(String fileName) {
		File file = new File(fileName);
		return bufferReadLineList(file);
	}



}
