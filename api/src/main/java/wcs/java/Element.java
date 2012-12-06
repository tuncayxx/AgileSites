package wcs.java;

import java.util.StringTokenizer;

import COM.FutureTense.Interfaces.FTValList;
import COM.FutureTense.Interfaces.ICS;
import wcs.java.Util.Arg;
import wcs.java.Util.Id;
import static java.lang.System.out;

/**
 * 
 * Element
 * 
 * @author msciab
 * 
 */
public abstract class Element implements wcs.core.Element {

	// separators
	private final static String sep = "\0";
	private final static String sep2 = sep + sep;

	// current site
	private String site;

	/**
	 * Execute the element
	 * 
	 * The bulk of the method is streaming the result and invoking embedded
	 * method calls.
	 * 
	 */
	@Override
	public String exec(ICS ics) {
		try {
			Env env = new Env(ics);
			site = ics.GetVar("site");

			String res = apply(env);

			out.println("\n=====\n" + res + "\n======\n");

			int start = res.indexOf(sep2);

			out.println("START=" + start);

			while (start != -1) {

				ics.StreamText(res.substring(0, start));

				int end = res.indexOf(sep2 + sep, start + 2);
				out.println("END=" + end);
				if (end == -1)
					end = res.length();

				String call = res.substring(start, end);

				out.println("ELMENTCALL " + call);

				StringTokenizer st = new StringTokenizer(call, sep);

				String element = st.nextToken();
				FTValList list = new FTValList();

				out.print("CALL " + element);
				while (st.hasMoreTokens()) {
					try {
						String k = st.nextToken();
						String v = st.nextToken();
						out.print(" " + k + "=" + v);
						list.setValString(k, v);
					} catch (Exception ex) {
						out.println("OPS " + ex.getMessage());
					}
				}
				out.println();

				ics.CallElement(element, list);

				res = res.substring(end + 3);
				start = res.indexOf(sep2);
				out.println("START=" + start);
			}

			ics.StreamText(res);
			return null;
		} catch (Exception ex) {
			ex.printStackTrace();
			return ex.getMessage();
		}
	}

	/**
	 * Call an element element
	 * 
	 * @param name
	 * @param args
	 */
	public String call(String name, Arg... args) {
		StringBuilder sb = new StringBuilder();
		// elements to call have the site name as a prefix
		sb.append(sep2).append(site).append(".").append(name).append(sep);
		for (Arg arg : args) {
			if (arg.value != null)
				sb.append(arg.name).append(sep).append(arg.value).append(sep);
		}
		sb.append(sep2);
		return sb.toString();
	}

	/**
	 * Generate the url to a given asset.
	 * 
	 * @param id
	 * @return
	 */
	public String url(Id id) {
		// TODO
		return null;
	}

	/**
	 * The method to be overriden by an implementing template
	 * 
	 * @param env
	 * @return
	 */
	abstract public String apply(Env env);
}
