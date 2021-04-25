package com.lyl.springboot.ossd.utils.token;

import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import com.lyl.springboot.ossd.domain.Student;
import org.springframework.stereotype.Service;

@Service("TokenService")
public class TokenService {
    // 生成token
    public String getToken(String id, String pwd) {
        String token="";
        token= JWT.create().withAudience(id)
                .sign(Algorithm.HMAC256(pwd));
        return token;
    }
}
