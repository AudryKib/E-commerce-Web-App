package org.ItSolutions.ecommerceWebApp.config;

import org.ItSolutions.ecommerceWebApp.entity.Product;
import org.ItSolutions.ecommerceWebApp.entity.ProductCategory;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.rest.core.config.RepositoryRestConfiguration;
import org.springframework.data.rest.webmvc.config.RepositoryRestConfigurer;
import org.springframework.http.HttpMethod;
import org.springframework.web.servlet.config.annotation.CorsRegistry;

@Configuration
public class MyDataRestConfig implements RepositoryRestConfigurer {

    @Override
    public void configureRepositoryRestConfiguration(RepositoryRestConfiguration config, CorsRegistry cors) {
        RepositoryRestConfigurer.super.configureRepositoryRestConfiguration(config, cors);

        //Disable POST PUT and DELETE for Product Class
        HttpMethod[] theUnsupportedMethods = {HttpMethod.POST, HttpMethod.PUT, HttpMethod.DELETE};
        config.getExposureConfiguration()
                .forDomainType(Product.class)
                .withItemExposure(((metdata, httpMethods) -> httpMethods.disable(theUnsupportedMethods)))
                .withCollectionExposure((metdata, httpMethods) -> httpMethods.disable(theUnsupportedMethods));


        //Disable POST PUT and DELETE for Product Category Class
        config.getExposureConfiguration()
                .forDomainType(ProductCategory.class)
                .withItemExposure(((metdata, httpMethods) -> httpMethods.disable(theUnsupportedMethods)))
                .withCollectionExposure((metdata, httpMethods) -> httpMethods.disable(theUnsupportedMethods));

    }



}
