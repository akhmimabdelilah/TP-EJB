import java.util.Hashtable;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;

import dao.IDaoRemote;
import entities.Hotel;
import entities.Ville;

public class TestVille {

	public static IDaoRemote<Ville> lookUpVilleRemote() throws NamingException {
		final Hashtable jndiProperties = new Hashtable();
		jndiProperties.put(Context.INITIAL_CONTEXT_FACTORY, "org.wildfly.naming.client.WildFlyInitialContextFactory");
		jndiProperties.put(Context.PROVIDER_URL, "http-remoting://localhost:8080");
		final Context context = new InitialContext(jndiProperties);

		return (IDaoRemote<Ville>) context.lookup("ejb:ISICEJBEAR/ISICEJBServer/Abdelilah!dao.IDaoRemote");

	}

	public static IDaoRemote<Hotel> lookUpHotelRemote() throws NamingException {
		final Hashtable jndiProperties = new Hashtable();
		jndiProperties.put(Context.INITIAL_CONTEXT_FACTORY, "org.wildfly.naming.client.WildFlyInitialContextFactory");
		jndiProperties.put(Context.PROVIDER_URL, "http-remoting://localhost:8080");
		final Context context = new InitialContext(jndiProperties);

		return (IDaoRemote<Hotel>) context.lookup("ejb:ISICEJBEAR/ISICEJBServer/Akhmim!dao.IDaoRemote");

	}

	public static void main(String[] args) {

		try {
			IDaoRemote<Ville> daov = lookUpVilleRemote();
			IDaoRemote<Hotel> daoh = lookUpHotelRemote();

//			dao.create(new Ville("EL JADIDA"));
//			dao.create(new Ville("Marrakech"));
//			dao.create(new Ville("Casablanca"));

//			Ville ville = daov.findById(1);
//			ville.setNom("Eljadida");
//			dao.update(ville);

//			for (Ville v : daov.findAll()) {
//				System.out.println(v.getNom());
//			}

			Ville v = daov.findById(2);

//			System.out.println(v);

			for (Hotel h : daoh.findByVille(v.getNom())) {
				System.out.println(h.getNom());
			}
		} catch (NamingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
}
