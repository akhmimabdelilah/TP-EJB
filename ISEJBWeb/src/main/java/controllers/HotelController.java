package controllers;

import java.io.IOException;
import java.util.List;

import dao.HotelIDao;
import entities.Hotel;
import jakarta.ejb.EJB;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletContext;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class HotelController
 */

public class HotelController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	@EJB
	private HotelIDao ejbh;
	@EJB
	private HotelIDao ejbv;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public HotelController() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String action = request.getParameter("action");
		if (action == null) {
			List<Hotel> villes = ejbv.findAll();
			request.setAttribute("villes", villes);

			List<Hotel> hotels = ejbh.findAll();
			request.setAttribute("hotels", hotels);

			ServletContext context = getServletContext();
			context.setAttribute("ejbv", ejbv);

			// Redirect to page hotel.jsp
			RequestDispatcher dispatcher = request.getRequestDispatcher("hotel.jsp");
			dispatcher.forward(request, response);

		}

		if (action.equals("edit")) {
			int Id = Integer.parseInt(request.getParameter("id"));
			Hotel updateHotel = ejbh.findById(Id);
			request.setAttribute("updateHotel", updateHotel);

			// Redirect to updateHotel.jsp
			RequestDispatcher dispatcher = request.getRequestDispatcher("updateHotel.jsp");
			dispatcher.forward(request, response);
		}

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String action = request.getParameter("action");

		if (action == null) {
			RequestDispatcher dispatcher = request.getRequestDispatcher("ville.jsp");
			dispatcher.forward(request, response);
		}

		if ("create".equals(action)) {

			String nom = request.getParameter("nom");
			String adresse = request.getParameter("adresse");
			String telephone = request.getParameter("telephone");
//			String ville = request.getParameter("ville");
			ejbh.create(new Hotel(nom, adresse, telephone));
//			int villeId = Integer.parseInt(Id);
//			Hotel v = ejbv.findById(villeId);
//			ejbh.create(new Hotel(nom, adresse, telephone, ville));

			response.sendRedirect(request.getContextPath() + "/HotelController");

		} else if ("delete".equals(action)) {
			String Id = request.getParameter("id");
			if (Id != null && !Id.isEmpty()) {
				int villeId = Integer.parseInt(Id);

				Hotel villeToDelete = ejbh.findById(villeId);

				if (villeToDelete != null) {
					boolean deleted = ejbh.delete(villeToDelete);

					if (deleted) {
						System.out.println("Hotel supprimée avec succès");
						response.sendRedirect(request.getContextPath() + "/HotelController");
					} else {
						System.out.println("La suppression de la ville a échoué");
						response.sendRedirect(request.getContextPath() + "/HotelController?deleteFailed=true");
					}
				} else {
					System.out.println("Hotel non trouvée avec l'ID : " + villeId);
					response.sendRedirect(request.getContextPath() + "/HotelController");
				}

			}

		} else if ("update".equals(action)) {
			String hotel = request.getParameter("hotel");
			String adresse = request.getParameter("adresse");
			String telephone = request.getParameter("telephone");
//			String ville = request.getParameter("ville");
			String Id = request.getParameter("id");

			if (Id != null && !Id.isEmpty()) {
				int hotelId = Integer.parseInt(Id);
				Hotel hToUpdate = ejbh.findById(hotelId);

				if (hToUpdate != null && hotel != null && adresse != null && telephone != null) {
					hToUpdate.setNom(hotel);
					hToUpdate.setAdresse(adresse);
					hToUpdate.setTelephone(telephone);

					Hotel updatedHotel = ejbh.update(hToUpdate);

					if (updatedHotel != null) {
						System.out.println("Hotel modifiée avec succès");
						response.sendRedirect(request.getContextPath() + "/HotelController");

					} else {
						System.out.println("La modification de la ville a échoué");
						response.sendRedirect(request.getContextPath() + "/HotelController?updateFailed=true");
					}
				} else {
					System.out.println("Hotel non trouvée avec l'ID : " + Id);
					response.sendRedirect(request.getContextPath() + "/HotelController");
				}
			}

		}

		doGet(request, response);
	}

}
