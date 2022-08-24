import java.util.List;

import stickers.Conteudo;

public interface ExtratorDeConteudo {
     
        List<Conteudo> extraiConteudos(String json);
}
