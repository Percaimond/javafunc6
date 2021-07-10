package task1;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

public class MethodBindingTest1 {

	private PLClass clzA = null;
	private PLClass clzB = null;
	private PLMethod methodFoo = null;
	private PLMethod methodFooParent = null;
	
	@Before
    public void setUp() {
        // hierarchy constructions
        this.clzA = new PLClass("A");
        this.clzB = new PLClass("B");
        clzB.setSuperClass(clzA);
        this.methodFoo = new PLMethod("foo");
        this.methodFooParent = new PLMethod("foo");
        clzA.addMethod(methodFooParent);
        clzB.addMethod(methodFoo);
        /*
		class A {
			void foo() {
		        print "A.foo";
		    }
		};
		
		class B : extends A {
		    void foo() {  
		        print "B.foo";
		    }
		};
		*/
    }
	
    @Test
    public void testMethodDynamicDifferentType() {
        PLObject x = new PLObject(clzA, clzA);
        PLMethod callee = x.bindMethodDynamically("foo");
        assertEquals(methodFooParent, callee);
    }

    @Test
    public void testMethodDynamicSameType() {
        PLObject y = new PLObject(clzB);
        PLMethod callee2 = y.bindMethodDynamically("foo");
        assertEquals(methodFoo, callee2);
    }
    
    @Test
    public void testMethodStaticMixed() {
        PLObject z = new PLObject(clzB, clzA);
        // declared type is A, dynamic type is B
        //  i.e., A z = new B()
        PLMethod callee3 = z.bindMethodStatically("foo");
        assertEquals(methodFooParent,callee3);
    } 
    
    @Test
    public void testMethodDynamicMixed() {
        PLObject z = new PLObject(clzB, clzA);
        // declared type is A, dynamic type is B
        //  i.e., A z = new B()
        PLMethod callee3 = z.bindMethodDynamically("foo");
        assertEquals(methodFoo, callee3);
    }

}
