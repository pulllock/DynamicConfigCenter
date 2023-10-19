package fun.pullock.dcc.spring;

public class BeanField {

    private String beanName;

    private String fieldName;

    public BeanField(String beanName, String fieldName) {
        this.beanName = beanName;
        this.fieldName = fieldName;
    }

    public String getBeanName() {
        return beanName;
    }

    public void setBeanName(String beanName) {
        this.beanName = beanName;
    }

    public String getFieldName() {
        return fieldName;
    }

    public void setFieldName(String fieldName) {
        this.fieldName = fieldName;
    }

    @Override
    public String toString() {
        return "BeanField{" +
                "beanName='" + beanName + '\'' +
                ", field='" + fieldName + '\'' +
                '}';
    }
}
