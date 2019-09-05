package client;

import io.netty.bootstrap.Bootstrap;
import io.netty.channel.ChannelFuture;
import io.netty.channel.ChannelInitializer;
import io.netty.channel.EventLoopGroup;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.SocketChannel;
import io.netty.channel.socket.nio.NioSocketChannel;

import java.net.InetSocketAddress;

/**
 * @author
 * @Description 引导客户端
 * @date
 */
public class EchoClient {
    private final String host;
    private final int port;

    public EchoClient(String host,int port) {
        this.host = host;
        this.port = port;
    }

    public void start() throws Exception{
        EventLoopGroup group = new NioEventLoopGroup();
        try{
            //创建bootstrap
            Bootstrap bootstrap = new Bootstrap();
            //指定EventLoopGroup用以处理客户端事件；需要适用于NIO的实现
            bootstrap.group(group)
                    //适用于NIO传输的Channel类型
                    .channel(NioSocketChannel.class)
                    //s设置服务器的InetSocketAddress
                    .remoteAddress(new InetSocketAddress(host,port))
                    //在创建Channel时，向ChannelPipeline中添加一个EchoClientHandler实例
                    .handler(new ChannelInitializer<SocketChannel>() {
                        @Override
                        protected void initChannel(SocketChannel socketChannel) throws Exception {
                            socketChannel.pipeline().addLast(new EchoClientHandler());
                        }
                    });
            //连接到远程节点，阻塞等待直到连接完成
            ChannelFuture future = bootstrap.connect().sync();
            //阻塞，直到Channel关闭
            future.channel().closeFuture().sync();
        }finally {
            //关闭线程池并释放所有的连接
            group.shutdownGracefully().sync();
        }
    }

    public static void main(String[] args) throws Exception {
        System.out.println("client start");
        new EchoClient("127.0.0.1",4321).start();
    }



}
