package br.com.uff.vepcm.domain.entity;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

public class FaleConosco {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
}
