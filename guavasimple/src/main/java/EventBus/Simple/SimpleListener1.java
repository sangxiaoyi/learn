package EventBus.Simple;

import com.google.common.eventbus.Subscribe;

/**
 * 创建Listener
 * @author
 * @Description
 * @date
 */
public class SimpleListener1 {
    @Subscribe
    public void doStringAction(final String event){
        System.out.println("SimpleListener1     doStringAction-》接收到的时间信息为"+event);
    }

    @Subscribe
    public void doIntAction(final int event){
        System.out.println("SimpleListener1     doIntAction-》接收到的时间信息为"+event);
    }
}
