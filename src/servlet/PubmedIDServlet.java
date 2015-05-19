package servlet;

import interaction.ElemOfPPI;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import banner.Sentence;
import dao.pubmedNERDao;
import edu.scrapy.scrapyPubmed;
import edu.tools.GetResultFromPPI;

/**
 * @author jack
 *
 */
public class PubmedIDServlet extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	public PubmedIDServlet() {
		super();
	}
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.setContentType("text/html;charset=gbk");
		response.setCharacterEncoding("utf-8");
		String pubmedID = request.getParameter("pubmedID").trim();
		if (pubmedID == null)
			return;
		scrapyPubmed pubmed = new scrapyPubmed(pubmedID);
		pubmed.scrapyFromNCBI();
		
		/** 
         * Gene Recognition
         */
		pubmedNERDao PubmedNERDao = new pubmedNERDao();
		List<Sentence> geneTagSentenceList = PubmedNERDao.GeneTagger(
				"./data/banner.properties", "./data/model_BC2GM.bin",
				pubmed.getPubmedText());
		
		GetResultFromPPI GetResultFromPPI = new GetResultFromPPI();
		List<ElemOfPPI> pPIResultList = GetResultFromPPI.getPubmedIDPPIResult(pubmedID);
//		String result = "";
//		for (ElemOfPPI ppi : pPIResultList) {
//			result += ppi.getPubmedID() + "; " + ppi.getGeneA().getGeneName() + "; " +
//					ppi.getGeneA().getGeneID() + "; " + ppi.getGeneA().getRecognitionProteins() + " || " +
//					ppi.getGeneB().getGeneName() + "; " +
//					ppi.getGeneB().getGeneID() + "; " + ppi.getGeneB().getRecognitionProteins() + " || " +
//					ppi.getRelateionWords() + " || " + ppi.getType() + "\n";
//		}
//		System.out.println(result);
		HttpSession hs = request.getSession();
		hs.setAttribute("pubmed", pubmed);
		hs.setAttribute("geneTagSentenceList", geneTagSentenceList);
		hs.setAttribute("pPIResultList", pPIResultList);
		response.sendRedirect("PubmedIDResult.jsp?result=true");
	}
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}
	
	
}
