package acesso;

import java.util.List;

import model.Conteudo;

public interface ExtratorDeConteudo {
	List<Conteudo> extraiConteudos(String json);

}
