package pers.example.test;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;

public class GetCodeTest {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
//		String rootPath = new File("src/main/webapp/download").getAbsolutePath();
		String rootPath = "I:\\Program Files\\Myeclipse\\Workspaces_02\\example\\src\\main\\webapp\\download";
		String className = "User";
		String packageName = "com.example.sys";
		//包名 转 目录
 		String directory = packageName.replaceAll("\\.", "/");
 		//查看指定文件的内容
 		String content = getFileContent(rootPath+"/code/1704210121481/src/"+directory+"/domain/"+className+".java");
		System.out.println(content);
	}
	
	
	/**
	 * 获取文件内容
	 * @param fileName
	 * @return
	 */
	public static String getFileContent(String fileName){
        StringBuffer content = new StringBuffer();
        try {
            FileInputStream fis = new FileInputStream(fileName);
            InputStreamReader isr = new InputStreamReader(fis,"UTF-8");
            BufferedReader br = new BufferedReader(isr);
            String line = null;
            while ((line = br.readLine()) != null) {
            	content.append(line);
            	String nextLine = System.getProperty("line.separator");
            	content.append(nextLine); // 补上换行符
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return content.toString();
	}

}
