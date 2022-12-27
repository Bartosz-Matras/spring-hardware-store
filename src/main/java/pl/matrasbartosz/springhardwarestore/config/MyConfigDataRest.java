package pl.matrasbartosz.springhardwarestore.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.rest.core.config.RepositoryRestConfiguration;
import org.springframework.data.rest.webmvc.config.RepositoryRestConfigurer;
import org.springframework.http.HttpMethod;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import pl.matrasbartosz.springhardwarestore.entity.*;

import javax.persistence.EntityManager;
import javax.persistence.metamodel.EntityType;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

@Configuration
public class MyConfigDataRest implements RepositoryRestConfigurer {

    private final EntityManager entityManager;

    @Autowired
    public MyConfigDataRest(EntityManager entityManager){
        this.entityManager = entityManager;
    }

    @Override
    public void configureRepositoryRestConfiguration(RepositoryRestConfiguration config, CorsRegistry cors) {
        HttpMethod[] theUnsupportedActions = {HttpMethod.PUT, HttpMethod.POST, HttpMethod.DELETE};

        // disable HTTP methods for Product: PUT, POST and DELETE
        disableHttpMethods(Product.class, config, theUnsupportedActions);

        // disable HTTP methods for ProductCategory: PUT, POST and DELETE
        disableHttpMethods(ProductCategory.class, config, theUnsupportedActions);

        // disable HTTP methods for ProductDetails: PUT, POST and DELETE
        disableHttpMethods(ProductDetails.class, config, theUnsupportedActions);

        // disable HTTP methods for ProductSubCategory: PUT, POST and DELETE
        disableHttpMethods(ProductSubCategory.class, config, theUnsupportedActions);

        // disable HTTP methods for Country: PUT, POST and DELETE
        disableHttpMethods(Country.class, config, theUnsupportedActions);

        // disable HTTP methods for State: PUT, POST and DELETE
        disableHttpMethods(State.class, config, theUnsupportedActions);

        exposeIds(config);
    }

    private void disableHttpMethods(Class<?> theClass, RepositoryRestConfiguration configuration, HttpMethod[] theUnsupportedActions) {
        configuration.getExposureConfiguration()
                .forDomainType(theClass)
                .withItemExposure((metadata, httpMethods) -> httpMethods.disable(theUnsupportedActions))
                .withCollectionExposure((metadata, httpMethods) -> httpMethods.disable(theUnsupportedActions));
    }

    private void exposeIds(RepositoryRestConfiguration config) {
        // expose entity ids
        //

        // - get a list of all entity classes from the entity manager
        Set<EntityType<?>> entities = entityManager.getMetamodel().getEntities();

        // - create an array of the entity types
        List<Class<?>> entityClasses = new ArrayList<>();

        // - get the entity types for the entities
        for (EntityType<?> tempEntityType : entities){
            entityClasses.add(tempEntityType.getJavaType());
        }

        // - expose the entity ids for the array of entity/domain types
        Class<?>[] domainTypes = entityClasses.toArray(new Class[0]);
        config.exposeIdsFor(domainTypes);
    }
}
