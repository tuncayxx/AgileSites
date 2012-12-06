package test;

import wcs.java.Asset;
import wcs.java.CSElement;
import wcs.java.Setup;
import wcs.java.Site;
import wcs.java.Template;

public class JavaSetup extends Setup {

	@Override
	public Site getSite() {
		return new Site("Test");
	}

	@Override
	public Asset[] getAssets() {
		return new Asset[] { //
		new Template("JUnitRunner", "test.template.JUnitRunner"), //
				new Template("TjLayout", "test.template.TjLayout"), //
				new CSElement("TjFooter", "test.cselement.TjFooter") };

	}
}
