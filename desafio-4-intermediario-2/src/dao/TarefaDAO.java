package dao;

import model.Tarefa;
import java.util.ArrayList;

public class TarefaDAO {
  ArrayList<Tarefa> tarefas = new ArrayList<>();
  int lastId = 0;

  public void add(String description) {
    Tarefa tarefa = new Tarefa();

    tarefa.setId(lastId + 1);
    tarefa.setDescricao(description);
    tarefa.setStatus("pendente");

    lastId++;

    tarefas.add(tarefa);

    System.out.printf("ID: %d - Descrição: %s - Status: %s\n", tarefa.getId(), tarefa.getDescricao(), tarefa.getStatus());
  }

  public void list() {
    if (tarefas.isEmpty()) {
      System.out.println("Lista vazia");
      return;
    }

    for (Tarefa tarefa : tarefas) {
      System.out.printf("ID: %d - Descrição: %s - Status: %s\n", tarefa.getId(), tarefa.getDescricao(), tarefa.getStatus());
    }
  }

  public void complete(int id) {
    Boolean found = false;

    for (Tarefa tarefa : tarefas) {
      if (tarefa.getId() == id) {
        tarefa.setStatus("Concluído");
        found = true;
        break;
      }
    }

    if(!found) {
      System.out.println("Tarefa não encontrada");
    }
  }

  public void end() {
    System.out.println("Encerramento");
    System.exit(1);
  }
}
