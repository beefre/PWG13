package org.bedu.backend.postwork7.service;

import org.springframework.stereotype.Service;

import java.util.regex.Pattern;

@Service
public class TelefonoService {

    private static final Pattern PATTERN_TELEFONO = Pattern.compile("^(\\d{2,4}[- .]?){2}\\d{4}$");
    private static final String FORMATO_INICIAL_TELEFONO = "(\\d{2})(\\d{4})(\\d+)";
    private static final String FORMATO_FINAL_TELEFONO = "($1)-$2-$3";

    public boolean isValido(String telefono){
        return PATTERN_TELEFONO.matcher(telefono).matches();
    }

    public String limpiaNumero(String telefono){
        return telefono.replaceAll("[^0-9]", "");
    }

    public String formatea(String telefono) {
        return String.valueOf(telefono).replaceFirst(FORMATO_INICIAL_TELEFONO, FORMATO_FINAL_TELEFONO);
    }
}
