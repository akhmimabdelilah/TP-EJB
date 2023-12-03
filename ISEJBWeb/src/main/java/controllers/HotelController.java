package controllers;

import java.io.IOException;
import java.util.List;

import dao.HotelIDao;
import dao.VilleIDao;
import entities.Hotel;
import entities.Ville;
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
	private VilleIDao ejbv;

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

			List<Ville> villes = ejbv.findAll();
			request.setAttribute("villes", villes);

			ServletContext contextv = getServletContext();
			contextv.setAttribute("ejbv", ejbv);

			List<Hotel> hotels = ejbh.findAll();
			request.setAttribute("hotels", hotels);

			ServletContext contexth = getServletContext();
			contexth.setAttribute("ejbh", ejbh);

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

		} else if (action.equals("search")) {

			String v = request.getParameter("ville");
			int villeId = Integer.parseInt(v);
//			Hotel h = ejbh.findByVille(villeId.getVille);

			if (villeId == 0) {
				List<Hotel> hotelList = ejbh.findAll();
				request.setAttribute("hotels", hotelList);
			} else {
				Ville ville = ejbv.findById(villeId);
				String villeName = ville.getNom();

				List<Hotel> hotelList = ejbh.findByVille(villeName);
				request.setAttribute("hotels", hotelList);
			}

			List<Ville> villeList = ejbv.findAll();
			request.setAttribute("villes", villeList);

			// Redirect to search.jsp
			RequestDispatcher dispatcher = request.getRequestDispatcher("search.jsp");
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

		List<Ville> villes = ejbv.findAll();
		request.setAttribute("villes", villes);

		List<Hotel> hotels = ejbh.findAll();
		request.setAttribute("hotels", hotels);

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

//				if (hToUpdate != null && hotel != null && adresse != null && telephone != null) {
				if (hToUpdate != null) {
					hToUpdate.setNom(hotel);
					hToUpdate.setAdresse(adresse);
					hToUpdate.setTelephone(telephone);
//					hToUpdate.setVille(ville);

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
