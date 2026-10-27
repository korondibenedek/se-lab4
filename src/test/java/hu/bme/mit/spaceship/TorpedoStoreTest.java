package hu.bme.mit.spaceship;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.Test;

class TorpedoStoreTest {

    @Test
    void fire_Success() {
        // Arrange
        TorpedoStore store = new TorpedoStore(1);

        // Act
        boolean result = store.fire(1);

        // Assert
        assertEquals(true, result);
    }

    @Test
    void fire_Failure_Overheating() {
        TorpedoStore store = new TorpedoStore(1, 1.0);
        boolean result = store.fire(1);
        assertEquals(false, result);
    }

    @Test
    void fire_ZeroTorpedos_ThrowsException() {
        TorpedoStore store = new TorpedoStore(1);
        assertThrows(IllegalArgumentException.class, () -> store.fire(0));
    }

    @Test
    void fire_NegativeTorpedos_ThrowsException() {
        TorpedoStore store = new TorpedoStore(1);
        assertThrows(IllegalArgumentException.class, () -> store.fire(-1));
    }

    @Test
    void fire_MoreThanAvailable_ThrowsException() {
        TorpedoStore store = new TorpedoStore(1);
        assertThrows(IllegalArgumentException.class, () -> store.fire(2));
    }

    @Test
    void isEmpty_InitiallyFalse() {
        TorpedoStore store = new TorpedoStore(1);
        assertEquals(false, store.isEmpty());
    }

    @Test
    void isEmpty_WhenZeroTorpedos_True() {
        TorpedoStore store = new TorpedoStore(0);
        assertEquals(true, store.isEmpty());
    }

    @Test
    void isEmpty_AfterFiringAllTorpedos_True() {
        TorpedoStore store = new TorpedoStore(1);
        store.fire(1);
        assertEquals(true, store.isEmpty());
    }

    @Test
    void getTorpedoCount_InitialValue() {
        TorpedoStore store = new TorpedoStore(10);
        assertEquals(10, store.getTorpedoCount());
    }
}
