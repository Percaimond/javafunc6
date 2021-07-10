package task1;

import java.util.ArrayList;
import java.util.List;

public class PLClass {
	
	private String name = null;
	private PLClass superClass = null;
	private List<PLMethod> methods = null;

	public PLClass(String name) {
		super();
		this.name = name;
		this.methods = new ArrayList<PLMethod>();
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public PLClass getSuperClass() {
		return superClass;
	}

	public void setSuperClass(PLClass superClass) {
		this.superClass = superClass;
	} 
	
	public void addMethod(PLMethod toAddMethod) {
		// insert in the class a reference to the object
		this.methods.add(toAddMethod);
		// insert in the method a reference to the parent class
		toAddMethod.setParentClass(this);
	}

	public List<PLMethod> getMethods() {
		return methods;
	}
	

}
