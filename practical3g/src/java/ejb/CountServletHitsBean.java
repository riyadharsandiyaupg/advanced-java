package ejb;
import javax.ejb.Singleton;
@Singleton
public class CountServletHitsBean {
    private int count;
    public synchronized int incrementAndGetHitCount(){
        return count++;
    }
}
