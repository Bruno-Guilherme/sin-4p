package br.com.aos.atv_curriculum.config.curriculum.exceptions;

public class CurriculumNotFoundException extends RuntimeException {
    public CurriculumNotFoundException(String message) {
        super(message);
    }
}
