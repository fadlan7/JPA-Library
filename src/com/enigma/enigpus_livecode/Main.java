package com.enigma.enigpus_livecode;

import com.enigma.enigpus_livecode.service.InventoryService;
import com.enigma.enigpus_livecode.service.InventoryServiceImpl;
import com.enigma.enigpus_livecode.view.EnigpusView;

public class Main {
    public static void main(String[] args) {
        InventoryService inventoryService = new InventoryServiceImpl();
        EnigpusView view = new EnigpusView(inventoryService);
        view.run();
    }
}
