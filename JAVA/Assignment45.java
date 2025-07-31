package com.wipro.practice;

import java.util.*;

class Students {
    int id;
    String name;
    String department;

    Students(int id, String name, String department) {
        this.id = id;
        this.name = name;
        this.department = department;
    }
}

public class Assignment45 {
    public static void main(String[] args) {
        List<Students> list = new ArrayList<>();
        list.add(new Students(1, "Ram", "CSE"));
        list.add(new Students(2, "Shyam", "ECE"));
        list.add(new Students(3, "Amit", "CSE"));
        list.add(new Students(4, "Ravi", "EEE"));
        list.add(new Students(5, "Anu", "ECE"));

        Map<String, List<String>> map = new HashMap<>();

        // Group students manually
        for (Students s : list) {
            if (!map.containsKey(s.department)) {
                map.put(s.department, new ArrayList<>());
            }
            map.get(s.department).add(s.name);
        }


        for (String dept : map.keySet()) {
            System.out.println("Department: " + dept);
            for (String name : map.get(dept)) {
                System.out.println("Name :" + name);
            }
        }
    }
}
/*Department: CSE
Name :Ram
Name :Amit
Department: EEE
Name :Ravi
Department: ECE
Name :Shyam
Name :Anu
*/
