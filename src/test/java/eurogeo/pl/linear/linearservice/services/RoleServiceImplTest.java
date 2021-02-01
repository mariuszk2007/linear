package eurogeo.pl.linear.linearservice.services;

import eurogeo.pl.linear.linearservice.web.mapper.AppUserMapperImpl_;
import eurogeo.pl.linear.linearservice.web.mapper.RoleMapper;
import eurogeo.pl.linear.linearservice.web.mapper.RoleMapperImpl_;
import eurogeo.pl.linear.linearservice.web.mapper.SetRoleMapperImpl;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.jupiter.api.Assertions.*;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = {AppUserMapperImpl_.class, SetRoleMapperImpl.class, RoleMapperImpl_.class})
class RoleServiceImplTest {

    @Autowired
    RoleMapper roleMapper;

    @Test
    void save() {
    }

    @Test
    void findByRolename() {

    }

    @Test
    void existByRolename() {
    }
}