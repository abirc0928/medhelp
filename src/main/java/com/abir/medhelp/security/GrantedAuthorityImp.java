package com.abir.medhelp.security;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.util.Assert;

public class GrantedAuthorityImp implements GrantedAuthority {
	
	private final String role;
	
	public GrantedAuthorityImp() {
		this.role = "";
	}
	
	public GrantedAuthorityImp(String role) {
        Assert.hasText(role, "A granted authority textual representation is required");
        this.role = role;
    }
	
	public String getAuthority() {
        return role;
    }
	
	public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }

        if (obj instanceof GrantedAuthorityImp) {
            return role.equals(((GrantedAuthorityImp) obj).role);
        }

        return false;
    }

    public int hashCode() {
        return this.role.hashCode();
    }

    public String toString() {
        return this.role;
    }
}
