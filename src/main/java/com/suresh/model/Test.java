package com.suresh.model;

public class Test {

	public static void main(String[] args) {
		
		StringBuilder email =new StringBuilder();
		
		email.append("<html><head> <style> table {font-family: arial, sans-serif;border-collapse: collapse;width: 950px;}"
				+ " td, th {border: 1px solid #dddddd;text-align: left;padding: 8px;} tr:nth-child(even) {background-color: #dddddd;} </style></head>"
				+ "<body>" + "<table style='margin-left: 100px;'>");
		email.append("<h4>Hello, Post data schedular information : </h4>");
		email.append("<tr> ");
        
		email.append("<th nowrap>").append("Merchant Master Id").append("</th>");
        email.append("<th nowrap>").append("Store Master Id").append("</th>");
        email.append("<th nowrap>").append("Consumer Id").append("</th>");
        email.append("<th nowrap>").append("Rule Id").append("</th>");
        email.append("<th nowrap>").append("Rule Type").append("</th>");
        email.append("<th nowrap>").append("Merchant Id").append("</th>");
        email.append("<th nowrap>").append("Store Id").append("</th>");
        email.append("<th nowrap>").append("Purchase Trans Amount").append("</th>");
        email.append("<th nowrap>").append("Fancoins Earned").append("</th>");
        email.append("<th nowrap>").append("Purchased Time").append("</th>");
        
        email.append("<tr>");
        
	
        email.append("<tr>");
        
        email.append("<td>").append("38").append("</td>");
        email.append("<td>").append("269").append("</td>");
        email.append("<td>").append("7388").append("</td>");
        email.append("<td>").append("249").append("</td>");
        email.append("<td>").append("FBR10").append("</td>");
        email.append("<td>").append("137885").append("</td>");
        email.append("<td>").append("463").append("</td>");
        email.append("<td>").append("3.19").append("</td>");
        email.append("<td>").append("0.16").append("</td>");
        email.append("<td nowrap>").append("2018-01-04 22:27:35.0").append("</td>");

        email.append("<tr>");
        
        
        email.append("<tr>");
        
        email.append("<td>").append("223").append("</td>");
        email.append("<td>").append("289").append("</td>");
        email.append("<td>").append("7378").append("</td>");
        email.append("<td>").append("249").append("</td>");
        email.append("<td>").append("FBR10").append("</td>");
        email.append("<td>").append("137985").append("</td>");
        email.append("<td>").append("468").append("</td>");
        email.append("<td>").append("6.19").append("</td>");
        email.append("<td>").append("5.16").append("</td>");
        email.append("<td nowrap>").append("2018-01-04 22:27:35.0").append("</td>");

        email.append("<tr>");
        
        email.append("<tr>");
        
        email.append("<td>").append("243").append("</td>");
        email.append("<td>").append("510").append("</td>");
        email.append("<td>").append("7566").append("</td>");
        email.append("<td>").append("476").append("</td>");
        email.append("<td>").append("FBR10").append("</td>");
        email.append("<td>").append("138538").append("</td>");
        email.append("<td>").append("44171").append("</td>");
        email.append("<td>").append("13.19").append("</td>");
        email.append("<td>").append("1.16").append("</td>");
        email.append("<td nowrap>").append("2018-01-04 22:27:35.0".substring(0, 19) ).append("</td>");

        email.append("<tr>");

    email.append("</table><h4> Thank You, </h4> \n The FanBank Team.</body></html>");
    
    System.out.println(email.toString());
	}
	
	public String getMessage()
	{
		StringBuilder email =new StringBuilder();
		
		return email.toString();
	}
}
