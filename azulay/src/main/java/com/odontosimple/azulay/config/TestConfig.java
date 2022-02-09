package com.odontosimple.azulay.config;

import com.odontosimple.azulay.entities.*;
import com.odontosimple.azulay.entities.enums.Dentes;
import com.odontosimple.azulay.repositories.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import java.time.Instant;
import java.util.Arrays;

@Configuration
@Profile("test")
public class TestConfig implements CommandLineRunner {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private TratamentoRepository tratamentoRepository;

    @Autowired
    private StatusRepository statusRepository;

    @Autowired
    private ProcedimentoRepository procedimentoRepository;

    @Autowired
    private DenteCodeRepository dentecodeRepository;

    @Autowired
    private TratamentoItemRepository tratamentoItemRepository;


    @Override
    public void run(String... args) throws Exception {

        User u1 = new User(null, "Maria Brown", "maria@gmail.com", "988888888", "123456", Instant.parse("1986-03-27T19:53:07Z"));
        User u2 = new User(null, "Alex Green", "alex@gmail.com", "977777777", "123456", Instant.parse("1989-06-20T19:53:07Z"));

        userRepository.saveAll(Arrays.asList(u1, u2));

        Status s1 = new Status(null, "Agendado");
        Status s2 = new Status(null, "Cancelado");
        Status s3 = new Status(null, "Aberto");
        Status s4 = new Status(null, "Fechado");
        Status s5 = new Status(null, "Ativo");
        Status s6 = new Status(null, "Inativo");

        statusRepository.saveAll(Arrays.asList(s1, s2, s3, s4, s5, s6));

        DenteCode d1 = new DenteCode(null, 11, "Incisivo Central_SD");
        DenteCode d2 = new DenteCode(null, 12, "Incisivo Lateral_SD");
        DenteCode d3 = new DenteCode(null, 13, "Canino_SD");
        DenteCode d4 = new DenteCode(null, 14, "Primeiro Pré Molar_SD");
        DenteCode d5 = new DenteCode(null, 15, "Segundo Pré Molar_SD");
        DenteCode d6 = new DenteCode(null, 16, "Primeiro Molar_SD");
        DenteCode d7 = new DenteCode(null, 17, "Segundo Molar_SD");
        DenteCode d8 = new DenteCode(null, 18, "Ciso_SD");
        DenteCode d9 = new DenteCode(null, 21, "Incisivo Central_SE");
        DenteCode d10 = new DenteCode(null, 22, "Incisivo Lateral_SE");
        DenteCode d11 = new DenteCode(null, 23, "Canino_SE");
        DenteCode d12 = new DenteCode(null, 24, "Primeiro Pré Molar_SE");
        DenteCode d13 = new DenteCode(null, 25, "Segundo Pré Molar_SE");
        DenteCode d14 = new DenteCode(null, 26, "Primeiro Molar_SE");
        DenteCode d15 = new DenteCode(null, 27, "Segundo Molar_SE");
        DenteCode d16 = new DenteCode(null, 28, "Ciso_SE");
        DenteCode d17 = new DenteCode(null, 31, "Incisivo Central_IE");
        DenteCode d18 = new DenteCode(null, 32, "Incisivo Lateral_IE");
        DenteCode d19 = new DenteCode(null, 33, "Canino_IE");
        DenteCode d20 = new DenteCode(null, 34, "Primeiro Pré Molar_IE");
        DenteCode d21 = new DenteCode(null, 35, "Segundo Pré Molar_IE");
        DenteCode d22 = new DenteCode(null, 36, "Primeiro Molar_IE");
        DenteCode d23 = new DenteCode(null, 37, "Segundo Molar_IE");
        DenteCode d24 = new DenteCode(null, 38, "Ciso_IE");
        DenteCode d25 = new DenteCode(null, 41, "Incisivo Central_ID");
        DenteCode d26 = new DenteCode(null, 42, "Incisivo Lateral_ID");
        DenteCode d27 = new DenteCode(null, 43, "Canino_ID");
        DenteCode d28 = new DenteCode(null, 44, "Primeiro Pré Molar_ID");
        DenteCode d29 = new DenteCode(null, 45, "Segundo Pré Molar_ID");
        DenteCode d30 = new DenteCode(null, 46, "Primeiro Molar_ID");
        DenteCode d31 = new DenteCode(null, 47, "Segundo Molar_ID");
        DenteCode d32 = new DenteCode(null, 48, "Ciso_ID");

        Procedimento p1 = new Procedimento(null, "Limpeza",200.00);
        Procedimento p2 = new Procedimento(null, "Restauracao",  250.00);
        Procedimento p3 = new Procedimento(null, "Canal",900.00);
        Procedimento p4 = new Procedimento(null, "Implante", 1700.00);
        Procedimento p5 = new Procedimento(null, "Extração", 300.00);

        dentecodeRepository.saveAll(Arrays.asList(d1, d2, d3, d4, d5, d6, d7, d8, d9, d10, d11, d12, d13, d14, d15, d16, d17, d18, d19, d20, d21, d22, d23, d24, d25, d26, d27, d28, d29, d30, d31, d32));
        procedimentoRepository.saveAll(Arrays.asList(p1, p2, p3, p4, p5));

        p1.getDentecodes().add(d18);
        p2.getDentecodes().add(d23);
        p2.getDentecodes().add(d29);
        p3.getDentecodes().add(d30);
        p4.getDentecodes().add(d31);
        p5.getDentecodes().add(d32);

        procedimentoRepository.saveAll(Arrays.asList(p1, p2, p3, p4, p5));

        Tratamento t1 = new Tratamento(null, Instant.parse("2019-06-20T19:53:07Z"), u1, s3);
        Tratamento t2 = new Tratamento(null, Instant.parse("2019-07-21T03:42:10Z"), u2, s4);
        Tratamento t3 = new Tratamento(null, Instant.parse("2019-07-22T15:21:22Z"), u1, s4);

        tratamentoRepository.saveAll(Arrays.asList(t1, t2, t3));

        TratamentoItem ti1 = new TratamentoItem(t1, p2, 2, p2.getPrice());
        TratamentoItem ti2 = new TratamentoItem(t2, p4, 1, p4.getPrice());
        TratamentoItem ti3 = new TratamentoItem(t3, p5, 2, p5.getPrice());
        TratamentoItem ti4 = new TratamentoItem(t3, p1, 1, p5.getPrice());

        tratamentoItemRepository.saveAll(Arrays.asList(ti1, ti2, ti3, ti4));

        Payment pay1 = new Payment(null, Instant.parse("2019-07-21T05:42:10Z"), t2 );
        t2.setPayment(pay1);

        tratamentoRepository.save(t2);

    }
}
