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

public class PPITypeServlet extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	public PPITypeServlet() {
		super();
	}
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.setContentType("text/html;charset=gbk");
		response.setCharacterEncoding("utf-8");
		String PPIType = request.getParameter("PPIType").trim();
//		System.out.println(PPIType);
		if (PPIType == null)
			return;
		// System.out.println(pubmedID);
		List<ElemOfPPI> pPIResults = GetResultFromPPI.getTypePPIResult(PPIType);
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
		hs.setAttribute("PPIType", PPIType);
		hs.setAttribute("pPIResultList", pPIResults);
		response.sendRedirect("PPITypeResult.jsp?result=true");
	}
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}
}
