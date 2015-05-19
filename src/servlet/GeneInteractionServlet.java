package servlet;

import interaction.ElemOfPPI;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import edu.tools.GetResultFromPPI;

public class GeneInteractionServlet extends HttpServlet {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	public GeneInteractionServlet() {
		super();
	}
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.setContentType("text/html;charset=gbk");
		response.setCharacterEncoding("utf-8");
		String GeneA = request.getParameter("GeneA").trim();
		String GeneB = request.getParameter("GeneB").trim();
		if (GeneA.compareTo("") == 0 || GeneB.compareTo("") == 0)
			return;
		// System.out.println(GeneA + "\t" + GeneB);
		List<ElemOfPPI> pPIResults = GetResultFromPPI.getTwoGeneInteractionPPIResult(GeneA, GeneB);
//		String result = "";
//		for (ElemOfPPI ppi : pPIResults) {
//			result += ppi.getPubmedID() + "; " + ppi.getGeneA().getGeneName() + "; " +
//					ppi.getGeneA().getGeneID() + "; " + ppi.getGeneA().getRecognitionProteins() + " || " +
//					ppi.getGeneB().getGeneName() + "; " +
//					ppi.getGeneB().getGeneID() + "; " + ppi.getGeneB().getRecognitionProteins() + " || " +
//					ppi.getRelateionWords() + " || " + ppi.getType() + "\n";
//		}
//		System.out.println(result);
		HttpSession hs = request.getSession();
		hs.setAttribute("GeneA", GeneA);
		hs.setAttribute("GeneB", GeneB);
		hs.setAttribute("pPIResultList", pPIResults);
		response.sendRedirect("InteractionPairsResult.jsp?result=true");
	}
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}
	
	
}
