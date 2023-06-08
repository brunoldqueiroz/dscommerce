package com.devsuperior.dscommerce.projections;

public interface UserDetailProjection {
    String getUsername();
    String getPassword();
    Long getRoleId();
    String getAuthority();
}
