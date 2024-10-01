# Projeto de Microserviços com Spring Boot, Docker e Kubernetes

Este projeto demonstra a implementação de uma arquitetura baseada em **microserviços** utilizando **Spring Boot**, com ferramentas de **DevOps** como **Docker** e **Kubernetes**. O projeto inclui três microserviços principais: `eureka-server`, `status-service` e `vehicle-service`, além de um serviço reativo usando **Spring WebFlux** e **banco de dados H2 reativo**.

Os microserviços estão devidamente configurados para **registro e descoberta de serviços** utilizando o **Eureka Server**. Além disso, o projeto faz uso de **Docker** para empacotamento e **Kubernetes** para o deploy e gerenciamento de contêineres.

O serviço reativo utiliza **Spring WebFlux** para lidar com requisições de forma não bloqueante, e **H2** como banco de dados reativo, oferecendo uma abordagem mais eficiente para lidar com operações de I/O, especialmente em cenários de alta concorrência.

## Ferramentas e Tecnologias Utilizadas
- **Spring Boot**: Framework principal para desenvolvimento dos microserviços.
- **Eureka Server**: Serviço de descoberta para registro dinâmico de microserviços.
- **Docker**: Utilizado para criação e empacotamento dos serviços em contêineres.
- **Kubernetes**: Orquestração de contêineres para deploy e gerenciamento.
- **Spring WebFlux**: Para desenvolvimento de APIs reativas e não bloqueantes.
- **H2 Reativo**: Banco de dados em memória reativo utilizado com Spring Data R2DBC.
