package 学习笔记.设计模式.行为型.责任链模式;

import 学习笔记.设计模式.行为型.责任链模式.handle.HRHandleRequest;
import 学习笔记.设计模式.行为型.责任链模式.handle.HandleRequest;
import 学习笔记.设计模式.行为型.责任链模式.handle.PMHandleRequest;
import 学习笔记.设计模式.行为型.责任链模式.handle.TLHandleRequest;

/**
 * @author SongShengLin
 * @date 2022/7/26 00:31
 * @description
 */
public class Test {

    /**
     * 责任链模式
     */
    public static void main(String[] args) {
        HandleRequest hr = new HRHandleRequest();
        HandleRequest pm = new PMHandleRequest(hr);
        HandleRequest tl = new TLHandleRequest(pm);

        System.out.println("----");
        Request request = new Request();
        tl.handleRequest(request);
        System.out.println("----");

        request = new AddRequest();
        tl.handleRequest(request);
        System.out.println("----");

        request = new MissRequest();
        pm.handleRequest(request);

    }
}
