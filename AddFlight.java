package controller;

import  model.Flight;
import java.io.IOException;
import java.io.PrintWriter;
import java.time.LocalDate;
import java.util.Arrays;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.FlightServiceImpl;

/**
 * Servlet implementation class AddFlight
 */
@WebServlet("/addMyFlight")
public class AddFlight extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AddFlight() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		 response.setContentType("text/html");
		 PrintWriter out=response.getWriter();
		 
		 long fnum=Long.parseLong(request.getParameter("fno"));
		 String fType=request.getParameter("fType");
		 String fSrc=request.getParameter("fSource");
		 String fDest=request.getParameter("fDest");
		 String[] layOff=request.getParameterValues("ch1");
		 String fDate=request.getParameter("flyDate");
		 double fCost=Double.parseDouble(request.getParameter("cost"));
		 
		 //to test whether request input come from html element are successfully
		/* out.println(fnum+" "+fType+" "+fSrc+" "+fDest+" "
		 +Arrays.toString(layOff)+" "+fDate+" "+fCost);
		 */
		 
		 //to construct object of flight using all requested inutes 
		 //convert string into LocalDate object 
		 LocalDate ld=LocalDate.parse(fDate);
		 
		 
		 /*
		  * public Filght(long flightNumber, String flightType, String flightsource, 
		  * String filghtDestination,
			String layOffPoints, LocalDate flyDate, double flightCharge) {
		  */
		//converting string [] into single String
		 String layOffPoints=Arrays.toString(layOff);
		 
		 //obj of flight
		 Flight flightObj=new Flight(fnum,fType,fSrc,fDest,layOffPoints,ld,fCost);
			
			out.println(flightObj);
			
			//creating obj of flightServiceImpl class to access all dao methods
			
			FlightServiceImpl service=new FlightServiceImpl();
			//invock addFlight(Flight obj)
			Flight obj=service.addFlight(flightObj);
			
			if(obj!=null)
			{
				out.print("<h3><font color='pink'>"+""+obj.getFlightType()+" "+"added to system"+"</font></h3><br>");
				out.print("<a href='AddFlight.jsp'>ADD MORE FLIGHT</a><br>");
				out.print("<a href='admintask.jsp'>Go ADMIN Page</a>");
				
			}else
			{
				System.out.println("<h3><font color='red'>Flight Not Added</font></h3>");
			}
		 
		
	}

}
