package controllers;

import java.io.IOException;
import java.util.List;

import dao.VilleIDao;
import entities.Ville;
import jakarta.ejb.EJB;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletContext;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class VilleController
 */
public class VilleController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	@EJB
	private VilleIDao ejbv;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public VilleController() {
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

			ServletContext context = getServletContext();
			context.setAttribute("ejbv", ejbv);

			// Redirect to page ville.jsp
			RequestDispatcher dispatcher = request.getRequestDispatcher("ville.jsp");
			dispatcher.forward(request, response);

		}

		if (action.equals("edit")) {
			int Id = Integer.parseInt(request.getParameter("id"));
			Ville updateVille = ejbv.findById(Id);
			request.setAttribute("updateVille", updateVille);

			// Redirect to updateVille.jsp
			RequestDispatcher dispatcher = request.getRequestDispatcher("updateVille.jsp");
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
			String ville = request.getParameter("ville");
			ejbv.create(new Ville(ville));
			response.sendRedirect(request.getContextPath() + "/VilleController");

		} else if ("delete".equals(action)) {
			String Id = request.getParameter("id");
			if (Id != null && !Id.isEmpty()) {
				int villeId = Integer.parseInt(Id);

				Ville villeToDelete = ejbv.findById(villeId);

				if (villeToDelete != null) {
					boolean deleted = ejbv.delete(villeToDelete);

					if (deleted) {
						System.out.println("Ville supprimée avec succès");
						response.sendRedirect(request.getContextPath() + "/VilleController");
					} else {
						System.out.println("La suppression de la ville a échoué");
						response.sendRedirect(request.getContextPath() + "/VilleController?deleteFailed=true");
					}
				} else {
					System.out.println("Ville non trouvée avec l'ID : " + villeId);
				}

				// Après la suppression, rediriger vers la page VilleController
//				response.sendRedirect(request.getContextPath() + "/VilleController");
			}

		} else if ("update".equals(action)) {
			String ville = request.getParameter("ville");
			String Id = request.getParameter("id");

			if (Id != null && !Id.isEmpty()) {
				int villeId = Integer.parseInt(Id);
				Ville vToUpdate = ejbv.findById(villeId);

				if (vToUpdate != null && ville != null) {
					vToUpdate.setNom(ville);
					Ville updatedVille = ejbv.update(vToUpdate);

					if (updatedVille != null) {
						System.out.println("Ville modifiée avec succès");
						response.sendRedirect(request.getContextPath() + "/VilleController");

					} else {
						System.out.println("La modification de la ville a échoué");
						response.sendRedirect(request.getContextPath() + "/VilleController?updateFailed=true");
					}
				} else {
					System.out.println("Ville non trouvée avec l'ID : " + Id);
				}
			}

		}
		doGet(request, response);

	}

}