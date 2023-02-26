package test;

import contact.contact;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class contactTest {

    @Test
    void testContact() {
        contact contact = new contact("112233", "John", "Doe", "2678889999", "4000 new, phila, pa, 19000");
        assertTrue(contact.getContactID().equals("112233"));
        assertTrue(contact.getFirstName().equals("John"));
        assertTrue(contact.getLastName().equals("Doe"));
        assertTrue(contact.getPhone().equals("2678889999"));
        assertTrue(contact.getAddress().equals("4000 new, phila, pa, 19000"));
    }

    @Test
    void testContactIDLong() {
        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            new contact("1234567891011", "John", "Doe", "267888999", "Practice Address");
        });
    }
    @Test
    void testContactIDNull() {
        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            new contact(null, "John", "Doe", "267888999", "Practice Address");
        });
    }

    @Test
    void testFirstNameLong() {
        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            new contact("12345678910", "JohnIsTooLong", "Doe", "267888999", "Practice Address");
        });
    }
    @Test
    void testFirstNameNull() {
        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            new contact("123456", null, "Doe", "267888999", "Practice Address");
        });
    }

    @Test
    void testLastNameLong() {
        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            new contact("123456789", "John", "Doe is too long", "267888999", "Practice Address");
        });
    }
    @Test
    void testLastNameNull() {
        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            new contact("123456", "John", null, "267888999", "Practice Address");
        });
    }

    @Test
    void testPhoneLong() {
        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            new contact("123456789", "John", "Doe", "2678889991234", "Practice Address");
        });
    }
    @Test
    void testPhoneNull() {
        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            new contact("12345", "John", "Doe", null, "Practice Address");
        });
    }

    @Test
    void testAddressLong() {
        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            new contact("123456789", "John", "Doe", "267888999", "Practice Address is too long fix it");
        });
    }
    @Test
    void testAddressIDNull() {
        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            new contact("12345", "John", "Doe", "267888999", null);
        });
    }

}