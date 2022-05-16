package domain

import domain.criterios.CriterioDeAprovacao

class AnalisadorDeAprovacao {

    private lateinit var criterio: CriterioDeAprovacao

    fun defineCriterio(criterio: CriterioDeAprovacao) {
        this.criterio = criterio
    }

    fun fechaBoletim(boletim: Boletim): BoletimFechado {
        return BoletimFechado(
            mediaEPs = boletim.mediaEPs, 
            mediaMiniEPs = boletim.mediaMiniEPs, 
            mediaFinal = this.criterio.mediaFinal(boletim), 
            foiAprovado = this.criterio.estaAprovado(boletim)
        )
    }

}