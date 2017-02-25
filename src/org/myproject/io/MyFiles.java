package org.myproject.io;

import java.io.File;
import java.io.FilenameFilter;
import java.util.Arrays;
import java.util.regex.Pattern;

public class MyFiles {

	public static void main(String[] args){
		//System.out.println(args[0]);
		File path=new File(".");
		String[] list;
		if(args.length==0){
			list=path.list();
		}else{
			list=path.list(new DirFilter(args[0]));
		}
		Arrays.sort(list,String.CASE_INSENSITIVE_ORDER);
		for(String dirItems:list){
			System.out.println(dirItems);
		}
	}
}

class DirFilter implements FilenameFilter{
	private Pattern pattern;
	public DirFilter(String regex){
		pattern=Pattern.compile(regex);
	}
	/**
	 * accept() 方法，创建这个类的目的是在于吧accept（） 方法听过给list()使用，
	 * 是list可以回调accept（），进而聚丁那些文件包含在列表中，这种结构也常常成为回调，这是一个策略模式例子，
	 */
	public boolean accept(File dir,String name){
		
		return pattern.matcher(name).matches();
	}
}
