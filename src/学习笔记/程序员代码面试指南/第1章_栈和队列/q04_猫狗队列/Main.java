package 学习笔记.程序员代码面试指南.第1章_栈和队列.q04_猫狗队列;

import java.util.LinkedList;
import java.util.Scanner;

/**
 * @author SongShengLin
 * @date 2022/1/9 4:22 PM
 * @description
 */
public class Main {


    public static void main(String[] args) {
        DogCatQueue dogCatQueue = new DogCatQueue();
        Scanner scanner = new Scanner(System.in);
        int num = scanner.nextInt();
        // 如果每次结果都输出，会因为多次IO操作超时，所以使用StringBuilder
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < num; i++) {
            String op = scanner.next();
            if ("add".equals(op)) {
                String pet = scanner.next();
                int count = scanner.nextInt();
                if ("cat".equals(pet)) {
                    dogCatQueue.add(new Cat(count));
                } else if ("dog".equals(pet)) {
                    dogCatQueue.add(new Dog(count));
                }
            } else if ("pollAll".equals(op)) {
                while (!dogCatQueue.isEmpty()) {
                    PetEnterPoJo petEnterPoJo = dogCatQueue.pollAll();
                    sb.append(petEnterPoJo.getPetType()).append(" ").append(petEnterPoJo.getPetNum()).append(System.lineSeparator());
                }
            } else if ("pollDog".equals(op)) {
                while (!dogCatQueue.isDogQueueEmpty()) {
                    PetEnterPoJo petEnterPoJo = dogCatQueue.pollDog();
                    sb.append(petEnterPoJo.getPetType()).append(" ").append(petEnterPoJo.getPetNum()).append(System.lineSeparator());
                }
            } else if ("pollCat".equals(op)) {
                while (!dogCatQueue.isCatQueueEmpty()) {
                    PetEnterPoJo petEnterPoJo = dogCatQueue.pollCat();
                    sb.append(petEnterPoJo.getPetType()).append(" ").append(petEnterPoJo.getPetNum()).append(System.lineSeparator());
                }
            } else if ("isEmpty".equals(op)) {
                sb.append(dogCatQueue.isEmpty() ? "yes" : "no").append(System.lineSeparator());
            } else if ("isDogEmpty".equals(op)) {
                sb.append(dogCatQueue.isDogQueueEmpty() ? "yes" : "no").append(System.lineSeparator());
            } else if ("isCatEmpty".equals(op)) {
                sb.append(dogCatQueue.isCatQueueEmpty() ? "yes" : "no").append(System.lineSeparator());
            }
        }
        scanner.close();
        System.out.println(sb);
    }
}

class DogCatQueue {
    private LinkedList<PetEnterPoJo> dogQueue;
    private LinkedList<PetEnterPoJo> catQueue;
    private long count;

    private final static String DOG = "dog";
    private final static String CAT = "cat";

    public DogCatQueue() {
        dogQueue = new LinkedList<>();
        catQueue = new LinkedList<>();
        count = 0;
    }

    public void add(Pet pet) {
        if (pet.getPetType().equals(CAT)) {
            catQueue.add(new PetEnterPoJo(pet, count++));
        } else if (pet.getPetType().equals(DOG)) {
            dogQueue.add(new PetEnterPoJo(pet, count++));
        } else {
            throw new RuntimeException("pet is error");
        }
    }

    public PetEnterPoJo pollAll() {
        if (!dogQueue.isEmpty() && !catQueue.isEmpty()) {
            if (dogQueue.peek().getCount() < catQueue.peek().getCount()) {
                return dogQueue.poll();
            } else {
                return catQueue.poll();
            }
        } else if (!dogQueue.isEmpty()) {
            return dogQueue.poll();
        } else if (!catQueue.isEmpty()) {
            return catQueue.poll();
        }
        throw new RuntimeException("DogCatQueue is error");
    }

    public PetEnterPoJo pollDog() {
        if (dogQueue.isEmpty()) {
            throw new RuntimeException("DogCatQueue is error");
        }
        return dogQueue.poll();
    }

    public PetEnterPoJo pollCat() {
        if (catQueue.isEmpty()) {
            throw new RuntimeException("DogCatQueue is error");
        }
        return catQueue.poll();
    }

    public boolean isEmpty() {
        return catQueue.isEmpty() && dogQueue.isEmpty();
    }

    public boolean isDogQueueEmpty() {
        return dogQueue.isEmpty();
    }

    public boolean isCatQueueEmpty() {
        return catQueue.isEmpty();
    }
}


class PetEnterPoJo {
    private Pet pet;
    private long count;

    public PetEnterPoJo(Pet pet, long count) {
        this.pet = pet;
        this.count = count;
    }

    public String getPetType() {
        return this.pet.getPetType();
    }

    public Pet getPet() {
        return this.pet;
    }

    public long getPetNum() {
        return this.pet.getPetNum();
    }

    public long getCount() {
        return this.count;
    }


}


/**
 * 条件：猫狗队列定义的类
 */
class Pet {
    private String type;
    /**
     * 根据题目输入，要存一个数字
     */
    private long num;

    public Pet(String type, long num) {
        this.type = type;
        this.num = num;
    }

    public String getPetType() {
        return this.type;
    }

    public long getPetNum() {
        return this.num;
    }
}

class Cat extends Pet {

    public Cat(long num) {
        super("cat", num);
    }
}

class Dog extends Pet {

    public Dog(long num) {
        super("dog", num);
    }
}

