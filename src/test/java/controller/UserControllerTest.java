package controller;

import com.admin.pharma.controllers.UserLoginController;
import com.admin.pharma.model.User;
import com.admin.pharma.service.UserService;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;
import util.UserUtil;

import java.util.Collection;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.mockito.Mockito.*;

@RunWith(MockitoJUnitRunner.class)
public class UserControllerTest {

//    @Mock
//    private UserService userService;
//
//    private UserLoginController userController;
//
//    @Before
//    public void setUp() throws Exception {
//        userController = new UserLoginController(userService);
//    }
//
//    @Test
//    public void shouldCreateUser() throws Exception {
//        final User savedUser = stubServiceToReturnStoredUser();
//        final User user = UserUtil.createUser();
//        User returnedUser = userController.createUser(user);
//        // verify user was passed to UserService
//        verify(userService, times(1)).save(user);
//        assertEquals("Returned user should come from the service", savedUser, returnedUser);
//    }
//
//    private User stubServiceToReturnStoredUser() {
//        final User user = UserUtil.createUser();
//        when(userService.save(any(User.class))).thenReturn(user);
//        return user;
//    }
//
//
//    @Test
//    public void shouldListAllUsers() throws Exception {
//        stubServiceToReturnExistingUsers(10);
//        Collection<User> users = userController.listUsers();
//        assertNotNull(users);
//        assertEquals(10, users.size());
//        // verify user was passed to UserService
//        verify(userService, times(1)).getList();
//    }
//
//    private void stubServiceToReturnExistingUsers(int howMany) {
//        when(userService.getList()).thenReturn(UserUtil.createUserList(howMany));
//    }

}
