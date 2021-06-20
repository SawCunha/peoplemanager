package com.dio.sawcunha.peoplemanager.services;

import com.dio.sawcunha.peoplemanager.exceptionmanager.exception.AddressNotFoundIDException;
import com.dio.sawcunha.peoplemanager.service.AddressService;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class AddressServiceTest {

    @Autowired
    private AddressService addressService;

    @Test
    public void deleteAddressException(){
        Assertions.assertThatThrownBy(() -> {
            addressService.delete(25L);
        }).isInstanceOf(AddressNotFoundIDException.class);
    }

}
