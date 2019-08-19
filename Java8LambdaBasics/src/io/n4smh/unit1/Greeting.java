package io.n4smh.unit1;

/***
 * FunctionalInterface annotation
 * 
 * It restricts the interface to be functional interface so that only one method
 * signature is allowed in it.
 * 
 * It's optional but recommended 
 * 
 */

@FunctionalInterface
public interface Greeting {

	public void perform();
}
