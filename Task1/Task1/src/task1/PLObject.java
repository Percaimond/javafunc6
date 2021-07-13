package task1;

import java.util.ArrayList;

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
		if(this.dynamicType.getSuperClass() != null){
		return this.dynamicType.getMethods().get(0);
		} else{
		return	this.staticType.getMethods().get(0);
		}
	}

	public PLMethod bindMethodStatically(String methodNameToCall) {
		String ok = this.dynamicType.toString();
		String ok2 = this.staticType.toString();
		System.out.println(ok);
		System.out.println(ok2);
		return this.staticType.getMethods().get(0);
	}

}
