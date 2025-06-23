package com.todo.backend.controller;

import com.todo.backend.model.Tarefa;
import com.todo.backend.repository.TarefaRepository;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/tarefas")
@CrossOrigin(origins = "https://todo-angular-sable-two.vercel.app")
public class TarefaController {

    private final TarefaRepository repo;

    public TarefaController(TarefaRepository repo) {
        this.repo = repo;
    }

    @PostMapping
    public Tarefa criar(@RequestBody Tarefa tarefa) {
        return repo.save(tarefa);
    }

    @GetMapping
    public List<Tarefa> listar() {
        return repo.findAll();
    }

    @PatchMapping("/{id}/status")
    public Tarefa atualizarStatus(@PathVariable Long id, @RequestParam Tarefa.Status status) {
        Tarefa tarefa = repo.findById(id).orElseThrow();
        tarefa.setStatus(status);
        return repo.save(tarefa);
    }

    @DeleteMapping("/{id}")
    public void deletar(@PathVariable Long id) {
        repo.deleteById(id);
    }
}
