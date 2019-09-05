package EventBus.Simple;

import com.google.common.eventbus.AllowConcurrentEvents;
import com.google.common.eventbus.Subscribe;

/**
 * @author
 * @Description
 * @date
 */
public class AysncListener {
    @Subscribe
    public void doAction(Integer msg){
        System.out.println("接收到的msg是："+msg);
    }
}
