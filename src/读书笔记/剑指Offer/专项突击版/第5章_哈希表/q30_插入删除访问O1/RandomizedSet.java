package 读书笔记.剑指Offer.专项突击版.第5章_哈希表.q30_插入删除访问O1;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Random;

/**
 * @author SongShengLin
 * @date 2021/9/30 9:40 上午
 * @description
 */
public class RandomizedSet {

    private HashMap<Integer, Integer> map;
    private ArrayList<Integer> nums;


    public RandomizedSet() {
        map = new HashMap<>();
        nums = new ArrayList<>();
    }

    // 如果不包含，才添加
    public boolean insert(int val) {
        if (map.containsKey(val)) {
            return false;
        }
        map.put(val, nums.size());
        nums.add(val);
        return true;
    }

    // 如果包含，才删除
    public boolean remove(int val) {
        if (!map.containsKey(val)) {
            return false;
        }
        // map不要直接删除，最好是把数组末尾元数坐标替换成待删除pos
        int pos = map.get(val);
        map.put(nums.get(nums.size() - 1), pos);
        map.remove(val);

        // nums不要直接删除pos位置上元素，与末尾元数交换后再删除，避免移动其他元素
        nums.set(pos, nums.get(nums.size() - 1));
        nums.remove(nums.size() - 1);
        return true;
    }


    public int getRandom() {
        Random random = new Random();
        return nums.get(random.nextInt(nums.size()));
    }
}
