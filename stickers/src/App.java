import java.io.InputStream;
import java.net.URL;
import java.util.List;
import java.util.Map;

public class App {
    public static void main(String[] args) throws Exception {

        // fazer uma conexão HTTP e buscar os top 250 filmes
        // String url = "https://imdb-api.com/en/API/Top250Movies/k_556r1nuc";
        // ExtratorDeConteudo extrator = new ExtratorDeConteudoDoIMDB();

        String url = "https://api.nasa.gov/planetary/apod?api_key=k2wKvm2xYAELkQXd2EcakIgjb2YBCj8oMv3aXrUh";
        ExtratorDeConteudo extrator = new ExtratorDeConteudoDaNasa();

        // String url = "http://localhost:8080/linguagens";
        // ExtratorDeConteudo extrator = new ExtratorDeConteudoDaAPI();

        var http = new ClienteHttp();
        String json = http.buscaDados(url);
        
        // exibir e manipular os dados
        List<Conteudo> conteudos = extrator.extraiConteudos(json);

        var geradora = new GeradoraDeFigurinhas();
        
        for (int i = 0; i < 4; i++) {
            Conteudo conteudo = conteudos.get(i);
                       
            InputStream inputStream = new URL(conteudo.getUrlImagem()).openStream();
            String nomeArquivo = "saida/" + conteudo.getTitulo() + ".png";

            geradora.cria(inputStream, nomeArquivo);

            System.out.println(conteudo.getTitulo());
            System.out.println(conteudo);
        }                       
    }
}

