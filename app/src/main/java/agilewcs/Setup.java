package agilewcs;

import wcs.java.Asset;
import wcs.java.CSElement;
import wcs.java.Site;
import wcs.java.SiteEntry;
import wcs.java.Template;

public class Setup extends wcs.java.Setup {

	@Override
	public Site getSite() {
		return new Site("AgileWCS");
	}

	@Override
	public Asset[] getAssets() {
		return new Asset[] {

				// typeless
				new Template("", "AwHeader", Template.INTERNAL,
						agilewcs.typeless.Header.class)
						.description("Header (Java)"), //

				new CSElement("AwFooter", agilewcs.typeless.Footer.class)
						.description("Footer (Java)"), //

				// for pages
				new Template("Page", "AwLayout", Template.LAYOUT,
						agilewcs.page.Layout.class)//
						.cache("false", "false") //
						.description("Page Layout (Java)"),

				new Template("Page", "AwLink", Template.LAYOUT,
						agilewcs.page.Link.class) //
						.cache("false", "false") //
						.description("Page Link (Java)"),

				new Template("Page", "AwDetail", Template.INTERNAL,
						agilewcs.page.Detail.class)//
						.cache("false", "false") //
						.description("Page Detail (Java)"), //

				new Template("Page", "AwSummary", Template.INTERNAL,
						agilewcs.page.Summary.class)//
						.cache("false", "false") //
						.description("Page Summary (Java)"), //

				new Template("Page", "AwFooter", Template.INTERNAL,
						agilewcs.page.Footer.class)//
						.cache("false", "false") //
						.description("Footer for Page (Java)"), //

				// test runner
				new CSElement("JUnitRunner", agilewcs.tests.JUnitRunner.class), //
				new SiteEntry("JUnitRunner", false) };
	}
}
