package orz.mikeneck.spring.study.first.aspect;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;

/**
 * Created by IntelliJ IDEA.
 * Account: mike
 * Date: 11/09/10
 * Time: 18:20
 * To change this template use File | Settings | File Templates.
 */
public class MessageBeanAspectWithAnnotationTest {

    @Test
    public void testSay() {
        ApplicationContext context =
                new FileSystemXmlApplicationContext("src/main/resources/first/aspect/fifthWithAnnotation.xml");
        MessageBean bean = (MessageBean) context.getBean("fifthTargetWithAnnotation");

        System.out.println(bean.say());
    }

}
