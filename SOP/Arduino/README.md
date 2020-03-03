# FreeRTOS

> Código é para realizar o cálculo de Seno através da Extensão de Taylor e mudar cadência do LED. Para isso são utilizado 3 tarefas, onde:

+ Tarefa vReceiver: Responsável por ficar recebendo dados da serial(usuário) e alimenta duas filas, uma do seno e uma do led;
+ Tarefa vTaskseno: Recebe da fila Buffer_seno um valor "MSXX" onde o XX representa um ângulo que varia de 0 a 99. A tarefa retorna para o usuário o resultado. Esse retorno deveria ser para a tarefa vReceiver e elá encaminhar para o usuário, mas isso não está acontecendo;
+ Tarefa VTaskled:  Recebe da fila Buffer_led um valor "BL1X" onde o X se refere a cadência que o Blink irá atuar.
