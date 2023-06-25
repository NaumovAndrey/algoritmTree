package org.example;

public class HashMap {
    static final int INIT_SIZE = 16;
    Basket[] baskets;

    public HashMap(int size) {
        baskets = new Basket[size];
    }

    public HashMap(){
        this(INIT_SIZE);
    }

    private int getIndex(int key){
        return (key % baskets.length + baskets.length) % baskets.length; // [0, length -1]
    }

    static class Entity{
        int key;
        int value;
    }

    static class Basket{
        Note head;
        static class Note{
            Entity entity;
            Note next;
        }
        private boolean push(Entity entity){
            Note node = new Note();
            node.entity = entity;

            if (head == null){
                head = node;
            }else {
                Note cur = head;
                while (cur != null){
                    if(cur.entity.key == entity.key){
                        return false;
                    }
                    if (cur.next == null){
                        cur.next = node;
                        return true;
                    }
                    cur = cur.next;
                }
            }
            return true;
        }

        private Integer find(int key){
            Note cur = head;
            while (cur != null){
                if(cur.entity.key == key){
                    return cur.entity.value;
                }
                cur = cur.next;
            }
            return null;
        }

        private boolean remove(int key){
            if (head != null) {
                if (head.entity.key == key) {
                    head = head.next;
                    return true;
                } else {
                    Note cur = head;
                    while (cur.next != null) {
                        if (cur.next.entity.key == key) {
                            cur.next = cur.next.next;
                            return true;
                        }
                        cur = cur.next;
                    }
                }
            }
            return false;
        }
    }


    //Добавление
    public boolean push(int key, int value){
        int index = getIndex(key);
        Basket basket = baskets[index];
        if (basket == null){
            basket = new Basket();
            baskets[index] = basket;
        }
        Entity entity = new Entity();
        entity.key = key;
        entity.value = value;
        return basket.push(entity);
    }

    //Поиск
    public Integer find(int key){
        int index = getIndex(key);
        Basket basket = baskets[index];
        if (basket != null){
            return basket.find(key);
        }
        return null;
    }

    //удаление
    public boolean remove(int key){
        int index = getIndex(key);
        Basket basket = baskets[index];
        if (basket != null){
            return basket.remove(key);
        }
        return false;
    }
}
