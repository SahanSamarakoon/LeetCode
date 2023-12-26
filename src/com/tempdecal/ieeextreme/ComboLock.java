package com.tempdecal.ieeextreme;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;

public class ComboLock {
    static List<char[]>  charListMap= new ArrayList<>();
    static Map<Integer, Map<Character, Integer>> charList = new HashMap<>();
    public static void hashmapSolution(List<char[]> charListMap) {
        for (int i = 0; i < 8; i++) {
            Map<Character, Integer> map = new HashMap<>();
            for (char[] chars : charListMap) {
                char c = chars[i];
                if (map.containsKey(c)) {
                    map.put(c, map.get(c) + 1);
                } else {
                    map.put(c, 1);
                }
            }
            charList.put(i,map);
        }
    }

    public static HashMap<Character, Integer> sortByValue(HashMap<Character, Integer> hm)
    {
        // Create a list from elements of HashMap
        List<Map.Entry<Character, Integer> > list =
                new LinkedList<Map.Entry<Character, Integer> >(hm.entrySet());

        // Sort the list
        Collections.sort(list, new Comparator<Map.Entry<Character, Integer> >() {
            public int compare(Map.Entry<Character, Integer> o1,
                               Map.Entry<Character, Integer> o2)
            {
                return (o1.getValue()).compareTo(o2.getValue());
            }
        });

        // put data from sorted list to hashmap
        HashMap<Character, Integer> temp = new LinkedHashMap<Character, Integer>();
        for (Map.Entry<Character, Integer> aa : list) {
            temp.put(aa.getKey(), aa.getValue());
        }
        return temp;
    }

    public static void main(String[] args) {
        BufferedReader reader;
        try {
//            reader = new BufferedReader(new FileReader(
//                    "/home/tempdecal/google-10000-english-usa-no-swears.txt"));

            reader = new BufferedReader(new FileReader("/home/tempdecal/file.txt"));

            String line = reader.readLine();
            while (line != null) {
                char[] tempArray=line.toCharArray();
                if (1<tempArray.length && tempArray.length<=8){
                    char[] charArray= new char[8];
                    Arrays.fill(charArray, '$');
                    int length = Math.min(tempArray.length,8);
                    for (int i = 0; i < length; i++) {
                        charArray[i] = tempArray[i];
                    }
                    charListMap.add(charArray);
                }
                line = reader.readLine();
            }
            hashmapSolution(charListMap);
            reader.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        for (int i = 0; i < 8; i++) {
            System.out.println();
            System.out.println("#################################################################################"+i);
            HashMap<Character, Integer> map = (HashMap<Character, Integer>) charList.get(i);
            Map<Character, Integer> hm1 = sortByValue(map);
            for (Map.Entry<Character, Integer> en : hm1.entrySet()) {
                System.out.println("Key = " + en.getKey() +
                        ", Value = " + en.getValue());
            }
        }
    }
}
