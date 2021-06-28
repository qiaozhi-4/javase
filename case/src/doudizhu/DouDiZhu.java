package doudizhu;

import java.util.ArrayList;
import java.util.Collections;

/*
斗地主综合案例:
    1.准备牌
    2.洗牌
    3.发牌
    4.看牌

 */
public class DouDiZhu {
    public static void main(String[] args) {
        //1.准备牌
        //定义一个存储54张牌的Arraylist集合,泛型使用String
        ArrayList<String> poker = new ArrayList<>();
        //先把大王和小王存储到poker集合中
        poker.add("大王");
        poker.add("小王");
        //定义两个数组,一个数组存储牌的花色,一个数组存储牌的序号
        String[] colors = {"♠","♥","♣","♦"};
        String[] numbers = {"2","A","K","Q","J","10","9","8","7","6","5","4","3"};
        for (String s : numbers) {
            for (String s1 : colors) {
                poker.add(s1 + s);
            }
        }
//        System.out.println(poker);

        /*
        2.洗牌
        使用集合的工具类collections中的方法
        static void shuffle(List<?> list）使用黑认随机源对指定列表进行置换。
         */
        Collections.shuffle(poker);//静态方法直接类名调用
//        System.out.println(poker);

        /*
        3.发牌
         */
        //定义4个集合,存储玩家的牌和底牌
        ArrayList<String> player1 = new ArrayList<>();
        ArrayList<String> player2 = new ArrayList<>();
        ArrayList<String> player3 = new ArrayList<>();
        ArrayList<String> diPai = new ArrayList<>();
        /*
        遍历poker集合,获取每一张牌
        使用poker集合的索引%3给3个玩家轮流发牌剩余张牌给底牌
        注意:
            先判断底牌(i>=51)，否则牌就发没了
         */
        for (int i = 0; i < poker.size(); i++) {
            //获取每一张牌
            String p = poker.get(i);
            if (i >= 51){
                //给底牌
                diPai.add(p);
            }else if (i%3 == 0){
                //给玩家1发牌
                player1.add(p);
            }else if (i%3 == 1){
                //给玩家2发牌
                player2.add(p);
            }else if (i%3 == 2){
                //给玩家3发牌
                player3.add(p);
            }

        }

        //4.看牌
        System.out.println("乔治" + player1);
        System.out.println("佩奇" + player2);
        System.out.println("杰瑞" + player3);
        System.out.println("底牌" + diPai);
    }
}
