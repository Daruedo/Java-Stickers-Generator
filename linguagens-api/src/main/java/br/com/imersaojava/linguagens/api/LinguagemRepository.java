package br.com.imersaojava.linguagens.api;

import org.springframework.data.mongodb.repository.MongoRepository;

public interface LinguagemRepository extends MongoRepository<Linguagem, String> {
    
}
