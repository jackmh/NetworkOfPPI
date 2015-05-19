package edu.scrapy;

import java.io.IOException;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;

public class scrapyPubmed {
	private String pubmedID;
	private String pubmedTitle;
	private String pubmedText;
	
	public scrapyPubmed(String pubmedID)
	{
		this.pubmedID = pubmedID;
	}
	/***
****************************** 
	 * Needed improved.................................................................
	 */
	public void scrapyFromNCBI() throws IOException
	{
		String url = "http://www.ncbi.nlm.nih.gov/pubmed/?term=" + this.pubmedID;
		Document document = Jsoup.connect(url).get();
		String title = document.select(".rprt_all h1").text();
		if (0 != title.compareTo("")) {
			this.pubmedTitle = title;
		}
		String abstractText = document.select(".rprt_all .abstr p").text();
		if (abstractText.compareTo("") != 0)
		{
			this.pubmedText = abstractText;
		}
	}
	
	public String getPubmedID() {
		return pubmedID;
	}
	
	public void setPubmedID(String pubmedID) {
		this.pubmedID = pubmedID;
	}
	
	public String getPubmedTitle() {
		return pubmedTitle;
	}
	public void setPubmedTitle(String pubmedTitle) {
		this.pubmedTitle = pubmedTitle;
	}
	public String getPubmedText() {
		return pubmedText;
	}
	
	public void setPubmedText(String pubmedText) {
		this.pubmedText = pubmedText;
	}
}
