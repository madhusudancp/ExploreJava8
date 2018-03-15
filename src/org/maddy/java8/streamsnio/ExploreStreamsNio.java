package org.maddy.java8.streamsnio;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.LinkOption;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class ExploreStreamsNio {
/*
* Use Path interface to operate on file and directory paths
* Use Files class to check, read, delete, copy, move, manage metadata of a file or directory
* Use Stream API with NIO.2
*
*/
	
	public static void main(String[] args) {
		String filePath = "D:\\CRP-UTILITY\\TEXTFILES\\transactions1.txt";
		Path p1 = Paths.get(filePath); // using an absolute path
		//Path p2 = Paths.get("c:\\data", "examples\\file.txt"); // using a relative path to construct the path c:\data\examples\file.txt
		
		boolean exists = Files.exists(p1, new LinkOption[]{ LinkOption.NOFOLLOW_LINKS});
		System.out.println(exists);
		
		try (Stream<Path> stream = Files.list(Paths.get("D:\\CRP-UTILITY\\TEXTFILES"))) {
		    stream.map(String::valueOf)
		        .filter(path -> path.endsWith(".txt"))
		        .forEach(System.out::println);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		 List<String> list = new ArrayList<>();
		try (Stream<String> stream = Files.lines(p1)) {

			list= stream.collect(Collectors.toList());;

		} catch (IOException e) {
			e.printStackTrace();
		}
		
		System.out.println(list.size());
		StringBuilder  sql= new StringBuilder("mysql -h 10.101.101.12 -P1162 -ususharma -p crp_344 -e \" select TRANSACTION_ID from  INV_HISTORY where TRANSACTION_ID in (");
        list.forEach(txnId->{sql.append(txnId).append(",");});
        String str = sql.toString();
        str= str.replaceAll(",$", "");
        str=str+")\" > txns3.csv";
        System.out.println(str);
        
        String filePathSql = "D:\\CRP-UTILITY\\TEXTFILES\\SQLOUTPUT\\txns1.txt";
    	Path p2 = Paths.get(filePathSql); // using an absolute path
    	        
    	List<String> listSql = new ArrayList<>();
		try (Stream<String> stream = Files.lines(p2)) {

			listSql= stream.collect(Collectors.toList());;

		} catch (IOException e) {
			e.printStackTrace();
		}
        final  List<String> listOrig = listSql;
		List<String> listNotProcessed = new ArrayList<>();
		list.forEach(txnid->{
			  if(! listOrig.contains(txnid)){
				  listNotProcessed.add(txnid);
			  }
		    });
		
		
		
		System.out.println("Not processed"+listNotProcessed.size());
		
		
		String content = listNotProcessed.toString();
		try {
			Files.write(Paths.get("D:\\CRP-UTILITY\\TEXTFILES\\SQLOUTPUT\\txnsnotprocessed1.txt"), content.getBytes());
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		
		
	    }
	
	
}
