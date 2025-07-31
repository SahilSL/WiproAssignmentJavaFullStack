package com.wipro.practice;
/*Create a class called CD whose attributes are Title and singer.  Arrange the CDs in ascending order based on the singer name.(Use Comparable)*/

import java.util.*;

class CD implements Comparable<CD> {
    String title;
    String singer;

    CD(String title, String singer) {
        this.title = title;
        this.singer = singer;
    }

    public int compareTo(CD other) {
        return this.singer.compareTo(other.singer);
    }
}

public class Assignment40 {
    public static void main(String[] args) {
        ArrayList<CD> cds = new ArrayList<>();

        cds.add(new CD("Song A", "YoYo Honey Singh"));
        cds.add(new CD("Song B", "Arjit Singh"));
        cds.add(new CD("Song C", "Sahil"));

        Collections.sort(cds); // sorts by singer name

        for (CD cd : cds) {
            System.out.println(cd.title + " - " + cd.singer);
        }
    }
}

/*Song B - Arjit Singh
Song C - Sahil
Song A - YoYo Honey Singh
*/