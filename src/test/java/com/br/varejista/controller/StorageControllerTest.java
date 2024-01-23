//package com.br.varejista.controller;
//
//import com.br.varejista.model.Product;
//import com.br.varejista.model.Storage;
//import com.br.varejista.service.StorageService;
//import org.junit.jupiter.api.BeforeEach;
//import org.junit.jupiter.api.Test;
//import org.junit.jupiter.api.extension.ExtendWith;
//import org.mockito.InjectMocks;
//import org.mockito.Mock;
//import org.mockito.Mockito;
//import org.mockito.MockitoAnnotations;
//import org.mockito.junit.jupiter.MockitoExtension;
//import org.springframework.http.HttpStatus;
//import org.springframework.http.ResponseEntity;
//
//import java.time.LocalDate;
//import java.util.Collections;
//import java.util.List;
//import java.util.Set;
//
//import static org.junit.jupiter.api.Assertions.assertEquals;
//import static org.mockito.Mockito.times;
//import static org.mockito.Mockito.when;
//
//@ExtendWith(MockitoExtension.class)
//class StorageControllerTest {
//
//    @Mock
//    private StorageService service;
//
//    @InjectMocks
//    private StorageController controller;
//
//    @BeforeEach
//    void setUp() {
//        MockitoAnnotations.openMocks(ClientControllerTest.class);
//    }
//
//    @Test
//    void saveNew() {
//        Storage storage = makeClient();
//        when(service.save(storage, com.br.varejista.validator.Operation.INSERT)).thenReturn(storage);
//        ResponseEntity response = controller.saveNew(storage);
//        assertEquals(HttpStatus.CREATED, response.getStatusCode());
//        assertEquals(storage, response.getBody());
//    }
//
//    @Test
//    void delete() {
//        ResponseEntity response = controller.delete(1);
//        assertEquals(HttpStatus.OK, response.getStatusCode());
//        Mockito.verify(service, times(1)).delete(1);
//    }
//
//    @Test
//    void findAllByStorageProducts() {
//        Product products = makeProduct();
//        List<Storage> expectedStorage = Collections.singletonList(makeStorage());
//        when(service.findAllByStorageAddress(products)).thenReturn(expectedStorage);
//        List<Storage> actualStorage = controller.findAllByStorageAddress(products);
//        assertEquals(expectedStorage, actualStorage);
//    }
//
//    @Test
//    void findAllByStorageCnpj() {
//        String cnpj = "12345678910";
//        List<Storage> expectedStorage = Collections.singletonList(makeStorage());
//        when(service.findAllByStorageCnpj(cnpj)).thenReturn(expectedStorage);
//        List<Storage> actualStorage = controller.findAllByStorageCnpj(cnpj);
//        assertEquals(expectedStorage, actualStorage);
//    }
//
//    @Test
//    void findAllByStorageFranchise() {
//        String franchise = "Grupo Oscar";
//        List<Storage> expectedStorage = Collections.singletonList(makeStorage());
//        when(service.findAllByStorageFranchise(franchise)).thenReturn(expectedStorage);
//        List<Storage> actualStorage = controller.findAllByStorageFranchise(franchise);
//        assertEquals(expectedStorage, actualStorage);
//    }
//
//    @Test
//    void findAllByStorageAddress() {
//        String address = "Rua Central, 123";
//        List<Storage> expectedStorage = Collections.singletonList(makeStorage());
//        when(service.findAllByStorageAddress(address)).thenReturn(expectedStorage);
//        List<Storage> actualStorage = controller.findAllByStorageAddress(address);
//        assertEquals(expectedStorage, actualStorage);
//    }
//
//    public Product makeProduct(){
//        return new Product(1,"Scarpin","Material sem origem animal", 300.0, 36,
//                1, "Preto", "Salto", "Arezzo",
//                LocalDate.of(2024, 1, 23));
//    }
//
//
//    public Storage makeStorage(Set<Product> products){
//        Product product = makeProduct();
//        products.add(product);
//        return new Storage(1,products ,"Oscar SJC", "12345678910", "Grupo Oscar", "Rua Central, 123");
//    }
//}
//
