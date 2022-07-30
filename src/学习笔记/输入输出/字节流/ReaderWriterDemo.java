package 学习笔记.输入输出.字节流;

import java.io.*;
import java.nio.charset.StandardCharsets;

/**
 * @author SongShengLin
 * @date 2022/4/10 20:12
 * @description
 */
public class ReaderWriterDemo {

    private final static String PATH1 = "/Users/songshenglin/IdeaProjects/note-coding/src/面试记录/输入输出/字节流/test.txt";
    private final static String PATH2 = "/Users/songshenglin/IdeaProjects/note-coding/src/面试记录/输入输出/字节流/copy.txt";


    public static void main(String[] args) {
        try {
            FileInputStream fis = new FileInputStream(PATH1);
            InputStreamReader isr = new InputStreamReader(fis, StandardCharsets.UTF_8);
            BufferedReader br = new BufferedReader(isr);


            FileOutputStream fos = new FileOutputStream(PATH2, Boolean.TRUE);
            OutputStreamWriter osw = new OutputStreamWriter(fos, StandardCharsets.UTF_8);
            BufferedWriter bw = new BufferedWriter(osw);

            int n = 0;
            char[] c = new char[1024];
            while ((n = br.read(c)) != -1) {
                bw.write(c, 0, n);
                bw.flush();
            }

            isr.close();
            osw.close();

            fis.close();
            fos.close();


        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
