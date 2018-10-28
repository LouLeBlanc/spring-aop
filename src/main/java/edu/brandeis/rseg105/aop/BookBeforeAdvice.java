/**
 * Written by Louis LeBlanc
 * For Homework Assignment 1
 * Expert Software Development in Java
 * Brandeis University
 * Instructed by Vitaly Yurik
 */
package edu.brandeis.rseg105.aop;

import java.lang.reflect.Method;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.aop.MethodBeforeAdvice;
import org.springframework.aop.framework.ProxyFactory;

/**
 * @author Louis LeBlanc
 *
 */
public class BookBeforeAdvice implements MethodBeforeAdvice {

	private static Logger logger = LoggerFactory.getLogger(BookBeforeAdvice.class);

	/**
	 * @param args
	 */
	public static void main(String[] args) {

		Book myBook = new Book((long) 1, "9780134685997", "Effective Java", (float) 54.99);

		ProxyFactory pf = new ProxyFactory();
		pf.addAdvice(new BookBeforeAdvice());
		pf.setTarget(myBook);

		Book proxy = (Book) pf.getProxy();

		proxy.reading();

	}

	@Override
	public void before(Method method, Object[] args, Object target) throws Throwable {
		logger.info("(Before '" + method.getName() + "', buy the book.)");
	}

}
