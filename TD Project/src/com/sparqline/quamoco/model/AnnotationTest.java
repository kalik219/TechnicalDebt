package com.sparqline.quamoco.model;

public class AnnotationTest {

	public static void main(String[] args) {
		QualityModel qm1 = new QualityModel("Test");
		
		Annotation ann = Annotation.builder()
				.key("Test")
				.value("Something")
				.create();
		
		Tool tool = Tool.builder("FindBugs")
				.description("A free alternative to Parasoft")
				.annotation(ann)
				.create();
		
		qm1.addTool(tool);
		
		System.out.println("Tool ID: " + tool.getIdentifier());
	}

}
