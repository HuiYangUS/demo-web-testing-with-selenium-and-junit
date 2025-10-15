package utilities;

public enum FileExtension {

	EXCEL(".xlsx"), PDF(".pdf");

	final String extension;

	FileExtension(String extension) {
		this.extension = extension;
	}

}
