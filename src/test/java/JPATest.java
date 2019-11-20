import dao.*;
import domain.*;
import org.jboss.arquillian.container.test.api.Deployment;
import org.jboss.arquillian.junit.Arquillian;
import org.jboss.arquillian.junit.InSequence;
import org.jboss.shrinkwrap.api.ShrinkWrap;
import org.jboss.shrinkwrap.api.spec.JavaArchive;
import org.junit.Test;
import org.junit.runner.RunWith;
import javax.inject.Inject;
import java.util.Date;


@RunWith(Arquillian.class)
public class JPATest {

    @Inject
    EnderecoDAO enderecoDAO;

    @Inject
    ContatoDAO contatoDAO;

    @Inject
    ParticipanteDAO participanteDAO;

    @Inject
    ArtigoDAO artigoDAO;

    @Inject
    InscricaoDAO inscricaoDAO;

    @Inject
    InscricaoefetuadaDAO inscricaoefetuadaDAO;


    @Deployment
    public static JavaArchive criarArquivoTeste() {
        return ShrinkWrap.create(JavaArchive.class)
                .addPackage(ParticipanteDAO.class.getPackage())
                .addPackage(Participante.class.getPackage())
                .addAsResource("META-INF/persistence.xml");
    }
    @Test
    @InSequence(1)
    public void testeSalvarParticipante() {

        Endereco endereco = new Endereco();
        endereco.setLogradouro("Rua do Meio");
        endereco.setBairro("Oasis");
        endereco.setCidade("Cajazeiras");
        endereco.setEstado("Paraíba");
        endereco.setNumero("500");
        endereco.setCep("58900-000");

        Contato contato = new Contato();
        contato.setTelefoneResidencial("(83) 3552-5356");
        contato.setTelefoneComercial("(83) 3552-5356");
        contato.setTelefoneCelular("(83) 9999-9999");

        Participante participante = new Participante();
        participante.setEndereco(endereco);
        participante.setContato(contato);
        participante.setNome("Salomé");
        participante.setCPF("666.666.666-66");
        participante.setEmail("salome@gmail.com");
        participante.setInstituicao("IFPB");
        participante.setNomeCracha("Salomméééé");
        participante.setProfissao("Profesora");
        participante.setTipoUsuario("NAO INDENTIFICADO");

        Inscricaoefetuada inscricaoefetuada = new Inscricaoefetuada();
        inscricaoefetuada.setFormaPagamento(Inscricaoefetuada.FormaPagamento.CARTAO);
        inscricaoefetuada.setQuantidade(1);
        inscricaoefetuada.setStatus("PAGO");
        inscricaoefetuada.setTransacao("sei lá");
        inscricaoefetuada.setValor(500.00);

        Inscricao inscricao = new Inscricao();
        inscricao.setDataInscricao(new Date());
        inscricao.setPreco(200.00);
        inscricao.setStatus("PAGO");
        inscricao.setTipoEvento(Inscricao.TipoEvento.CONGRESSO);
        inscricao.setTipoParticipacao("Sei lá");
        inscricao.setParticipante(participante);

        Artigo artigo = new Artigo();
        artigo.setTitulo("Blá Blá Blá Blá");
        artigo.setCoautores("Zé do Caibro");
        artigo.setOrientador("Chico Chavier");
        artigo.setData_submissao("12/12/2019");
        artigo.setModalidade("Sei lá");
        artigo.setUrlDownload("dadasdasdadadasd");
        artigo.setParticipante(participante);

        participanteDAO.salvar(participante);
        inscricaoefetuadaDAO.salvar(inscricaoefetuada);
        inscricaoDAO.salvar(inscricao);
        artigoDAO.salvar(artigo);

    }

}
