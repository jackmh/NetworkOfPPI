package interaction;

public class GeneMention {
	private String GeneID;
	private String GeneName;
	private String RecognitionProteins;
	
	public GeneMention(String GeneID, String GeneName, String RecognitionProteins) {
		this.GeneID = GeneID;
		this.GeneName = GeneName;
		this.RecognitionProteins  = RecognitionProteins;
	}
		
	public String getGeneName() {
		return GeneName;
	}

	public void setGeneName(String geneName) {
		GeneName = geneName;
	}

	public String getGeneID() {
		return GeneID;
	}

	public void setGeneID(String geneID) {
		GeneID = geneID;
	}

	public String getRecognitionProteins() {
		return RecognitionProteins;
	}
	
	public void setRecognitionProteins(String recognitionProteins) {
		RecognitionProteins = recognitionProteins;
	}
}
