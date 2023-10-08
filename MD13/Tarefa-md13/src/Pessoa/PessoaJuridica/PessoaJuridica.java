package Pessoa.PessoaJuridica;

import Pessoa.Pessoa;

public class PessoaJuridica extends Pessoa{
    
    
    private Long cnpj;

    public PessoaJuridica(Long cnpj) {
        this.cnpj = cnpj;
    }

    public Long getCnpj() {
        return cnpj;
    }

    public void setCnpj(Long cnpj) {
        this.cnpj = cnpj;
    }

    @Override
    public String toString() {
        return getNome() + " do CNPJ " + this.cnpj + " é uma " + getClass().getSimpleName() ;
    }

    
    

    
}
