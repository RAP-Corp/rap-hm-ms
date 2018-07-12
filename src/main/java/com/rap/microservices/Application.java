package com.rap.microservices;

import com.mongodb.connection.SslSettings;
import com.mongodb.connection.netty.NettyStreamFactoryFactory;
import io.netty.channel.nio.NioEventLoopGroup;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.mongo.MongoClientSettingsBuilderCustomizer;
import org.springframework.context.annotation.Bean;
import org.springframework.data.mongodb.config.EnableMongoAuditing;
import org.springframework.data.mongodb.repository.config.EnableReactiveMongoRepositories;

import javax.annotation.PreDestroy;


@SpringBootApplication
@EnableReactiveMongoRepositories
//@EnableWebFluxSecurity
@EnableMongoAuditing
public class Application {

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);

    }

    private NioEventLoopGroup eventLoopGroup = new NioEventLoopGroup();


    @Bean
    public MongoClientSettingsBuilderCustomizer sslCustomizer() {
        return clientSettingsBuilder -> clientSettingsBuilder
                .sslSettings(SslSettings.builder()
                        .enabled(true)
                        .invalidHostNameAllowed(true)
                        .build())
                .streamFactoryFactory(NettyStreamFactoryFactory.builder()
                        .eventLoopGroup(eventLoopGroup).build());

    }

    @PreDestroy
    public void shutDownEventLoopGroup() {
        eventLoopGroup.shutdownGracefully();
    }


}
