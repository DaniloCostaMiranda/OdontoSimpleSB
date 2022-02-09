package com.odontosimple.azulay.entities.enums;

public enum Dentes {

    Incisvo_central_SD(11),
    Incisvo_lateral_SD(12),
    Canino_SD(13),
    Primeiro_pre_molar_SD(14),
    Segundo_pre_molar_SD(15),
    Primeiro_molar_SD(16),
    Segundo_molar_SD(17),
    Ciso_SD(18),
    Incisvo_central_SE(21),
    Incisvo_lateral_SE(22),
    Canino_SE(23),
    Primeiro_pre_molar_SE(24),
    Segundo_pre_molar_SE(25),
    Primeiro_molar_SE(26),
    Segundo_molar_SE(27),
    Ciso_SE(28),
    Incisvo_central_IE(31),
    Incisvo_lateral_IE(32),
    Canino_IE(33),
    Primeiro_pre_molar_IE(34),
    Segundo_pre_molar_IE(35),
    Primeiro_molar_IE(36),
    Segundo_molar_IE(37),
    Ciso_IE(38),
    Incisvo_central_ID(41),
    Incisvo_lateral_ID(42),
    Canino_ID(43),
    Primeiro_pre_molar_ID(44),
    Segundo_pre_molar_ID(45),
    Primeiro_molar_ID(46),
    Segundo_molar_ID(47),
    Ciso_ID(48);

    private int code;

    private Dentes(int code){
        this.code = code;
    }

    public int getCode(){
        return code;
    }

    public static Dentes valueOf(int code) {
        for(Dentes value : Dentes.values()){
            if(value.getCode() == code){
                return value;
            }
        }
        throw new IllegalArgumentException("Código de identificação do dente inválido");
    }
}
