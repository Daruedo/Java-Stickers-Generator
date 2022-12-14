
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.InputStream;
import javax.imageio.ImageIO;
import java.awt.Color;
import java.awt.Font;

public class GeradoraDeFigurinhas {

    // leitura da imagem

    //InputStream inputStream = new FileInputStream(new File("entrada/filme.jpg"));
    //IPnputStream inputStream = new URL("https://imersao-java-apis.s3.amazonaws.com/TopMovies_2.jpg").openStream();
    //BufferedImage imagemOriginal = ImageIO.read(new File("entrada/filme.jpg"));

    public void cria(InputStream inputStream, String nomeArquivo) throws Exception {

      BufferedImage imagemOriginal = ImageIO.read(inputStream); 

      // cria nova imagem em memória com transparência e com tamanho novo
      int largura = imagemOriginal.getWidth();
      int altura = imagemOriginal.getHeight();
      int novaAltura = altura + 200;
      BufferedImage novaImagem = new BufferedImage(largura, novaAltura, BufferedImage.TRANSLUCENT);

      // copiar a imagem original para nova imagem (em memória)
      Graphics2D graphics = (Graphics2D) novaImagem.getGraphics();
      graphics.drawImage(imagemOriginal, 0, 250, null);

      // configurar a fonte
      var fonte = new Font(Font.SANS_SERIF, Font.BOLD, 70);
      graphics.setColor(Color.CYAN);
      graphics.setFont(fonte);

      // escrever uma frase na nova imagem
      graphics.drawString("S.E.N.S.A.C.I.O.N.A.L", 150, novaAltura - 150);


      // escrever a nova imagem em um arquivo
      ImageIO.write(novaImagem, "png", new File(nomeArquivo));
         
    }

// public static void main(String[] args) throws Exception {
//    var geradora = new GeradoradFigurinhas();
//    geradora.cria(null, null);
    
// }

}
