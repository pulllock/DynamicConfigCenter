package fun.pullock.dcc.spring;

import org.springframework.context.annotation.Import;

import java.lang.annotation.*;

@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
@Documented
@Import(DccConfigRegistrar.class)
public @interface EnableDCC {
}
