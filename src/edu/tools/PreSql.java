package edu.tools;

//��Ҫ���õ�SQL���
public final class PreSql {

	public static final String DB_PPI_GENESELECT = "select geneName from Gene where geneID=?";
	public static final String db_ppi_select = "select p.pubmedID, p.geneAID, g1.geneName as geneAName, p.geneANEREntity, "
			+ "p.geneBID, g2.geneName  as geneBName, p.geneBNEREntity, p.relationWords, p.ppiType"
			+ " from  pubmedPPI p join Gene g1 on p.geneAID = g1.geneID join Gene g2 on p.geneBID = g2.geneID;";
}
