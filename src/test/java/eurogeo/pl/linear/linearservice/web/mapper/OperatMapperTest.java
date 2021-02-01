package eurogeo.pl.linear.linearservice.web.mapper;

import eurogeo.pl.linear.linearservice.domain.Operat;
import eurogeo.pl.linear.model.OperatDto;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import static org.assertj.core.api.Assertions.assertThat;

import java.util.UUID;

import static org.junit.jupiter.api.Assertions.*;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = { OperatMapperImpl_.class, DateMapper.class})
class OperatMapperTest {
    @Autowired
    OperatMapper operatMapper;

    @Test
    void operatDtoToOperat() {
        UUID createUserId = UUID.randomUUID();
        UUID updateUserId = UUID.randomUUID();
        OperatDto operatDto = new OperatDto();
        operatDto.setLayer("stsav");
        operatDto.setCreateUser(createUserId);
        operatDto.setUpdateUser(updateUserId);
        operatDto.setOdKm(45.0);
        operatDto.setDoKm(90);
        Operat operat = operatMapper.operatDtoToOperat(operatDto);
        assertThat(operat.getCreateUser().getUserId()).isEqualByComparingTo(createUserId);
        assertThat(operat.getUpdateUser().getUserId()).isEqualByComparingTo(updateUserId);
    }

    @Test
    void operatToOperatDto() {
    }
}