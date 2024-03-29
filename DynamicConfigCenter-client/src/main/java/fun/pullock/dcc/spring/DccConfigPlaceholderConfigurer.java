package fun.pullock.dcc.spring;

import fun.pullock.dcc.listener.ConfigEvent;
import fun.pullock.dcc.listener.ConfigListener;
import fun.pullock.dcc.loader.ConfigLoaderDelegate;
import org.springframework.beans.BeansException;
import org.springframework.beans.PropertyValue;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;
import org.springframework.beans.factory.config.PropertyPlaceholderConfigurer;
import org.springframework.beans.factory.config.TypedStringValue;
import org.springframework.context.EnvironmentAware;
import org.springframework.core.env.Environment;

import java.lang.reflect.Field;
import java.util.*;

public class DccConfigPlaceholderConfigurer extends PropertyPlaceholderConfigurer implements EnvironmentAware, ConfigListener, InitializingBean {

    private String beanName;

    private BeanFactory beanFactory;

    private Environment environment;

    private static ConfigLoaderDelegate configLoaderDelegate = ConfigLoaderDelegate.getInstance();

    private static final Map<String, List<BeanField>> keyBeanFields = new HashMap<>();

    public void setBeanName(String beanName) {
        this.beanName = beanName;
    }

    @Override
    public void setBeanFactory(BeanFactory beanFactory) {
        this.beanFactory = beanFactory;
    }

    /**
     * 在Spring初始化Bean的时候，会调用此方法来返回占位符的实际值，
     * 这里先看下Environment中是否存在相关的值，
     * 再看Zookeeper中是否有相关值
     * @param placeholder
     * @param props
     * @return
     */
    @Override
    protected String resolvePlaceholder(String placeholder, Properties props) {
        if (environment.containsProperty(placeholder)) {
            return environment.getProperty(placeholder);
        }
        return configLoaderDelegate.get(placeholder);
    }

    /**
     * 这一步是在解析BeanDefinition的时候用来收集@Value注解的属性以及占位符
     * @param beanFactoryToProcess
     * @param properties
     * @throws BeansException
     */
    @Override
    protected void processProperties(ConfigurableListableBeanFactory beanFactoryToProcess, Properties properties) throws BeansException {
        String[] beanNames = beanFactoryToProcess.getBeanDefinitionNames();
        for (String curName : beanNames) {
            // Check that we're not parsing our own bean definition,
            // to avoid failing on unresolvable placeholders in properties file locations.
            if (!(curName.equals(this.beanName) && beanFactoryToProcess.equals(this.beanFactory))) {
                PropertyValue[] propertyValues = beanFactoryToProcess.getBeanDefinition(curName).getPropertyValues().getPropertyValues();
                for (PropertyValue propertyValue : propertyValues) {
                    Object originValue = propertyValue.getValue();
                    if (originValue instanceof TypedStringValue) {
                        String value = (String) propertyValue.getValue();
                        if (value.startsWith(DEFAULT_PLACEHOLDER_PREFIX) && value.endsWith(DEFAULT_PLACEHOLDER_SUFFIX)) {
                            // TODO
                        }
                    }
                }

                String beanClassName = beanFactoryToProcess.getBeanDefinition(curName).getBeanClassName();
                Class<?> clazz = null;
                if (beanClassName != null) {
                    try {
                        clazz = Class.forName(beanClassName);
                    } catch (ClassNotFoundException e) {
                        e.printStackTrace();
                    }
                }

                if (clazz != null) {
                    for (Field field : clazz.getDeclaredFields()) {
                        if (field.isAnnotationPresent(Value.class)) {
                            String annotationValue = field.getAnnotation(Value.class).value();
                            if (annotationValue.startsWith(DEFAULT_PLACEHOLDER_PREFIX) && annotationValue.endsWith(DEFAULT_PLACEHOLDER_SUFFIX)) {
                                String key = annotationValue.substring(2, annotationValue.length() - 1);
                                List<BeanField> beanFields = keyBeanFields.get(key);
                                if (beanFields == null) {
                                    beanFields = new ArrayList<>();
                                    keyBeanFields.put(key, beanFields);
                                }
                                beanFields.add(new BeanField(curName, field.getName()));

                            }
                        }
                    }
                }

                super.processProperties(beanFactoryToProcess, properties);
            }
        }
    }

    @Override
    public void setEnvironment(Environment environment) {
        this.environment = environment;
    }

    /**
     * Zookeeper的值变化之后，这里会收到通知，
     * 如果是之前收集到的占位符对应的Bean，使用反射动态改变对应值
     * @param configEvent
     */
    @Override
    public void configUpdate(ConfigEvent configEvent) {
        String key = configEvent.getKey();
        List<BeanField> beanFields = keyBeanFields.get(key);
        if (beanFields != null) {
            for (BeanField beanField : beanFields) {
                Object bean = beanFactory.getBean(beanField.getBeanName());
                Class<?> clazz = bean.getClass();
                try {
                    Field field = clazz.getDeclaredField(beanField.getFieldName());
                    field.setAccessible(true);
                    field.set(bean, configEvent.getValue());
                } catch (NoSuchFieldException | IllegalAccessException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    @Override
    public void afterPropertiesSet() throws Exception {
        configLoaderDelegate.addConfigListener(this);
    }
}
