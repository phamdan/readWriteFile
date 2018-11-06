package lab09;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;

public class Utlis {
	public static String readContentFromFile(String path)
	{	
		String a="";
		//File file = new File(path);
		/*if(!file.exists())
		{
			file.createNewFile();
		}
		
		FileInputStream fileInputStream =new FileInputStream(file);
		int c =fileInputStream.read();
		while(c!=-1)
		{
			System.out.print((char)c);
			c=fileInputStream.read();
			a=a+c;
		}
		fileInputStream.close();
		return a;*/
		try {
            FileInputStream fis = new FileInputStream(new File(path));
            try (BufferedReader br = new BufferedReader(new InputStreamReader(fis))) {
                String line;
                while ((line = br.readLine()) != null) {
                	a=a+line+"\n";
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
		return a;
	}
		
	public static void writeContentToFile(String path) throws IOException
	{
		File file = new File(path);
		if(!file.exists())
		{
			file.createNewFile();
		}
    	FileOutputStream fileOutputStream = new FileOutputStream(file);
    	String s="hello world ";
    	fileOutputStream.write(s.getBytes());
    	fileOutputStream.close();
	}
	
	public static void writeContentToFile2(String path) throws IOException
	{
		try (BufferedWriter bw = new BufferedWriter(new FileWriter(path, true))) {
			String content = "\n hello";
			bw.write(content);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	  public static File findFileByName(String folderPath, String fileName) {
		  File file = new File(folderPath);
		  /*Kiểm tra đường dẫn có tồn tại hay không, nếu tồn tại thì tiếp tục kiểm tra nếu nó là file thì lấy ra tên 
		  file so sánh với key truyền vào nếu giống thì in ra đường dẫn tới file đó.*/
	        if (file.exists()) {
	            if (file.isFile()) {
	                if (file.getName().endsWith(fileName)) {
	                    System.out.println(file.getAbsolutePath());
	                }
	            }
	            /*Nếu đường dẫn nhận vào là thư mục thì duyệt danh sách file sao đó đệ quy gọi 
	              lại phương thức findFile().
	             */
	            File[] listFile = file.listFiles();
	            if (listFile != null) {
	                for (File f : listFile) {
	                	findFileByName(f.getAbsolutePath(), fileName);
	                }
	            }
	        } else {
	            System.out.println("folderPath chua duoc tao");
	        }
			return null;
	    }
	
	
    public static void main(String[] args) throws IOException {
		
    	
    	writeContentToFile("D:\\file Dan\\dan\\src\\lab09\\text.txt");
    	
    	writeContentToFile2("D:\\file Dan\\dan\\src\\lab09\\text.txt");
    	writeContentToFile2("D:\\file Dan\\dan\\src\\lab09\\text.txt");
    	String a=readContentFromFile("D:\\file Dan\\dan\\src\\lab09text.txt");
    	System.out.println(a);
    }
}
