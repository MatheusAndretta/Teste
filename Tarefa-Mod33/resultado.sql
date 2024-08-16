select * from tb_marca;

select * from tb_carro;

select * from tb_acessorio;


delete from tb_marca;

delete from tb_carro;

delete from tb_acessorio;


select  m.nome,c.nome,c.cor,a.tipoacessorio,a.descricao,c.descricao
	from tb_marca m, tb_carro c, tb_acessorio a
	where m.codigo = c.codigo;
