import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThrows;

public class ServicoFactoryTest {

    @Test
    public void deveRetornarFesta() {
        IServico servico = ServicoFactory.obterServico("Festa");
        assertEquals("Festa organizada", servico.executar());
        assertEquals("Festa cancelada", servico.cancelar());
    }

    @Test
    public void deveRetornarCampeonato() {
        IServico servico = ServicoFactory.obterServico("Campeonato");
        assertEquals("Campeonato realizado", servico.executar());
        assertEquals("Campeonato cancelado", servico.cancelar());
    }

    @Test
    public void deveRetornarReuniao() {
        IServico servico = ServicoFactory.obterServico("Reuniao");
        assertEquals("Reunião agendada", servico.executar());
        assertEquals("Reunião cancelada", servico.cancelar());
    }

    @Test
    public void deveRetornarDoacao() {
        IServico servico = ServicoFactory.obterServico("Doacao");
        assertEquals("Doação organizada", servico.executar());
        assertEquals("Doação cancelada", servico.cancelar());
    }

    @Test
    public void deveLancarExcecaoParaServicoInexistente() {
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            ServicoFactory.obterServico("Inexistente");
        });
        assertEquals("Serviço inexistente", exception.getMessage());
    }

    @Test
    public void deveLancarExcecaoParaServicoInvalido() {
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            ServicoFactory.obterServico("Jubilamento"); // Classe sem implementar IServico
        });
        assertEquals("Serviço inválido", exception.getMessage());
    }
}
{
}
