# Projeto de Microserviços com Spring Boot, Docker e Kubernetes

Este projeto demonstra a implementação de uma arquitetura baseada em **microserviços** utilizando **Spring Boot**, com ferramentas de **DevOps** como **Docker**, **Kubernetes**, e **GitHub Actions**. O projeto inclui três microserviços principais: `eureka-server`, `status-service` e `vehicle-service`, todos gerenciados e orquestrados com Kubernetes e Docker.

Os microserviços estão devidamente configurados para **registro e descoberta de serviços** utilizando o **Eureka Server**. Além disso, o projeto faz uso de **Docker** para empacotamento e **Kubernetes** para o deploy e gerenciamento de contêineres. Testes de integração podem ser realizados utilizando **Testcontainers**, que simula ambientes externos com containers Docker, garantindo que os serviços interajam corretamente em um ambiente controlado.

## Ferramentas e Tecnologias Utilizadas
- **Spring Boot**: Framework principal para desenvolvimento dos microserviços.
- **Eureka Server**: Serviço de descoberta para registro dinâmico de microserviços.
- **Docker**: Utilizado para criação e empacotamento dos serviços em contêineres.
- **Kubernetes**: Orquestração de contêineres para deploy e gerenciamento.
- **GitHub Actions**: Integração contínua (CI) para build e deploy automatizado.
- **Testcontainers**: Para testes de integração com dependências externas.
