package org.springframework.samples.petclinic.web;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.samples.petclinic.model.Vet;
import org.springframework.samples.petclinic.model.Vets;
import org.springframework.samples.petclinic.service.ClinicService;

import java.util.*;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.BDDMockito.given;
import static org.mockito.BDDMockito.then;

@ExtendWith(MockitoExtension.class)
class VetControllerTest {

    @Mock
    ClinicService clinicService;

    @Mock
    Map<String, Object> model;

    @InjectMocks
    VetController controller;

    List<Vet> vetList;


    @BeforeEach
    void setup() {
        vetList = new ArrayList<>();
        vetList.add(new Vet());
        given(clinicService.findVets()).willReturn(vetList);
    }

    @Test
    void showVetList() {
        //given => setup
        //when
        String viewName = controller.showVetList(model);
        //then
        then(clinicService).should().findVets();
        then(model).should().put(anyString(), any());
        assertThat(viewName).isEqualToIgnoringCase("vets/vetList");
    }

    @Test
    void showResourcesVetList() {
        //given => setup
        //when
        Vets vets = controller.showResourcesVetList();
        //then
        then(clinicService).should().findVets();
        assertThat(vets.getVetList().size()).isEqualTo(1);
    }
}