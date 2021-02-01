package eurogeo.pl.linear.linearservice.services;

import eurogeo.pl.linear.linearservice.domain.Operat;
import eurogeo.pl.linear.linearservice.domain.Projekt;
import eurogeo.pl.linear.linearservice.repositories.OperatRepository;
import eurogeo.pl.linear.linearservice.repositories.ProjektRepository;
import eurogeo.pl.linear.linearservice.web.mapper.OperatMapper;
import eurogeo.pl.linear.model.OperatDto;
import eurogeo.pl.linear.model.ProjektDto;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.mockito.stubbing.Answer;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;


import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class OperatServiceImplTest {

    @Mock
    OperatMapper operatMapper;
    @Mock
    ProjektRepository projektRepository;
    @Mock
    OperatRepository operatRepository;
    @InjectMocks
    OperatServiceImpl service;

    @Test
    void listOperatsByLayer() {

    }

    @Test
    void getByOperatIdAndProjectId() {
    }

    @Test
    void saveNewOperat() {

    }

    @Test
    void updateOperat() {
    }

    @Test
    void listOperatsBeetwenScope() {
    }

    @Test
    void listOperatsInScope() {
    }

    @Test
    void listOperatsLessThan() {
    }


}