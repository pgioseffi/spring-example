package br.com.pgioseffi.spring.example.config.security.model;

import java.util.Collection;
import java.util.Objects;
import java.util.UUID;
import java.util.stream.Collectors;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import com.fasterxml.jackson.annotation.JsonIgnore;

import br.com.pgioseffi.spring.example.model.User;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class UserPrincipal implements UserDetails {

	private static final long serialVersionUID = 1L;

	private UUID id;

	private String name;

	private String username;

	@JsonIgnore
	private String email;

	@JsonIgnore
	private String password;

	private Collection<? extends GrantedAuthority> authorities;

	public UserPrincipal(final UUID idParam, final String nameParam, final String usernameParam, final String emailParam, final String passwordParam,
			final Collection<? extends GrantedAuthority> authoritiesParam) {
		this.id = idParam;
		this.name = nameParam;
		this.username = usernameParam;
		this.email = emailParam;
		this.password = passwordParam;
		this.authorities = authoritiesParam;
	}

	public static UserPrincipal create(final User user) {
		return new UserPrincipal(user.getId(), user.getName(), user.getUsername(), user.getEmail(), user.getPassword(),
				user.getRoles().stream().map(role -> new SimpleGrantedAuthority(role.getName())).collect(Collectors.toList()));
	}

	@Override
	public String getUsername() {
		return this.username;
	}

	@Override
	public String getPassword() {
		return this.password;
	}

	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		return this.authorities;
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
	public boolean equals(final Object o) {
		if (this == o) {
			return true;
		}

		if (o == null || this.getClass() != o.getClass()) {
			return false;
		}

		return Objects.equals(this.id, ((UserPrincipal) o).id);
	}

	@Override
	public int hashCode() {
		return Objects.hash(this.id);
	}
}