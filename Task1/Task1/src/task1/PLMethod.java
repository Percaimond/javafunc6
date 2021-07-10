package task1;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class PLMethod {

	private String name = null;
	// class that owns this method
	private PLClass parentClass = null;

	public PLMethod(String name) {
		super();
		this.name = name;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public PLClass getParentClass() {
		return parentClass;
	}

	public void setParentClass(PLClass parentClass) {
		this.parentClass = parentClass;
	}

	private List<String> getAncestors() {
		List<String> allAncestors = new ArrayList<String>();
		PLClass cClass = this.parentClass;
		while (cClass != null) {
			allAncestors.add(cClass.getName());
			cClass = cClass.getSuperClass();
		}
		return allAncestors;
	}

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		List<String> ancestors = getAncestors();
		Collections.reverse(ancestors);
		for (String ancestor : ancestors) {
			sb.append(ancestor + "~");
		}
		sb.append("PLMethod [name=" + name + "]");
		return sb.toString();
	}





}
