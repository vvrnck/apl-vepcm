package br.com.uff.vepcm.service.exception;

public class LoginUsuarioException extends RuntimeException {
    public LoginUsuarioException() {
        super();
    }

    public LoginUsuarioException(String message) {
        super(message);
    }

    public LoginUsuarioException(String message, Throwable cause) {
        super(message, cause);
    }
}
