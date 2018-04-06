/**
 * 
 */
package com.skc.doubleton;

import static java.lang.annotation.ElementType.TYPE;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

import java.lang.annotation.Documented;
import java.lang.annotation.Retention;
import java.lang.annotation.Target;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

/**
 * @author chaudhsi
 *
 */
@Documented
@Retention(RUNTIME)
@Target(TYPE)
@Component
@Scope("prototype")
public @interface Instance {
	int number() default 1;
}
