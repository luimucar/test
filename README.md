# Test

O objetivo é criar um fomulário de cadastro e armazenar as informações digitadas no banco de dados, neste projeto, utilize o Spring Framework para o MVC e persistência de dados juntamente com o Hibernate. Após a finalização faça commit e envie o link para esdras.tavares@fiveware.com.br

# Dicas

1 - De um fork neste projeto, clone e importe no eclipse

2 - Crie 2 módulos "maven" com os seguintes nomes:

  - fiveware-test-service (jar)
  - fiveware-test-web (war)
  
Observe que já existe um "parent" e o fiveware-test-model(jar)

3 - Configure o Spring MVC no projeto web(fiveware-test-web), essa configuração deve ser SEM XML.

4 - Crie um formulário qualquer de cadastro que tenha no mínimo os seguintes elementos:

  - Campo de texto
  - Checkbox
  - Combobox
  - radio
  
O envio dos dados do formulário deve ser via AJAX

5 - Crie o modelo de dados para este formulário no MySQL e também a entidade no módulo fiveware-test-model

6 - Implemente todas as camadas, a view chamando o controller, o controller chamando o service e o service invocando o repositório.
