package 程序员代码面试指南.第1章_栈和队列.猫狗队列;

/**
 * 新建一个类，不修改条件原定的类，将不同实例盖上时间戳count
 */
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

    public String getEnterPetType() {
        return this.pet.getPetType();
    }
}
