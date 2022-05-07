package 学习笔记.面试学习.输入输出.字节流;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

/**
 * @author SongShengLin
 * @date 2022/4/10 20:07
 * @description
 */
public class FileOutputStreamDemo {

    private final static String PATH = "/Users/songshenglin/IdeaProjects/note-coding/src/面试记录/输入输出/字节流/test.txt";

    public static void main(String[] args) throws IOException {
        FileOutputStream fileOutputStream = new FileOutputStream(PATH, Boolean.TRUE);
        fileOutputStream.write('B');

        FileInputStream fileInputStream = new FileInputStream(PATH);
        byte[] bytes = new byte[1024];

        int read = fileInputStream.read(bytes);

        System.out.println(read);


    }
}
