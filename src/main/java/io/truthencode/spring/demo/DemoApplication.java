package io.truthencode.spring.demo;

import io.truthencode.spring.demo.verticle.HelloWorld;
import io.vertx.core.Vertx;
import io.vertx.core.logging.Logger;
import io.vertx.core.logging.LoggerFactory;
import org.apache.camel.CamelContext;
import org.apache.camel.component.vertx.VertxComponent;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import javax.annotation.PostConstruct;

@SpringBootApplication
public class DemoApplication {

    public static void main(String[] args) {
        SpringApplication.run(DemoApplication.class, args);
    }
    private static Logger logger = LoggerFactory.getLogger(DemoApplication.class);
    @Autowired
    private HelloWorld hello;

    @Autowired
    private CamelContext camelContext;

    @PostConstruct
    public void deployServerVerticle() {
        logger.info("Setting up Vertx");
        final Vertx vertx = Vertx.vertx();
        VertxComponent vertxComponent = new VertxComponent();
        vertxComponent.setVertx(vertx);
        camelContext.addComponent("vertx", vertxComponent);
        vertx.deployVerticle(hello);
    }
}