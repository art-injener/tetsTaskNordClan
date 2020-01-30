package ru.art.testTaskNordClan.model;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import javax.persistence.*;
import java.util.Collection;

/**
 * User description class
 * @author Danilchenko Artem
 */
@Entity
@Table(name = "usr")
public class User implements UserDetails {

    /** property identifier of user */
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    /** property identifier of user */
    private String username;
    /** property password of user*/
    private String password;
    /** property state of account */
    private boolean active;
    /** */
    public User() {
    }
    /** get identifier of user */
    public Long getId() {
        return id;
    }
    /** set identifier of user*/
    public void setId(Long id) {
        this.id = id;
    }
    /** get name of user */
    public void setUsername(String username) {
        this.username = username;
    }
    /** get name of user */
    public String getUsername() {
        return username;
    }
    /** Indicates whether the user's account has expired.
     * An expired account cannot be authenticated. */
    @Override
    public boolean isAccountNonExpired() {
        return true;
    }
    /**  Indicates whether the user is locked or unlocked.
     * A locked user cannot be authenticated.*/
    @Override
    public boolean isAccountNonLocked() {
        return true;
    }
    /** Indicates whether the user's credentials (password) has expired.*/
    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }
    /** Indicates whether the user is enabled or disabled. */
    @Override
    public boolean isEnabled() {
        return isActive();
    }
    /** Returns the authorities granted to the user. Cannot return null */
    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return null;
    }
    /** get password of user */
    public String getPassword() {
        return password;
    }
    /** set password of user*/
    public void setPassword(String password) {
        this.password = password;
    }
    /** get state of account */
    public boolean isActive() {
        return active;
    }
    /** set state of account*/
    public void setActive(boolean active) {
        this.active = active;
    }
}
