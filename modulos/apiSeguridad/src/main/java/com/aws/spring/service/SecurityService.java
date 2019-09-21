package com.aws.spring.service;

import com.aws.spring.dto.RenewPasswordFirstDTO;
import com.aws.spring.dto.RespuestaApi;
import com.aws.spring.dto.UpdatePasswordDTO;

public interface SecurityService {

	public RespuestaApi getToken(String username, String password);
	public RespuestaApi resetNewPasswordFirst(RenewPasswordFirstDTO updatePassword);
	public RespuestaApi updatePassword(UpdatePasswordDTO updatePassword);
	public RespuestaApi signOut(String token);
	public RespuestaApi refreshToken(String token);
}
