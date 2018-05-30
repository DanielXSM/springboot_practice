package com.gupao.springbootjsp.controller;

import com.gupao.springbootjsp.entity.WiselyMessage;
import com.gupao.springbootjsp.entity.WiselyResponse;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.stereotype.Controller;

/**
 * @program: spring-boot-jsp
 * @description:WebSocket 得控制器
 * @author:Daniel.zhao
 * @create:2018-05-30 10:52
 **/
@Controller
public class WsController {
    /**
     * 当浏览器向服务端发送请求时，通过@MessageMapping映射/welcome这个地址，类似@RequestMapping，当服务端有消息存在时，会对订阅@
     * SendTo中路径的浏览器发送请求。接下来我们添加一个Jsp页面来配置WebSocket的JS使用方式。
     * @param wiselyMessage
     * @return
     * @throws Exception
     */
      @MessageMapping("/welcome")
      @SendTo("/topic/getResponse")
        public WiselyResponse say(WiselyMessage wiselyMessage) throws Exception{
        //等待三秒返回消息内容
        return new WiselyResponse("匿名信息："+wiselyMessage.getName());

    }
}
