package com.cyw.TalkRobot.netty;

import com.cyw.TalkRobot.service.TalkService;
import com.cyw.TalkRobot.util.SpringUtil;
import io.netty.channel.Channel;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.SimpleChannelInboundHandler;
import io.netty.channel.group.ChannelGroup;
import io.netty.channel.group.DefaultChannelGroup;
import io.netty.handler.codec.http.websocketx.TextWebSocketFrame;
import io.netty.util.concurrent.GlobalEventExecutor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.util.ObjectUtils;

/**
 * 用于处理消息的handler
 * 由于他的传输数据的载体是frame，这个frame在netty中，是用于为websocket专门处理文本对象的，frame是消息的载体，此类叫TextWebSocketFrame
 */
@Slf4j
public class ChatHandler extends SimpleChannelInboundHandler<TextWebSocketFrame> {

    private TalkService talkService;

    //所有正在连接的channel都会存在这里面，所以也可以间接代表在线的客户端
    public static ChannelGroup channelGroup = new DefaultChannelGroup(GlobalEventExecutor.INSTANCE);

    @Override
    protected void channelRead0(ChannelHandlerContext ctx, TextWebSocketFrame msg) throws Exception {
        //获取客户端所传输的消息
        String content = msg.text();
        if (ObjectUtils.isEmpty(talkService)) {
            talkService = SpringUtil.getBean(TalkService.class);
        }
        String say = talkService.say(content);
        Channel channel = ctx.channel();
        TextWebSocketFrame helloNetty = new TextWebSocketFrame(say);
        channel.writeAndFlush(helloNetty);
        //1.获取客户端发来的消息
        //2.判断消息类型，根据不同的类型来处理不同的业务
        /**
         * 2.1 当websocket第一次open的时候，初始化channel，把用的channel和userId关联起来
         * 2.2 聊天类型的消息，把聊天记录保存到数据库，同时标记消息的签收状态【未签收】
         * 2.3 签收消息类型，针对具体的消息进行签收，针对具体的消息进行签收，修改数据库中对应消息的签收状态【已签收】
         * 2.4 心跳类型的消息
         */
    }

    @Override
    public void handlerRemoved(ChannelHandlerContext ctx) throws Exception {
        Channel channel = ctx.channel();
        System.out.println("关闭渠道" + channel.id());
        channelGroup.remove(ctx.channel());
    }

    @Override
    public void handlerAdded(ChannelHandlerContext ctx) throws Exception {
        Channel channel = ctx.channel();
        System.out.println("建立渠道" + channel.id());
        Channel findChannel = channelGroup.find(channel.id());
        if (ObjectUtils.isEmpty(findChannel)) {
            channelGroup.add(ctx.channel());
        }
    }

    @Override
    public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause) throws Exception {
        Channel channel = ctx.channel();
        System.out.println("发生异常，关闭渠道" + channel.id());
        channelGroup.remove(ctx.channel());
    }
}
