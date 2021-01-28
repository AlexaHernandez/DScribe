package ca.mcgill.cs.swevo.dscribe.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.METHOD)
public @interface AssertBool 
{
	public String state();
	public String bool();
	public String factory();
	public String[] params();
}

