package zuoye5_22_1;

import java.io.File;
import java.io.IOException;

public class Demo1 {
	private String pathName;
	
	public Demo1(String pathName) {
		this.pathName = pathName;
	}
	public void showMore() throws IOException {
		File file = new File(pathName);
		if(file.exists()) {
			System.out.println("文件信息如下");
			showFile(file);
			System.out.println("文件信息输出完毕");
		}else {
			System.out.println("你输入的文件地址不存在");
		}
	}
	
	public void showFile(File file) throws IOException {
			if(file.isDirectory()) {
				File [] arrFile = file.listFiles();
				if(arrFile == null) {
					int b = blankNum(file);
					for(int i = 0;i < b;i++) {
						System.out.print("\t");
					}
					System.out.println("+" + file.getName());
				}else {
					int b = blankNum(file);
					for(int i = 0;i < b;i++) {
						System.out.print("\t");
					}
					System.out.println("+" + file.getName());
					for(int j = 0; j < arrFile.length; j++) {
						showFile(arrFile[j]);
					}
				}
			}else {
				int b = blankNum(file);
				for(int i = 0;i < b;i++) {
					System.out.print("\t");
				}
				System.out.println("-" + file.getName());
			}
	}
	
	public int blankNum(File file) throws IOException {
	int num = 0;
	File fileParent = new File(pathName);
	File temp = file;
	if(temp.getCanonicalPath().equals(fileParent.getCanonicalPath())) {
		return 0;
	}
	for (int i = 0;i < 10;i++) {
		if(temp.getCanonicalPath().equals(fileParent.getCanonicalPath())) {
			num = i;
			break;
		}else {
			temp = temp.getParentFile();
		}
	}
	return num;	
	}
	
	public static void main(String[] args) throws IOException {
		Demo1 d = new Demo1("D:\\Desktop");
		d.showMore();
	}
}
