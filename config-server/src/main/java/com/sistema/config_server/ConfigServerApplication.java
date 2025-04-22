package com.sistema.config_server;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.config.server.EnableConfigServer;

@SpringBootApplication
@EnableConfigServer
public class ConfigServerApplication {
    public static void main(String[] args) {
        SpringApplication.run(ConfigServerApplication.class, args);
    }
}


global:
  scrape_interval: 5s  # Intervalo para la recolección de métricas

scrape_configs:
  - job_name: 'microservicios'
    static_configs:
      - targets: ['localhost:8081', 'localhost:8082', 'localhost:8083']  # Aquí agregas las URLs de tus microservicios
