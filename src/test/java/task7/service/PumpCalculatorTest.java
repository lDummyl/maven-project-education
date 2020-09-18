package task7.service;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.Mockito;
import task7.dao.FakePumpDaoImpl;
import task7.model.Pump;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.ArgumentMatchers.anyDouble;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

class PumpCalculatorTest {

    @Mock
    private FakePumpDaoImpl pumpDao;
    private PumpCalculator pc;

    @BeforeEach
    void setup() {
        pumpDao = Mockito.mock(FakePumpDaoImpl.class);
        pc = new PumpCalculator();
        pc.setPumpDao(pumpDao);
    }

    @Test
    void getPumpNotNullResultTest() {
        assertNotNull(pc.get(anyDouble(), anyDouble()));
    }

    @Test
    void getPumpMethodCallTest() {
        Pump pump = new Pump();
        when(pumpDao.selectPump(anyDouble(), anyDouble())).thenReturn(Optional.of(pump));
        pc.get(123.0, 321.0);
        verify(pumpDao).selectPump(anyDouble(), anyDouble());
    }

}