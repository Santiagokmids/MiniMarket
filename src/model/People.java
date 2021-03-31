package model;

public class People {
	
	//Attributes
	private Document document;
	private String id;
	
	public People(Document document, String id) {
		this.document = document;
		this.id = id;
	}

	public Document getDocument() {
		return document;
	}

	public void setDocument(Document document) {
		this.document = document;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}
	
	
}
