package EventBus.Simple;

import com.google.common.eventbus.Subscribe;

import java.util.logging.Logger;

/**
 * 创建Listener
 * @author
 * @Description
 * @date
 */
public class SimpleListener {
    @Subscribe
    public void doStringAction(final String event){
        System.out.println("SimpleListener     doStringAction-》接收到的时间信息为"+event);
    }

    @Subscribe
    public void doIntAction(final Integer event){//注意，这里如果参数改为int，则接收不到消息
        System.out.println("SimpleListener     doIntAction-》接收到的时间信息为"+event);
    }
}
