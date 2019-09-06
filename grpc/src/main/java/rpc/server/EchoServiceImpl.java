package rpc.server;

/**
 * @author
 * @Description
 * @date
 */
public class EchoServiceImpl implements EchoService{

    public String echo(String ping) {
        System.out.println("执行客户端socket的请求");
        return ping !=null?ping+"--->I am ok":"I am bad";
    }
}
