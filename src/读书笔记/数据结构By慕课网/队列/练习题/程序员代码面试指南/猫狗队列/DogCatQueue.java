package 读书笔记.数据结构By慕课网.队列.练习题.程序员代码面试指南.猫狗队列;

import java.util.LinkedList;

public class DogCatQueue {
    private LinkedList<PetEnterQueue> dogQueue;
    private LinkedList<PetEnterQueue> catQueue;
    private long count;

    public DogCatQueue() {
        dogQueue = new LinkedList<>();
        catQueue = new LinkedList<>();
    }


    public void add(Pet pet) {
        if (pet.getType().equals("dog")) {
            dogQueue.add(new PetEnterQueue(pet, count++));
        } else if (pet.getType().equals("cat")) {
            catQueue.add(new PetEnterQueue(pet, count++));
        } else {
            throw new RuntimeException("Error:not Dog or Cat!");
        }
    }

    public Pet pollAll() {
        if (!dogQueue.isEmpty() && !catQueue.isEmpty()) {
            if (dogQueue.peek().getCount() < catQueue.peek().getCount()) {
                return dogQueue.poll().getPet();
            } else {
                return catQueue.poll().getPet();
            }
        } else if (!dogQueue.isEmpty()) {
            return dogQueue.poll().getPet();
        } else if (!catQueue.isEmpty()) {
            return catQueue.poll().getPet();
        } else {
            throw new RuntimeException("Error:queue is empty");
        }
    }

    public Pet pollDog() {
        if (!this.isDogQueueEmpty()) {
            return (Dog) this.dogQueue.poll().getPet();
        } else {
            throw new RuntimeException("Dog queue is empty!");
        }
    }

    public Cat pollCat() {
        if (!this.isCatQueueEmpty()) {
            return (Cat) this.catQueue.poll().getPet();
        } else {
            throw new RuntimeException("Cat queue is empty!");
        }
    }


    public boolean isEmpty() {
        return dogQueue.isEmpty() && catQueue.isEmpty();
    }

    public boolean isDogQueueEmpty() {
        return dogQueue.isEmpty();
    }

    public boolean isCatQueueEmpty() {
        return catQueue.isEmpty();
    }
}
