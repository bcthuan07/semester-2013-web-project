package entity;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.SessionFactoryObserver;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;
import org.hibernate.service.ServiceRegistryBuilder;

public class HibernateUtil {

	private static final SessionFactory SESSION_FACTORY;
	private static final ServiceRegistry SERVICE_REGISTRY;
	
	static {
		try {
			Configuration config = new Configuration().configure("hibernate.cfg.xml");
			SERVICE_REGISTRY = new ServiceRegistryBuilder().applySettings(config.getProperties()).buildServiceRegistry();
			config.setSessionFactoryObserver(new SessionFactoryObserver() {
				private static final long serialVersionUID = 1L;
				@Override
				public void sessionFactoryCreated(SessionFactory factory) {
				}
				@Override
				public void sessionFactoryClosed(SessionFactory factory) {
					ServiceRegistryBuilder.destroy(SERVICE_REGISTRY);
				}
			});
			SESSION_FACTORY = config.buildSessionFactory(SERVICE_REGISTRY);
		} catch (Throwable ex) {
			System.err.println(ex);
			throw new ExceptionInInitializerError(ex);
		}
	}
	public static Session openSession(){
		return SESSION_FACTORY.openSession();
	}
}
