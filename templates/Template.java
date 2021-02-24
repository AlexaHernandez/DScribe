package $package$;

import static org.junit.jupiter.api.Assertions.assertEquals;

import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.Test;

public class $class$Test { 
	
	// Use for Singleton and Flyweight
	Template("NoPublicConstructor")
	public void testSingleton_NoPublicConstructors()
	{
		Constructor<?>[] publicConstructors = $class$.class.getConstructors();  // No input needed 
		assertEquals(0, publicConstructors.length);
	}
	
	@Template("SingletonInstance")
	public void testSingleton_OneInstance()
	{
		$class$ instance1 = $class$.$factory$(); // It would be nice to have default values (e.g., default factor is instance()) 
		$class$ instance2 = $class$.$factory$(); 
		assertSame(instance1, instance2);
	}
	
	@Template("Clone")
   	 public void testClone() 
	{
		$class$ initial = $factory$;  // Here the challenge is initializing an object with default values 
		$class$ cloned = initial.clone();
		assertNotSame(initial, cloned);
		assertEquals(initial.getClass(), cloned.getClass());
		assertEquals(initial, cloned);
   	}
	
	@Template("FlyweightUniqueness")
	public void testFlyweight_UniqueObjects() 
	{
		$class$ flyweightObj1 = $class$.$factory$($params$); // Challenge is generating params and identifying factory (access method)
		$class$ flyweightObj2 = $class$.$factory$($params$); 
		assertSame(flyweightObj1, flyweightObj1);
	}
	
	@Template("FlyweightUpdateStores")
	public void testFlyweight_UpdatesStore() 
	{
		Field storeField = Direction.class.getDeclaredField($storeName$);  // Challenge 1) determine store name; 2) determine factory, 3) determine default params for factory
		storeField.setAccessible(true);
		storeField.set(null, new HashMap<>());
		$class$ flyweightObj = $class$.$factory$($params$);
		Map<?, ?> store = storeField.get(null);
		assert(store.containsValue(flyweightObj)); 
	}
}
