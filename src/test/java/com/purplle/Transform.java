package com.purplle;

import java.lang.reflect.Constructor;
import java.lang.reflect.Method;

import org.testng.annotations.IAnnotation;
import org.testng.annotations.ITestAnnotation;
import org.testng.internal.annotations.IAnnotationFinder;
import org.testng.internal.annotations.IAnnotationTransformer;

public class Transform implements IAnnotationTransformer  {

	@Override
	public void transform(ITestAnnotation annotation, Class testClass, Constructor testConstructor, Method testMethod) {
		// TODO Auto-generated method stub
		annotation.setRetryAnalyzer(testClass);
	}

}
