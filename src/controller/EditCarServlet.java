package controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.MuscleCar;

/**
 * Servlet implementation class EditCarServlet
 */
@WebServlet("/editCarServlet")
public class EditCarServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public EditCarServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		MuscleCarHelper dao = new MuscleCarHelper();
		
		String make = request.getParameter("make");
		String model = request.getParameter("model");
		String color = request.getParameter("color");
		Integer year = Integer.parseInt(request.getParameter("year"));
		double time = Double.parseDouble(request.getParameter("time"));
		Integer tempId = Integer.parseInt(request.getParameter("id"));
		
		MuscleCar carToUpdate = dao.searchForItemById(tempId);
		carToUpdate.setMake(make);
		carToUpdate.setModel(model);
		carToUpdate.setExteriorColor(color);
		carToUpdate.setYear(year);
		carToUpdate.setZeroToSixtyTime(time);
		
		dao.updateItem(carToUpdate);
		
		getServletContext().getRequestDispatcher("/viewAllCarsServlet").forward(request, response);
	}

}
