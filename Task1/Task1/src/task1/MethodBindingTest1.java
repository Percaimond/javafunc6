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
        this.clzA = new PLClass("A");//new class name "A"
        this.clzB = new PLClass("B");//new class name "B"
        clzB.setSuperClass(clzA);//sets clzA as superclass to clzB
        this.methodFoo = new PLMethod("foo");//new method of name "foo"
        this.methodFooParent = new PLMethod("foo");//new method of name "foo"
        clzA.addMethod(methodFooParent);//adds methoFooParent as a method to clzA
        clzB.addMethod(methodFoo);//adds methoFoo as a method to clzA
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

    @Test
    public void testMethodStaticDifferentType() {//nicht richtig
        PLObject x = new PLObject(clzB, clzA);
        PLMethod callee = x.bindMethodDynamically("foo");
        assertEquals(methodFooParent, callee);
    }

    @Test
    public void testMethodStaticSameType() {//nicht richtig
        PLObject y = new PLObject(clzB, clzB);
        PLMethod callee2 = y.bindMethodDynamically("foo");
        assertEquals(methodFoo, callee2);
    }

}
