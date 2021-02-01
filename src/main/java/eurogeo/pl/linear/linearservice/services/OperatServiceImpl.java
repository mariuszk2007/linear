package eurogeo.pl.linear.linearservice.services;

import eurogeo.pl.linear.linearservice.domain.AppUser;
import eurogeo.pl.linear.linearservice.domain.Operat;
import eurogeo.pl.linear.linearservice.domain.Projekt;
import eurogeo.pl.linear.linearservice.repositories.OperatRepository;
import eurogeo.pl.linear.linearservice.repositories.ProjektRepository;
import eurogeo.pl.linear.linearservice.repositories.UserRepository;
import eurogeo.pl.linear.linearservice.web.controller.NotFoundException;
import eurogeo.pl.linear.linearservice.web.mapper.OperatMapper;
import eurogeo.pl.linear.model.OperatDto;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import org.springframework.stereotype.Service;


import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;
import java.util.stream.Collectors;



@RequiredArgsConstructor
@Service
@Slf4j
public class OperatServiceImpl implements OperatService {

    private final OperatRepository operatRepository;
    private final OperatMapper operatMapper;
    private final ProjektRepository projektRepository;
    private final UserRepository userRepository;
    @Override
    public List<OperatDto> listOperatsByLayer(UUID projektId, String layer) {
        Optional<Projekt> projekt = projektRepository.findById(projektId);
        if (projekt.isPresent()) {
            List<OperatDto> operatList = new ArrayList<OperatDto>(operatRepository.findAllByProjektAndLayerContainingOrderByOperatNumber(projekt.get(), layer)
                    .stream()
                    .map(operatMapper::operatToOperatDto)
                    .collect(Collectors.toList()));

            return operatList;
        }
        return null;
    }

    @Override
    public OperatDto getByOperatIdAndProjectId(long operatId, UUID projektID) {
       Optional<Projekt> projekt = projektRepository.findById(projektID);
       if(projekt.isPresent()) {
           Operat operat = operatRepository.findByOperatNumberAndProjekt(operatId, projekt.get());
           return operatMapper.operatToOperatDto(operat);
       }
       else return null;
    }

    @Override
    public OperatDto saveNewOperat(OperatDto operatDto) {
        Operat operatDto1 = new Operat();
        operatDto1.setLayer(operatDto.getLayer());
        operatDto1.setOperatNumber(operatDto.getOperatNumber());
        operatDto1.setOdKm(operatDto.getOdKm());
        operatDto1.setDoKm(operatDto.getDoKm());

        Optional<Projekt> projekt = projektRepository.findById(operatDto.getProjektId());

        Optional<AppUser> user = userRepository.findById(operatDto.getCreateUser());
        if(user.isPresent()){
            operatDto1.setCreateUser(user.get());
            operatDto1.setUpdateUser(user.get());
        }
        if(projekt.isPresent()) {
            operatDto1.setProjekt(projekt.get());
            return operatMapper.operatToOperatDto(operatRepository.save(operatDto1));
        }
        return null;
    }

    @Override
    public OperatDto updateOperat(UUID operatId, OperatDto operatDto) {
        System.out.println("jestem w opdate operat");
        Operat operat = operatRepository.findById(operatId).orElseThrow(NotFoundException::new);
        operat.setOperatNumber(operatDto.getOperatNumber());
        operat.setLayer(operatDto.getLayer());
        operat.setOdKm(operatDto.getOdKm());
        operat.setDoKm(operatDto.getDoKm());
        operat.setUpdateUser(userRepository.findById(operatDto.getUpdateUser()).get());
        

        return operatMapper.operatToOperatDto(operatRepository.save(operat));
    }

    @Override
    public List<OperatDto> listOperatsBeetwenScope(double fromScope, double toScope, UUID projektId) {
        List<OperatDto> operatList;
        Optional<Projekt> projekt = projektRepository.findById(projektId);

        if(projekt.isPresent()) {
            operatList = new ArrayList<>(operatRepository.findAllByOdKmLessThanEqualAndDoKmGreaterThanEqualAndProjektOrderByOperatNumber(fromScope, toScope,
                    projekt.get()
            ).stream()
             .map(operatMapper::operatToOperatDto)
             .collect(Collectors.toList()));
            return operatList;
        }
        else return null;
    }
    @Override
    public List<OperatDto> listOperatsInScope(double fromScopeOd,double toScopeOd, UUID projektId, double fromScopeDo ,double toScopeDo) {
        List<OperatDto> operatList;
        Optional<Projekt> projekt = projektRepository.findById(projektId);

        if(projekt.isPresent()) {
            operatList = new ArrayList<>(operatRepository.findAllByOdKmBetweenAndProjektOrDoKmBetweenAndProjektOrOdKmLessThanEqualAndDoKmGreaterThanEqualAndProjektOrderByOperatNumber(fromScopeOd,toScopeOd, projekt.get(),fromScopeDo, toScopeDo,projekt.get(),fromScopeOd,toScopeDo,projekt.get()
            ).stream()
                    .map(operatMapper::operatToOperatDto)
                    .collect(Collectors.toList()));
            return operatList;
        }
        else return null;
    }

    @Override
    public List listOperatsLessThan(double fromScope, UUID projektId) {
       List<Operat> operatList;
        Optional<Projekt> projekt = projektRepository.findById(projektId);
        if(projekt.isPresent()) {

            operatList = new ArrayList(operatRepository.findAllByOdKmLessThanEqualAndProjektOrderByOperatNumber(fromScope,
                    projekt.get()).stream().map(operatMapper::operatToOperatDto).collect(Collectors.toList()));

            return operatList;
        }
        else return null;
    }

    @Override
    public List<OperatDto> getByProjectId(UUID projektId) {
        List<OperatDto> operatList;
        Optional<Projekt> projekt = projektRepository.findById(projektId);
        if (projekt.isPresent()) {
            operatList = new ArrayList(operatRepository.findAllByProjektOrderByOperatNumber(projekt.get())
                    .stream()
                    .map(operatMapper::operatToOperatDto)
                    .collect(Collectors.toList()));

            return operatList;

        }
        return null;
    }

}
