package com.example;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class AppTest {

    private Application application;
    private Logger mockLogger;

    @BeforeEach
    public void setUp() {
        // Crear una instancia de la clase de la aplicación
        application = new Application();

        // Crear un mock para el Logger
        mockLogger = mock(Logger.class);

        // Reemplazar el logger real por el mock
        // Usar un framework como PowerMock para interceptar el Logger sería ideal en este caso
        LoggerFactory.getLogger(Application.class);  // Aquí es donde modificarías el logger si fuera necesario
    }

    @Test
    public void testGetStatus() {
        // Test para verificar que el método getStatus devuelve "OK"
        String status = application.getStatus();
        assertEquals("OK", status, "El estado debería ser 'OK'");
    }

    @Test
    public void testInitMethodLogsInfo() {
        // Verificar que el método init() genera el log esperado
        application.init();
        verify(mockLogger).info("Java app started");
    }
}
