
## 📚 Sobre o Projeto

Neste repositório, você encontrará o código-fonte de uma REST API e seu respectivo Frontend (pasta `/docs`). Este projeto, construído com Java 21 e Spring Boot 3, é o resultado de quatro dias de lives, com um propósito incrível:

**Objetivo**: "Permitir que os usuários conversem com os campeões do League of Legends (LOL)".

Para isso, utilizamos algumas das mais recentes Inteligências Artificiais (IAs) Generativas, possibilitando que nossa API "entenda" a personalidade única de cada campeão para criar interações que capturam sua essência, tornando cada conversa uma experiência única.

## Pré-Requisitos

Caso queira reproduzir este projeto, você terá os seguintes pré-requisitos:

- Vontade de Aprender 😉
- Instalação da JDK 21 (versão LTS do Java na data das lives)
- Instalação do IntelliJ IDEA Community Edition ou a IDE de sua preferência (Eclipse, VSCode etc)
- [Opcional] Conta na AWS (caso queira publicar a sua API REST na Nuvem usando o AWS Elastic Beanstalk)
- [Opcional] Conta na OpenAI e/ou Google para integração com os modelos GPT e/ou Gemini respectivamente.



Fundamentos da linguagem de programação Java e configurações de projetos Spring Boot. Foco em Programação Orientada a Objetos e sua relação com Bancos de Dados SQL através do Spring Data JDBC.
API REST, abordando design, desenvolvimento e documentação, com foco em campeões do League of Legends. Publicação da API no AWS Elastic Beanstalk.
Incorporação de IA para otimizar a API, utilizando o Spring Cloud OpenFeign para integração com APIs de IA de grandes provedores, como OpenAI (GPT) e Google (Gemini).
Construção da interface do usuário, interatividade e integração com a API explorando os fundamentos de HTML, CSS e JavaScript.

## 🏛️ Arquitetura do Projeto

A seguir, apresentamos o diagrama arquitetural do projeto, destacando a separação das responsabilidades entre as camadas. Desde a interface de usuário até os mecanismos de interação com sistemas externos, passando por adaptadores, casos de uso e as entidades centrais do domínio, cada elemento é estrategicamente posicionado para reforçar a modularidade, a escalabilidade e a manutenibilidade do sistema.

### Estrutura de Diretórios

Refletindo a organização apresentada no diagrama arquitetural, a estrutura de diretórios do projeto sugere uma Clean Architecture simplificada, visando a uma clara separação das responsabilidades e promovendo a autonomia das camadas em um projeto Spring Boot. Esta abordagem estrutural não só facilita a manutenção e a evolução do código, mas também sustenta a integração e a colaboração eficaz entre as diferentes partes da aplicação.

## Banco de Dados SQL em Memória

A utilização do banco de dados H2 neste projeto serve como uma fundação ágil e flexível para modelar nosso domínio de conhecimento — os campeões do LOL. Essa escolha permite uma rápida prototipação e um ambiente de desenvolvimento eficiente, essencial para armazenar e recuperar informações detalhadas sobre cada campeão. Dessa forma, garantimos que as IAs Generativas que integramos possam acessar um repositório rico e detalhado, permitindo-lhes capturar com precisão a essência e a personalidade única de cada campeão, enriquecendo assim a interatividade e a profundidade das interações realizadas.
