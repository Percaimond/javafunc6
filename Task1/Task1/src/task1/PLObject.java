package task1;

public class PLObject {

	private PLClass dynamicType = null;
	private PLClass staticType = null;

	public PLObject(PLClass dynamicAndStaticType) {
		super();
		this.dynamicType = dynamicAndStaticType;
		this.staticType = dynamicAndStaticType;
	}

	public PLObject(PLClass dynamicType, PLClass staticType) {
		super();
		this.dynamicType = dynamicType;
		this.staticType = staticType;
	}

	public PLMethod bindMethodDynamically(String methodNameToCall) {
		// STUDENT SOLUTION
		// RESOLVE THE METHOD BASED ON THE DYNAMIC TYPE OF THIS OBJECT
		//this.dynamicType;
		/*PLMethod dynamicMethod1 = new PLMethod(methodNameToCall);
		String ok = dynamicMethod1.getParentClass().toString();
		System.out.println(ok);
		PLMethod obj = new PLMethod("foo");
		return dynamicMethod1;*/
		return  null;
	}

	public PLMethod bindMethodStatically(String methodNameToCall) {
		// STUDENT SOLUTION
		// RESOLVE THE METHOD BASED SOLELY ON THE STATIC TYPE OF THIS OBJECT
		//needs the first
		PLClass foo = null;
		//A~B.PLMethod obj = new PLMethod("foo");
		return null;
	}

}
