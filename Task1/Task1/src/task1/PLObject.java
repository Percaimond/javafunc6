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

	public PLMethod bindMethodDynamically(String methodNameToCall) {//kommt ohne argument aus weil nur eine methode wenn mehrer muss man suchen welche klasse diese methode hat
		System.out.println(this.staticType.getMethods().get(0).toString());
		System.out.println(this.dynamicType.getMethods().get(0).toString());
		//if(this.dynamicType.getSuperClass() == null){
		if(this.staticType != this.dynamicType){
			if(this.dynamicType.getSuperClass() == null){
				//return this.staticType.getMethods().get(0);
				return this.dynamicType.getMethods().get(0);
			} else {
				return this.staticType.getMethods().get(0);//wenn das nicht kommentiert ist ist dynamicmixed richtig aber static different falsche
				//return this.dynamicType.getMethods().get(0);//hier genau anders rum
			}
		} else{
			return this.dynamicType.getMethods().get(0);
		}
	}

	public PLMethod bindMethodStatically(String methodNameToCall) {//erklärung bei bindMethodDynamically
		System.out.println(this.staticType.getMethods().get(0).toString());
			return this.staticType.getMethods().get(0);
		}
	}


