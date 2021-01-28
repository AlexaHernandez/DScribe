package $package$;

import static org.junit.jupiter.api.Assertions.assertEquals;

import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.Test;

public class $class$Test { 
	
	@Template("assertBool")
    @Types($state$=EXPR, $bool$=EXPR, $factory$=EXPR, $params$=EXPR_LIST)
    @Test
    public void test_$method$_$state$() {
        assert$bool$($factory$.$method$($params$));
    }
	
}