package EventBus.Simple;

import com.google.common.eventbus.EventBus;

/**
 * 定义一个EventBus，将Listener类进行注册，通过post方法即可向其发送消息
 * @author
 * @Description
 * @date
 */
public class SimpleEventBusTest {

    public static void main(String[] args){
        final EventBus eventBus = new EventBus();
        //注册Listener
        eventBus.register(new SimpleListener());
        eventBus.register(new SimpleListener1());

        //向订阅者发送消息
        eventBus.post("event data");
        eventBus.post(123456);
    }
}
