package fun.pullock.dcc.spring;

import org.springframework.beans.factory.xml.NamespaceHandlerSupport;

public class DccConfigNamespaceHandler extends NamespaceHandlerSupport {

    @Override
    public void init() {
        registerBeanDefinitionParser("config", new DccConfigDefinitionParser());
    }
}
