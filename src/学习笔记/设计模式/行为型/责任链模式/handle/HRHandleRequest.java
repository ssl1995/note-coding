package 学习笔记.设计模式.行为型.责任链模式.handle;


import 学习笔记.设计模式.行为型.责任链模式.MissRequest;
import 学习笔记.设计模式.行为型.责任链模式.Request;

/**
 * @author SongShengLin
 * @date 2022/7/26 00:12
 * @description
 */
public class HRHandleRequest implements HandleRequest {


    @Override
    public void handleRequest(Request request) {
        if (request instanceof MissRequest) {
            System.out.println("要离职，人事审批！");
        }
        System.out.println("处理完毕");
    }
}
