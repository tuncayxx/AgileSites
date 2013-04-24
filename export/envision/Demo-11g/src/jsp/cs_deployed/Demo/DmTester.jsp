<%-- DO NOT EDIT - GENERATED BY AgileSites 
--%><%@ taglib prefix="cs" uri="futuretense_cs/ftcs1_0.tld"
%><%@ taglib prefix="ics" uri="futuretense_cs/ics.tld"
%><%@ taglib prefix="insite" uri="futuretense_cs/insite.tld"
%><%@ taglib prefix="render" uri="futuretense_cs/render.tld"
%><%@ page import="wcs.core.*" 
%><%! final static Log log = Log.getLog("demo.element.Tester.jsp");
%><cs:ftcs><ics:if condition='<%=ics.GetVar("tid") != null%>'><ics:then><render:logdep cid='<%=ics.GetVar("tid")%>' c="Template" /></ics:then></ics:if><%
		String res = WCS.dispatch(ics, "demo.element.Tester");
		Sequencer seq = new Sequencer(res);
	%><%=seq.header()%><%
		while (seq.hasNext()) {
			Call c = seq.next();
			String name = c.getName();
			log.trace("JSP: %s", c.toString());
	%><% // -----------------------------------------------------
		if (name.equalsIgnoreCase("ICS:CALLELEMENT")) {
			String element = c.getOnce("ELEMENT");
		%><ics:callelement element='<%=element%>'><%
		    for (String k : c.keysLeft()) {
			%><ics:argument name='<%=k%>' value='<%=c.getOnce(k)%>' /><%
			}
		%></ics:callelement><%
		} /* END ICS:CALLELEMENT */
	%><% // -----------------------------------------------------
		if (name.equalsIgnoreCase("RENDER:CALLELEMENT")) {
			String elementname = c.getOnce("ELEMENTNAME");
			%><render:callelement elementname='<%=elementname%>'><%
			 for (String k : c.keysLeft()) {
			  %><render:argument name='<%=k%>' value='<%=c.getOnce(k)%>' /><%
			 }
			%></render:callelement><%
		} /* END RENDER:CALLELEMENT */
	%><% // -----------------------------------------------------
	  if (name.equalsIgnoreCase("RENDER:CALLTEMPLATE")) {
			String cc = c.getOnce("C");
			String cid = c.getOnce("CID");
			String tname = c.getOnce("TNAME");
	   %><render:calltemplate 
			c='<%=cc%>' 
			cid='<%=cid%>'
		    site='<%=c.getOnce("SITE")%>'
			tname='<%=tname%>'
			ttype='<%=c.getOnce("TTYPE")%>' 
			slotname='<%=c.getOnce("SLOTNAME")%>' 
			tid='<%=c.getOnce("TID")%>'><%
			for (String k : c.keysLeft()) {
		  	%><render:argument name='<%=k%>' value='<%=c.getOnce(k)%>' /><%
			}
	    %></render:calltemplate><%
	  } /* end RENDER:CALLTEMPLATE */
	%><% // -----------------------------------------------------
		if (name.equalsIgnoreCase("INSITE:CALLTEMPLATE")) {
			String cc = c.getOnce("C");
			String cid = c.getOnce("CID");
			String tname = c.getOnce("TNAME");
			String field = c.getOnce("FIELD");
	  %><insite:calltemplate 
		    site='<%=c.getOnce("SITE")%>'
			c='<%=cc%>'
			cid='<%=cid%>'
			field='<%=field%>'
			tname='<%=tname%>'
			ttype='<%=c.getOnce("TTYPE")%>' 
			slotname='<%=c.getOnce("SLOTNAME")%>' 
			tid='<%=c.getOnce("TID")%>'><%
			for (String k : c.keysLeft()) {
		%><insite:argument name='<%=k%>' value='<%=c.getOnce(k)%>' /><%
			}
		%></insite:calltemplate><%
		} /* END INSITE:CALLTEMPLATE */
	%><% // -----------------------------------------------------
	 if (name.equalsIgnoreCase("INSITE:CALLTEMPLATELOOP")) {
		String cc = c.getOnce("C");
		String field = c.getOnce("FIELD");
		String listname = c.getOnce("LISTNAME");
		String output = Common.tmp();
       %><insite:slotlist field='<%= field %>'
         ><ics:listloop listname='<%= listname %>'
         ><ics:listget listname='<%= listname %>' 
               fieldname='value' 
               output='<%= output %>'
         /><insite:calltemplate 
			c='<%=cc%>'
			cid='<%=ics.GetVar(output)%>'
		    site='<%=c.getOnce("SITE")%>'
			tname='<%=c.getOnce("TNAME")%>'
			ttype='<%=c.getOnce("TTYPE")%>' 
			tid='<%=c.getOnce("TID")%>'><%
		for (String k : c.keysLeft()) {
	       %><insite:argument name='<%=k%>' value='<%=c.getOnce(k)%>' /><%
		}
	   %></insite:calltemplate></ics:listloop></insite:slotlist><%
	 } /* END INSITE:CALLTEMPLATELOOP */
	%><% // -----------------------------------------------------
		if (name.equalsIgnoreCase("INSITE:EDIT")) {
			String assetid = c.getOnce("ASSETID");
			String assettype = c.getOnce("ASSETTYPE");
			String field = c.getOnce("FIELD");
			String value = c.getOnce("VALUE");
			String index = c.getOnce("INDEX");
		%><insite:edit 
		    assettype='<%= assettype %>'
		    assetid='<%= assetid %>'
		    field='<%= field %>'
			value='<%= value %>'
			index='<%= index %>'
		><%
		  for (String k : c.keysLeft()) {
		%><insite:argument name='<%=k%>' value='<%=c.getOnce(k)%>' /><%
		   }
		 %></insite:edit><%
		} /* END INSITE:EDIT */
	%><% // -----------------------------------------------------
	%><%=seq.header()%><%
  }
%></cs:ftcs>