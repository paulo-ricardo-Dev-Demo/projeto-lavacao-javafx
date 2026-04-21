package br.edu.ifsc.fln.model.exceptions;

public class ExceptionLavacao extends Exception {
    public ExceptionLavacao(ExceptionLavacao e) {}

    public ExceptionLavacao(String msg) {
        super(msg);
    }

    public ExceptionLavacao(String msg, ExceptionLavacao causa) {
        super(msg, causa);
    }
}
