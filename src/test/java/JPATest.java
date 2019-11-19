import dao.ArtigoDAO;
import domain.Artigo;
import org.jboss.arquillian.container.test.api.Deployment;
import org.jboss.arquillian.core.api.annotation.Inject;
import org.jboss.arquillian.junit.Arquillian;
import org.jboss.arquillian.junit.InSequence;
import org.jboss.shrinkwrap.api.ShrinkWrap;
import org.jboss.shrinkwrap.api.asset.EmptyAsset;
import org.jboss.shrinkwrap.api.spec.JavaArchive;
import org.junit.Test;
import org.junit.runner.RunWith;

@RunWith(Arquillian.class)
public class JPATest {

    @Inject
    ArtigoDAO artigoDao;

    @Deployment
    public static JavaArchive criarArquivoTeste() {
        return ShrinkWrap.create(JavaArchive.class)
                .addPackage(Artigo.class.getPackage())
                .addPackage(Artigo.class.getPackage())
                .addAsResource("META-INF/persistence.xml");
    }
    @Test
    public void testeSalvarArtigo() {
        Artigo artigo = new Artigo("titulo teste","orientador teste","coautores teste",
                "modalidade teste"
                ,"data teste","urlteste");
        artigoDao.salvar(artigo);

    }
}
