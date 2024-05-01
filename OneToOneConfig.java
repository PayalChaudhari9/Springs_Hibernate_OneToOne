package springs_hibernate_anno_bean.dao;

import javax.persistence.EntityManager;
import javax.persistence.Persistence;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan(basePackages = {"springs_hibernate_anno_bean.dao","springs_hibernate_anno_bean.dto"})
public class OneToOneConfig {

	@Bean
	public EntityManager getEntityManager() {
		return Persistence.createEntityManagerFactory("shivani").createEntityManager();
	}
}
