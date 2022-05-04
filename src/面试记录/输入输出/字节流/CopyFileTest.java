package 面试记录.输入输出.字节流;

import java.io.*;

/**
 * @author SongShengLin
 * @date 2022/4/10 20:12
 * @description
 */
public class CopyFileTest {

    private final static String PATH1 = "/Users/songshenglin/IdeaProjects/note-coding/src/面试记录/输入输出/字节流/test.txt";
    private final static String PATH2 = "/Users/songshenglin/IdeaProjects/note-coding/src/面试记录/输入输出/字节流/copy.txt";


    public static void main(String[] args) {
        try {
            FileInputStream fis = new FileInputStream(PATH1);
            BufferedInputStream bis = new BufferedInputStream(fis);

            FileOutputStream fos = new FileOutputStream(PATH2, Boolean.TRUE);
            BufferedOutputStream bos = new BufferedOutputStream(fos);

            int n = 0;
            byte[] b = new byte[1024];
            while ((n = bis.read(b)) != -1) {
                // 写b，长度为[0,n]
                bos.write(b, 0, n);

                // 缓冲去写入
                bos.flush();
            }
            bis.close();
            bos.close();

            fis.close();
            fos.close();


        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
