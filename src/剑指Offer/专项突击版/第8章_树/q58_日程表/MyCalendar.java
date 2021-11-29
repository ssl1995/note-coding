package 剑指Offer.专项突击版.第8章_树.q58_日程表;

import java.util.Map;
import java.util.TreeMap;

/**
 * @author SongShengLin
 * @date 2021/10/15 8:35 上午
 * @description
 */
public class MyCalendar {
    // 使用二叉搜索树，让查找效率保持为O(logN)
    private TreeMap<Integer, Integer> events;


    public MyCalendar() {
        events = new TreeMap<>();
    }

    public boolean book(int start, int end) {
        // floorEntry(start):找出<待插入开始时间的最晚区间
        Map.Entry<Integer, Integer> event = events.floorEntry(start);
        if (event != null && event.getValue() > start) {
            return false;
        }

        // ceilingEntry(start):找出>待插入开始时间的最早区间
        event = events.ceilingEntry(start);
        if (event != null && event.getKey() < end) {
            return false;
        }

        events.put(start, end);
        return true;
    }
}
