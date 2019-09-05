package server;

import io.netty.buffer.ByteBuf;
import io.netty.buffer.Unpooled;
import io.netty.channel.ChannelFutureListener;
import io.netty.channel.ChannelHandler;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelInboundHandlerAdapter;
import io.netty.util.CharsetUtil;

/**
 * @author
 * @Description
 * @date
 */
//标记一个ChannelHandler可以被多个Channel安全的共享
@ChannelHandler.Sharable
public class EchoServerHandler extends ChannelInboundHandlerAdapter {

    /**
     * 对于每个传入的消息都要调用
     * @param ctx
     * @param msg
     */
    @Override
    public void channelRead(ChannelHandlerContext ctx ,Object msg){
        ByteBuf in = (ByteBuf) msg;
        System.out.println("server received:"+in.toString(CharsetUtil.UTF_8));
        ctx.write(Unpooled.copiedBuffer("hello client,this is server",CharsetUtil.UTF_8));
    }

    /**
     * 通知ChannelInboundHandler最后一次对channelRead()的调用是当前批量读取中的最后一条消息
     * @param ctx
     * @throws Exception
     */
    @Override
    public void channelReadComplete(ChannelHandlerContext ctx)throws Exception{
        //将未决消息冲刷到远程节点，并且关闭该Channel.
        ctx.writeAndFlush(Unpooled.copiedBuffer("server is done",CharsetUtil.UTF_8))
                .addListener(ChannelFutureListener.CLOSE);
    }

    /**
     * 在读取操作期间，有异常抛出时会调用
     * @param ctx
     * @param cause
     */
    @Override
    public void exceptionCaught(ChannelHandlerContext ctx,Throwable cause){
        //打印异常栈追踪
        cause.printStackTrace();
        //关闭该channel
        ctx.close();
    }
}
