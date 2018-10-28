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
import org.springframework.aop.ThrowsAdvice;
import org.springframework.aop.framework.ProxyFactory;

/**
 * @author Louis LeBlanc
 *
 */
public class BookThrowsAdvice implements ThrowsAdvice {

	private static Logger logger = LoggerFactory.getLogger(BookThrowsAdvice.class);

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Book myBook = new Book((long) 1, "9780134685997", "Effective Java", (float) 54.99);

		ProxyFactory pf = new ProxyFactory();
		pf.addAdvice(new BookThrowsAdvice());
		pf.setTarget(myBook);

		Book proxy = (Book) pf.getProxy();

		try {
			proxy.throwException();
		} catch (Exception ignored) {

		}

	}

	public void afterThrowing(Method method, Object[] args, Object target, Exception ex) {
		logger.info("(***)");
		logger.info("(Runtime Exception Captured)");
		logger.info("(Caught: " + ex.getClass().getName() + ")");
		logger.info("(Method: " + method.getName() + ")");
		System.out.print("***\n");
	}

}
