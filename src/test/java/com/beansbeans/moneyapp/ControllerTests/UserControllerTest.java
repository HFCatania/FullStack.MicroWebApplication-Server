package com.beansbeans.moneyapp.ControllerTests;
import com.beansbeans.moneyapp.Controllers.UserController;
import com.beansbeans.moneyapp.Model.User;
import com.beansbeans.moneyapp.Services.UserService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import java.sql.SQLException;
import java.util.Arrays;
import java.util.List;
import java.sql.SQLException;
import static org.mockito.Mockito.*;

@RunWith(MockitoJUnitRunner.class)
public class UserControllerTest {

    @Mock
    private UserService userService;

    @InjectMocks
    private UserController userController;

    @Test
    public void createUserTest(){
        User user = mockUser();

        try {
            when(userService.create(user)).thenReturn(user);
        }
        catch (SQLException ex) {
            System.out.println("SQL exception in tcreateUserTest #1");
        }
        userController.create(user);

        try {
            verify(userService, times(1)).create(user);
        }
        catch(SQLException ex) {
            System.out.println("SQL exception in tcreateUserTest #2");
        }
    }

    @Test
    public void loginTest() throws SQLException {
        User user = mockUser();

        when(userService.login(user)).thenReturn(user);
        userController.login(user);

        verify(userService, times(1)).login(user);
    }

    @Test
    public void findAllUsersTest(){
        when(userService.findAll()).thenReturn(testList());
        userController.findAll();

        verify(userService, times(1)).findAll();
    }

    @Test
    public void getByIdTest(){
        when(userService.show(mockUser().getId())).thenReturn(mockUser());
        userController.getById(mockUser().getId());

        verify(userService, times(1)).show(mockUser().getId());
    }

    @Test
    public void updateUserInfoTest(){
        User user = mockUser();

        when(userService.updateUser(4L, user)).thenReturn(user);
        userController.updateUserInfo(4L, user);

        verify(userService, times(1)).updateUser(4L, user);
    }

    @Test
    public void deleteUserTest(){
        when(userService.deleteUser(mockUser().getId())).thenReturn(true);
        userController.deleteUser(mockUser().getId());

        verify(userService, times(1)).deleteUser(mockUser().getId());
    }

    private User mockUser(){
        return new User(1L,"Miles", "Davis","sowhat", "913jmnf108fjqaifn10i3wda", "email@email.com");
    }

    private List<User> testList(){
        User testUser1 = new User(2L,"fake","name","testname","lkgs89g3poig2oiu","test1@email.com");
        User testUser2 = new User(3L,"test","name","username","pdmia9d93pm20imap3i9mn","test2@email.com");
        return Arrays.asList(testUser1,testUser2);
    }

}
