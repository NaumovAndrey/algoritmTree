package org.example;

public class Main {
    public static void main(String[] args) {

        // ---------- lesson4 (HashMap) ----------
//        HashMap map = new HashMap();

//        map.push(1, 2);
//        map.push(-1, 2);
//        map.push(17, 3);
//        map.push(3, 5);

//        System.out.println(map.find(1));
//        System.out.println(map.find(17));
//        System.out.println(map.find(3));
//        System.out.println(map.find(4));
//        System.out.println(map.find(-1));

//        map.remove(17);
//        System.out.println(map.find(17));


        // ---------- lesson4 (Tre) ----------
        Tree tree = new Tree();
        for (int i = 1; i < 5; i++) {
            tree.insert(i);
        }
    }
}