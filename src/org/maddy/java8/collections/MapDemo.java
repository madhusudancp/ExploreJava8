package org.maddy.java8.collections;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.TreeMap;

//Map interface Demo
public class MapDemo {
	public static void main(String[] args) {
		
/*		        populateThenDump(new HashMap<String,Integer>());
		        populateThenDump(new TreeMap<String,Integer>());
		        populateThenDump(new LinkedHashMap<String,Integer>());
*/
		      
		Map<Integer,String> memCacheMap = new LinkedHashMap<>();
		
		memCacheMap.put(100,"A~A~22221~POS~L");
		memCacheMap.put(200,"A~U~22222~POS~L");
		memCacheMap.put(300,"A~A~22223~POS~L");
		memCacheMap.put(400,"A~U~22224~POS~L");
		memCacheMap.put(500,"A~A~22225~POS~F");
	
		        String lastVal= getLatestMapElementValue(memCacheMap);
		        
		        System.out.println(lastVal);
	}

	
	private static String getLatestMapElementValue(Map<Integer,String> batchIdMap){
		System.out.println("SIZE:::"+batchIdMap.size());
		   final Set<Entry<Integer,String>> mapValues = batchIdMap.entrySet();
	       final Entry<Integer,String>[] test = new Entry[batchIdMap.size()];
	       mapValues.toArray(test);
	      // System.out.print("Latest VALUE::"+test[batchIdMap.size()-1].getKey()+"::::"+test[batchIdMap.size()-1].getValue());
	      String va =test[batchIdMap.size()-1].getValue();
	      if(va.contains("F")){
	    	  Integer key =test[batchIdMap.size()-1].getKey();
	    	 boolean removed= batchIdMap.entrySet().removeIf(e->e.getKey()==key);
	      System.out.println(key+"---Removed---"+removed+"----"+batchIdMap.size());
	      va =test[batchIdMap.size()-1].getValue();
	      int index = va.indexOf("L");
    	  String value = va.replace("L", "F");
    	  return value;
	      }else{
	    	  int index = va.indexOf("L");
	    	  String value = va.replace("L", "F");
	    	  return value;
	      }
	}
	
	
	
    static void populateThenDump(Map<String,Integer> map) {
        System.out.println(map.getClass().getName());
        map.put("Zero",  0);
        map.put("One",   1);
        map.put("Two",   2);
        map.put("Three", 3);
        map.put("Four",  4);

        /*for (Map.Entry<String,Integer> entry : map.entrySet()) {
            System.out.println(entry.getKey() + " => " + entry.getValue());
        }*/
       map.forEach((k,v)->System.out.println(k+"----"+v));
       
      /*Object dd= map.entrySet().toArray()[map.size() -1];
       System.out.println("last"+dd);
       */
       final Set<Entry<String,Integer>> mapValues = map.entrySet();
       final Entry<String,Integer>[] test = new Entry[map.size()];
       mapValues.toArray(test);

       System.out.print("First Key:"+test[0].getKey());
       System.out.println(" First Value:"+test[0].getValue());

       System.out.print("Last Key:"+test[map.size()-1].getKey());
       System.out.println(" Last Value:"+test[map.size()-1].getValue());
       
       map.entrySet().removeIf(e-> e.getValue()==0 );
       map.keySet().forEach(System.out::println);
       
    }
	
	
	
}
