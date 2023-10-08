package Pessoa.PessoaFisica;

import Pessoa.Pessoa;

public class PessoaFisica extends Pessoa {

    
    private Long cpf;
    
    public PessoaFisica(Long cpf) {
        this.cpf = cpf;
        
    }

    public Long getCpf() {
        return cpf;
    }

    public void setCpf(Long cpf) {
        this.cpf = cpf;
    }

    @Override
    public String toString() {
        return getNome() + " do CPF " + this.cpf + " é uma " + getClass().getSimpleName() ;
    }
        

    
}
