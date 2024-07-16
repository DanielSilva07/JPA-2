import br.com.danielsilva.dao.*;
import br.com.danielsilva.domain.Acessorios;
import br.com.danielsilva.domain.Carro;
import br.com.danielsilva.domain.Marca;
import org.junit.Assert;
import org.junit.Test;
import static org.junit.Assert.*;

public class CarroTest {

    private ICarroDao carroDao;
    private IAcessoriosDao acessoriosDao;
    private IMarcaDao marcaDao;

    public CarroTest(){
        carroDao = new CarroDao();
         marcaDao = new MarcaDao();
         acessoriosDao = new AcessoriosDao();
    }

    @Test
    public void cadastrar(){
        Acessorios acessorios = new Acessorios();


        Carro carro = new Carro();
        carro.setName("Mazda");
        carro.setAno("1998");
        carro.setPrice(4400L);
        acessorios.setCarro(carro);
        acessorios.setDescription("Nitro");

        carro = carroDao.cadastrar(carro);
        acessorios = acessoriosDao.cadastrar(acessorios);

        Assert.assertNotNull(carro);
        Assert.assertNotNull(acessorios);

    }

    @Test
    public void buscarPorId(){
        Carro carro = new Carro();
        carro.setId(17L);

        Carro carroDAO = carroDao.buscarPorId(carro.getId());
        Assert.assertNotNull(carroDAO);
        Assert.assertEquals(carro.getId() , carroDAO.getId());
        System.out.println(carroDAO.getName());


    }
    @Test
    public void excluir(){
        Carro carro =  new Carro();
        carro.setId(17L);

        Carro carroDAO = carroDao.buscarPorId(carro.getId());
        carroDao.excluir(carro);
        Assert.assertNotNull(carroDAO);
        System.out.println("Carro excluido foi " + carroDAO.getName());


    }



}