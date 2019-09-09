package rpc.test;

import rpc.server.RpcExporter;
import rpc.client.RpcImporter;
import rpc.server.EchoService;
import rpc.server.EchoServiceImpl;

import java.io.IOException;
import java.net.InetSocketAddress;

/**
 * @author
 * @Description
 * @date
 */
public class TestRpc {
    public static void main(String[] args){
        //创建异步发布服务端的线程并启动，用于接收RPC客户端的请求，根据请求参数调用服务实现类，返回结果给客户端
        new Thread(new Runnable() {
            public void run() {
                try {
                    RpcExporter.exporter("localhost",8080);
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }).start();
        //创建客户端服务代理类，构造RPC请求参数，发起RPC调用
        RpcImporter<EchoService> importer = new RpcImporter<EchoService>();
        EchoService echoService = importer.importer(EchoServiceImpl.class,new InetSocketAddress("localhost",8080));
        System.out.println("客户端接收到应答数据");
        System.out.println(echoService.echo("Are u ok?"));
    }
}
