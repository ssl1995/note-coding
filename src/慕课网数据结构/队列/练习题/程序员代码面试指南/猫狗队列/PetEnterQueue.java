package 慕课网数据结构.队列.练习题.程序员代码面试指南.猫狗队列;

public class PetEnterQueue {
    private Pet pet;
    private long count;

    public PetEnterQueue(Pet pet, long count) {
        this.pet = pet;
        this.count = count;
    }

    public Pet getPet() {
        return this.pet;
    }

    public long getCount() {
        return this.count;
    }

    public String getPetType() {
        return this.pet.getType();
    }
}
