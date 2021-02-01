package eurogeo.pl.linear.linearservice.services;

import eurogeo.pl.linear.linearservice.domain.Operat;
import eurogeo.pl.linear.linearservice.domain.Projekt;
import eurogeo.pl.linear.linearservice.repositories.ProjektRepository;
import eurogeo.pl.linear.linearservice.web.controller.NotFoundException;
import eurogeo.pl.linear.linearservice.web.mapper.ProjektMapper;
import eurogeo.pl.linear.model.ProjektDto;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Optional;
import java.util.Set;
import java.util.UUID;
import java.util.stream.Collectors;

@RequiredArgsConstructor
@Service
@Slf4j
public class ProjektServiceImpl implements ProjektService {
   private final ProjektRepository projektRepository;
   private final ProjektMapper projektMapper;



    @Override
    public Set<ProjektDto> projektSet() {
        Set<ProjektDto> projekts = new HashSet<>();
       projekts = projektRepository.findAll()
                .stream()
                .map(projektMapper::projektToProjektDto)
                .collect(Collectors.toSet());
       for(ProjektDto projektDto:projekts){
           System.out.println("projekt id: " + projektDto.getProjektId());
       }
        return projekts;
    }

    @Override
    public ProjektDto getProjektDtoById(UUID projektId) {
        Projekt projekt = projektRepository.findById(projektId).orElseThrow(NotFoundException::new);

        return projektMapper.projektToProjektDto(projekt);
    }

    @Override
    public ProjektDto saveNewProjekt(ProjektDto projektDto) {


            return projektMapper.projektToProjektDto(projektRepository.save(projektMapper.projektDtoToProjekt(projektDto)));

    }


    @Override
    public ProjektDto updateProjekt( ProjektDto projektDto) {


       Projekt projekt =projektRepository.findById(projektDto.getProjektId()).orElseThrow(NotFoundException::new);
        projekt.setProjektName(projektDto.getProjektName());
        projekt.setProjektDescription(projektDto.getProjektDescription());

        return projektMapper.projektToProjektDto(projektRepository.save(projekt));

        }


    }

