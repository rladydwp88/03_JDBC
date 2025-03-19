package kh.edu.common;

import java.io.FileOutputStream;
import java.util.Properties;
import java.util.Scanner;

public class CreateXMLFile {
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		Properties prop = new Properties();
		
		try {
			System.out.print("생성할 파일 이름 : ");
			String fileName = sc.next();
			
			FileOutputStream fos = new FileOutputStream(fileName + ".xml");

			prop.storeToXML(fos, fileName + ".xml file!!!");
			
			System.out.println(fileName + ".xml 파일 생성 완료");
			
			sc.close();
			
		} catch (Exception e) {
			System.out.println("xml 파일 생성 중 예외발생");
			e.printStackTrace();
		} 
	}
}
