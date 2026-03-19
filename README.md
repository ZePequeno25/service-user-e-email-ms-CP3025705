**ATENÇÃO: Configurações obrigatórias**

Antes de rodar os serviços, revise e altere os campos sensíveis nos arquivos `application.properties` de **ambos** os projetos (user-service e email-service):

- `spring.datasource.username` e `spring.datasource.password` (MySQL)
- `spring.rabbitmq.addresses` (URL completa do CloudAMQP)
- `spring.mail.username` e `spring.mail.password` (Gmail – use senha de aplicativo!)

Não deixe valores de exemplo ou credenciais reais commitadas no Git.
