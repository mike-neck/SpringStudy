package orz.mikeneck.spring.study.first.aop;

/**
 * Created by IntelliJ IDEA.
 * Account: mike
 * Date: 11/09/10
 * Time: 15:52
 * To change this template use File | Settings | File Templates.
 */
public class MessageBeanImpl implements MessageBean {
    private String name;

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    @Override
    public MessageBean name(String name) {
        setName(name);
        return this;
    }

    @Override
    public String say() {
        try {
            Thread.sleep(5 * 1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return name;
    }
}
