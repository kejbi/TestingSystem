package pl.prozprojekt.testingsystem.security;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import pl.prozprojekt.testingsystem.entities.User;

import java.util.*;
import java.util.stream.Collectors;

public class CustomUserDetails implements UserDetails {
    private long id;
    private String name;
    private String username;
    private String password;
    private boolean isStudent;
    private Collection<? extends GrantedAuthority> authorities;

    public CustomUserDetails(long id, String username, String password, Collection<? extends GrantedAuthority> authorities, boolean isStudent) {
        this.id = id;
        this.username = username;
        this.password = password;
        this.authorities = authorities;
        this.name = username;
        this.isStudent = isStudent;
    }

    public CustomUserDetails(User user) {
        this.id = user.getId();
        this.username = user.getName(); //name is also the username
        this.password = user.getPassword();
        List<GrantedAuthority> authorities = Arrays.asList(new SimpleGrantedAuthority(user.getRole()));
        this.authorities = authorities;
        this.name = user.getName();
        this.isStudent = user.isStudent();
    }

    public static CustomUserDetails create(User user) {
        List<GrantedAuthority> authorities = new LinkedList<>();
        authorities.add(new SimpleGrantedAuthority(user.getRole()));
        return new CustomUserDetails(user.getId(), user.getName(), user.getPassword(), authorities, user.isStudent());
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setAuthorities(Collection<? extends GrantedAuthority> authorities) {
        this.authorities = authorities;
    }

    public boolean isStudent() {
        return isStudent;
    }

    public void setStudent(boolean student) {
        isStudent = student;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return authorities;
    }

    @Override
    public String getPassword() {
        return password;
    }

    @Override
    public String getUsername() {
        return username;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

    public String getName() {
        return name; //name is also username
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CustomUserDetails that = (CustomUserDetails) o;
        return Objects.equals(id, that.id);
    }
}
