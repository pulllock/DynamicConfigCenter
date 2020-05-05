package me.cxis.dcc.spring;

import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.beans.factory.config.BeanDefinitionHolder;
import org.springframework.beans.factory.support.BeanDefinitionReaderUtils;
import org.springframework.beans.factory.support.GenericBeanDefinition;
import org.springframework.beans.factory.xml.BeanDefinitionParser;
import org.springframework.beans.factory.xml.ParserContext;
import org.w3c.dom.Element;

public class DccConfigDefinitionParser implements BeanDefinitionParser {

    @Override
    public BeanDefinition parse(Element element, ParserContext parserContext) {
        GenericBeanDefinition beanDefinition = new GenericBeanDefinition();
        beanDefinition.setBeanClass(DccConfigPlaceholderConfigurer.class);

        BeanDefinitionHolder beanDefinitionHolder = new BeanDefinitionHolder(beanDefinition, "dcc-config");
        BeanDefinitionReaderUtils.registerBeanDefinition(beanDefinitionHolder, parserContext.getRegistry());
        return beanDefinition;
    }
}
