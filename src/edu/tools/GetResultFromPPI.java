package edu.tools;

import interaction.ElemOfPPI;
import interaction.GeneMention;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class GetResultFromPPI {
	
	private DBHandler dbhandler = null;
	private PreparedStatement ps = null;
	
	public GetResultFromPPI() {
		dbhandler = new DBHandler();
	}
	/**
	 * Needed to improved ...................................
	 */
	public List<ElemOfPPI> getPubmedIDPPIResult(String pubmedID) {
		List<ElemOfPPI> PubmedIDOfPPIList = new ArrayList<ElemOfPPI>();
		
		List<ElemOfPPI> pPIResultElemOfPPIs = getPPIData();
		for (ElemOfPPI ppi : pPIResultElemOfPPIs) {
			String pID = ppi.getPubmedID();
			if (0 == pID.compareTo(pubmedID)) {
				PubmedIDOfPPIList.add(ppi);
			}
		}
		return PubmedIDOfPPIList;
	}
	
	public List<ElemOfPPI> getTwoGeneInteractionPPIResult(String GeneA, String GeneB) {
		List<ElemOfPPI> typeOfPPIList = new ArrayList<ElemOfPPI>();
		
		List<ElemOfPPI> pPIResultElemOfPPIs = getPPIData();
		for (ElemOfPPI ppi : pPIResultElemOfPPIs) {
			String geneAString = ppi.getGeneA().getGeneName();
			String geneBString = ppi.getGeneB().getGeneName();
			if ((0 == geneAString.compareTo(GeneA) && 0 == geneBString.compareTo(GeneB))
					|| (0 == geneAString.compareTo(GeneB) && 0 == geneBString.compareTo(GeneA))) {
				typeOfPPIList.add(ppi);
			}
		}
		return typeOfPPIList;
	}
	
	public List<ElemOfPPI> getTypePPIResult(String PPIType) {
		List<ElemOfPPI> typeOfPPIList = new ArrayList<ElemOfPPI>();
		
		List<ElemOfPPI> pPIResultElemOfPPIs = getPPIData();
		for (ElemOfPPI ppi : pPIResultElemOfPPIs) {
			String type = ppi.getType();
			if (0 == type.compareTo(PPIType)) {
				typeOfPPIList.add(ppi);
			}
		}
		return typeOfPPIList;
	}
	
	private List<ElemOfPPI> getPPIData() {
		List<ElemOfPPI> pPIResultElemOfPPIs = new ArrayList<ElemOfPPI>();
		try {
			ps = dbhandler.getPrSt(PreSql.db_ppi_select);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				String PubmedID = rs.getString(1);
				// ---- GeneA ------
				String GeneAID = rs.getString(2).trim();
				String GeneAName = rs.getString(3).trim();
				String RecognitionAProteins = rs.getString(4).trim();
				if (0 == RecognitionAProteins.compareTo(""))
					continue;
				// ---- GeneB ------
				String GeneBID = rs.getString(5).trim();
				String GeneBName = rs.getString(6).trim();
				String RecognitionBProteins = rs.getString(7).trim();
				if (0 == RecognitionBProteins.compareTo(""))
					continue;
				// ---- Relation Words ----
				String RelationWords = rs.getString(8).trim();
				String type = rs.getString(9).trim();

				GeneMention GeneA = new GeneMention(GeneAID, GeneAName,
						RecognitionAProteins);
				GeneMention GeneB = new GeneMention(GeneBID, GeneBName,
						RecognitionBProteins);
				ElemOfPPI ppi = new ElemOfPPI(PubmedID, GeneA, RelationWords,
						GeneB, type);
				pPIResultElemOfPPIs.add(ppi);
			}
			return pPIResultElemOfPPIs;
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
			return null;
		}
		
//		String PPIResultFname = "/home/jack/projectInHIT/result/PPIResult.txt";
//		String[] elemsList = null;
//		Iterable<String> allLines = IOUtils.readLines(PPIResultFname);
//		for (String pPILine : allLines) {
//			 pPILine = pPILine.trim();
//			 if (pPILine.charAt(0) == '#') {
//				 continue;
//			 }
//			 elemsList = pPILine.split("\t");
//			 if (elemsList.length < 9) {
//				 continue;
//			 }
//			 String PubmedID = elemsList[0].trim();
//			 if (0 == PubmedID.compareTo(""))
//				 continue;
//			 // ---- GeneA ------
//			 String GeneAName = elemsList[1].trim();
//			 String GeneAID = elemsList[2].trim();
//			 String RecognitionAProteins = elemsList[3].trim();
//			 if (0 == RecognitionAProteins.compareTo(""))
//				 continue;
//			 // ---- GeneB ------
//			 String GeneBName = elemsList[4].trim();
//			 String GeneBID = elemsList[5].trim();
//			 String RecognitionBProteins = elemsList[6].trim();
//			 if (0 == RecognitionBProteins.compareTo(""))
//				 continue;
//			 // ---- Relation Words ----
//			 String RelationWords = elemsList[7].trim();
//			 String type = elemsList[8].trim();
//			 GeneMention GeneA = new GeneMention(GeneAID, GeneAName, RecognitionAProteins);
//			 GeneMention GeneB = new GeneMention(GeneBID, GeneBName, RecognitionBProteins);
//			 ElemOfPPI ppi = new ElemOfPPI(PubmedID, GeneA, RelationWords, GeneB, type);
//			 pPIResultElemOfPPIs.add(ppi);
//		 }
//		return pPIResultElemOfPPIs;
	}
}
