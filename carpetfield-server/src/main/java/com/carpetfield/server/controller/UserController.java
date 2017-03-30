package com.carpetfield.server.controller;

import com.carpetfield.server.domain.Game;
import com.carpetfield.server.domain.Invitation;
import com.carpetfield.server.domain.Organization;
import com.carpetfield.server.domain.OrganizationMembership;
import com.carpetfield.server.domain.Role;
import com.carpetfield.server.domain.RoleEnum;
import com.carpetfield.server.domain.User;
import com.carpetfield.server.dto.UserOrganizationDTO;
import com.carpetfield.server.service.UserService;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Set;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by alicana on 09/03/2017.
 */
@RestController
@RequestMapping("/users")
@EnableAutoConfiguration
public class UserController {

  @Autowired
  private UserService userService;

  /* GET /users */
  @RequestMapping(method = RequestMethod.GET)
  public Collection<User> list() {
    return userService.getAllUsers();
  }

  /* GET /users/1 */
  @RequestMapping(value = "{id}", method = RequestMethod.GET)
  public User getUser(@PathVariable Long id) {
    return userService.getUserById(id)
        .orElseThrow(() -> new NoSuchElementException("User not found"));
  }

  /* POST /users {user data} */
  @RequestMapping(method = RequestMethod.POST)
  public User createUser(@RequestBody @Valid final User user) {
    return userService.createOrUpdate(user);
  }

  @RequestMapping(value = "{id}", method = RequestMethod.DELETE)
  public void delete(@PathVariable Long id) {
    userService.deleteUserById(id);
  }

  @RequestMapping(value = "{id}", method = RequestMethod.PUT)
  public User update(@PathVariable Long id, @RequestBody @Valid final User user) {
    User update = userService.getUserById(id)
        .orElseThrow(() -> new NoSuchElementException("User not found"));
    // MARK: <Alternative> BeanUtils.copyProperties

    Role r = new Role();
    r.setId(15l);
    r.setRoleEnum(RoleEnum.ROLE_ADMIN);
    Set<Role> roles = new HashSet<>();
    roles.add(r);

    update.setEmail(user.getEmail());
    update.setPassword(user.getPassword());
    update.setRoles(roles);
    return userService.createOrUpdate(update);
  }

  /* GET /users/id/games */
  @RequestMapping(value = "{id}/games", method = RequestMethod.GET)
  public Collection<Game> getUserGames(@PathVariable Long id) {
    return userService.findGamesOfUser(id);
  }

  /* GET /users/id/invitations */
  @RequestMapping(value = "{id}/invitations", method = RequestMethod.GET)
  public Collection<Invitation> getUserInvitations(@PathVariable Long id) {
    return userService.findInvitationsOfUser(id);
  }

  @RequestMapping(value = "{id}/organizations", method = RequestMethod.GET)
  public List<UserOrganizationDTO> getOrganizations(@PathVariable Long id) {

    User user = getUser(id);
    Collection<OrganizationMembership> memberships = user.getMemberships();

    List<UserOrganizationDTO> result = new ArrayList<>();
    for (OrganizationMembership om : memberships) {
      Organization org = om.getOrganization();

      UserOrganizationDTO tmpUserOrgDTO = new UserOrganizationDTO();
      tmpUserOrgDTO.setName(org.getName());
      tmpUserOrgDTO.setOrganizationId(org.getId());
      tmpUserOrgDTO.setOwner(om.isOwner());

      result.add(tmpUserOrgDTO);

    }

    return result;

  }

}
