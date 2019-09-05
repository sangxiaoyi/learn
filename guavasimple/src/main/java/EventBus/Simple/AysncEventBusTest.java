package EventBus.Simple;

import com.google.common.eventbus.AsyncEventBus;
import org.junit.Test;

import java.util.concurrent.Executors;

/**
 * @author
 * @Description
 * @date
 */
public class AysncEventBusTest {
    @Test
    public void testAysncEvent(){
        AsyncEventBus eventBus = new AsyncEventBus(Executors.newFixedThreadPool(3));
        eventBus.register(new AysncListener());
        for(int i=0;i<100;i++){
            eventBus.post(i);
        }
        System.out.println("==============DONE==================");
    }

}
