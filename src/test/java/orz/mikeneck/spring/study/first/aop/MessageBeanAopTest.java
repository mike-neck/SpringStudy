package orz.mikeneck.spring.study.first.aop;

import org.junit.Test;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.xml.XmlBeanFactory;
import org.springframework.core.io.FileSystemResource;

/**
 * Created by IntelliJ IDEA.
 * Account: mike
 * Date: 11/09/10
 * Time: 16:43
 * To change this template use File | Settings | File Templates.
 */
public class MessageBeanAopTest {

    private static final String CONTEXT_XML = "src/main/resources/first/aop/forthBeans.xml";

    @Test
    public void testSay() {
        BeanFactory factory = new XmlBeanFactory(new FileSystemResource(CONTEXT_XML));
        MessageBean bean = (MessageBean) factory.getBean("proxy");

        System.out.println(bean.say());
    }
}
