package com.mygame.doudizhu;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;

public class PokerGame {
    //♠ ♣ ♥ ♦
    static ArrayList<String> list = new ArrayList<>();
    static HashMap<String, Integer> map = new HashMap<>();
    static{
        //准备牌
        String[] color = {"♠", "♣", "♥", "♦"};
        String[] number = {"3", "4", "5", "6", "7", "8", "9", "10", "J", "Q", "K", "A", "2"};

        //牌盒
        int count = 0;
        for (String num : number) {
            for (String c : color) {
                list.add(c + num);
            }
        }
        list.add("joker");
        list.add("JOKER");
        map.put("J", 11);
        map.put("Q", 12);
        map.put("K", 13);
        map.put("A", 14);
        map.put("2", 15);
        map.put("joker", 50);
        map.put("JOKER", 100);
    }
    public PokerGame() {
        //洗牌
        Collections.shuffle(list);

        //发牌
        ArrayList<String> lord = new ArrayList<>();
        ArrayList<String> p1 = new ArrayList<>();
        ArrayList<String> p2 = new ArrayList<>();
        ArrayList<String> p3 = new ArrayList<>();

        for (int i = 0; i < list.size(); i++) {
            if(i<3){
                lord.add(list.get(i));
            }
            else{
                if(i%3==0){
                    p1.add(list.get(i));
                }
                else if(i%3==1){
                    p2.add(list.get(i));
                }
                else if(i%3==2){
                    p3.add(list.get(i));
                }
            }
        }
        //给玩家洗牌
        pokerSort(lord);
        pokerSort(p1);
        pokerSort(p2);
        pokerSort(p3);

        //看牌
        lookPoker("底牌", lord);
        lookPoker("张三", p1);
        lookPoker("李四", p2);
        lookPoker("王五", p3);
    }

    public void lookPoker(String name, ArrayList<String> list){
        System.out.print(name+": ");
        for (String poker : list) {
            System.out.print(poker + " ");
        }
        System.out.println();
    }
    public void pokerSort(ArrayList<String> list){
        list.sort((o1, o2) -> getValue(o1) - getValue(o2));
    }
    public int getValue(String poker){
        String num;
        if(!poker.equals("JOKER")&&!poker.equals("joker")) {
            num = poker.substring(1);
        }
        else{
            num = poker;
        }
        if(map.containsKey(num)){
            return map.get(num);
        }
        else {
            return Integer.parseInt(num);
        }
    }
}
