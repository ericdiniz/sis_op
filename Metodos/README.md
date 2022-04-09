O escalonador é responsável por decidir a ordem de execução dos processos prontos, ou seja, que escalona os processos. O escalonamento de processos é realizado por um algoritmo que visa tratar de forma eficiente e rápida os processos a serem tratados. Vários critérios podem ser definidos para a avaliação dos escalonadores. Os mais frequentes são:

* tempo de execução (turnaround) → mede o tempo decorrido entre a criação e o encerramento da tarefa, computando todos os tempos de processamento e de espera.

* tempo de espera (waiting time) → tempo total perdido pela tarefa na fila de prontos, aguardando o processador.

* tempo de resposta → tempo decorrido entre a chegada de um evento ao sistema e o resultado imediato de seu processamento.

* Eficiência → Indica o grau de utilização do processador na execução das tarefas do usuário.

* Justiça → Distribuição do processador entre as tarefas prontas.

------

#### Escalonamento FCFC (First-Come, First Served)

> É a forma mais elementar de escalonamento. Utiliza um algoritmo simples que atende as tarefas em sequência assim que ficam prontas. Ou seja, de acordo com sua chegada na fila de prontos (FIFO). Não utiliza preempção.

#### Escalonamento Round-Robin

> O FCFS não leva em conta a importância das tarefas nem seu comportamento em relação aos recursos. É o algoritmo FCFS com a adição de preempção por tempo ao escalonamento. Define um tempo de quantum.

#### Escalonamento SJF

> O algoritmo de escalonamento que proporciona os menores tempos médios de execução e de espera é conhecido como menor tarefa primeiro, ou SJF (Shortest Job First). Consiste em atribuir o processador à menor (mais curta) tarefa da fila de tarefas prontas.

#### Escalonamento por Prioridades

> No escalonamento por prioridades, a cada tarefa é associada uma prioridade (número inteiro) usada para escolher a próxima tarefa a receber o processador, a cada troca de contexto.

------

#### Referências:

Sistemas Operacionais: Conceitos e Mecanismos – Carlos Maziero disponível em: <http://wiki.inf.ufpr.br/maziero/doku.php?id=so:livro_de_sistemas_operacionais>
