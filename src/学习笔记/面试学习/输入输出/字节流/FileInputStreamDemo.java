package 学习笔记.面试学习.输入输出.字节流;

import java.io.FileInputStream;
import java.io.IOException;

/**
 * @author SongShengLin
 * @date 2022/4/10 18:42
 * @description
 */
public class FileInputStreamDemo {

    private final static String PATH = "/Users/songshenglin/IdeaProjects/note-coding/src/面试记录/输入输出/字节流/test.txt";

    public static void main(String[] args) throws IOException {
        FileInputStream fileInputStream = new FileInputStream(PATH);
        byte[] b = new byte[1024];

        int read = fileInputStream.read(b);
        while (fileInputStream.read(b) != -1) {
            System.out.println(new String(b));
        }

        fileInputStream.close();

    }
}
