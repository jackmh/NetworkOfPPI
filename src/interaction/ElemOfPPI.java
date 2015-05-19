package interaction;

public class ElemOfPPI {
	private String pubmedID;
	private GeneMention GeneA; // Gene with it's corresponding Recognition Proteins
	private String RelateionWords;
	private GeneMention GeneB;
	private String type; // PIP PPI IPP

	public ElemOfPPI(String PubmedID, GeneMention GeneA, String RelationWords,
			GeneMention GeneB, String type) {
		this.pubmedID = PubmedID;
		this.GeneA = GeneA;
		this.RelateionWords = RelationWords;
		this.GeneB = GeneB;
		this.type = type;
	}

	public String getPubmedID() {
		return pubmedID;
	}
	
	public void setPubmedID(String pubmedID) {
		this.pubmedID = pubmedID;
	}
	
	public GeneMention getGeneA() {
		return GeneA;
	}

	public void setGeneA(GeneMention geneA) {
		GeneA = geneA;
	}

	public String getRelateionWords() {
		return RelateionWords;
	}

	public void setRelateionWords(String relateionWords) {
		RelateionWords = relateionWords;
	}

	public GeneMention getGeneB() {
		return GeneB;
	}

	public void setGeneB(GeneMention geneB) {
		GeneB = geneB;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

}
