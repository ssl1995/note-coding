package 学习笔记.设计模式.行为型.责任链模式.handle;

import 学习笔记.设计模式.行为型.责任链模式.LeaveRequest;
import 学习笔记.设计模式.行为型.责任链模式.Request;

/**
 * @author SongShengLin
 * @date 2022/7/26 00:28
 * @description
 */
public class TLHandleRequest implements HandleRequest {

    private HandleRequest handleRequest;

    public TLHandleRequest(HandleRequest handleRequest) {
        this.handleRequest = handleRequest;
    }


    @Override
    public void handleRequest(Request request) {
        if (request instanceof LeaveRequest) {
            System.out.println("要请假,项目组长审批！");
        } else {
            handleRequest.handleRequest(request);
        }
    }
}
