package io.truthencode.spring.demo.verticle;


import io.vertx.core.AbstractVerticle;
import io.vertx.core.http.HttpServerOptions;
import org.springframework.stereotype.Component;

@Component
public class HelloWorld extends AbstractVerticle {
    public void start() {
        vertx.createHttpServer(new HttpServerOptions().setPort(8080)).requestHandler(
                req -> req.response().end("<body><h1>Hello World from Java!</h1></body>")).listen();
    }
}
