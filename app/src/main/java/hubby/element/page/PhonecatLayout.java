package hubby.element.page;

import static wcs.Api.*;
import wcs.api.Id;
import wcs.api.Log;
import wcs.api.Index;
import wcs.api.Env;
import wcs.api.Asset;
import wcs.java.Picker;
import wcs.java.Element;
import wcs.java.SitePlan;
import wcs.java.Template;
import wcs.java.AssetSetup;

@Index("hubby/elements.txt")
public class PhonecatLayout extends Element {
	final static Log log = getLog(PhonecatLayout.class);

	public static AssetSetup setup() {
		return new Template("Page", "PhonecatLayout", Template.LAYOUT, // change
																		// template
																		// type
																		// here
				"Hubby_Phonecat", hubby.element.page.PhonecatLayout.class) //
				.cache("false", "false") // change caching here
				.description("Layout for type Page Hubby_Phonecat");
	}

	@Override
	public String apply(Env e) {
		// log.trace("Hubby_PhonecatLayout");
		Picker html = Picker.load("/hubby/index.html", "body");
		Asset a = e.getAsset();

		System.out.println("bla");
		
		SitePlan sp = (wcs.java.SitePlan) e.getSitePlan();
		Id[] desc = sp.descendant(10000);
		System.out.println("desc#"+desc.length);
		for (Id id : desc)
			System.out.println(id);
			

		return html.html(a, e, model(arg("Title", "PhoneCat")));
	}
}