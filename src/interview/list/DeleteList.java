package interview.list;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class DeleteList {
    public static void main(String[] args) {
        List<String> list = new ArrayList<String>() {{
            add("2");
            add("3");
            add("3");
            add("3");
            add("4");
        }};
        for (int i = 0; i < list.size(); i++) {
            if (list.get(i).equals("3")) {
                list.remove(i);
            }
        }
        // 没有删除干净，还剩一个3没有删除
        System.out.println(list);
    }
}
