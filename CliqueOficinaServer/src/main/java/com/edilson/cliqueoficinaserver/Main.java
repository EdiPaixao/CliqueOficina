package com.edilson.cliqueoficinaserver;

import com.edilson.cliqueoficinaserver.view.ViewConfiguracaoServidor;
import com.edilson.cliqueoficinaserver.view.ViewStatusServidor;

public class Main {

    public static void main(String[] args) {
        //new ViewConfiguracaoServidor().setVisible( true );
        new ViewStatusServidor().setVisible( true );
    }
}
