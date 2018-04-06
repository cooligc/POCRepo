/**
 * 
 */
package com.skc.doubleton;

import java.lang.reflect.Field;
import java.util.Map;
import java.util.Set;

import org.reflections.Reflections;
import org.reflections.scanners.FieldAnnotationsScanner;
import org.reflections.scanners.MethodAnnotationsScanner;
import org.reflections.scanners.SubTypesScanner;
import org.reflections.scanners.TypeAnnotationsScanner;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Component;

/**
 * @author chaudhsi
 *
 */
@Component
public class MyAnnoHook implements InitializingBean,ApplicationContextAware {
	
	private ApplicationContext context;

	/* (non-Javadoc)
	 * @see org.springframework.beans.factory.InitializingBean#afterPropertiesSet()
	 */
	@Override
	public void afterPropertiesSet() throws Exception {
		
		Map<String,Object> metaMap = context.getBeansWithAnnotation(Instance.class);
		MyFactory factory = context.getBean(MyFactory.class);
		metaMap.forEach((K,V) ->{
			Instance instance = V.getClass().getDeclaredAnnotation(Instance.class);
			factory.createInstances(V.getClass(), instance.number());
		});
		factory.makeUnModifiable();
		
		Reflections reflections = new Reflections("com",new SubTypesScanner(),new FieldAnnotationsScanner(),new TypeAnnotationsScanner(), new MethodAnnotationsScanner());
		Set<Field> fieldAnnotations = reflections.getFieldsAnnotatedWith(InjectMe.class);
		fieldAnnotations.forEach(field -> {
			field.setAccessible(true);
			Class clazz = field.getType();
			Object object = factory.getInstance(clazz);
			Object obj = context.getBean(field.getDeclaringClass());
			try {
				field.set(obj, object);
			} catch (IllegalArgumentException | IllegalAccessException e) {
				e.printStackTrace();
			}
			field.setAccessible(false);
		});
		
		
		Set<Field> autowiredAnnotations = reflections.getFieldsAnnotatedWith(Autowired.class);
		autowiredAnnotations.forEach(field -> {
			Class clazz = field.getType();
			Object obj = factory.getInstance(clazz);
			if(obj != null) {
				throw new RuntimeException("@Instance Type annotation is not compitable with @Autowired . Use @InjectMe for dynamic injection.");
			}
		});
		
		
	}

	@Override
	public void setApplicationContext(ApplicationContext applicationContext)throws BeansException {
		this.context = applicationContext;
	}

}
