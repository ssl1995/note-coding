package 学习笔记.设计模式.行为型.责任链模式.handle;

import 学习笔记.设计模式.行为型.责任链模式.AddRequest;
import 学习笔记.设计模式.行为型.责任链模式.Request;

/**
 * @author SongShengLin
 * @date 2022/7/26 00:27
 * @description
 */
public class PMHandleRequest implements HandleRequest {

    private HandleRequest handleRequest;


    public PMHandleRequest(HandleRequest request) {
        this.handleRequest = request;
    }

    @Override
    public void handleRequest(Request request) {
        if (request instanceof AddRequest) {
            System.out.println("要加薪，项目经历审批");
        } else {
            handleRequest.handleRequest(request);
        }
    }
}
