package com.cyw.TalkRobot.netty;

import io.netty.bootstrap.ServerBootstrap;
import io.netty.channel.ChannelFuture;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.nio.NioServerSocketChannel;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

/**
 * Netty 服务类
 */
@Slf4j
@Component
public class WebSocketServer implements ApplicationRunner {

    @Value("${netty.port}")
    private int nettyPort;

    @Override
    public void run(ApplicationArguments args) {
        //线程池组
        NioEventLoopGroup parentGroup = new NioEventLoopGroup();//主：用于接受客户端链接请求
        NioEventLoopGroup childGroup = new NioEventLoopGroup();//副：执行任务，用于处理客户端的I/O操作
        try {
            //服务启动类
            ServerBootstrap server = new ServerBootstrap();
            server.group(parentGroup, childGroup)//设置主从线程组
                    .channel(NioServerSocketChannel.class)//设置nio双向通道
                    .childHandler(new WSServerInitializer());//添加子处理器，用于处理从线程池的任务
            ChannelFuture channelFuture = server.bind(nettyPort).sync();
            log.info("Netty 服务已启动...");
            channelFuture.channel().closeFuture().sync();
        } catch (Exception e) {
            e.printStackTrace();
        }finally {
            parentGroup.shutdownGracefully();
            childGroup.shutdownGracefully();
            log.info("Netty 服务已启动...");
        }
    }
}
