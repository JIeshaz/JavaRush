package com.javarush.task.task05.task0505;

/* 
Кошачья бойня
*/

public class Solution {
    public static void main(String[] args) {
        Cat cat1 = new Cat("Muzrik",2,4,6);
        Cat cat2 = new Cat("Pushok", 4, 5, 5);
        Cat cat3 = new Cat("Shezhok",3, 3,6);
        boolean result = cat1.fight(cat2);
        if (result)
            System.out.println(cat1+" побеждает");
        else System.out.println(cat2+" побеждает");
        result = cat2.fight(cat3);
        if (result)
            System.out.println(cat2+" побеждает");
        else System.out.println(cat3+" побеждает");
        result = cat3.fight(cat1);
        if (result)
            System.out.println(cat3+" побеждает");
        else System.out.println(cat1+" побеждает");
    }

    public static class Cat {
        protected String name;
        protected int age;
        protected int weight;
        protected int strength;

        public Cat(String name, int age, int weight, int strength) {
            this.name = name;
            this.age = age;
            this.weight = weight;
            this.strength = strength;
        }

        public boolean fight(Cat anotherCat) {
            int ageAdvantage = this.age > anotherCat.age ? 1 : 0;
            int weightAdvantage = this.weight > anotherCat.weight ? 1 : 0;
            int strengthAdvantage = this.strength > anotherCat.strength ? 1 : 0;

            int score = ageAdvantage + weightAdvantage + strengthAdvantage;
            return score > 2; // return score > 2 ? true : false;
        }
    }
}
