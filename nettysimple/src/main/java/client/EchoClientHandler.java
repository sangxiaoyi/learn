package client;

import io.netty.buffer.ByteBuf;
import io.netty.buffer.Unpooled;
import io.netty.channel.ChannelHandler;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.SimpleChannelInboundHandler;
import io.netty.util.CharsetUtil;

/**
 * 实现客户端逻辑
 */
@ChannelHandler.Sharable
public class EchoClientHandler extends SimpleChannelInboundHandler<ByteBuf> {

    /**
     * 当从服务器接收到一条消息时被调用
     */
    @Override
    protected void channelRead0(ChannelHandlerContext channelHandlerContext, ByteBuf in) throws Exception {
        //记录已接收消息的转储
        System.out.println("Client received: "+ in.toString(CharsetUtil.UTF_8));
    }

    /**
     * 在服务器的连接已经建立之后将被调用
     */
    @Override
    public void channelActive(ChannelHandlerContext ctx){
        System.out.println("已经建立了连接了");
        //当被通知Channel是活跃的时候，发送一条消息
        ctx.writeAndFlush(Unpooled.copiedBuffer("hello server",CharsetUtil.UTF_8));
    }

    /**
     * 在处理过程中引发异常时调用
     */
    @Override
    public void exceptionCaught(ChannelHandlerContext ctx,Throwable cause){
        //在发生异常时，记录错误并关闭Channel
        cause.printStackTrace();
        ctx.close();
    }
}
